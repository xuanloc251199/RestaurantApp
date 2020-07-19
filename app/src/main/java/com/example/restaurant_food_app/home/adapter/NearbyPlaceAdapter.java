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
import com.example.restaurant_food_app.home.model.NearbyPlace;
import com.example.restaurant_food_app.home.view.DetailPlaceActivity;
import java.util.List;

public class NearbyPlaceAdapter extends RecyclerView.Adapter<NearbyPlaceAdapter.ViewHolder> {

    Context mContext;
    List<NearbyPlace> mData;

    public NearbyPlaceAdapter(Context mContext, List<NearbyPlace> mData) {
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

        holder.mImgNearbyPlace.setImageResource(mData.get(position).getImgNeatbyPlace());
        holder.mTitleNearbyPlace.setText(mData.get(position).getTitleNearbyPlace());
        holder.mDesNearbyPlace.setText(mData.get(position).getDesNearbyPlace());

        holder.mCvNearbyPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailPlaceActivity.class);

                intent.putExtra("Image", mData.get(position).getImgNeatbyPlace());
                intent.putExtra("Title", mData.get(position).getTitleNearbyPlace());
//                intent.putExtra("Description", mData.get(position).getDesNearbyPlace());

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView mImgNearbyPlace;
        TextView mTitleNearbyPlace, mDesNearbyPlace;
        CardView mCvNearbyPlace;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImgNearbyPlace = itemView.findViewById(R.id.img_place_id);
            mTitleNearbyPlace = itemView.findViewById(R.id.name_place_id);
            mDesNearbyPlace = itemView.findViewById(R.id.address_place_id);
            mCvNearbyPlace = itemView.findViewById(R.id.cardViewPlace_id);
        }
    }
}
