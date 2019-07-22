package com.example.submission1;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.submission1.main.MovieAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShow extends Fragment {
    private RecyclerView recyclerView;

    public TvShow() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_show);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<MovieModel> ambilNih = ambilData();

        MovieAdapter adapter = new MovieAdapter(requireContext(), ambilNih);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private ArrayList<MovieModel> ambilData() {
        String[] judul_show = getResources().getStringArray(R.array.judul_show);
        String[] deskripsi_show = getResources().getStringArray(R.array.deskripsi_show);
        TypedArray gambar_show = getResources().obtainTypedArray(R.array.show_poster);

        ArrayList<MovieModel> movies = new ArrayList<>();
        for (int i = 1; i <= judul_show.length; i++) {
            movies.add(new MovieModel(judul_show[i - 1], deskripsi_show[i - 1], gambar_show.getResourceId(i - 1, 0)));
        }
        return movies;
    }
}