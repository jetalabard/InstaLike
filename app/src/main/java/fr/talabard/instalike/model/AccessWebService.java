package fr.talabard.instalike.model;

import fr.talabard.instalike.InstaLikeService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AccessWebService {

    private static AccessWebService instance;
    private static InstaLikeService service;
    protected InstaLikeService webService;

    private static final String URL = "https://salty-tor-38087.herokuapp.com";

    private AccessWebService(){
        createClient();
    }

    public static InstaLikeService getClient(){
        if(instance == null){
            instance = new AccessWebService();
        }
        return service;
    }

    protected void createClient(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory .create())
                .client(httpClient.build())
                .build();

        service = retrofit.create(InstaLikeService.class);

    }

}
