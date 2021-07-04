package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import android.os.Bundle;

public class DetailKamera extends AppCompatActivity {
    Button btn_sewa;
    TextView  GetNama, GetHarga;
    ImageView GetGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kamera);
        getSupportActionBar().setTitle("Detail Mobil");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_sewa=findViewById(R.id.btn_sewa);
        GetGambar = findViewById(R.id.getgambar);
        GetNama = findViewById(R.id.getnama);
        GetHarga = findViewById(R.id.getharga);
        showData();
        btn_sewa.setOnClickListener(v -> {
            Intent ina=new Intent(getApplicationContext(),SewaKamera.class);
            startActivity(ina);
        });


    }


    @SuppressLint("SetTextI18n")
    private void showData(){
        String nama = getIntent().getExtras().getString("MyName");
        switch (nama){
            case "Sony A7":
                GetNama.setText("Sony A7");
                GetGambar.setImageResource(R.drawable.sony);
                GetHarga.setText("Rp.280.000");
                break;
            case "Panasonic Lumix":
                GetNama.setText("Panasonic Lumix");
                GetGambar.setImageResource(R.drawable.panasonic);
                GetHarga.setText("Rp.300.000");
                break;
            case "Samsung NX3000":
                GetNama.setText("Samsung NX3000");
                GetGambar.setImageResource(R.drawable.samsung);
                GetHarga.setText("Rp.500.000");
                break;
            case "Fujifilm X-H1":
                GetNama.setText("Fujifilm X-H1");
                GetGambar.setImageResource(R.drawable.fujifilm);
                GetHarga.setText("Rp.420.000");
                break;
            case "Nikon D850":
                GetNama.setText("Nikon D850");
                GetGambar.setImageResource(R.drawable.nikon);
                GetHarga.setText("Rp.670.000");
                break;
            case "Canon 1200D":
                GetNama.setText("Canon 1200D");
                GetGambar.setImageResource(R.drawable.canon);
                GetHarga.setText("Rp.320.000");
                break;
            case "GoPro Hero 7 Black":
                GetNama.setText("GoPro Hero 7 Black");
                GetGambar.setImageResource(R.drawable.gopro);
                GetHarga.setText("Rp.330.000");
                break;
        }
    }

}
