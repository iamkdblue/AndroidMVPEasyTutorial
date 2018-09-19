package app.kdblue.com.androidmvpeasytutorial;

import java.util.List;

import app.kdblue.com.androidmvpeasytutorial.Pojo.Posts;

public interface Contract {


    /*I created this interface for simplicity , so you can add
     * new feature in future .its helps alot , i will suggest you this pattern*/

    //View
    interface View{
        void showProgress();
        void hideProgress();
        void onSuccessResult(List<Posts> postsList);
        void onFailedResult(String msg);
    }

    //Presenter
    interface Presenter{

        //sending request to repository
        void onPostsRequest();

        //receiving response from repository
        void onSuccess(List<Posts> postsList);

        //receiving response from repository
        void onFailed(String msg);

    }

    //Repository
    interface Repository{
        void repoPosts();
    }

}
