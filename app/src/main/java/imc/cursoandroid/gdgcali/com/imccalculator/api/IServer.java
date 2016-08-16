package imc.cursoandroid.gdgcali.com.imccalculator.api;

import java.util.ArrayList;
import java.util.List;

import imc.cursoandroid.gdgcali.com.imccalculator.model.iagree.ObligationsModel;
import imc.cursoandroid.gdgcali.com.imccalculator.model.wp.RecentPostAnswer;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by joseberna on 16/08/16.
 */
public interface IServer {
    @GET("/")
    void GetRecentPost(@Query("json") String json, Callback<ArrayList<RecentPostAnswer>> resp);


    @POST("/iAgree/rest/AcuerdosComWS/obtenerObligacionesiAgree")
    void getObligations(@Body String body, Callback<List<ObligationsModel>> response);

}
