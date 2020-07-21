package com.example.restaurant_food_app.home.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.restaurant_food_app.R;
import com.example.restaurant_food_app.home.adapter.CategoryPlacesAdapter;
import com.example.restaurant_food_app.home.adapter.PlacesAdapter;
import com.example.restaurant_food_app.home.model.CategoryPlaces;
import com.example.restaurant_food_app.home.model.Places;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ItemCategoryActivity extends AppCompatActivity {

    private final String JSON_URL = "http://192.168.0.110/webproject/public/APIdiadiemMonan" ;
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;


    private List<Places> placesFlowCategory ;
    private RecyclerView mRecyclerView ;


    TextView mNameCategory;
    Button mButtonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_category);


        placesFlowCategory = new ArrayList<>() ;


        mappedId();

        intentView();

        eventButton();

        jsonrequest();


    }



    //Intent
    private void intentView() {

        Intent intent = getIntent();
        String title = intent.getExtras().getString("Name Category");

        mNameCategory.setText(title);

    }


    //Mapped Id
    private void mappedId() {

        mRecyclerView = findViewById(R.id.recycler_category_places_id);
        mNameCategory = findViewById(R.id.name_item_category_id);

    }

    //Event
    private void eventButton() {
        //        mButtonBack = findViewById(R.id.btn_back_id);
//        mButtonBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ItemCategoryActivity.this, CategoryFragment.class);
//                startActivity(intent);
//            }
//        });
    }


    //Json
    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {


                    try {
                        jsonObject = response.getJSONObject(i) ;

                        String imgPlaceUrl = "http://192.168.0.110/webproject/public/ANHDD/";

                        Places places = new Places() ;
                        places.setIdDiadiem(jsonObject.getInt("id_diadiem"));
                        places.setTen(jsonObject.getString("ten"));
                        places.setDiachi(jsonObject.getString("diachi"));
                        places.setVung(jsonObject.getString("vung"));
                        places.setLienhe(jsonObject.getString("lienhe"));
                        places.setOpen(jsonObject.getString("open"));
                        places.setClose(jsonObject.getString("close"));
                        places.setAvtDiadiem(imgPlaceUrl + jsonObject.getString("avt"));
                        places.setDanhgia(jsonObject.getDouble("danhgia"));
                        places.setDanhgia(jsonObject.getDouble("x"));
                        places.setDanhgia(jsonObject.getDouble("y"));
                        placesFlowCategory.add(places);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(placesFlowCategory);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(ItemCategoryActivity.this);
        requestQueue.add(request) ;


    }

    private void setuprecyclerview(List<Places> placesList) {


        PlacesAdapter placesAdapter = new PlacesAdapter(this, placesList) ;
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(placesAdapter);

    }
}
