/*
package com.ichuk.coffee.application;

import android.app.Application;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

*/
/**
 * Created by xzh on 2017/12/19.
 *
 *//*


public class LocationApplication extends Application {
    public AMapLocationClientOption mLocationOption = null;
    public String locationStr = "";

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        //设置单次定位
        mLocationOption.setOnceLocation(true);
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        //解析定位结果
                        setLocationStr(aMapLocation.getCity());
                        Log.e("AmapSuccess", "onLocationChanged: " + aMapLocation.toString());
                    } else {
                        setLocationStr("定位失败");
                        Log.e("AmapError", "location Error, ErrCode:"
                                + aMapLocation.getErrorCode() + ", errInfo:"
                                + aMapLocation.getErrorInfo());
                    }
                }
            }
        });
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();

    }

    public void setLocationStr (String str) {
        this.locationStr = str;
        Log.e("setLocationStr", "getLocationStr: " + locationStr );
    }

    public String getLocationStr() {
        return locationStr;
    }

}
*/
