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
import com.example.restaurant_food_app.home.model.Evaluate;

import java.util.List;

public class EvaluateAdapter extends RecyclerView.Adapter<EvaluateAdapter.ViewHolder> {

    Context mContext;
    List<Evaluate> mData;

    public EvaluateAdapter(Context mContext, List<Evaluate> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_evaluate,
                parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.thumbnailEva.setImageResource(mData.get(position).getThumbnailEva());
        holder.titleEva.setText(mData.get(position).getTitleEva());
        holder.amountEva.setText(mData.get(position).getAmountEva());

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, FastFoodActivity.class);
//
//                mContext.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView thumbnailEva;
        private TextView titleEva, amountEva;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

             thumbnailEva = itemView.findViewById(R.id.thumbnailEva_id);
             titleEva = itemView.findViewById(R.id.titleEva_id);
             amountEva = itemView.findViewById(R.id.amountEva_id);
             cardView = itemView.findViewById(R.id.cardViewEva_id);
        }
    }
}
