package fr.talabard.instalike;

import java.util.List;

import fr.talabard.instalike.business.ILPicture;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jerem on 31/03/2017.
 */

public interface InstaLikeService {
    public static final String URL = "https://salty-tor-38087.herokuapp.com";

    @GET("/pictures/news")
    Call<List<ILPicture>>  getNews();

    @GET("/pictures/detail/{id}")
    Call<ILPicture> getDetailsOfPicture(@Path("id") long id);
}
