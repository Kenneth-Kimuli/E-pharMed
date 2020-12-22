package com.example.e_pharmed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class PharmacyActivity extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    TextView textView;
    String[] listPharmacy;
    //ArrayList<String> list;
    //ArrayAdapter<String > adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy_medicine);

        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.lv1);
        textView = findViewById(R.id.textView);
        listPharmacy = getResources().getStringArray(R.array.array_pharmacies);

        //sets up the list view
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listPharmacy);
        listView.setAdapter(adapter);

        //todo: search view edit
        /*searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if (listPharmacy.contains(query)) {
                    adapter.getFilter().filter(query);
                } else {
                    Toast.makeText(PharmacyActivity.this, "No Match found", Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
                return false;
            }
        });*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String value = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PharmacyActivity.this, MedicineActivity.class));
            }
        });

    }
}
