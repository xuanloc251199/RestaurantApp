package com.example.restaurant_food_app.home.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.restaurant_food_app.R;
import com.example.restaurant_food_app.home.adapter.PlacesAdapter;
import com.example.restaurant_food_app.home.adapter.ProductsAdapter;
import com.example.restaurant_food_app.home.model.Places;
import com.example.restaurant_food_app.home.model.Products;
import com.example.restaurant_food_app.main.NavigationBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetailPlaceActivity extends AppCompatActivity {

    //Json
    private JsonArrayRequest jsonArrayRequest;
    private RequestQueue requestQueue;

    //Recycler View
    private List<Products> lstProduct = new ArrayList<>();
    private List<Places> lstPlaces = new ArrayList<>();
    private RecyclerView mRecyclerViewProduct, mRecyclerViewNearby;


    //Element Layout
    ImageView mImagePlace;
    TextView mTitlePlace, mNamePlace, mAddress, mLocation, mCategory,
            mContact, mTimeO, mTimeC;
    Button mButtonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place);

        mappedId();


        eventButton();


        intentData();



    }


    //Mapped Id
    private void mappedId() {

        mButtonBack = findViewById(R.id.btn_back_id);

        mRecyclerViewProduct = findViewById(R.id.recycler_products_id);
        mRecyclerViewNearby = findViewById(R.id.recycler_nearby_id);



        mTitlePlace = findViewById(R.id.titlePlace_id);
        mImagePlace = findViewById(R.id.info_img_place_id);
        mNamePlace = findViewById(R.id.info_name_place_id);
        mTimeO = findViewById(R.id.timeO_id);
        mTimeC = findViewById(R.id.timeC_id);
        mContact = findViewById(R.id.title_contact_id);
        mAddress = findViewById(R.id.title_add_id);
        mCategory = findViewById(R.id.title_cate_id);
        mLocation = findViewById(R.id.title_location_id);

    }


    //Event
    private void eventButton() {

        //Button Back
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailPlaceActivity.this, NavigationBar.class);
                startActivity(intent);
            }
        });


//        mCvViewProduct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DetailPlaceActivity.this, MenuProducts.class);
//                startActivity(intent);
//            }
//        });


    }


    //Intent
    @SuppressLint("SetTextI18n")
    public void intentData() {

        Intent intent = getIntent();
        int idPlace = intent.getExtras().getInt("ID_Place");
        String category = intent.getExtras().getString("Category");
        String title = intent.getExtras().getString("Name Place");
        String namePlace = intent.getExtras().getString("Name Place");
        String address = intent.getExtras().getString("Address");
        String location = intent.getExtras().getString("Location");
        String contact = intent.getExtras().getString("Contact");
        String timeOpen = intent.getExtras().getString("Open");
        String timeClose = intent.getExtras().getString("Close");
        String image = intent.getExtras().getString("Avt Place");
        String map = intent.getExtras().getString("Map");
        String evaluate = intent.getExtras().getString("Evaluate");


        mTitlePlace.setText(title);
        mNamePlace.setText(namePlace);
        mTimeO.setText("Mở: " + timeOpen);
        mTimeC.setText("Đóng: " + timeClose);
        mContact.setText(contact);
        mAddress.setText(address);
        mLocation.setText(location);
        mCategory.setText(category);

        RequestOptions requestOptions = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_bad);


        // set image using Glide
        Glide.with(this).load(image).apply(requestOptions).into(mImagePlace);


        String JSON_PRODUCT_URL = "http://192.168.43.124/webproject/public/APIsanpham/" + idPlace;
        String JSON_NEARBY_URL = "http://192.168.43.124/webproject/public/APIdiadiemlancan/" + location;

        initViewProducts(JSON_PRODUCT_URL);
        initViewNearby(JSON_NEARBY_URL);

    }

    //View - Recycler View
    private void initViewProducts(String JSON_URL) {

        jsonArrayRequest = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {

                    try {

                        String imgUrl = "http://192.168.43.124/webproject/public/ANHSP/";

                        jsonObject = response.getJSONObject(i) ;
                        Products products = new Products();


                            products.setNameSanpham(jsonObject.getString("name_sanpham"));
                            products.setGia(jsonObject.getInt("gia"));
                            products.setAvtSanpham(imgUrl + jsonObject.getString("avt_sanpham"));

                            lstProduct.add(products);



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setupProductRecycler(lstProduct);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DetailPlaceActivity.this, "Lỗi",Toast.LENGTH_SHORT);
            }
        });


        requestQueue = Volley.newRequestQueue(DetailPlaceActivity.this);
        requestQueue.add(jsonArrayRequest) ;


    }

    private void initViewNearby(String JSON_URL) {

        jsonArrayRequest = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {

                    try {

                        String imgUrl = "http://192.168.43.124/webproject/public/ANHDD/";

                        jsonObject = response.getJSONObject(i) ;


                        lstPlaces.add(
                                new Places(
                                        jsonObject.getInt("id_diadiem"),
                                        jsonObject.getString("ten"),
                                        jsonObject.getString("diachi"),
                                        jsonObject.getString("vung"),
                                        jsonObject.getString("lienhe"),
                                        jsonObject.getString("open"),
                                        jsonObject.getString("close"),
                                        imgUrl + jsonObject.getString("avt_diadiem"),
                                        jsonObject.getString("bando"),
                                        (float) jsonObject.getDouble("danhgia"),
                                        jsonObject.getString("theloai")
                                )
                        );



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setupNearbyRecycler(lstPlaces);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DetailPlaceActivity.this, "Lỗi",Toast.LENGTH_SHORT);
            }
        });


        requestQueue = Volley.newRequestQueue(DetailPlaceActivity.this);
        requestQueue.add(jsonArrayRequest) ;


    }

    //Set up Recycler
    private void setupProductRecycler(List<Products> lstProduct) {


        ProductsAdapter productsAdapter = new ProductsAdapter(this,lstProduct) ;
        mRecyclerViewProduct.setLayoutManager(new LinearLayoutManager(DetailPlaceActivity.this,
                RecyclerView.VERTICAL, false));
        mRecyclerViewProduct.setHasFixedSize(true);
        mRecyclerViewProduct.setAdapter(productsAdapter);

    }

    private void setupNearbyRecycler(List<Places> lstPlaces) {


        PlacesAdapter placesAdapter = new PlacesAdapter(this,lstPlaces) ;
        mRecyclerViewNearby.setLayoutManager(new LinearLayoutManager(DetailPlaceActivity.this,
                RecyclerView.HORIZONTAL, false));
        mRecyclerViewNearby.setAdapter(placesAdapter);

    }

}
