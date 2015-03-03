package com.example.go;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Transaction extends Activity {

    private TextView transactionCard;
    private TextView transactionBalance;
    private Button buttonReturn;

    private ScrollView scrollView;
    private LinearLayout scrollLine;

    final int TransactionCODE = 1003;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.transaction);
        transactionCard = (TextView) findViewById(R.id.TransactionCard);
        transactionBalance = (TextView) findViewById(R.id.TransactionBalance);

        Intent intent = getIntent();
        String _cardNumber = intent.getStringExtra("cardNumber");
        String _balance = intent.getStringExtra("balance");
        transactionCard.setText("Card Number: " + _cardNumber);
        transactionBalance.setText("Balance:          " + _balance);

        scrollView = (ScrollView)findViewById(R.id.scrollView);
        scrollLine = (LinearLayout)scrollView.findViewById(R.id.scrollLine);
        for(int i=0; i < 10; i++){
            ImageView imageView = new ImageView(this);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.go));
            scrollLine.addView(imageView,i);
        }
        buttonReturn = (Button)findViewById(R.id.Return);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(TransactionCODE,intent);
                finish();
            }
        });
    }

}