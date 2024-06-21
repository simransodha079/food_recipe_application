package com.example.food_recipe_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Advance_Recipe extends AppCompatActivity {
    //
    RecyclerView slingView;
    List<Slidingmodel> slidingmodelList;
    SlidAdapter slidAdapter;
    FirebaseFirestore database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_recipe);
        database=FirebaseFirestore.getInstance();
        slingView=findViewById(R.id.slidingrec);

       slingView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false));
        slidingmodelList = new ArrayList<>();
        slidAdapter = new SlidAdapter(getApplicationContext(),slidingmodelList);
        slingView.setAdapter(slidAdapter);



       database.collection("Order")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult() ){
                                Slidingmodel slidingmodel = document.toObject(Slidingmodel.class);
                                slidingmodelList.add(slidingmodel);
                                // product_adapter.notifyDataSetChanged();
                                slidAdapter.notifyDataSetChanged();
                            }
                        }else {
                            Toast.makeText(getApplication(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}