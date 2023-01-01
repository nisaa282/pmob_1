package com.fakhrunnisaa.pmob_1;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fakhrunnisaa.pmob_1.room.User;

public class HomeActivity extends AppCompatActivity {
    private TextView text;
    Button logout;

    private User user;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        logout = findViewById(R.id.buttonLogout);

        text = findViewById(R.id.tampilnama);

        if (user != null) {
            text.setText(user.getNama());
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveToLogin = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(moveToLogin);
            }
        });
    }
}