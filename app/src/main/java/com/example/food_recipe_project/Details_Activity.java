package com.example.food_recipe_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class Details_Activity extends AppCompatActivity {
    TextView quantity;
    int totalQuantity =1;
    int totalprice = 0;
    TextView total;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth auth;
    DatabaseReference reference;
    ImageView imageView;
    TextView name,rate,description;
    Product_Model product_model = null;
    Button addcard,add,remove;
    String userName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        firebaseFirestore=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();





        final Object object = getIntent().getSerializableExtra("detail");
        if (object instanceof Product_Model){
            product_model = (Product_Model) object;
        }
        imageView=findViewById(R.id.detailimage);
        name=findViewById(R.id.dname);
        rate=findViewById(R.id.drate);
        description=findViewById(R.id.ddes);
        addcard=findViewById(R.id.addtocard);
        add=findViewById(R.id.add);
        remove=findViewById(R.id.remove);
        quantity=findViewById(R.id.quantity);
        total=findViewById(R.id.totalquantity);

        if (product_model != null){
            Glide.with(getApplicationContext()).load(product_model.getUri()).into(imageView);
            name.setText(product_model.getName());
            rate.setText(String.valueOf(product_model.getRate()));
            description.setText(product_model.getDescription());
            totalprice = product_model.getRate() * totalQuantity;

        }
addcard.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(Details_Activity.this, Order_Recipe.class));
    }
});


    }
}