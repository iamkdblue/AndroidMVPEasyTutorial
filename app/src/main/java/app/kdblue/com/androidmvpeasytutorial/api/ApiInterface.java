package app.kdblue.com.androidmvpeasytutorial.api;

import java.util.List;

import app.kdblue.com.androidmvpeasytutorial.Pojo.Posts;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Call<List<Posts>> getPosts();

}
