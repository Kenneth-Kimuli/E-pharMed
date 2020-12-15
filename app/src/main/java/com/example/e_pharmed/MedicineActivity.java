package com.example.e_pharmed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MedicineActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    TextView textView;
    //Button button;
    String[] listMedicine;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy_medicine);

        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.lv1);
        textView = findViewById(R.id.textView);
        //button = findViewById(R.id.button);

        listMedicine = getResources().getStringArray(R.array.array_medicine);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listMedicine);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value=adapter.getItem(position);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MedicineActivity.this,ScanActivity.class));

            }
        });
    }
}
