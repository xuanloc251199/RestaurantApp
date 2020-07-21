package com.example.restaurant_food_app.category.adapter;

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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.restaurant_food_app.category.view.DrinksActivity;
import com.example.restaurant_food_app.category.view.FastFoodsActivity;
import com.example.restaurant_food_app.category.view.FoodActivity;
import com.example.restaurant_food_app.R;
import com.example.restaurant_food_app.category.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    Context mContext;
    List<Category> mData;
    RequestOptions options;


    public CategoryAdapter(Context mContext, List<Category> mData) {
        this.mContext = mContext;
        this.mData = mData;

        options = new RequestOptions().centerCrop()
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_category, parent,
                false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        ViewHolder viewHolder = holder;

        viewHolder.title.setText(mData.get(position).getTheloai());
        Glide.with(mContext).load(mData.get(position).getThumbnail())
                .apply(options)
                .into(holder.thumbnail);

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position){
                    case 0: {

                        intentCategory(FoodActivity.class, position);

                    }
                    break;
                    case 1: {

                        intentCategory(DrinksActivity.class, position);

                    }
                    break;
                    case 2: {

                        intentCategory(FastFoodsActivity.class, position);

                    }
                    break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + position);
                }

            }
        });

    }

    private void intentCategory(Class<?> activityClass, int position) {

        Intent intent = new Intent(mContext, activityClass);


        intent.putExtra("Id_Category", mData.get(position).getIdTheloai());
        intent.putExtra("Name Category", mData.get(position).getTheloai());
        intent.putExtra("Thumbnail Category", mData.get(position).getThumbnail());

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView thumbnail;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_category_id);
            thumbnail = itemView.findViewById(R.id.thumbnail_category_id);
            cardView = itemView.findViewById(R.id.cardViewCategory_id);


        }
    }
}
