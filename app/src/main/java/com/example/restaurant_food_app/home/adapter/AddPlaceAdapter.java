package com.example.restaurant_food_app.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_food_app.R;
import com.example.restaurant_food_app.home.model.AddressPlace;

import java.util.List;

public class AddPlaceAdapter extends RecyclerView.Adapter<AddPlaceAdapter.ViewHolder>{

    Context mContext;
    List<AddressPlace> mData;

    public AddPlaceAdapter(Context mContext, List<AddressPlace> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =LayoutInflater.from(mContext).inflate(R.layout.item_address_place,
                parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.thumbnail.setImageResource(mData.get(position).getThumbnailAdd());
        holder.title.setText(mData.get(position).getTitleAdd());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView thumbnail;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail_add_id);
            title = (TextView) itemView.findViewById(R.id.title_add_id);

        }
    }
}
