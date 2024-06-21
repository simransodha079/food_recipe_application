package com.example.food_recipe_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class Admin_Page extends AppCompatActivity {
ImageView document,recipee,slinding;
FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        document=findViewById(R.id.uploaddocument);
        recipee=findViewById(R.id.advance);
        slinding=findViewById(R.id.uploadsling);
        firebaseAuth=FirebaseAuth.getInstance();
        document.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Upload_Page.class);
                startActivity(intent);
            }
        });

        recipee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Advance_Recipe.class);
                startActivity(intent);
            }
        });

        slinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Add_Sliding.class);
                startActivity(intent);
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
                startActivity(new Intent(Admin_Page.this, Login.class));
                finish();

                return true;
            case R.id.logout_btn:
                firebaseAuth.signOut();
                startActivity(new Intent(Admin_Page.this, Login.class));
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}