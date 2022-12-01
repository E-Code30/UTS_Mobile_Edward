package com.Edward_F55121005.aplikasi_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private EdwardAdapter adapter;
    private ArrayList<Edward> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new EdwardAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();
    }

    private void addItem() {
        heroes = new ArrayList<>();
        for (int i   = 0; i < dataName.length; i++) {
            Edward hero = new Edward ();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            heroes.add(hero);
        }
        adapter.setHeroes(heroes);
    }

    private void prepare() {
        dataName =   getResources().getStringArray(R.array.data_name);
        dataDescription =    getResources().getStringArray(R.array.data_description);
        dataPhoto =   getResources().obtainTypedArray(R.array.data_photo);
    }
}
