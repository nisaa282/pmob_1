package com.fakhrunnisaa.pmob_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fakhrunnisaa.pmob_1.room.User;
import com.fakhrunnisaa.pmob_1.room.UserDao;
import com.fakhrunnisaa.pmob_1.room.UserDataBase;



public class RegisterActivity extends AppCompatActivity {
    EditText TextNim, TextNama, TextPassword, TextCnfPassword;
    Button buttonRegister;

    TextView textViewLogin;
    private UserDao userDao;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextNim = findViewById(R.id.nim);
        TextNama = findViewById(R.id.nama);
        TextPassword = findViewById(R.id.password);
        TextCnfPassword = findViewById(R.id.CnfPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        textViewLogin = findViewById(R.id.textLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });

        userDao = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nimtext = TextNim.getText().toString().trim();
                String namatext = TextNama.getText().toString().trim();
                String password = TextPassword.getText().toString().trim();
                String passwordConf = TextCnfPassword.getText().toString().trim();

                if (password.equals(passwordConf)) {
                    User user = new User(nimtext, namatext, password);
                    userDao.insert(user);
                    Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(moveToLogin);

                } else {
                    Toast.makeText(RegisterActivity.this, "Password tidak sesuai", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
