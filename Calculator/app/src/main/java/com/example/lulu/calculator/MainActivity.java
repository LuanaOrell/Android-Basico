package com.example.lulu.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtResult;
    private String operator="";
    private int resultP;
    private int result=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = (TextView)findViewById(R.id.textResult);
    }
    public void onClick(View view){
        if(txtResult.getText().toString().equals("0")){
            txtResult.setText("");
        }
        switch (view.getId()){
            case R.id.btn_n0:
            case R.id.btn_n1:
            case R.id.btn_n2:
            case R.id.btn_n3:
            case R.id.btn_n4:
            case R.id.btn_n5:
            case R.id.btn_n6:
            case R.id.btn_n7:
            case R.id.btn_n8:
            case R.id.btn_n9:
                Button button = (Button) view;
                txtResult.setText(txtResult.getText() + button.getText().toString());
                resultP=Integer.parseInt(button.getText().toString());
                cambiarResultado();
                break;
            case R.id.btn_suma:
                txtResult.setText(txtResult.getText()+"+");
                operator="+";
                break;
            case R.id.btn_resta:
                txtResult.setText(txtResult.getText()+"-");
                operator="-";
                break;
            case R.id.btn_div:
                txtResult.setText(txtResult.getText()+"/");
                operator="/";
                break;
            case R.id.btn_mult:
                txtResult.setText(txtResult.getText()+"*");
                operator="*";
                break;
            case R.id.btn_equals:
                txtResult.setText(Integer.toString(result));
                break;
            case R.id.btn_limpiar:
                txtResult.setText("0");
                result=0;
                operator="";
                break;
        }


    }

    private void cambiarResultado() {
        if(result == 0){
            result=resultP;
        }
        if(operator.equals("+")) {
            result = result + resultP;
            operator = "";
        }
        if(operator.equals("-")) {
            result = result - resultP;
            operator = "";
        }
        if(operator.equals("*")) {
            result = result * resultP;
            operator = "";
        }
        if(operator.equals("/")) {
            result = result / resultP;
            operator = "";
        }

    }
}
