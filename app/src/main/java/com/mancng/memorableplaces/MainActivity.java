package com.mancng.memorableplaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    static ArrayList<String> places;
    static ArrayAdapter<String> arrayAdapter;
    static ArrayList<LatLng> locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = (ListView) findViewById(R.id.myListView);

        places = new ArrayList<String>();

        places.add("Add a new place...");

        locations = new ArrayList<>();

        locations.add(new LatLng(0, 0));


        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, places);

        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("locationInfo", position);
                startActivity(i);

            }
        });



    }
}
