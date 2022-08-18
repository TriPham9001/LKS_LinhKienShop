package com.example.lks_linhkienshop.retrofit;
import com.example.lks_linhkienshop.Model.Category;
import com.example.lks_linhkienshop.Model.HoaDon;
import com.example.lks_linhkienshop.Model.Image;
import com.example.lks_linhkienshop.Model.KhachHang;
import com.example.lks_linhkienshop.Model.SanPham;
import com.example.lks_linhkienshop.Model.Search;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IRetrofitService {


    @POST("views/khach_hang_login.php")
    Call<KhachHang> login(@Body KhachHang kh);

    @POST("views/san_pham_get_voucher.php")
    Call<List<SanPham>> sanphamhot();

    @POST("views/san_pham_get_images.php")
    Call<List<Image>> getimges(@Body SanPham sp);

    @POST("views/gio_hang_post.php")
    Call<HoaDon> taoHoaDon(@Body HoaDon hd);

    @POST("views/the_loai_get_all.php")
    Call<List<Category>> getCategory();

    @POST("views/san_pham_get_by_the_loai.php")
    Call<List<SanPham>> getSPByCategory(@Body Category category);

    @POST("views/search.php")
    Call<List<Search>> search(@Body Search txtSearch);


}
