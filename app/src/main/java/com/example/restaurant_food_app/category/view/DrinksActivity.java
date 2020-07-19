package com.example.restaurant_food_app.category.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restaurant_food_app.R;
import com.example.restaurant_food_app.api.NetworkResponseListener;
import com.example.restaurant_food_app.api.TaskDrinks;
import com.example.restaurant_food_app.api.TaskFoods;
import com.example.restaurant_food_app.category.adapter.Places2Adapter;
import com.example.restaurant_food_app.category.model.Places2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DrinksActivity extends AppCompatActivity implements NetworkResponseListener {

    RecyclerView mRecyclerView;
    Places2Adapter places2Adapter;
    List<Places2> places2List;


    Button mBtnBack;
    TextView mNameCategory;
    EditText mEdtSearch;
    CharSequence search = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        mappedId();

        eventClick();

        intentData();

        searchEvent();


        places2List = new ArrayList<>();


        TaskDrinks taskDrinks = new TaskDrinks(DrinksActivity.this);
        taskDrinks.execute();

    }



    private void mappedId() {

        mRecyclerView = findViewById(R.id.recycler_product_id);

        mBtnBack = findViewById(R.id.btn_back_id);

        mNameCategory = findViewById(R.id.name_item_category_id);

        mEdtSearch = findViewById(R.id.edt_search_id);

    }


    private void eventClick() {

        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrinksActivity.this, CategoryFragment.class);
                startActivity(intent);
            }
        });

    }


    private void intentData() {

        Intent intent = getIntent();
        String title = intent.getExtras().getString("Name Category");

        mNameCategory.setText(title);


    }


    public void searchEvent() {

        mEdtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {

                places2Adapter.getFilter().filter(string);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    @Override
    public void SuccessData(String data) {

        //ip 172.16.1.181 192.168.43.124


        try {
            JSONArray jsonArray = new JSONArray(data);

            String imgPlaceUrl = "http://192.168.43.124/webproject/public/ANHDD/";

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                places2List.add(

                        new Places2(
                                jsonObject.getInt("id_diadiem"),
                                jsonObject.getString("ten"),
                                jsonObject.getString("diachi"),
                                jsonObject.getString("vung"),
                                jsonObject.getString("lienhe"),
                                jsonObject.getString("open"),
                                jsonObject.getString("close"),
                                imgPlaceUrl + jsonObject.getString("avt_diadiem"),
                                jsonObject.getString("bando"),
                                (float) jsonObject.getDouble("danhgia"),
                                jsonObject.getString("theloai")

                        )
                );
            }
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                    RecyclerView.VERTICAL, false));
            places2Adapter = new Places2Adapter(this, places2List);
            mRecyclerView.setAdapter(places2Adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void FailedData() {

        Toast.makeText(this, "Failed to Load Data on Fragment 2", Toast.LENGTH_SHORT).show();

    }
}