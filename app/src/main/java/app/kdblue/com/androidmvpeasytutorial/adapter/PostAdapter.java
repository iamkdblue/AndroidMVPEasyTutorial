package app.kdblue.com.androidmvpeasytutorial.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.kdblue.com.androidmvpeasytutorial.Pojo.Posts;
import app.kdblue.com.androidmvpeasytutorial.R;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyPostViewHolder> {

    private List<Posts> postsList;

    public PostAdapter(List<Posts> postsList) {
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public MyPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_posts, parent, false);
        return new MyPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPostViewHolder holder, int position) {
        Posts posts = postsList.get(position);

        holder.tvTitle.setText(posts.getTitle());
        holder.tvDescription.setText(posts.getBody());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class MyPostViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle,tvDescription;

        public MyPostViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
