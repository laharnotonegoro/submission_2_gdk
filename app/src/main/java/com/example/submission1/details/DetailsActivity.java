package com.example.submission1.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.submission1.MovieModel;
import com.example.submission1.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView ivPoster = findViewById(R.id.iv_poster_list_detail);
        TextView tvjudul = findViewById(R.id.tv_judul_list_detail);
        TextView deskripsi = findViewById(R.id.tv_deskripsi_detail);

        if (getIntent().getExtras() != null) {
            MovieModel movie = getIntent().getParcelableExtra("data");

            ivPoster.setImageResource(movie.getPoster());
            tvjudul.setText(movie.getTitle());
            deskripsi.setText(movie.getDescription());
        }
    }
}
