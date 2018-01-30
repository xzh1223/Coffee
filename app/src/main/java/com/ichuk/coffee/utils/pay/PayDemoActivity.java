package com.ichuk.coffee.utils.pay;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.ichuk.coffee.activity.home.PaySuccessActivity;
import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.utils.Constants;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.Map;

/**
 * Created by xzh on 2017/12/21.
 *
 */

public class PayDemoActivity extends BaseActivity {

    public static final String RSA_PRIVATE = "";
    public static final String RSA2_PRIVATE = "";
    private static final int WEIXIN_DATA = 0x00;
    private static final int SDK_PAY_FLAG = 0x01;

    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG:
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    //同步获取结果
                    String resultInfo = payResult.getResult();
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(context, "支付成功", Toast.LENGTH_SHORT).show();
                        toActivity(PaySuccessActivity.class);
                    } else {
                        Toast.makeText(context, payResult.toString(), Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:
                    break;
            }
            return false;
        }
    });
    private IWXAPI msgApi;

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        toAliPay("", "");
        toWXPay();
    }

    /**
     *  WX Pay
     */
    private void toWXPay() {
        msgApi = WXAPIFactory.createWXAPI(context, Constants.WX_APP_ID, true);
        msgApi.registerApp(Constants.WX_APP_ID);

        // get data from server
        /*PayReq request = new PayReq();
        request.appId = mData.getAppid();
        request.partnerId = mData.getPartnerid();
        request.prepayId = mData.getPrepayid();
//        request.packageValue = mData.getPackage1();
        request.packageValue = "Sign=WXPay";
        request.nonceStr = mData.getNoncestr();
        request.timeStamp = mData.getTimestamp() + "";
        request.sign = mData.getSign();
        // send request
        msgApi.sendReq(request);*/
    }

    /**
     *  ali pay
     */
    private void toAliPay(String mCode, String mMoney) {
        //秘钥验证的类型 true:RSA2 false:RSA
        boolean rsa2 = (RSA2_PRIVATE.length() > 0);
        //构造支付订单参数列表
        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(Constants.ALIPAY_APP_ID, rsa2, mCode, "" + mMoney);
        //构造支付订单参数信息
        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
        String privateKey = rsa2 ? RSA2_PRIVATE : RSA_PRIVATE;
        //对支付参数信息进行签名
        String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
        final String orderInfo = orderParam + "&" + sign;
        //异步处理
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                //新建任务
                PayTask alipay = new PayTask(PayDemoActivity.this);
                //获取支付结果
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {

    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return 0;
    }
}
