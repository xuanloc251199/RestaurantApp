package com.example.restaurant_food_app.home.view;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restaurant_food_app.LoadingDialog;
import com.example.restaurant_food_app.home.adapter.PlacesAdapter;
import com.example.restaurant_food_app.R;
import com.example.restaurant_food_app.api.NetworkResponseListener;
import com.example.restaurant_food_app.api.TaskHome;
import com.example.restaurant_food_app.home.model.Places;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements NetworkResponseListener {


    private RecyclerView mRecyclerView;
    private PlacesAdapter placesAdapter;
    private List<Places> placeList = new ArrayList<>();

    View view;

    TextView mTitleCategory, mTitleDiscover;
    EditText mSearch;

    LoadingDialog loadingDialog;


    public HomeFragment() {

    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        view = inflater.inflate(R.layout.fragment_home, container, false);


        mappedID();


        searchEvent(mSearch);


        return view;

    }



    private void mappedID() {

        mRecyclerView = view.findViewById(R.id.recycler_feature_id);


        mTitleCategory = view.findViewById(R.id.title_category_id);
        mTitleDiscover = view.findViewById(R.id.title_discover_id);
        mSearch = view.findViewById(R.id.search_id);

    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TaskHome taskHome = new TaskHome(HomeFragment.this);
        taskHome.execute();


    }


    private void setUpRecyclerView(List<Places> placeList) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        placesAdapter = new PlacesAdapter(getContext(), placeList);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(placesAdapter);
    }

    public void searchEvent(EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {

                placesAdapter.getFilter().filter(string);

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
            String imgPlaceUrl = "http://192.168.0.110/webproject/public/ANHDD/";

            for (int i=0;i<jsonArray.length();i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                placeList.add(
                        new Places(
                                jsonObject.getInt("id_diadiem"),
                                jsonObject.getString("ten"),
                                jsonObject.getString("diachi"),
                                jsonObject.getString("vung"),
                                jsonObject.getString("lienhe"),
                                jsonObject.getString("open"),
                                jsonObject.getString("close"),
                                imgPlaceUrl + jsonObject.getString("avt_diadiem"),
                                jsonObject.getDouble("danhgia"),
                                jsonObject.getString("theloai"),
                                jsonObject.getDouble("x"),
                                jsonObject.getDouble("y")
                        )
                );
            }

            setUpRecyclerView(placeList);

        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }



    @Override
    public void FailedData() {
        Toast.makeText(getContext(), "Failed to Load Data on Fragment 2", Toast.LENGTH_SHORT).show();
    }

}
