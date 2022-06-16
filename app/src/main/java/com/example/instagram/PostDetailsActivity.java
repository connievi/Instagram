package com.example.instagram;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.parceler.Parcel;
import org.parceler.Parcels;
import org.w3c.dom.Text;

import java.util.Date;

public class PostDetailsActivity extends AppCompatActivity {
    public static final String TAG = "PostDetailsActivity";
    private TextView tvUsername;
    private TextView tvCaption;
    private TextView tvCreatedAt;
    //private ImageView ivImage;

    Post post;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvCaption = (TextView) findViewById(R.id.tvCaption);
        tvCreatedAt = (TextView) findViewById(R.id.tvCreatedAt);
        //ivImage = (ImageView) findViewById(R.id.ivImage);

        if (getIntent().getExtras() != null) {
            post = (Post) getIntent().getParcelableExtra("Post");
        }

        tvCaption.setText(post.getDescription());
        tvUsername.setText(post.getUser().getUsername());

        Date createdAt = post.getCreatedAt();
        String timeAgo = Post.calculateTimeAgo(createdAt);
        tvCreatedAt.setText(timeAgo);
    }



}