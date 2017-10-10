package com.sagar.android.primalitytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber;
    Button buttonCheck;
    TextView textViewTimeTaken;
    TextView textViewResult;

    enum Result {
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
    }
}
