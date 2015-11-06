package com.example.lulu.climaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private AdapterPais mAdapterPais;

    public ListView listPais;
    public Pais [] paises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listPais = (ListView)findViewById(R.id.listPaises);
        paises = new Pais[] {
                new Pais(R.drawable.afghanistan,"Afghanistan"),
                new Pais(R.drawable.andorra,"Andorra"),
                new Pais(R.drawable.argentina,"Argentine"),
                new Pais(R.drawable.australia,"Australia"),
                new Pais(R.drawable.barbados,"Barbados"),
                new Pais(R.drawable.bolivia,"Bolivia"),
                new Pais(R.drawable.brazil,"Brazil"),
                new Pais(R.drawable.canada,"Canada"),
                new Pais(R.drawable.colombia,"Colombia"),
                new Pais(R.drawable.cuba,"Cuba")};

        mAdapterPais= new AdapterPais(this,R.layout.item_pais,paises);
        listPais.setAdapter(mAdapterPais);
        listPais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(MainActivity.this,Temperatura.class);
                intent.putExtra("PAIS",paises[position].nomPais);
                startActivity(intent);

            }
        });
    }
}
