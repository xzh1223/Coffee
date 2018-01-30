package com.ichuk.coffee.utils.share;

import android.content.Intent;
import android.os.Bundle;

import com.ichuk.coffee.base.BaseActivity;
import com.ichuk.coffee.utils.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

/**
 * Created by xzh on 2017/12/22.
 *
 */

public class QQShareActivity extends BaseActivity {
    private Tencent mTencent;
    private int mStatus = 2;

    /**
     * set event
     */
    @Override
    protected void setEvent() {
        if (mStatus == 2) {
            toShareQQ();
        } else {
            shareToQzone();
        }
    }

    /**
     * share to QQ
     */
    private void toShareQQ() {
        Bundle bundle = new Bundle();
        bundle.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        bundle.putString(QQShare.SHARE_TO_QQ_TITLE, "要分享的标题");
        bundle.putString(QQShare.SHARE_TO_QQ_SUMMARY, "要分享的摘要");
        bundle.putString(QQShare.SHARE_TO_QQ_TARGET_URL, "http://www.qq.com/news/1.html");
        bundle.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif");
        bundle.putString(QQShare.SHARE_TO_QQ_APP_NAME, "测试应用222222");
//        bundle.putInt(QQShare.SHARE_TO_QQ_EXT_INT,  "其他附加功能");

        mTencent.shareToQQ(this, bundle, new BaseUiListener());
    }

    /**
     *  share to Qzone
     */
    private void shareToQzone() {
        Bundle bundle = new Bundle();
        //分享类型
//        bundle.putString(QzoneShare.SHARE_TO_QQ_KEY_TYPE, SHARE_TO_QZONE_TYPE_IMAGE_TEXT);
        bundle.putString(QzoneShare.SHARE_TO_QQ_TITLE, "标题");//必填
        bundle.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, "摘要");//选填
        bundle.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL, "跳转URL");//必填
//        bundle.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, "图片链接ArrayList");
        mTencent.shareToQzone(this, bundle, new BaseUiListener());
    }

    private class BaseUiListener implements IUiListener {

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

    /**
     * initial view
     */
    @Override
    protected void initView() {
        mTencent = Tencent.createInstance(Constants.QQ_APP_ID, this.getApplicationContext());
        mStatus = getIntent().getIntExtra("shared", 2);
    }

    /**
     * load layout
     */
    @Override
    protected int setLayout() {
        return 0;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mTencent.onActivityResult(requestCode, resultCode, data);
    }
}
