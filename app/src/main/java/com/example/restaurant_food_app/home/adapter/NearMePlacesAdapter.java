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
import com.example.restaurant_food_app.home.model.NearMePlaces;
import com.example.restaurant_food_app.home.view.DetailPlaceActivity;

import java.util.List;

public class NearMePlacesAdapter extends RecyclerView.Adapter<NearMePlacesAdapter.ViewHolder> {

    Context mContext;
    List<NearMePlaces> mData;

    public NearMePlacesAdapter(Context mContext, List<NearMePlaces> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_places,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.mImgPlace.setImageResource(mData.get(position).getImgPlace());
        holder.mNamePlace.setText(mData.get(position).getNamePlace());
        holder.mDesPlace.setText(mData.get(position).getDesPlace());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailPlaceActivity.class);

                intent.putExtra("Image", mData.get(position).getImgPlace());
                intent.putExtra("Title", mData.get(position).getNamePlace());

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

        ImageView mImgPlace;
        TextView mNamePlace, mDesPlace;
        CardView mCardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImgPlace = itemView.findViewById(R.id.img_place_id);
            mNamePlace = itemView.findViewById(R.id.name_place_id);
            mDesPlace = itemView.findViewById(R.id.address_place_id);
            mCardView = itemView.findViewById(R.id.cardViewPlace_id);

        }
    }
}
