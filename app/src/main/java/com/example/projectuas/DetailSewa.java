package com.example.projectuas;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailSewa extends AppCompatActivity  {

    //deklarasi variabel pada kelas detail sewa
    TextView getktp,getmerk,getnama,getalamat,getnomor,getlama,gettanggal,gettotal;
    ImageView getgambar;
    int iLama, iHarga,dTotal;
    String Total;

    //memanggil layout detail sewa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sewa);
        getSupportActionBar().setTitle("Keterangan Detail Sewa");

        getktp =findViewById(R.id.getktp);
        getmerk = findViewById(R.id.getmerk);
        getnama = findViewById(R.id.getnama);
        getalamat = findViewById(R.id.getalamat);
        getnomor = findViewById(R.id.getnomor);
        getlama = findViewById(R.id.getlama);
        gettanggal = findViewById(R.id.gettanggal);
        gettotal = findViewById(R.id.getharga);
        getgambar = findViewById(R.id.getgambar);
        showData();

    }

    //memberikan nilai pada variabel-variabel
    @SuppressLint("SetTextI18n")
    private void showData(){
        String merk = getIntent().getExtras().getString("Merk");
        String ktp=getIntent().getExtras().getString("KTP");
        String nama=getIntent().getExtras().getString("Nama");
        String alamat=getIntent().getExtras().getString("Alamat");
        String nohp=getIntent().getExtras().getString("Nohp");
        String lama=getIntent().getExtras().getString("lama");
        String tanggal=getIntent().getExtras().getString("Tanggal");

        //membuat daftar merk kamera dengan menggunakan switch case
        switch (merk) {
            case "Sony A7":
                iHarga = 280000;
                break;
            case "Panasonic Lumix":
                iHarga = 300000;
                break;
            case "Samsung NX3000":
                iHarga = 500000;
                break;
            case "Fujifilm X-H1":
                iHarga = 420000;
                break;
            case "Nikon D850":
                iHarga = 670000;
                break;
            case "Canon 1200D":
                iHarga = 320000;
                break;
            case "GoPro Hero 7 Black":
                iHarga = 330000;
                break;
        }

        iLama=Integer.parseInt(lama);
        dTotal=iHarga*iLama;
        Total=String.valueOf(dTotal);

        switch (merk){
            case "Sony A7":
                getgambar.setImageResource(R.drawable.sony);
                getmerk.setText(merk);
                getnama.setText(nama);
                getalamat.setText(alamat);
                getnomor.setText(nohp);
                getlama.setText(lama);
                gettanggal.setText(tanggal);
                gettotal.setText(Total);
                getktp.setText(ktp);
                break;
            case "Panasonic Lumix":
                getgambar.setImageResource(R.drawable.panasonic);
                getmerk.setText(merk);
                getnama.setText(nama);
                getalamat.setText(alamat);
                getnomor.setText(nohp);
                getlama.setText(lama);
                gettanggal.setText(tanggal);
                gettotal.setText(Total);
                getktp.setText(ktp);
                break;
            case "Samsung NX3000":
                getgambar.setImageResource(R.drawable.samsung);
                getmerk.setText(merk);
                getnama.setText(nama);
                getalamat.setText(alamat);
                getnomor.setText(nohp);
                getlama.setText(lama);
                gettanggal.setText(tanggal);
                gettotal.setText(Total);
                getktp.setText(ktp);
                break;
            case "Fujifilm X-H1":
                getgambar.setImageResource(R.drawable.fujifilm);
                getmerk.setText(merk);
                getnama.setText(nama);
                getalamat.setText(alamat);
                getnomor.setText(nohp);
                getlama.setText(lama);
                gettanggal.setText(tanggal);
                gettotal.setText(Total);
                getktp.setText(ktp);
                break;
            case "Nikon D850":
                getgambar.setImageResource(R.drawable.nikon);
                getmerk.setText(merk);
                getnama.setText(nama);
                getalamat.setText(alamat);
                getnomor.setText(nohp);
                getlama.setText(lama);
                gettanggal.setText(tanggal);
                gettotal.setText(Total);
                getktp.setText(ktp);
                break;
            case "Canon 1200D":
                getgambar.setImageResource(R.drawable.canon);
                getmerk.setText(merk);
                getnama.setText(nama);
                getalamat.setText(alamat);
                getnomor.setText(nohp);
                getlama.setText(lama);
                gettanggal.setText(tanggal);
                gettotal.setText(Total);
                getktp.setText(ktp);
                break;
            case "GoPro Hero 7 Black":
                getgambar.setImageResource(R.drawable.gopro);
                getmerk.setText(merk);
                getnama.setText(nama);
                getalamat.setText(alamat);
                getnomor.setText(nohp);
                getlama.setText(lama);
                gettanggal.setText(tanggal);
                gettotal.setText(Total);
                getktp.setText(ktp);
                break;
        }

    }
}