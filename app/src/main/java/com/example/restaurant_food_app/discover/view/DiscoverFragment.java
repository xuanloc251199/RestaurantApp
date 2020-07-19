package com.example.restaurant_food_app.discover.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restaurant_food_app.R;
import com.example.restaurant_food_app.home.adapter.NearMePlacesAdapter;
import com.example.restaurant_food_app.home.adapter.NewPlacesApdapter;
import com.example.restaurant_food_app.home.model.NearMePlaces;
import com.example.restaurant_food_app.home.model.NewPlaces;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment {

    List<NearMePlaces> nearMePlaces;
    List<NewPlaces> newPlacesList;

    public DiscoverFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discover, container, false);

        //Recycler View Near Me Places
        RecyclerView recyclerViewPlaces = view.findViewById(R.id.recycler_near_me_id);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPlaces.setLayoutManager(linearLayoutManager);

        NearMePlacesAdapter adapter = new NearMePlacesAdapter(getContext(),
                nearMePlaces);
        recyclerViewPlaces.setAdapter(adapter);

        //Recycler View New Places
        RecyclerView recyclerView = view.findViewById(R.id.recycler_new_places_id);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        NewPlacesApdapter apdapter = new NewPlacesApdapter(getContext(), newPlacesList);
        recyclerView.setAdapter(apdapter);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViewNearMePlaces();

        initViewNewPlaces();

    }

    private void initViewNearMePlaces() {

        nearMePlaces = new ArrayList<>();

        nearMePlaces.add(new NearMePlaces(R.drawable.banh_cam,
                "Bánh Cam",
                "Thơm ngon"));
        nearMePlaces.add(new NearMePlaces(R.drawable.banh_cuon,
                "Bánh Cam",
                "Thơm ngon"));
        nearMePlaces.add(new NearMePlaces(R.drawable.banh_cam,
                "Bánh Cam",
                "Thơm ngon"));

    }

    private void initViewNewPlaces() {

        newPlacesList = new ArrayList<>();
        newPlacesList.add(new NewPlaces(R.drawable.milkteabong,
                "Trà sửa Bông",
                "Ngon bổ rẻ nhé =))))"));

        newPlacesList.add(new NewPlaces(R.drawable.kitchenrice,
                "Cơm Kitchen",
                "Cơm bao ngon"));

        newPlacesList.add(new NewPlaces(R.drawable.changanguvi,
                "Ăn vặt Ố Ồ - Chân Gà Ngũ Vị",
                "Chân nhiều thịt =)))"));

        newPlacesList.add(new NewPlaces(R.drawable.faifobuffer,
                "Faifo Buffer",
                "Buffer bao nhiều"));
    }

}
