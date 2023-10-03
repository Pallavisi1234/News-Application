package com.example.mynewsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.media.RouteListingPreference;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;


import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomePage extends AppCompatActivity implements CategoryAdapter.CategoryClickinterface {
    private static final String API_KEY = "7df8b301047e4525831d3d1d8a977ef3";

    //7df8b301047e4525831d3d1d8a977ef3

    private RecyclerView rvnews, recycler;
    private ProgressBar pbLoading;

    //SwipeRefreshLayout swipeRefreshLayout;

    NavigationView nav;
    Menu menu;

    private FirebaseAuth mFirebaseAuth;
    GoogleSignInClient gsc;
    private ArrayList<Articles> articlesArrayList;
    private ArrayList<CategoryModel> categoryModels;
    private CategoryAdapter categoryAdapter;
    private NewsAdapter newsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        rvnews = findViewById(R.id.rvnews);
        recycler = findViewById(R.id.recycler);
        pbLoading = findViewById(R.id.pbLoading);
        mFirebaseAuth = FirebaseAuth.getInstance();
        // nav=(NavigationView)findViewById(R.id.navmenu);

        /*swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        swipeRefreshLayout.setRefreshing(false);

                    }
                }, 1200);
            }
        });*/




                articlesArrayList = new ArrayList<>();
        categoryModels = new ArrayList<>();


        newsAdapter = new NewsAdapter(articlesArrayList,this);
        categoryAdapter = new CategoryAdapter(categoryModels,this,this::onCategoryClick);
        rvnews.setLayoutManager(new LinearLayoutManager(this));
        rvnews.setAdapter(newsAdapter);
        recycler.setAdapter(categoryAdapter);
        getCategories();
        getNews("All");
        newsAdapter.notifyDataSetChanged();

    }



    private void getCategories(){
        categoryModels.add(new CategoryModel("All","https://images.unsplash.com/photo-1523995462485-3d171b5c8fa9?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1035&q=80"));
        categoryModels.add(new CategoryModel("Technology","https://images.unsplash.com/photo-1504164996022-09080787b6b3?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80"));
        categoryModels.add(new CategoryModel("Science","https://images.unsplash.com/photo-1564325724739-bae0bd08762c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80"));
        categoryModels.add(new CategoryModel("Sports","https://images.unsplash.com/photo-1579952363873-27f3bade9f55?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1035&q=80"));
        categoryModels.add(new CategoryModel("Business","https://images.unsplash.com/photo-1460925895917-afdab827c52f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1115&q=80"));
        categoryModels.add(new CategoryModel("Entertainment","https://images.unsplash.com/photo-1603190287605-e6ade32fa852?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80"));
        categoryModels.add(new CategoryModel("Health","https://images.unsplash.com/photo-1505751172876-fa1923c5c528?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80"));
        categoryAdapter.notifyDataSetChanged();
    }




private void getNews(String category) {
    pbLoading.setVisibility(View.VISIBLE);
    articlesArrayList.clear();
    String categoryURL = "https://newsapi.org/v2/top-headlines?country=in&category=" + category + "&apiKey=7df8b301047e4525831d3d1d8a977ef3";
    String url = "https://newsapi.org/v2/top-headlines?country=in&excludeDomains=stackoverflow.com&sortBy=publishedAt&language=en&apiKey=7df8b301047e4525831d3d1d8a977ef3";
    String BASE_URL = "https://newsapi.org/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
    Call<NewsModel> call;
    if (category.equals("All")) {
        call = retrofitAPI.getAllNews(url);
    } else {
        call = retrofitAPI.getNewsByCategory(categoryURL);
    }

    call.enqueue(new Callback<NewsModel>() {
        @Override
        public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
            NewsModel newsModel = response.body();
            pbLoading.setVisibility(View.GONE);
            ArrayList<Articles> articles = newsModel.getArticles();
            for (int i = 0; i < articles.size(); i++) {
                articlesArrayList.add(new Articles(articles.get(i).getTitle(), articles.get(i).getDescription(), articles.get(i).getUrlToImage(),
                        articles.get(i).getUrl(), articles.get(i).getContent()));
            }
            newsAdapter.notifyDataSetChanged();



            /*nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    if (id == R.id.nav_logout) {
                        mFirebaseAuth.signOut();
                        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                finish();
                                Intent intent=new Intent(HomePage.this,Login.class);
                                startActivity(intent);
                            }
                        });
                        Intent intent=new Intent(HomePage.this,Login.class);
                        startActivity(intent);
                        finish();
                        return true;
                    }

                    if(id==R.id.contact){
                        Intent intent=new Intent(HomePage.this,contactus.class);
                        startActivity(intent);

                    }


                    return true;
                }
            });*/

        }

        @Override
        public void onFailure(Call<NewsModel> call, Throwable t) {
            Toast.makeText(HomePage.this, "Fail to get news", Toast.LENGTH_SHORT).show();

        }
    });
}
    @Override
    public void onCategoryClick(int position) {
        String category = categoryModels.get(position).getCategory();
        getNews(category);
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
        if(item.getItemId()== R.id.logout)
          {
              mFirebaseAuth.signOut();
              startActivity(new Intent(HomePage.this, Login.class));
              finishAffinity();
          } else if (item.getItemId()== R.id.settings) {
              Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();

          } else if (item.getItemId()==R.id.about) {

              Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show();
          }
//        switch (item.getItemId()){
//            case R.id.logout :
//                Toast.makeText(this, "log out clicked", Toast.LENGTH_SHORT).show();
//                return  true;
//            case R.id.about:
//                Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.settings:
//                Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
//                return true;
//        }
        return super.onOptionsItemSelected(item);

    }*/
}
