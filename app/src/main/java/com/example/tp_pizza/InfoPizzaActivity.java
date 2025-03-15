package com.example.tp_pizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoPizzaActivity extends AppCompatActivity {
    private TextView nom, description, preparation, ingrediants;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pizza);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pizza Recipes");

        nom = findViewById(R.id.nomTxt);
        description = findViewById(R.id.descriptionTxt);
        preparation = findViewById(R.id.preparationTxt);
        ingrediants = findViewById(R.id.ingredientsTxt);
        image = findViewById(R.id.image);

        nom.setText(getIntent().getStringExtra("nom"));
        description.setText(getIntent().getStringExtra("description"));
        preparation.setText(getIntent().getStringExtra("preparation"));
        ingrediants.setText(getIntent().getStringExtra("ingredients"));
        image.setImageResource(getIntent().getIntExtra("image", R.mipmap.timer));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem shareItem = menu.add(0, 1, 0, "Share");
        shareItem.setIcon(ContextCompat.getDrawable(this, R.mipmap.share));
        shareItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        shareItem.setOnMenuItemClickListener(item -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Lorem ipsum dolor sit amet!");
            startActivity(Intent.createChooser(shareIntent, "Share via"));
            return true;
        });

        return true;
    }
}