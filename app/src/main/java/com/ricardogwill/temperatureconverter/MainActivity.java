package com.ricardogwill.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;
    private TextView outputTextView;
    private RadioButton cToFRadioButton;
    private double inputNumber;
    private double convertedDouble;
    // Format to show only one decimal place.
    DecimalFormat decimalFormat = new DecimalFormat("###,###.#");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = (EditText) findViewById(R.id.input_editText);
        outputTextView = (TextView) findViewById(R.id.output_textView);
        cToFRadioButton = (RadioButton) findViewById(R.id.CtoF_radioButton);
    }

    public void convertCToF(View view) {
        // Gets a String from the input EditText.
        String textFromEditText = inputEditText.getText().toString();
        // Turns the String into a Double so that it can go into a formula.
        inputNumber = Double.parseDouble(textFromEditText);
        // If statement regarding the checked radio box.
        if (cToFRadioButton.isChecked()) {
            // Uses the Double in a formula and returns a Double.
            convertedDouble = ((inputNumber * (1.8)) + 32);
            // Sets the TextView to show the String version of the Double formula result.
            // The number is formatted to one decimal place, and °F is used.
            outputTextView.setText(decimalFormat.format(convertedDouble) + " °F");
        } else {
            // Uses the Double in a formula and returns a Double.
            convertedDouble = ((inputNumber - 32) * 0.555556);
            // Sets the TextView to show the String version of the Double formula result.
            // The number is formatted to one decimal place, and °C is used.
            outputTextView.setText(decimalFormat.format(convertedDouble) + " °C");
        }
        // Makes the EditText blank again so another number can easily be input.
        inputEditText.setText("");
    }

}
