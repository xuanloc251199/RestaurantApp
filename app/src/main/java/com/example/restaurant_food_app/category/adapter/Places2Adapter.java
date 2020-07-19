package com.example.restaurant_food_app.category.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.restaurant_food_app.R;
import com.example.restaurant_food_app.category.model.Places2;
import com.example.restaurant_food_app.home.view.DetailPlaceActivity;

import java.util.ArrayList;
import java.util.List;

public class Places2Adapter extends RecyclerView.Adapter<Places2Adapter.ViewHolder> {

    Context mContext;
    List<Places2> mData;
    List<Places2> mDataFiltered;
    RequestOptions mOptions;

    public Places2Adapter(Context mContext, List<Places2> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.mDataFiltered = mData;


        mOptions = new RequestOptions().centerCrop()
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_bad);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_place2,
                parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Places2 places2 = mDataFiltered.get(position);

        holder.mNameProduct.setText(places2.getTen());
        holder.mRateProduct.setText(String.valueOf(places2.getDanhgia()));
        holder.mNamePlace.setText(places2.getDiachi());

//        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
//        holder.mRateProduct.setText(decimalFormat.format(products.getGia())+" ₫");//gia

        holder.mCardView.setAnimation(AnimationUtils
                        .loadAnimation(mContext,R.anim.fade_scale_animation));

        Glide.with(mContext).load(places2.getAvtDiadiem())
                .apply(mOptions)
                .into(holder.mImgProduct);

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailPlaceActivity.class);

                //Pass data
                intent.putExtra("ID_Place", places2.getIdDiadiem());
                intent.putExtra("Name Place", places2.getTen());
                intent.putExtra("Address", places2.getDiachi());
                intent.putExtra("Location", places2.getVung());
                intent.putExtra("Contact", places2.getLienhe());
                intent.putExtra("Open", places2.getOpen());
                intent.putExtra("Close", places2.getClose());
                intent.putExtra("Avt Place", places2.getAvtDiadiem());
                intent.putExtra("Map", places2.getBando());
                intent.putExtra("Evaluate", places2.getDanhgia());
                intent.putExtra("Category", places2.getTheloai());

                //Star Activity
                mContext.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return mDataFiltered.size();
    }


    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String Key = constraint.toString();
                if (Key.isEmpty()) {

                    mDataFiltered = mData ;

                }
                else {
                    List<Places2> lstPlaces2 = new ArrayList<>();
                    for (Places2 row : mData) {

                        if (row.getTen().toLowerCase().contains(Key.toLowerCase())){
                            lstPlaces2.add(row);
                        }

                    }

                    mDataFiltered = lstPlaces2;

                }


                FilterResults filterResults = new FilterResults();
                filterResults.values= mDataFiltered;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {


                mDataFiltered = (List<Places2>) results.values;
                notifyDataSetChanged();

            }
        };




    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImgProduct, mStarProduct;
        TextView mNameProduct, mRateProduct, mNamePlace;
        CardView mCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImgProduct = itemView.findViewById(R.id.img_product_id);
            mStarProduct = itemView.findViewById(R.id.imgStar_id);
            mNameProduct = itemView.findViewById(R.id.name_place2_id);
            mRateProduct = itemView.findViewById(R.id.star_product_id);
            mNamePlace = itemView.findViewById(R.id.prod_name_place_id);
            mCardView = itemView.findViewById(R.id.cardViewProduct_id);

        }
    }
}
