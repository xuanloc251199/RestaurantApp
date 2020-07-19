package com.example.restaurant_food_app.notification.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restaurant_food_app.R;
import com.example.restaurant_food_app.notification.adapter.ViewPagerNotiAdapter;
import com.google.android.material.tabs.TabLayout;

public class NotificationFragment extends Fragment {

    View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public NotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notification, container, false);

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayoutNotification_id);
        viewPager = (ViewPager) view.findViewById(R.id.viewPagerNotification_id);

        ViewPagerNotiAdapter adapter = new ViewPagerNotiAdapter(getChildFragmentManager());

        adapter.addFragment(new ServiceFragment(), "Dịch vụ");
        adapter.addFragment(new MyNotificationFragment(), "Của tôi");
        adapter.addFragment(new NewsFeedFragment(), "Tin mới");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
