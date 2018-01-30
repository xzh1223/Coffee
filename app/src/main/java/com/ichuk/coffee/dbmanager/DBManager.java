package com.ichuk.coffee.dbmanager;

import com.ichuk.coffee.bean.UserBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.ichuk.coffee.utils.Constants.BASE_URL;

/**
 * Created by xzh on 2018/1/23.
 */

public class DBManager {

    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    static IRetrofit iRetrofit = retrofit.create(IRetrofit.class);

    /**
     *  登录
     */
    public static void login(UserBean user, Callback<ResponseBody > callback) {
//        String json = GsonUtil.beanToJson(user);
//        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
        Call<ResponseBody> call = iRetrofit.login("13247815378", "123456");
        call.enqueue(callback);
    }

}
