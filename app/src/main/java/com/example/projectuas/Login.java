package com.example.projectuas;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectuas.MainActivity;
import com.example.projectuas.MainActivity;
import com.example.projectuas.R;
import com.example.projectuas.database.DBHelper;
import com.example.projectuas.database.DBHelper;

import static android.text.Html.fromHtml;

public class Login extends AppCompatActivity {
    EditText txUsername, txPassword;
    Button btnLogin;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txUsername = (EditText)findViewById(R.id.txUsername);
        txPassword = (EditText)findViewById(R.id.txPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        dbHelper = new DBHelper(this);



        TextView daftar = (TextView)findViewById(R.id.tvCreateAccount);
        daftar.setText(fromHtml("Belum punya akun. " +
                "</font><font color='#3b5998'>create one</font>"));

        daftar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
            }
        });

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

    public static Spanned fromHtml(String html){
        Spanned result;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        }else {
            result = Html.fromHtml(html);
        }
        return result;
    }
}