package com.example.go;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ForgotPage extends Activity {

	private EditText forgotCardNumber;
	private EditText forgotCVV;
    private Button forgotSibmut;
    private Button forgotCancle;

    private boolean flag1 = true;
    private boolean flag2 = true;
    private final int forgotCODE = 1012;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.forgot_userid);

        forgotCardNumber = (EditText) findViewById(R.id.ForgotCardNumber);
        forgotCVV = (EditText) findViewById(R.id.ForgotCVV);
        forgotSibmut = (Button) findViewById(R.id.forgotSubmit);
        forgotCancle = (Button) findViewById(R.id.forgotCancle);
        
        forgotSibmut.setOnClickListener(new View.OnClickListener() {
        	
			
			@Override
			public void onClick(View arg0) {
				String cardNumber = forgotCardNumber.getText().toString();
				String cvv = forgotCVV.getText().toString();
				cardNumberValidation(cardNumber);
				cvvValidation(cvv);
				if(flag1 && flag2){
					Intent intent = new Intent();
	                setResult(forgotCODE,intent);
	                finish();
				}
			}
		});
        
        forgotCancle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(ForgotPage.this,MainPage.class);
				startActivity(intent);
			}
		});
    }

    private void cardNumberValidation(String cardNumber){
	    if(cardNumber == null || cardNumber.trim().length() == 0 || cardNumber.trim().equals("")){
	    	Toast.makeText(getApplicationContext(), "Card Nummber can't be null !", Toast.LENGTH_SHORT).show();
	    	flag1 = false;
	    }else{
	    	flag1 = true;
	    }
	}
    private void cvvValidation(String cvv){
    	if(cvv == null || cvv.trim().length() == 0 || cvv.trim().equals("")){
    		Toast.makeText(getApplicationContext(), "CVV can't be null !", Toast.LENGTH_SHORT).show();
    		flag2 = false;
    	}else{
    		flag2 = true;
    	}
    }
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}