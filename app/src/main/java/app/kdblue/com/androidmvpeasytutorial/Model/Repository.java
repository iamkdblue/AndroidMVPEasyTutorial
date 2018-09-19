package app.kdblue.com.androidmvpeasytutorial.Model;

import java.util.List;

import app.kdblue.com.androidmvpeasytutorial.Contract;
import app.kdblue.com.androidmvpeasytutorial.Pojo.Posts;
import app.kdblue.com.androidmvpeasytutorial.api.ApiClient;
import app.kdblue.com.androidmvpeasytutorial.api.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository implements Contract.Repository {

    private Contract.Presenter presenter;
    ApiInterface apiService ;

    public Repository(Contract.Presenter presenter) {
        this.presenter = presenter;
        apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    @Override
    public void repoPosts() {
        Call<List<Posts>> postsCall = apiService.getPosts();

        postsCall.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {

                List<Posts> postsList = response.body();
                //Here i am passing response to presenter
                presenter.onSuccess(postsList);

            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

                //Here i am passing response to presenter
                presenter.onFailed(t.getMessage());
            }
        });

    }
}
