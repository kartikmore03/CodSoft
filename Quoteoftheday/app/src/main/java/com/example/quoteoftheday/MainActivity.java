package com.example.quoteoftheday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private List<String> favoriteQuotes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        quoteTextView = findViewById(R.id.quoteTextView);
        Button generateButton = findViewById(R.id.generateButton);
        Button addToFavoritesButton = findViewById(R.id.addToFavoritesButton);
        Button shareButton = findViewById(R.id.shareButton);
        Button viewFavoritesButton = findViewById(R.id.viewFavoritesButton);

        // Set click listener for the "Generate Quote" button
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call a method to set a random inspirational quote
                setRandomInspirationalQuote();
            }
        });

        // Set click listener for the "Add to Favorites" button
        addToFavoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call a method to handle adding to favorites
                addToFavorites();
            }
        });

        // Set click listener for the "Share Quote" button
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call a method to handle sharing the quote
                shareQuote();
            }
        });

        // Set click listener for the "View Favorites" button
        viewFavoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the ViewFavoritesActivity
                openViewFavoritesActivity();
            }
        });
    }

    private void setRandomInspirationalQuote() {
        // Array of inspirational quotes
        String[] quotes = {
                "Believe you can and you're halfway there. -Theodore Roosevelt",
                "The only limit to our realization of tomorrow will be our doubts of today. -Franklin D. Roosevelt",
                "It always seems impossible until it's done. -Nelson Mandela",
                "The future belongs to those who believe in the beauty of their dreams. -Eleanor Roosevelt",
                "The only way to do great work is to love what you do. -Steve Jobs",
                "Success is not final, failure is not fatal: It is the courage to continue that counts. - Winston Churchill",
                "Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful. - Albert Schweitzer"
        };

        // Select a random quote
        String randomQuote = quotes[new Random().nextInt(quotes.length)];

        // Set the random quote to the TextView
        quoteTextView.setText(randomQuote);
    }

    private void addToFavorites() {
        // Get the current quote
        String currentQuote = quoteTextView.getText().toString();

        // Check if the quote is not already in favorites
        if (!favoriteQuotes.contains(currentQuote)) {
            // Add the current quote to the list of favorite quotes
            favoriteQuotes.add(currentQuote);
            Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Quote already in Favorites", Toast.LENGTH_SHORT).show();
        }
    }

    private void shareQuote() {
        // Get the current quote
        String currentQuote = quoteTextView.getText().toString();

        // Create an Intent to share the quote
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, currentQuote);

        // Start the activity to show the share options
        startActivity(Intent.createChooser(shareIntent, "Share Quote"));
    }

    private void openViewFavoritesActivity() {
        // Open the ViewFavoritesActivity
        Intent intent = new Intent(this, ViewFavoritesActivity.class);
        intent.putStringArrayListExtra("favoriteQuotes", (ArrayList<String>) favoriteQuotes);
        startActivity(intent);
    }
}
