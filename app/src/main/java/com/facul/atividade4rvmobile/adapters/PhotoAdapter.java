package com.facul.atividade4rvmobile.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import com.facul.atividade4rvmobile.R;
import com.facul.atividade4rvmobile.model.Photo;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder>{

    private List<Photo> dados;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public PhotoAdapter(List<Photo> photos){
        this.dados = photos;
    }

    @NonNull
    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photo_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.ViewHolder holder, int position) {
        Photo photo = dados.get(position);

        TextView tv1 = holder.view.findViewById(R.id.tvPhotoTitulo);
        tv1.setText(photo.getTitle());

        TextView tv2 = holder.view.findViewById(R.id.tvPhotoIdAlbum);
        tv2.setText(""+photo.getAlbumId());

        ImageView iv1 = holder.view.findViewById(R.id.tvPhotoImage);
        Picasso.get().load(photo.getUrl()).into(iv1);

        ImageView iv2 = holder.view.findViewById(R.id.tvPhotoThumbnail);
        Picasso.get().load(photo.getThumbnailUrl()).into(iv2);
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}
