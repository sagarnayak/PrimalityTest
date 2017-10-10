package com.sagar.android.primalitytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private Button buttonCheck;
    private TextView textViewTimeTaken;
    private TextView textViewResult;

    private enum Result {
        PRIME("Prime"),
        NOT_PRIME("Not Prime");

        private String value;

        Result(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextNumber = (EditText) findViewById(R.id.edittext_number);
        buttonCheck = (Button) findViewById(R.id.button_check);
        textViewTimeTaken = (TextView) findViewById(R.id.textview_time_taken_value);
        textViewResult = (TextView) findViewById(R.id.textview_result);

        editTextNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
