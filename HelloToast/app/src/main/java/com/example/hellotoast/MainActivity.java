package com.example.hellotoast;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView displayCountText;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayCountText = findViewById(R.id.text_display_count);

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count_value");
            displayCountText.setText(String.valueOf(count));
        }

        updateZeroButtonColor();
    }


    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count_value", count);
    }

    public void show_toast(View view) {
        Toast.makeText(this, "Hello Toast", Toast.LENGTH_SHORT).show();
        // Toast.makeText(this, "Count is: " + count, Toast.LENGTH_SHORT).show();
    }

    public void increase_count(View view) {
        count++;
        displayCountText.setText(String.valueOf(count));

        Button btnCount = findViewById(R.id.button_count);
        btnCount.setBackgroundTintList(null);
        if (count % 2 == 0) {
            btnCount.setBackgroundColor(getResources().getColor(R.color.green)); // even
        } else {
            btnCount.setBackgroundColor(getResources().getColor(R.color.magenta)); // odd
        }

        updateZeroButtonColor();
    }

    public void reset_count(View view) {
        count = 0;
        displayCountText.setText(String.valueOf(count));


        Button btnCount = findViewById(R.id.button_count);
        btnCount.setBackgroundColor(getResources().getColor(R.color.blue));

        updateZeroButtonColor();
    }


    private void updateZeroButtonColor() {
        Button btnZero = findViewById(R.id.button_zero);

        if (count == 0) {
            btnZero.setBackgroundColor(getResources().getColor(R.color.gray));
        } else {
            btnZero.setBackgroundColor(getResources().getColor(R.color.orange));
        }
    }
}
