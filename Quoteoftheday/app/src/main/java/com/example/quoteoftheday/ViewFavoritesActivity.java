package com.example.quoteoftheday;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ViewFavoritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_favorites);

        // Get the list of favorite quotes from the intent
        List<String> favoriteQuotes = getIntent().getStringArrayListExtra("favoriteQuotes");

        // Display the list of favorite quotes in a ListView
        ListView favoritesListView = findViewById(R.id.favoritesListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, favoriteQuotes);
        favoritesListView.setAdapter(adapter);
    }
}

