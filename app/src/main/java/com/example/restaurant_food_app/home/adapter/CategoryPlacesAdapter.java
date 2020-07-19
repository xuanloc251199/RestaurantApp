package com.example.restaurant_food_app.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_food_app.R;
import com.example.restaurant_food_app.home.model.CategoryPlaces;
import com.example.restaurant_food_app.home.view.DetailPlaceActivity;

import java.util.List;

public class CategoryPlacesAdapter extends RecyclerView.Adapter<CategoryPlacesAdapter.ViewHolder> {

    Context mContext;
    List<CategoryPlaces> mData;

    public CategoryPlacesAdapter(Context mContext, List<CategoryPlaces> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_places,
                parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mImagePlaces.setImageResource(mData.get(position).getImagePlaces());
        holder.mTitlePlaces.setText(mData.get(position).getTitlePlaces());
        holder.mDesPlaces.setText(mData.get(position).getDesPlaces());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailPlaceActivity.class);

                intent.putExtra("Image", mData.get(position).getImagePlaces());
                intent.putExtra("Title", mData.get(position).getTitlePlaces());

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImagePlaces;
        TextView mTitlePlaces, mDesPlaces;
        CardView mCardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImagePlaces = itemView.findViewById(R.id.img_place_id);
            mTitlePlaces = itemView.findViewById(R.id.name_place_id);
            mDesPlaces = itemView.findViewById(R.id.address_place_id);
            mCardView = itemView.findViewById(R.id.cardViewPlace_id);
        }
    }
}
