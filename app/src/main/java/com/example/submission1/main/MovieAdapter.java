package com.example.submission1.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.submission1.MovieModel;
import com.example.submission1.R;
import com.example.submission1.details.DetailsActivity;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHoloder> {
    private Context context;
    private List<MovieModel> items;

    public MovieAdapter(Context context, List<MovieModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MovieViewHoloder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MovieViewHoloder(LayoutInflater.from(context).inflate(R.layout.list_movie,
                viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHoloder movieViewHoloder, int i) {
        movieViewHoloder.bindItem(items.get(i));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MovieViewHoloder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView judul;

        public MovieViewHoloder(@NonNull View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.iv_poster_list);
            judul = itemView.findViewById(R.id.tv_judul_list);
        }

        void bindItem(final MovieModel info) {
            poster.setImageResource(info.getPoster());
            judul.setText(info.getTitle());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, DetailsActivity.class);
                    i.putExtra("data", info);
                    context.startActivity(i);
                }
            });
        }
    }
}
