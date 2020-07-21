package com.example.restaurant_food_app.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.restaurant_food_app.home.model.Places;
import com.example.restaurant_food_app.home.view.DetailPlaceActivity;

import java.util.ArrayList;
import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.MyViewHolder> {


    Context mContext;
    List<Places> mData;
    List<Places> mDataFiltered;
    RequestOptions options;

    public PlacesAdapter(Context mContext, List<Places> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.mDataFiltered = mData;

            options = new RequestOptions()
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_bad);
    }




    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.item_places,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        final Places places = mDataFiltered.get(position);

        MyViewHolder viewHolder = holder;

        viewHolder.titlePlace.setText(places.getTen());
        viewHolder.addressPlace.setText(places.getDiachi());
        viewHolder.evaluatePlace.setText(String.valueOf(places.getDanhgia()));

        //Load Image
        Glide.with(mContext).load(places.getAvtDiadiem())
                .apply(options)
                .into(holder.imgPlace);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailPlaceActivity.class);

                //Pass data
                intent.putExtra("ID_Place", places.getIdDiadiem());
                intent.putExtra("Name Place", places.getTen());
                intent.putExtra("Address", places.getDiachi());
                intent.putExtra("Location", places.getVung());
                intent.putExtra("Contact", places.getLienhe());
                intent.putExtra("Open", places.getOpen());
                intent.putExtra("Close", places.getClose());
                intent.putExtra("Avt Place", places.getAvtDiadiem());
                intent.putExtra("Evaluate", places.getDanhgia());
                intent.putExtra("Category", places.getTheloai());
                intent.putExtra("X", places.getX());
                intent.putExtra("Y", places.getY());

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
                    List<Places> lstPlaces = new ArrayList<>();
                    for (Places row : mData) {

                        if (row.getTen().toLowerCase().contains(Key.toLowerCase())){
                            lstPlaces.add(row);
                        }


                    }

                    mDataFiltered = lstPlaces;

                }


                FilterResults filterResults = new FilterResults();
                filterResults.values= mDataFiltered;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {


                mDataFiltered = (List<Places>) results.values;
                notifyDataSetChanged();

            }
        };




    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titlePlace, addressPlace, evaluatePlace;
        ImageView imgPlace;
        CardView cardView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titlePlace = itemView.findViewById(R.id.name_place_id);
            addressPlace = itemView.findViewById(R.id.address_place_id);
            evaluatePlace = itemView.findViewById(R.id.evaluate_place_id);
            imgPlace = itemView.findViewById(R.id.img_place_id);
            cardView = itemView.findViewById(R.id.cardViewPlace_id);

        }

    }
}
