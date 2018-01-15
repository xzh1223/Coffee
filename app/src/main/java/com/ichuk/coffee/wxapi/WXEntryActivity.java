package com.ichuk.coffee.wxapi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.ichuk.coffee.utils.Constants;
import com.ichuk.coffee.utils.ToastUtil;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by xzh on 2017/12/20.
 *
 */

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IWXAPI api = WXAPIFactory.createWXAPI(this, Constants.WX_APP_ID, false);
        api.handleIntent(getIntent(),this);
    }

    @Override
    public void onReq(BaseReq baseReq) {
        Log.e("----->",baseReq.toString());
    }

    @Override
    public void onResp(BaseResp baseResp) {
        ToastUtil.toast(this, baseResp.errStr);
        Log.e("----->",baseResp.toString());
    }
}
