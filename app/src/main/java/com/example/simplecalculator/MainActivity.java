package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    EditText window;
    String number1 = "", number2 = "", number = "", operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity","onCreate called");
        setContentView(R.layout.activity_main);
        window = findViewById(R.id.calc_window);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity","onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity","onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity","onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity","onStop called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity","onRestart called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","onDestroy called");
    }
    public void numberClicked(View view) {
        Button numberButton = (Button) view;
        number += numberButton.getText().toString();
        window.setText(window.getText().toString() + numberButton.getText().toString());
    }

    public void operatorClicked(View view) {
        number1 = number;
        number = "";
        Button operatorButton = (Button) view;
        operator = operatorButton.getText().toString();
        window.setText(window.getText().toString() + operator);
    }

    public void equalClicked(View view) {
        try {
            number2 = number;
            BigDecimal result = new BigDecimal("0");
            BigDecimal num1 = new BigDecimal(number1);
            BigDecimal num2 = new BigDecimal(number2);

            switch (operator) {
                case "+":
                    result = num1.add(num2);
                    break;
                case "-":
                    result = num1.subtract(num2);
                    break;
                case "*":
                    result = num1.multiply(num2);
                    break;
                case "/":
                    result = num1.divide(num2,3, RoundingMode.CEILING);
                    break;
            }
            window.setText(String.valueOf(result));
            number = String.valueOf(result);
            number1 = "";
            number2 = "";
            operator = "";
        } catch (Exception e) {
            window.setText(R.string.invalid_expression);
        }

    }

    public void clearClicked(View view) {
        number = "";
        number1 = "";
        number2 = "";
        operator = "";
        window.setText("");
    }
}