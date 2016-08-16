package imc.cursoandroid.gdgcali.com.imccalculator.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by joseberna on 16/08/16.
 */
public class Server {
    private static Server instance;
    private IServer facade;

    protected Server() {
    }

    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    public void init(String url, final Context context) {

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new ItemTypeAdapterFactory()) // This is the important line ;)
                .create();


        RestAdapter AdapterWithHeaders = new RestAdapter.Builder()
                .setEndpoint(url)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .build();
        facade = AdapterWithHeaders.create(IServer.class);
    }


    public static IServer getSingleton() {
        return getInstance().facade;
    }

}
