package com.tarex.valdo.tarex.ui.restaurantList;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.tarex.valdo.tarex.R;
import com.tarex.valdo.tarex.model.restaurant.Restaurant;
import com.tarex.valdo.tarex.ui.base.BaseActivity;
import com.tarex.valdo.tarex.ui.base.BaseAdapter;
import com.tarex.valdo.tarex.widget.EmptyStateRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RestautantListActivity extends BaseActivity implements RestaurantListView,BaseAdapter.OnItemClickListener<Restaurant> {

    RecyclerView recyclerView;

    @InjectPresenter
    RestaurantListPresenter presenter;

    private RestaurantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        recyclerView = findViewById(R.id.rv);
        initRecycler();
    }

    @Override
    public void onItemClick(@NonNull Restaurant item) {
    }

    @Override
    public void showItems(@NonNull List<Restaurant> items) {
        adapter.changeDataSet(items);
    }

    @Override
    public void handleError(Throwable error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
        Log.e("Alm", error.getMessage());
        error.printStackTrace();
    }
    private void initRecycler() {
        adapter = new RestaurantAdapter(new ArrayList<>());
        adapter.setOnItemClickListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
}
