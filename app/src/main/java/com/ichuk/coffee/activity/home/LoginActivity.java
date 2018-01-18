package com.ichuk.coffee.activity.home;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ichuk.coffee.R;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.utils.Constants;
import com.ichuk.coffee.utils.ToastUtil;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.BaseSsoHandler;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * loginActivity
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvHeaderTitle;
    private ImageView ivBack;
    private EditText etPhone;
    private EditText etPassword;
    private TextView tvForgetPassword;
    private TextView tvRegisterAccount;
    private Button btnLogin;
    private LinearLayout llQQ;
    private LinearLayout llWeiXin;
    private LinearLayout llWeiBo;
    private Tencent mTencent;
    private IWXAPI api;
    private Oauth2AccessToken mAccessToken;
    private BaseSsoHandler mSsoHandler;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        llQQ = findViewById(R.id.ll_QQ);
        llWeiXin = findViewById(R.id.ll_WeiXin);
        llWeiBo = findViewById(R.id.ll_WeiBo);
        ivBack = findViewById(R.id.iv_back);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        etPhone = findViewById(R.id.et_phone);
        etPassword = findViewById(R.id.et_password);
        tvForgetPassword = findViewById(R.id.tv_forget_password);
        tvRegisterAccount = findViewById(R.id.tv_register_account);
        btnLogin = findViewById(R.id.btn_login);
    }

    /**
     * set event
     */
    @Override
    protected void setEvent() {

        ivBack.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        tvForgetPassword.setOnClickListener(this);
        tvRegisterAccount.setOnClickListener(this);
        llQQ.setOnClickListener(this);
        llWeiXin.setOnClickListener(this);
        llWeiBo.setOnClickListener(this);
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        setHeader();
    }

    /**
     * set header
     */
    private void setHeader() {
        tvHeaderTitle.setText(getResources().getString(R.string.to_login));
        ivBack.setVisibility(View.VISIBLE);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, RegisterActivity.class);
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_login:
                Toast.makeText(context, "to login", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_register_account:
                intent.putExtra("FLAG", 1);
                startActivity(intent);
                break;
            case R.id.tv_forget_password:
                intent.putExtra("FLAG", 2);
                startActivity(intent);
                break;
            case R.id.ll_QQ:
                mTencent = Tencent.createInstance(Constants.QQ_APP_ID, this.getApplicationContext());
                mTencent.login(LoginActivity.this, "all", new BaseUiListener());
                break;
            case R.id.ll_WeiXin:
                regToWX();
                sendAuthRequest();
                break;
            case R.id.ll_WeiBo:
                initWebSDK();
                mSsoHandler = new SsoHandler(LoginActivity.this);
                mSsoHandler.authorize(new SelfWbAuthListener());
                break;
        }
    }

    /*****************************************************************************************
     *  QQ登录
     ****************************************************************************************/

    public class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object o) {
            Toast.makeText(context, "success", Toast.LENGTH_SHORT).show();
            try {
                JSONObject jsonObject = new JSONObject(o.toString());
                String openid = jsonObject.getString("openid");
                String accessToken = jsonObject.getString("access_token");
                String expires = jsonObject.getString("expires_in");
                mTencent.setOpenId(openid);
                mTencent.setAccessToken(accessToken, expires);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            getUserInfo();
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(context, "onError", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel() {
            Toast.makeText(context, "onCancel", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Tencent.onActivityResultData(requestCode, resultCode, data, new BaseUiListener());
        if(mSsoHandler!=null){
            mSsoHandler.authorizeCallBack(requestCode,resultCode,data);
        }
    }

    /**
     * get user info for QQ
     */
    public void getUserInfo() {
        QQToken qqToken = mTencent.getQQToken();
        UserInfo info = new UserInfo(getApplicationContext(), qqToken);
        info.getUserInfo(new IUiListener() {
            @Override
            public void onComplete(Object response) {
//                UserBean userBean = (UserBean) GsonUtil.jsonToBean(response.toString(), UserBean.class);
//                mTextView.setText(userBean.toString());
            }

            @Override
            public void onError(UiError uiError) {
//                mTextView.setText(uiError.toString());
            }

            @Override
            public void onCancel() {
//                mTextView.setText("onCancel");
            }
        });
    }


    /*****************************************************************************************
     *  微信登录
     ****************************************************************************************/
    private void regToWX() {
        api = WXAPIFactory.createWXAPI(LoginActivity.this, Constants.WX_APP_ID, false);
        api.registerApp(Constants.WX_APP_ID);
    }

    /**
     *  send request for wx
     */
    private void sendAuthRequest() {

        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_base";
        req.state = "wechat_sdk_demo_test";
        api.sendReq(req);

    }

    /*****************************************************************************************
     *  微博登录
     ****************************************************************************************/
    /**
     *  initial WeiBo
     */
    private void initWebSDK() {
        WbSdk.install(this,new AuthInfo(this, Constants.APP_KEY_SINA, Constants.REDIRECT_URL,
                Constants.SCOPE));
    }

    private class SelfWbAuthListener implements com.sina.weibo.sdk.auth.WbAuthListener{
        @Override
        public void onSuccess(final Oauth2AccessToken token) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mAccessToken = token;
                    if (mAccessToken.isSessionValid()) {
                        ToastUtil.toast(context, "授权成功");
                        //获取个人资料
                        /*OkHttpUtils.get()
                                .url("https://api.weibo.com/2/users/show.json")
                                .addParams("access_token",mAccessToken.getToken())
                                .addParams("uid",mAccessToken.getUid())
                                .build()
                                .execute(new StringCallback() {
                                    @Override
                                    public void onError(Call call, Exception e, int id) {
                                        ViseLog.d("获取失败："+e.getMessage());
                                        e.printStackTrace();
                                    }

                                    @Override
                                    public void onResponse(String response, int id) {
                                        ViseLog.d("response:"+response);
                                    }
                                });*/

                    }
                }
            });
        }

        @Override
        public void cancel() {
            ToastUtil.toast(context,"取消授权");
        }

        @Override
        public void onFailure(WbConnectErrorMessage errorMessage) {
            Toast.makeText(LoginActivity.this, errorMessage.getErrorCode() + errorMessage.getErrorMessage(), Toast.LENGTH_LONG).show();
        }
    }


}

