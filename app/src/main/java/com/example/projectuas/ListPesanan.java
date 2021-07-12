package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ListPesanan extends AppCompatActivity {

    //membuat list pesanan dengan memanggil komponen listview
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = findViewById(R.id.listpesanan);
        showData();

    }

    //mendefenisikan objek showdata untuk menampilkan halaman detail sewa
    private void showData(){
        setContentView(R.layout.activity_detail_sewa);

    }
}