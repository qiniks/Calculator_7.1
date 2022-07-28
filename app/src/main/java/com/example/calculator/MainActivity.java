package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Integer first, second, result;
    private Boolean isOperationClick;
    private String op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
    }

    @SuppressLint("NonConstantResourceId")
    public void onNumberClick(View view) {
        switch (view.getId()){
            case R.id.btn_zero:
                setNumber("0");
                break;

            case R.id.btn_one:
                setNumber("1");
                break;

            case R.id.btn_two:
                setNumber("2");
                break;

            case R.id.btn_three:
                setNumber("3");
                break;

            case R.id.btn_four:
                setNumber("4");
                break;

            case R.id.btn_five:
                setNumber("5");
                break;

            case R.id.btn_six:
                setNumber("6");
                break;

            case R.id.btn_seven:
                setNumber("7");
                break;

            case R.id.btn_eight:
                setNumber("8");
                break;

            case R.id.btn_nine:
                setNumber("9");
                break;

            case R.id.btn_clear:
                tvResult.setText("0");
                first = 0;
                second = 0;
                break;
        }
        isOperationClick = false;
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void onOperationClick(View view) {
        switch (view.getId()){
            case R.id.btn_plus:
                first = Integer.parseInt(tvResult.getText().toString());
                op = "plus";
                break;

            case R.id.btn_minus:
                first = Integer.parseInt(tvResult.getText().toString());
                op = "minus";
                break;

            case R.id.btn_division:
                first = Integer.parseInt(tvResult.getText().toString());
                op = "division";
                break;

            case R.id.btn_multiplication:
                first = Integer.parseInt(tvResult.getText().toString());
                op = "multiplication";
                break;

            case R.id.btn_equal:
                switch (op) {
                    case "plus":
                        second = Integer.parseInt(tvResult.getText().toString());
                        result = first + second;
                        tvResult.setText(result.toString());
                        break;

                    case "minus":
                        second = Integer.parseInt(tvResult.getText().toString());
                        result = first - second;
                        tvResult.setText(result.toString());
                        break;

                    case "division":
                        second = Integer.parseInt(tvResult.getText().toString());
                        result = first / second;
                        tvResult.setText(result.toString());
                        break;

                    case "multiplication":
                        second = Integer.parseInt(tvResult.getText().toString());
                        result = first * second;
                        tvResult.setText(result.toString());
                        break;
                }
        }
        isOperationClick = true;
    }

    private void setNumber(String number){
        if(tvResult.getText().toString().equals("0")){
            tvResult.setText(number);
        }else if(isOperationClick){
            tvResult.setText(number);
        }else {
            tvResult.append(number);
        }
    }
}