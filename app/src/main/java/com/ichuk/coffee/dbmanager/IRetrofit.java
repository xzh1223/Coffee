package com.ichuk.coffee.dbmanager;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IRetrofit {

    @FormUrlEncoded
    @POST("LoginServ.html")
    Call<ResponseBody> login(@Field("mobile") String mobile, @Field("password") String password);

//    @GET("findWorksByUserId/{userId}")
//    Call<List<Work>> findWorksByUserId(@Path("userId") int userId);
//
//    @POST("addWork")
//    Call<Integer> addWork(@Body RequestBody body);

}