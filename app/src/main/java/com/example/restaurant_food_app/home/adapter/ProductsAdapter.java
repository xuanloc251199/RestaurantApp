package com.example.restaurant_food_app.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.restaurant_food_app.R;
import com.example.restaurant_food_app.home.model.Places;
import com.example.restaurant_food_app.home.model.Products;

import java.text.DecimalFormat;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    Context mContext;
    List<Products> mData;
    RequestOptions options;

    public ProductsAdapter(Context mContext, List<Products> mData) {
        this.mContext = mContext;
        this.mData = mData;

        options = new RequestOptions()
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_bad);

    }

    @NonNull
    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_products,
                parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.ViewHolder holder, int position) {

        Products products = mData.get(position);

        holder.mNameProduct.setText(products.getNameSanpham());
        holder.mPriceProduct.setText(String.valueOf(products.getGia()));
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.mPriceProduct.setText(decimalFormat.format(products.getGia())+" ₫");

        Glide.with(mContext).load(products.getAvtSanpham())
                .apply(options)
                .into(holder.mImgProduct);



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mNameProduct, mPriceProduct;
        ImageView mImgProduct;
        ConstraintLayout mConstraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mNameProduct = itemView.findViewById(R.id.tv_nameProduct_id);
            mPriceProduct = itemView.findViewById(R.id.tv_priceProduct_id);
            mImgProduct = itemView.findViewById(R.id.img_product_id);
            mConstraintLayout = itemView.findViewById(R.id.conProduct_id);


        }
    }
}
