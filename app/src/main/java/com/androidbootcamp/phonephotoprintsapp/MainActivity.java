package com.androidbootcamp.phonephotoprintsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    int numOfPrints;
    double smallPrints = .19;
    double mediumPrints = .49;
    double largePrints = .79;
    double totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText prints = (EditText) findViewById(R.id.txtPrints);
        final RadioButton rad1 = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton rad2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton rad3 = (RadioButton) findViewById(R.id.radioButton3);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button order = (Button) findViewById(R.id.btnOrder);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfPrints = Integer.parseInt(prints.getText().toString());
                DecimalFormat currency = new DecimalFormat("$##.00");
                if(rad1.isChecked()) {
                    if(numOfPrints <= 50){
                        totalCost = numOfPrints * smallPrints;
                        result.setText(currency.format(totalCost) + " for " + numOfPrints + " small 4 x 9 prints");
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Prints must be 50 or less", Toast.LENGTH_SHORT).show();
                    }
                }

                if(rad2.isChecked()){
                    if(numOfPrints <= 50){
                        totalCost = numOfPrints * mediumPrints;
                        result.setText(currency.format(totalCost) + " for " + numOfPrints + " medium 5 x 7 prints");
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Prints must be 50 or less", Toast.LENGTH_SHORT).show();

                    }
                }

                if(rad3.isChecked()) {
                    if(numOfPrints <= 50) {
                        totalCost = numOfPrints + largePrints;
                        result.setText(currency.format(totalCost) + " for " + numOfPrints + " large 8 x 10 prints");

                    }
                    else {
                        Toast.makeText(MainActivity.this, "Prints must be 50 or less", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }
}

