package com.happykart.android.data.remote;

import com.happykart.android.data.remote.model.ProductListResponse;
import com.happykart.android.data.remote.model.ProductResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @GET("api/v1/products.json")
    Observable<ProductListResponse> getProductList(@Query("page") int page, @Query("category") String category);

    @GET("api/v1/products/{id}.json")
    Observable<ProductResponse> getProduct(@Path("id") long id);

}
