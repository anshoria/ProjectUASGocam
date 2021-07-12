package com.example.projectuas;


import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectuas.database.DBHelper;

public class Register extends AppCompatActivity {

    //mendeklarasikan variabel-variabel untuk melakukan register
    EditText txUsernameReg, txPasswordReg, txConPassword;
    Button btnRegister;
    DBHelper dbHelper;

    //membuat method oncreate untuk menampilkan layout activity register
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DBHelper(this);


        txUsernameReg = (EditText)findViewById(R.id.txUsernameReg);
        txPasswordReg = (EditText)findViewById(R.id.txPasswordReg);
        txConPassword = (EditText)findViewById(R.id.txConPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);


        //menampung nilai hasil input user kemudian disimpan pada database dbhelper
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txUsernameReg.getText().toString().trim();
                String password = txPasswordReg.getText().toString().trim();
                String conPassword = txConPassword.getText().toString().trim();

                ContentValues values = new ContentValues();

                if (!password.equals(conPassword)){
                    Toast.makeText(Register.this, "Password tidak sesuai", Toast.LENGTH_SHORT).show();
                }
                else if (password.equals("") || email.equals("")){
                    Toast.makeText(Register.this, "Email dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else {
                    values.put(DBHelper.rov_email, email);
                    values.put(DBHelper.rov_password, password);
                    dbHelper.insertData(values);

                    Toast.makeText(Register.this, "Daftar berhasil", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

}