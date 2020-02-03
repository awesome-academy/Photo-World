package vn.tien.photo_world.screen.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.tien.photo_world.R;
import vn.tien.photo_world.data.model.Photo;
import vn.tien.photo_world.screen.edit.EditActivity;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<Photo> mPhotos;
    private Context mConText;

    public HomeAdapter(Context context, List<Photo> photos) {
        mPhotos = photos;
        mConText = context;
    }

    public void setSearchResult(List<Photo> photos) {
        mPhotos = photos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_photo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photo photo = mPhotos.get(position);
        holder.mTextName.setText(photo.getAuthor().getName());
        holder.mTextDate.setText(photo.getCreateDay());
        holder.mTextDescrip.setText(photo.getDescription());

        Glide.with(holder.mPhoto.getContext()).load(photo.getUrls().getFull())
                .into(holder.mPhoto);
        holder.mPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = EditActivity.getIntent(mConText);
                mConText.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mPhotos == null ? 0 : mPhotos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mPhoto;
        private TextView mTextName;
        private TextView mTextDate;
        private TextView mTextDescrip;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mPhoto = itemView.findViewById(R.id.image_photo);
            mTextName = itemView.findViewById(R.id.text_name);
            mTextDate = itemView.findViewById(R.id.text_date);
            mTextDescrip = itemView.findViewById(R.id.text_descrip);
        }
    }
}