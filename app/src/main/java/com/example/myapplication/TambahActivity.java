package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.database.entittas.Mahasiswa;

public class TambahActivity extends AppCompatActivity {

    EditText etName, etNpm;
    Button btnSimpan;

    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etName = findViewById(R.id.etName);
        etNpm = findViewById(R.id.etNpm);
        btnSimpan = findViewById(R.id.btnSimpan);
        database = AppDatabase.getInstance(getApplicationContext());

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.fullName = etName.getText().toString();
                mahasiswa.npm = etNpm.getText().toString();
                database.mahasiswaDao().insertAll(mahasiswa);
                finish();
            }
        });
    }
}