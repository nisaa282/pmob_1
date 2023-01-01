package com.fakhrunnisaa.pmob_1;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fakhrunnisaa.pmob_1.room.User;
import com.fakhrunnisaa.pmob_1.room.UserDao;
import com.fakhrunnisaa.pmob_1.room.UserDataBase;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {
    EditText textNim, textPassword;
    Button buttonLogin;
    TextView textViewRegister;
    UserDao db;
    UserDataBase dataBase;

    SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNim = findViewById(R.id.nim);
        textPassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewRegister = findViewById(R.id.textRegister);

        sharedPreferences = getSharedPreferences("", MODE_PRIVATE);

        dataBase = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();


        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nim = textNim.getText().toString().trim();
                String password = textPassword.getText().toString().trim();

                User user = db.getUser(nim, password);
                if (user != null) {
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "Akun tidak ditemukan, atau nim/password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}