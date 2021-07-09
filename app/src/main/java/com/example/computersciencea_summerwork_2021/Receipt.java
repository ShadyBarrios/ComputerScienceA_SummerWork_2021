package com.example.computersciencea_summerwork_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Receipt extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        setValues();
    }

    private void setValues(){
        TextView subtotal = (TextView) findViewById(R.id.Subtotal);
        TextView tax = (TextView) findViewById(R.id.Tax);
        TextView total = (TextView) findViewById(R.id.Total);
        subtotal.setText(Order.subtotalString);
        tax.setText(Order.taxString);
        total.setText(Order.totalString);
    }
}