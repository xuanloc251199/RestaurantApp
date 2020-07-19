package com.example.restaurant_food_app.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.restaurant_food_app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class LoginActivity extends AppCompatActivity {

    EditText mEdtUserName, mEdtPassWord;
    TextView textViewRegister;
    Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initBackgroundImage();

        mEdtUserName = findViewById(R.id.username);
        mEdtPassWord = findViewById(R.id.password);
        mBtnLogin = findViewById(R.id.btn_login);
        textViewRegister = findViewById(R.id.tv_register);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }


    private void initBackgroundImage() {
        ImageView imageView = findViewById(R.id.IV_background);

        RequestOptions options = new RequestOptions();
        options.centerCrop();
        options.placeholder(new ColorDrawable(Color.BLACK));

        Glide.with(this)
                .load(R.drawable.bg)
                .transition(withCrossFade())
                .apply(options)
                .into(imageView);
    }

    

//    public class TaskLogin extends AsyncTask<String, Void, String> {
//
//
//        //ip 172.16.1.181 192.168.43.124
//
//        private static final String BASE_URL = "http://172.16.1.181/webproject/public/APItaikhoan";
//
//
//
//
//
//        @Override
//        protected String doInBackground(String... strings) {
//
//
//
//            String username = strings[0];
//            String password = strings[1];
//
//            OkHttpClient okHttpClient = new OkHttpClient();
//
//            okHttpClient.retryOnConnectionFailure();
//            okHttpClient.newBuilder().connectTimeout(30, TimeUnit.SECONDS)
//                    .writeTimeout(30,TimeUnit.SECONDS)
//                    .readTimeout(30,TimeUnit.SECONDS)
//                    .build();
//
//            RequestBody formBody = new FormBody.Builder()
//                    .add("nguoidung", username)
//                    .add("matkhau", password)
//                    .build();
//
//            Request request = new Request.Builder()
//                    .url(BASE_URL)
//                    .post(formBody)
//                    .build();
//
//            Response response = null;
//            try{
//                response = okHttpClient.newCall(request).execute();
//                if(response.isSuccessful()){
//                    String result = response.body().string();
//                    if(result.equalsIgnoreCase("login")){
//                        Intent i = new Intent(LoginActivity.this,
//                                NavigationBar.class);
//                        startActivity(i);
//                        finish();
//                    }else{
//                        showToast("Email or Password mismatched!");
//                    }
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//            return null;
//        }
//
//    }




    public void showToast(final String Text){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this,
                        Text, Toast.LENGTH_LONG).show();
            }
        });
    }


    public void openHome() {
        Intent intent = new Intent(LoginActivity.this, NavigationBar.class);
        startActivity(intent);
    }
}
