package com.sagar.android.primalitytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sagar Nayak on 11 OCT 2017
 * This is the activity to check if a number is a prime number or not. the full logical explanation
 * for this class can be found at http://aideafactory.com/primality-test
 */
public class MainActivity extends AppCompatActivity {

    //views
    private EditText editTextNumber;
    private Button buttonCheck;
    private TextView textViewTimeTaken;
    private TextView textViewTimeTakenValue;
    private TextView textViewResult;

    /**
     * enum to contain result type that are prime or not prime.
     */
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

        ////////////////////////////////////////////////////////////////////////////////////////////
        //view binding
        editTextNumber = (EditText) findViewById(R.id.edittext_number);
        buttonCheck = (Button) findViewById(R.id.button_check);
        textViewTimeTaken = (TextView) findViewById(R.id.textview_time_taken);
        textViewTimeTakenValue = (TextView) findViewById(R.id.textview_time_taken_value);
        textViewResult = (TextView) findViewById(R.id.textview_result);
        ////////////////////////////////////////////////////////////////////////////////////////////

        /*
        text watcher to check if a number is valid for testing or not.
        if user enters a number that is not a valid number the app will clear the edittext and show
        an error message to user.
        also as the data type used here is long the max limit it can hold is
        9223372036854775807L. if user exceeds this limit it will show error message to user.
         */
        editTextNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editTextNumber.getText().length() == 0)
                    return;
                try {
                    if (Long.parseLong(editTextNumber.getText().toString()) > Long.MAX_VALUE) {
                        Toast.makeText(MainActivity.this, "Max limit is : " + Long.MAX_VALUE, Toast.LENGTH_SHORT).show();
                        editTextNumber.setText("");
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Max limit is : " + Long.MAX_VALUE, Toast.LENGTH_SHORT).show();
                    editTextNumber.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        /*
        on button click the the checking for prime number will start.
        it will also check for the time taken for that number to be calculated by the method.
         */
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextNumber.getText().length() == 0)
                    return;
                long startTime = System.nanoTime();
                if (isPrime(Long.parseLong(editTextNumber.getText().toString())))
                    textViewResult.setText(String.valueOf(Result.PRIME.getValue()));
                else
                    textViewResult.setText(String.valueOf(Result.NOT_PRIME.getValue()));
                long stopTime = System.nanoTime();
                textViewTimeTaken.setText(String.valueOf("Time Taken"));
                textViewTimeTakenValue.setText(String.valueOf((stopTime - startTime) + " ns"));
            }
        });
    }

    /**
     * method to check if a number is a prime number.
     * @param numberToCheck number to check
     * @return true if prime, false otherwise
     */
    private boolean isPrime(long numberToCheck) {
        if (numberToCheck <= 1)
            return false;
        if (numberToCheck <= 3)
            return true;
        if (numberToCheck % 2 == 0 || numberToCheck % 3 == 0)
            return false;
        for (long i = 5; i * i <= numberToCheck; i += 6) {
            if (numberToCheck % i == 0 || numberToCheck % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
