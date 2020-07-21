//package com.example.restaurant_food_app.home.view;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Toast;
//
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonArrayRequest;
//import com.android.volley.toolbox.Volley;
//import com.example.restaurant_food_app.R;
//import com.example.restaurant_food_app.home.adapter.ProductsAdapter;
//import com.example.restaurant_food_app.home.model.Products;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MenuProducts extends AppCompatActivity {
//
//    private final String JSON_URL = "http://192.168.0.110/webproject/public/APIsanpham";
//    private JsonArrayRequest jsonArrayRequest;
//    private RequestQueue requestQueue;
//    private List<Products> lstProduct = new ArrayList<>();
//    private RecyclerView recyclerView;
//
//
//    ConstraintLayout constraintLayout;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_menu_products);
//
//
//
//        mappedID();
//
//        setuprecyclerview(lstProduct);
//
//        jsonRequest();
//
//
//
//    }
//
//
//    private void mappedID() {
//
//        recyclerView = findViewById(R.id.recycler_products_id);
//
//
//    }
//
//
//    private void jsonRequest() {
//
//        jsonArrayRequest = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                JSONObject jsonObject  = null ;
//
//                for (int i = 0 ; i < response.length(); i++ ) {
//
//
//                    try {
//
//                        String imgUrl = "http://192.168.0.110/webproject/public/ANHSP/";
//
//                        jsonObject = response.getJSONObject(i) ;
//                        Products products = new Products() ;
//                        products.setNameSanpham(jsonObject.getString("name_sanpham"));
//                        products.setGia(jsonObject.getInt("gia"));
//                        products.setAvtSanpham(imgUrl + jsonObject.getString( "avt_sanpham"));
//
//                        lstProduct.add(products);
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//
//                }
//
//                setuprecyclerview(lstProduct);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MenuProducts.this, "Lỗi",Toast.LENGTH_SHORT);
//            }
//        });
//
//
//        requestQueue = Volley.newRequestQueue(MenuProducts.this);
//        requestQueue.add(jsonArrayRequest) ;
//
//
//    }
//
//    private void setuprecyclerview(List<Products> lstProduct) {
//
//
//        ProductsAdapter productsAdapter = new ProductsAdapter(this,lstProduct) ;
//        recyclerView.setLayoutManager(new LinearLayoutManager(MenuProducts.this));
//        recyclerView.setAdapter(productsAdapter);
//
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
