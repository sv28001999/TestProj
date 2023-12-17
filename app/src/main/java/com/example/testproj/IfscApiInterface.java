package com.example.testproj;

import com.example.testproj.models.IfscResponseBody;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IfscApiInterface {
    @GET("{ifscEndPoint}")
    Call<IfscResponseBody> getIfscInfo(@Path("ifscEndPoint") String ifscCode);
}
