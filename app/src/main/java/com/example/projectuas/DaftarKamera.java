package com.example.projectuas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;


public class DaftarKamera extends AppCompatActivity {

    //mendeklarasikan variabel dengan jenis data arraylist
    private String[] listkamera = {"Sony","Panasonic","Samsung","Fujifilm","Nikon","Canon","GoPro"};
    private ArrayList<String> data;

    //menampilkan layout activity daftar kamera
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_kamera);
        getSupportActionBar().setTitle("Daftar kamera");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ListView listView = findViewById(R.id.listkamera);

        //membuat objek dari clas data menjadi arraylist
        data = new ArrayList<>();
        getData();

        //membuat objek dari array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, R.layout.support_simple_spinner_dropdown_item, data);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String getName = data.get(position);

                Intent sendData = new Intent(DaftarKamera.this, DetailKamera.class);
                sendData.putExtra("MyName", getName);
                startActivity(sendData);
            }
        });
    }

    private void getData(){
        Collections.addAll(data, listkamera);
    }
}