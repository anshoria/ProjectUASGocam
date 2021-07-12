package com.example.projectuas;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projectuas.database.DBHelper;


public class Login extends AppCompatActivity {

    //Mendeklarasikan variabel-variabel login
    EditText txUsername, txPassword;
    Button btnLogin;
    DBHelper dbHelper;

    //menampilkan layout login dan mendefenisikan komponen edittext dan button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txUsername = (EditText)findViewById(R.id.txUsername);
        txPassword = (EditText)findViewById(R.id.txPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        dbHelper = new DBHelper(this);


        //memberikan perintah pada tombol daftar untuk menampilkan halamann register
        TextView daftar = (TextView)findViewById(R.id.tvCreateAccount);
        daftar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
            }
        });


        //memberikan perintah pada button login untuk berpindah ke halaman utama
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txUsername.getText().toString().trim();
                String password = txPassword.getText().toString().trim();

                Boolean res = dbHelper.checkUser(email, password);
                if (res == true){
                    Toast.makeText(Login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, MainActivity.class));
                }else {
                    Toast.makeText(Login.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}