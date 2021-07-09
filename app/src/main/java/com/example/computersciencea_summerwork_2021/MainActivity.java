package com.example.computersciencea_summerwork_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    double bun = 0.00, meat = 0.00, condimentTotal = 0.00;
    double subtotal, tax, total;
    final double taxRate = 0.125;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.CalculateButton);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setValues(); // sets the order values and checks all the conditions
                startActivity(new Intent(MainActivity.this, Receipt.class));
            }
        });

    }

    private void updateBun(){
        double bun = 0.00;

        RadioButton whiteBreadButton = (RadioButton) findViewById(R.id.WhiteBreadButton);
        RadioButton wheatBreadButton = (RadioButton) findViewById(R.id.WheatBreadButton);

        if(whiteBreadButton.isChecked())
            bun = 1.00;
        else if (wheatBreadButton.isChecked())
            bun = 1.25;

        this.bun = bun;
    }

    private void updateMeat(){
        double meat = 0.00;
        RadioButton beefButton = (RadioButton) findViewById(R.id.BeefButton);
        RadioButton turkeyButton = (RadioButton) findViewById(R.id.TurkeyButton);
        RadioButton veganButton = (RadioButton) findViewById(R.id.VeganButton);

        if(beefButton.isChecked())
            meat = 2.00;
        else if(turkeyButton.isChecked())
            meat = 2.50;
        else if(veganButton.isChecked())
            meat = 2.75;

        this.meat = meat;
    }

    private void updateCondiments(){
        double condimentTotal = 0.00;

        CheckBox mayo = (CheckBox) findViewById(R.id.MayonaiseCheckBox);
        CheckBox ketchup = (CheckBox) findViewById(R.id.KetchupCheckBox);
        CheckBox mustard = (CheckBox) findViewById(R.id.MustardCheckBox);

        if(mayo.isChecked())
            condimentTotal += 0.15;
        if(ketchup.isChecked())
            condimentTotal += 0.15;
        if(mustard.isChecked())
            condimentTotal += 0.15;

        this.condimentTotal = condimentTotal;
    }

    public void setSubtotal(){
        double subtotal = 0.00;

        subtotal += bun;
        subtotal += meat;
        subtotal += condimentTotal;

        this.subtotal = subtotal;
    }

    public void setTax(){
        double tax = subtotal * taxRate;
        this.tax = tax;
    }

    public void setTotal(){
        double total = subtotal + tax;
        this.total = total;
    }

    private void updateOrders(){
        updateBun();
        updateMeat();
        updateCondiments();
    }

    public void compile() {
        updateOrders();
        setSubtotal();
        setTax();
        setTotal();
    }

    public void setValues(){
        compile();

        Order.subtotal = this.subtotal;
        Order.total = this.total;
        Order.tax = this.tax;

        Order.setValues();
    }
}