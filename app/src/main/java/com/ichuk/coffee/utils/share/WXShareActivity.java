package com.ichuk.coffee.utils.share;

import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.utils.Constants;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by xzh on 2017/12/22.
 *
 */

public class WXShareActivity extends BaseActivity {

    private IWXAPI msgApi;
    private int mShared = 0;
    private boolean isTimelineCb = false;

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        msgApi = WXAPIFactory.createWXAPI(context, Constants.WX_APP_ID, true);
        msgApi.registerApp(Constants.WX_APP_ID);
        toShareText("contentStr", false);
    }

    /**
     *  share to wx by text
     */
    private void toShareText(String content, boolean isTimelineCb) {
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
     * initial view
     */
    @Override
    protected void initView() {
        mShared = getIntent().getIntExtra("shared",0);
        sharedStyle();
    }

    /**
     *  judge shared style
     */
    private void sharedStyle() {
        if (mShared == 0) {
            isTimelineCb = false;
        } else {
            isTimelineCb = true;
        }
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return 0;
    }
}
