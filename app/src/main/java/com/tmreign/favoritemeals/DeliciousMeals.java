package com.tmreign.favoritemeals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeliciousMeals extends AppCompatActivity {
    @BindView(R.id.listView)ListView mListView;
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    private String[] meals = new String[] {"Beef and Bean Burritos", "Shrimp Scampi",
            "Fried Round Steak", "Chicken Florentine Pasta", "Roasted Red Pepper Pasta", "Pepperoni Pizza Burgers",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delicious_meals);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, meals);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String meals = ((TextView)view).getText().toString();
                Toast.makeText(DeliciousMeals.this, meals, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Place Your Favorite Meals: " + location);
    }
}
