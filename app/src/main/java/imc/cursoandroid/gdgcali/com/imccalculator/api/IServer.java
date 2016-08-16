package imc.cursoandroid.gdgcali.com.imccalculator.api;

import java.util.ArrayList;

import imc.cursoandroid.gdgcali.com.imccalculator.model.wp.RecentPostAnswer;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by joseberna on 16/08/16.
 */
public interface IServer {
    @GET("/")
    void GetRecentPost(@Query("json") String json, Callback<ArrayList<RecentPostAnswer>> resp);

}
