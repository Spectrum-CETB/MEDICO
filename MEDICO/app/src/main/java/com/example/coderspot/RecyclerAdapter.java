package com.example.coderspot;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyviewHolder> {
    Context context;
    List<SONGS> songsList;


    public RecyclerAdapter(Context context, List<SONGS> songsList) {
        this.context = context;
        this.songsList = songsList;
    }
    public void setSongsList(List<SONGS> songsList) {
        this.songsList = songsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_adapter,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyviewHolder holder, int position) {
        holder.tvSongName.setText(songsList.get(position).getTitle().toString());
 Picasso.get().load(Uri.parse(songsList.get(position).getImageUrl())).into(holder.image);
        /* Glide.with(context).load(Uri.parse(songsList.get(position).getImageUrl())).apply(RequestOptions.centerCropTransform()).into(holder.image); */
    }

    @Override
    public int getItemCount() {
        if(songsList != null){
            return songsList.size();
        }
        return 0;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder  {
        TextView tvSongName;
        ImageView image;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
             tvSongName = (TextView) itemView.findViewById(R.id.title);
            image = (ImageView)itemView.findViewById(R.id.image);
        }
    }
}
