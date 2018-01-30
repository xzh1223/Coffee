package com.ichuk.coffee.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ichuk.coffee.R;
import com.ichuk.coffee.utils.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

/**
 * Created by xzh on 2018/1/29.
 */

public abstract class ShareActivity extends BaseActivity {
    private static IWXAPI msgApi;
    public static Tencent mTencent;
    private Dialog dialog;

    /**
     *  show share type
     */
    protected void showShareTypeDialog(Activity activity) {
        View view = View.inflate(context, R.layout.item_dialog_share_type, null);
        dialog = new Dialog(context, R.style.ActionSheetDialogStyle);
        dialog.setContentView(view);

        final Window dialogWindow = dialog.getWindow();
        dialogWindow.getDecorView().setPadding(0, 0, 0, 0); //消除边距
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setAttributes(lp);
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();

        ImageView ivEsc = view.findViewById(R.id.iv_esc);
        LinearLayout llWeiXin = view.findViewById(R.id.ll_WeiXin);
        LinearLayout llFriend = view.findViewById(R.id.ll_friend);
        LinearLayout llQQ = view.findViewById(R.id.ll_QQ);
        LinearLayout llWorkspace = view.findViewById(R.id.ll_workspace);

        ivEsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
        llWeiXin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toShareText(context, "测试内容", false);
            }
        });
        llFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toShareText(context, "测试内容", true);
            }
        });
        llQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toShareQQ(ShareActivity.this);
            }
        });
        llWorkspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareToQzone(ShareActivity.this);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mTencent.onActivityResult(requestCode, resultCode, data);
    }

    /**
     *  initial WXAPI
     * @param context
     */
    private static void createWXShare(Context context) {
        msgApi = WXAPIFactory.createWXAPI(context, Constants.WX_APP_ID, true);
        msgApi.registerApp(Constants.WX_APP_ID);
    }

    /**
     * initial Tencent
     * @param activity
     */
    public static void createQQShare(Activity activity) {
        mTencent = Tencent.createInstance(Constants.QQ_APP_ID, activity.getApplicationContext());
    }

    /**
     *  share to wx by text
     */
    public static void toShareText(Context context, String content, boolean isTimelineCb) {

        createWXShare(context);

        // initial WXTxtObject to write text content
        WXTextObject textObject = new WXTextObject();
        textObject.text = content;
        // initial WXMediaMessage
        WXMediaMessage message = new WXMediaMessage();
        message.mediaObject = textObject;
        message.description = content;

        // constructor req
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = content;
        req.message = message;
        req.scene = isTimelineCb ? SendMessageToWX.Req.WXSceneTimeline : SendMessageToWX.Req.WXSceneSession;
        msgApi.sendReq(req);
    }

    /**
     * share to QQ
     */
    public static void toShareQQ(Activity activity) {
        createQQShare(activity);
        Bundle bundle = new Bundle();
        bundle.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        bundle.putString(QQShare.SHARE_TO_QQ_TITLE, "要分享的标题");
        bundle.putString(QQShare.SHARE_TO_QQ_SUMMARY, "要分享的摘要");
        bundle.putString(QQShare.SHARE_TO_QQ_TARGET_URL, "http://www.qq.com/news/1.html");
        bundle.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif");
        bundle.putString(QQShare.SHARE_TO_QQ_APP_NAME, "测试应用222222");
//        bundle.putInt(QQShare.SHARE_TO_QQ_EXT_INT,  "其他附加功能");

        mTencent.shareToQQ(activity, bundle, new BaseUiListener());
    }

    /**
     *  share to Qzone
     */
    public static void shareToQzone(Activity activity) {
        Bundle bundle = new Bundle();
        //分享类型
//        bundle.putString(QzoneShare.SHARE_TO_QQ_KEY_TYPE, SHARE_TO_QZONE_TYPE_IMAGE_TEXT);
        bundle.putString(QzoneShare.SHARE_TO_QQ_TITLE, "标题");//必填
        bundle.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, "摘要");//选填
        bundle.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL, "跳转URL");//必填
//        bundle.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, "图片链接ArrayList");
        mTencent.shareToQzone(activity, bundle, new BaseUiListener());
    }

    /**
     *  listener
     */
    private static class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object o) {

        }

        @Override
        public void onError(UiError e) {

        }

        @Override

        public void onCancel() {

        }

    }

}
