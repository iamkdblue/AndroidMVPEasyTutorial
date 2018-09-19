package app.kdblue.com.androidmvpeasytutorial.View;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import app.kdblue.com.androidmvpeasytutorial.Contract;
import app.kdblue.com.androidmvpeasytutorial.Pojo.Posts;
import app.kdblue.com.androidmvpeasytutorial.Presenter.PresenterImpl;
import app.kdblue.com.androidmvpeasytutorial.R;
import app.kdblue.com.androidmvpeasytutorial.adapter.PostAdapter;

public class MainActivity extends AppCompatActivity implements Contract.View {


    /*DISCLAIMER*/

    /*IF YOU ARE LOOKING THIS CODE FIRST TIME , THEN FIRST SEE
    * CONTRACT INTERFACE , ITS HELP YOU TO UNDERSTAND WHATS GOING HERE :)*/


    private RecyclerView rvPosts;
    private PostAdapter postAdapter;
    protected PresenterImpl presenterImpl;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvPosts = findViewById(R.id.rvPosts);
        rvPosts.setLayoutManager(new LinearLayoutManager(this));

        //remember only view talk to presenter
        presenterImpl = new PresenterImpl(this);

        showProgress();
        presenterImpl.onPostsRequest();
    }

    //part of View as i mention in blog(show loading) , coming from View interface which is in Contract Interface
    @Override
    public void showProgress() {
        progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
    }

    //part of View as i mention in blog(hide loading) ,coming from View interface which is in Contract Interface
    @Override
    public void hideProgress() {
        if (progress != null) {
            progress.dismiss();
        }
    }

    //Result come from presenter ,coming from View interface which is in Contract Interface
    @Override
    public void onSuccessResult(List<Posts> postsList) {

        hideProgress();
        if (postsList != null && postsList.size() > 0) {
            postAdapter = new PostAdapter(postsList);
            rvPosts.setAdapter(postAdapter);
        }

    }

    //Result come from presenter ,coming from View interface which is in Contract Interface
    @Override
    public void onFailedResult(String msg) {
        hideProgress();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
