package com.example.coderspot;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_list extends  Fragment{
    List<SONGS> songsList;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        songsList = new ArrayList<>();
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new RecyclerAdapter(getActivity().getApplicationContext(),songsList);
        recyclerView.setAdapter(recyclerAdapter);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<SONGS>> call = apiService.getSONGS();
call.enqueue(new Callback<List<SONGS>>() {
    @Override
    public void onResponse(Call<List<SONGS>> call, Response<List<SONGS>> response) {
        songsList = response.body();
        Log.d("TAG","Response = "+songsList);
        recyclerAdapter.setSongsList(songsList);
    }

    @Override
    public void onFailure(Call<List<SONGS>> call, Throwable t) {
        Log.d("TAG","Response = "+t.toString());
    }
});

    }
}
