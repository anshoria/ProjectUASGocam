package com.example.projectuas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SewaKamera extends AppCompatActivity {

    //mendeklarasikan variabel pada kelas sewa kamera
    DatePickerDialog picker;
    Button bt_tgl;
    TextView tvtgl;

    EditText edtnama,edtalamat,edthp,edtlama,edtktp;
    Spinner spinmerk;
    Button btnsimpan;


    String Nama,Alamat,Nohp,Merk,lama,Tanggal,KTP;
    String[] merk_kamera={"Sony A7","Panasonic Lumix","Samsung NX3000","Fujifilm X-H1","Nikon D850","Canon 1200D","GoPro Hero 7 Black"};
    String tempmerk;

    //membuat fitur sewa kamera dengan memanggil layout sewa kamera dan mendefenisikan variabel-variabel pada method oncreate
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewa_kamera);
        getSupportActionBar().setTitle("Sewa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvtgl=findViewById(R.id.tvtgl);
        bt_tgl=findViewById(R.id.bt_tgl);
        edtktp=findViewById(R.id.edtktp);
        edtnama=findViewById(R.id.edtnama);
        edtalamat=findViewById(R.id.edtalamat);
        edthp=findViewById(R.id.edthp);
        edtlama=findViewById(R.id.edtlama);
        spinmerk=findViewById(R.id.spinmerk);

        //membuat objek baru dari arrayadapter
        //memberikan nilai pada variabel merk kamera dengan membuat komponen spinner
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,merk_kamera);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinmerk.setAdapter(adapter);
        spinmerk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tempmerk=merk_kamera[position];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //membuat kalender untuk input tanggal
        bt_tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(SewaKamera.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvtgl.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
                picker.show();
            }
        });


        //memberikan nilai pada variabel-variabel setelah mengklik button simpan
        btnsimpan=findViewById(R.id.btnsimpan);
        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KTP=edtktp.getText().toString();
                Nama=edtnama.getText().toString();
                Alamat=edtalamat.getText().toString();
                Nohp=edthp.getText().toString();
                lama=edtlama.getText().toString();
                Merk= tempmerk;
                Tanggal=tvtgl.getText().toString();

                if (KTP.isEmpty()||Nama.isEmpty()||Alamat.isEmpty()||Nohp.isEmpty()||lama.isEmpty()||Merk.isEmpty()||Tanggal.isEmpty()){
                    Toast.makeText(SewaKamera.this,"(*) tidak boleh kosong !",Toast.LENGTH_SHORT).show();
                    return;
                }

                //membuat objel intent untuk berpindah ke kelas detail sewa
                Intent i=new Intent(getApplicationContext(),DetailSewa.class);
                i.putExtra("Nama",Nama);
                i.putExtra("Alamat",Alamat);
                i.putExtra("Nohp",Nohp);
                i.putExtra("lama",lama);
                i.putExtra("Merk",Merk);
                i.putExtra("KTP",KTP);
                i.putExtra("Tanggal",Tanggal);
                startActivity(i);
            }
        });
    }

}

