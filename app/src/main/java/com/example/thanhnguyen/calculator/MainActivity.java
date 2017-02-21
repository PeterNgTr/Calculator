package com.example.thanhnguyen.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText opOne, opTwo;
    TextView result;
    Button btnAdd, btnSub, btnMul, btnDivide;
    int finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addUI();
        addListener();
    }

    public void addUI() {
        opOne = (EditText) findViewById(R.id.operandOne);
        opTwo = (EditText) findViewById(R.id.operandTwo);
        result = (TextView) findViewById(R.id.result);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setEnabled(false);

        btnSub = (Button) findViewById(R.id.btnSub);
        btnSub.setEnabled(false);

        btnMul = (Button) findViewById(R.id.btnMul);
        btnMul.setEnabled(false);

        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnDivide.setEnabled(false);
    }

    public void addListener() {
        opOne.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!isEmpty(opOne)) {
                    btnAdd.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMul.setEnabled(true);
                    btnDivide.setEnabled(true);
                }
                else {
                    btnAdd.setEnabled(false);
                    btnSub.setEnabled(false);
                    btnMul.setEnabled(false);
                    btnDivide.setEnabled(false);
                }
            }
        });


        opTwo.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!isEmpty(opTwo)) {
                    btnAdd.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMul.setEnabled(true);
                    btnDivide.setEnabled(true);
                }
                else {
                    btnAdd.setEnabled(false);
                    btnSub.setEnabled(false);
                    btnMul.setEnabled(false);
                    btnDivide.setEnabled(false);
                }
            }
        });

    btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add();
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sub();
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                multiply();
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                divide();
            }
        });
    }

    public int parseInt(TextView textView) {
        return Integer.parseInt(textView.getText().toString());
    }

    public void add() {
        if (isEmpty(opOne) || isEmpty(opTwo)){
            result.setText(String.valueOf("Please input operand"));
        }else {
            finalResult = parseInt(opOne) + parseInt(opTwo);
            result.setText(String.valueOf(finalResult));
        }
    }

    public void sub() {
        if (isEmpty(opOne) || isEmpty(opTwo)){
            result.setText(String.valueOf("Please input operand"));
        }else {
            finalResult = parseInt(opOne) - parseInt(opTwo);
            result.setText(String.valueOf(finalResult));
        }
    }

    public void multiply() {
        if (isEmpty(opOne) || isEmpty(opTwo)){
            result.setText(String.valueOf("Please input operand"));
        }else {
            finalResult = parseInt(opOne) * parseInt(opTwo);
            result.setText(String.valueOf(finalResult));
        }
    }

    public void divide() {
        try {
            if (isEmpty(opOne) || isEmpty(opTwo)){
                result.setText(String.valueOf("Please input operand"));
            }else {
                finalResult = parseInt(opOne) / parseInt(opTwo);
            }

        }catch (ArithmeticException e) {
            System.err.println("ArithmeticException:" + e.getMessage());
        }
        result.setText(String.valueOf(finalResult));
    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
}
