package app.kdblue.com.androidmvpeasytutorial.Presenter;

import java.util.List;

import app.kdblue.com.androidmvpeasytutorial.Contract;
import app.kdblue.com.androidmvpeasytutorial.Model.Repository;
import app.kdblue.com.androidmvpeasytutorial.Pojo.Posts;

public class PresenterImpl implements Contract.Presenter {

    private Contract.View view;
    private Contract.Repository repository;


    //Alaways remember Presenter only connects view and repository .
    public PresenterImpl(Contract.View view) {
        this.view = view;
        this.repository = new Repository(this);
    }

    //this method come from Presenter interface which is in contract
    @Override
    public void onPostsRequest() {
        repository.repoPosts();
    }

    //this method come from Presenter interface which is in contract
    @Override
    public void onSuccess(List<Posts> postsList) {
        view.onSuccessResult(postsList);
    }

    //this method come from Presenter interface which is in contract
    @Override
    public void onFailed(String msg) {
        view.onFailedResult(msg);
    }

}
