package org.izv.abrirycerraractivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = MainActivity.class.getName() + "xyzyx";

    private EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {
            Log.v(TAG, "onRestoreInstanceState");
            String string = savedInstanceState.getString("valor");
            etText.setText(string + " " + string);
        }
        initialize();
    }

    /*@Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.v(TAG, "onRestoreInstanceState");
        String string = savedInstanceState.getString("valor");
        etText.setText(string + " " + string);
    }*/

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(TAG, "onSaveInstanceState");
        outState.putString("valor", etText.getText().toString());
        //serializable es "caro"
        //parcelable
    }

    private void initialize() {
        Button btGo = findViewById(R.id.btGo);
        etText = findViewById(R.id.etText);

        btGo.setOnClickListener((View v) -> {
            //openActivity();
            etText.setText("algo");
        });
    }

    private void openActivity() {
        Intent intencion = new Intent(this, SecondaryActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("valorBundle", etText.getText().toString());
        intencion.putExtras(bundle);
        intencion.putExtra("valorExtra", etText.getText().toString());
        startActivity(intencion);
    }

}