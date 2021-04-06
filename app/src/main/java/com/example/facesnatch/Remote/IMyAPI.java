package com.example.facesnatch.Remote;

import com.example.facesnatch.Model.APIResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IMyAPI {
    @FormUrlEncoded
    @POST("login.php")
    Call<APIResponse> loginUser(@Field("id") String id, @Field("password") String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<APIResponse> registerUser(@Field("id") String id, @Field("name") String name, @Field("position") String position, @Field("password") String password);

}
