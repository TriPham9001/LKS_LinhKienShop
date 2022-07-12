package com.example.lks_linhkienshop.retrofit;
import com.example.lks_linhkienshop.Model.KhachHang;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IRetrofitService {


    @POST("views/khach_hang_login.php")
    Call<KhachHang> login(@Body KhachHang kh);


}
