package org.izv.abrirycerraractivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        initialize();
    }

    private void initialize() {
        Button btBack = findViewById(R.id.btBack);
        TextView tvText = findViewById(R.id.tvText);

        //ViewModel
        Bundle bundle = getIntent().getExtras();
        String valorBundle, valorExtra;
        valorBundle = bundle.getString("valorBundle");
        valorExtra = bundle.getString("valorExtra");

        tvText.setText(valorBundle + " " + valorExtra);

        btBack.setOnClickListener((View v) -> {
            finish();
        });
    }
}