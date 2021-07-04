package com.example.projectuas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.time.temporal.IsoFields;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("ProjekUAS");

        Button btShow = (Button) findViewById(R.id.bt_customdialog);
        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Initiate Custom Dialog
                 */
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.customdialog);
                dialog.setTitle("Rezatian07");

                /**
                 * Mengeset komponen dari custom dialog
                 */
                TextView satu= dialog.findViewById(R.id.Tim);
                satu.setText("GoCam");
                TextView dua= dialog.findViewById(R.id.Reza);
                dua.setText("Aplikasi Rental Kamera");
                TextView tiga= dialog.findViewById(R.id.Said);
                tiga.setText("Instagram: @anshoria11");
                TextView empat= dialog.findViewById(R.id.Abed);
                empat.setText("Facebook: anshoria");
                TextView lima= dialog.findViewById(R.id.abiyyi);
                lima.setText("Gmail: anshoriakbar11@gmail.com");
                ImageView image =dialog.findViewById(R.id.icon);
                image.setImageResource(R.mipmap.ic_launcher);

                Button dialogButton = dialog.findViewById(R.id.bt_ok);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        Button btn_informasi = findViewById(R.id.btn_info_kamera);
        Button btn_sewa = findViewById(R.id.btn_sewa);

        btn_informasi.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, DaftarKamera.class));
        });
        btn_sewa.setOnClickListener(v -> {
            Intent sew = new Intent(getApplicationContext(), SewaKamera.class);
            startActivity(sew);
        });

    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}