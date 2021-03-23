package com.example.searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView);

        arrayList = new ArrayList<String>();

        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cat");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (arrayList.contains(query))
                {
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(MainActivity.this,"Not found",Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

}