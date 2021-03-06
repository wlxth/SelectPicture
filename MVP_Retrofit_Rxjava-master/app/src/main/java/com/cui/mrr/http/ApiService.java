package com.cui.mrr.http;


import com.cui.mrr.entity.ListEntity;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by cuiyang on 16/6/1.
 */
public interface ApiService {


    @GET("selectlubotuNews")
    Observable<List<ListEntity>> getMainList();

    @Streaming //使用Streaming将不把文件读进内存
    @GET
    Observable<ResponseBody> downloadFile(@Url String url);
}
