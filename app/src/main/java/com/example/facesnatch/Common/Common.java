package com.example.facesnatch.Common;

import com.example.facesnatch.Remote.IMyAPI;
import com.example.facesnatch.Remote.RetrofitClient;

public class Common {
    public static final String BASE_URL = "http://192.168.0.106/facesnatch/";
    public static IMyAPI getAPI(){
        return RetrofitClient.getClient(BASE_URL).create(IMyAPI.class);
    }
}
