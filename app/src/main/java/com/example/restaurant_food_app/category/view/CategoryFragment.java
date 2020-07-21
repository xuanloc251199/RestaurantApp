package com.example.restaurant_food_app.category.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restaurant_food_app.R;
import com.example.restaurant_food_app.api.TaskCategories;
import com.example.restaurant_food_app.category.adapter.CategoryAdapter;
import com.example.restaurant_food_app.api.NetworkResponseListener;
import com.example.restaurant_food_app.category.model.Category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends Fragment implements NetworkResponseListener {

    RecyclerView mRecyclerView;
    CategoryAdapter categoryAdapter;
    List<Category> categoryList;


    View view;

    TextView mNameCategory;
    ImageView mThumbnail;


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        view = inflater.inflate(R.layout.fragment_category, container, false);


        mappedId();


        return view;
    }

    private void mappedId() {

        mRecyclerView = view.findViewById(R.id.recycler_category_id);

        mNameCategory = view.findViewById(R.id.name_category_id);
        mThumbnail = view.findViewById(R.id.thumbnail_category_id);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TaskCategories taskCategories = new TaskCategories(CategoryFragment.this);
        taskCategories.execute();

        categoryList = new ArrayList<>();

    }

    @Override
    public void SuccessData(String data) {

        //ip 172.16.1.181 192.168.43.124


        try {
            JSONArray jsonArray = new JSONArray(data);
            String imgCategoryUrl = "http://192.168.0.110/webproject/public/ANHTHELOAI/";

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                categoryList.add(
                        new Category(
                                jsonObject.getInt("id_theloai"),
                                jsonObject.getString("theloai"),
                                imgCategoryUrl + jsonObject.getString("thumbnail")

                        )
                );
            }

            setUpRecyclerView(categoryList);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void setUpRecyclerView(List<Category> categories) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL, false));
        categoryAdapter = new CategoryAdapter(getContext(), categories);
        mRecyclerView.setAdapter(categoryAdapter);

    }

    @Override
    public void FailedData() {

        Toast.makeText(getContext(), "Failed to Load Data on Fragment 2", Toast.LENGTH_SHORT).show();

    }
}

