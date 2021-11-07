package com.bcit.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.text.NumberFormat;

public class MainLoginActivity extends AppCompatActivity
    implements TextView.OnEditorActionListener, View.OnClickListener{

    // define variables for the widgets
    EditText billAmountEditText;
    TextView percentTextView;
    Button percentUpButton;
    Button percentDownButton;
    TextView tipTextView;
    TextView totalTextView;

    // define instance variables that should be saved
    String billAmountString = "";
    float tipPercent = .15f;

    static final String STATE_TIP_PERCENT = "tipPercent";
    static final String STATE_BILL_AMOUNT = "billAmount";

    TextView tvLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        // get references to the widgets
        billAmountEditText = findViewById(R.id.editBillAmount);
        percentTextView = findViewById(R.id.tvPercentNumber);
        percentUpButton = findViewById(R.id.btnPlus);
        percentDownButton = findViewById(R.id.btnMinus);
        tipTextView = findViewById(R.id.tvTipAmount);
        totalTextView = findViewById(R.id.tvTotalAmount);

        // set the listeners
        billAmountEditText.setOnEditorActionListener(this);
        percentUpButton.setOnClickListener(this);
        percentDownButton.setOnClickListener(this);

        tvLogout = findViewById(R.id.tvLogout);
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut(); // logout
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });

    }

    public void calculateAndDisplay() {
        // get the bill amount
        billAmountString = billAmountEditText.getText().toString();
        float billAmount;
        try {
            billAmount = Float.parseFloat(billAmountString);
        }
        catch (NumberFormatException e) {
            billAmount = 0;
        }

        // calculate tip and total
        float tipAmount = billAmount * tipPercent;
        float totalAmount = billAmount + tipAmount;


        // display the other results with formatting
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        tipTextView.setText(currency.format(tipAmount));
        totalTextView.setText(currency.format(totalAmount));

        NumberFormat percent = NumberFormat.getPercentInstance();
        percentTextView.setText(percent.format(tipPercent));
    }

    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            calculateAndDisplay();
        }
        return false;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMinus:
                tipPercent = tipPercent - .01f;
                calculateAndDisplay();
                break;
            case R.id.btnPlus:
                tipPercent = tipPercent + .01f;
                calculateAndDisplay();
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putFloat(STATE_TIP_PERCENT, tipPercent);
        outState.putString(STATE_BILL_AMOUNT, billAmountString);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null){
            tipPercent = savedInstanceState.getFloat(STATE_TIP_PERCENT);
            billAmountString = savedInstanceState.getString(STATE_BILL_AMOUNT);

            calculateAndDisplay();
        }
    }

}