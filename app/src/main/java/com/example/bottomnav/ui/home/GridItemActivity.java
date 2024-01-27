package com.example.bottomnav.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomnav.R;

public class GridItemActivity extends AppCompatActivity {
    TextView name;
    ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.griditem);

        name = findViewById(R.id.griddata);
        image = findViewById(R.id.imageView);

        Intent intent = getIntent();
        if (intent != null) {
            name.setText(intent.getStringExtra("name"));
            image.setImageResource(intent.getIntExtra("image", 0));
        }
    }
}
