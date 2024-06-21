package com.example.food_recipe_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
FirebaseAuth firebaseAuth;

    RecyclerView productView;
    List<Product_Model> product_modelList;
    Product_Adapter product_adapter;
FirebaseFirestore database;


    ViewPager mViewPager;
    int[] images = {R.drawable.fs1, R.drawable.fs2, R.drawable.fs3, R.drawable.fs4,
            R.drawable.fs5};
    ViewPagerAdapter mViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();

        mViewPager =findViewById(R.id.viewPagerMain);
        mViewPagerAdapter = new ViewPagerAdapter(getApplicationContext(), images);
        mViewPager.setAdapter(mViewPagerAdapter);

        database= FirebaseFirestore.getInstance();
        productView=findViewById(R.id.productrec);


        //productView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false));
        product_modelList = new ArrayList<>();
        Product_Adapter adapter=new Product_Adapter(getApplicationContext(), product_modelList);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),2);

        // at last set adapter to recycler view.
        productView.setLayoutManager(layoutManager);
        productView.setAdapter(adapter);
        //  product_adapter = new Product_Adapter(getApplicationContext(),product_modelList);
        // productView.setAdapter(product_adapter);


        database.collection("Product")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult() ){
                                Product_Model product_model = document.toObject(Product_Model.class);
                                product_modelList.add(product_model);
                                // product_adapter.notifyDataSetChanged();
                                adapter.notifyDataSetChanged();
                            }
                        }else {
                            Toast.makeText(getApplication(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            /*case R.id.rate_app:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                }
                return true;*/
            case R.id.login_menu:
                startActivity(new Intent(MainActivity.this, Login.class));
                finish();

                return true;
            case R.id.logout_btn:
                firebaseAuth.signOut();
                startActivity(new Intent(MainActivity.this, Login.class));
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}