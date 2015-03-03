package com.example.go;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterPage extends Activity {

	private EditText createCardNumber;
	private EditText createUserId;
	private EditText createCVV;
	private EditText createPwd;
	private EditText confirmPwd;
	private EditText createEmail;
	private EditText confirmEmail;
    private Button   createSubmit;
    private Button   createcancle;

    private StringBuffer errorMsg;
    
    private final int registerCODE = 1013;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.register);

        createCardNumber = (EditText) findViewById(R.id.CreateCardNumber);
        createUserId = (EditText) findViewById(R.id.CreateUserId);
        createCVV = (EditText) findViewById(R.id.CreateCVV);
        createPwd = (EditText) findViewById(R.id.CreatePwd);
        confirmPwd = (EditText) findViewById(R.id.ConfirmPwd);
        createEmail = (EditText) findViewById(R.id.CreateEmail);
        confirmEmail = (EditText) findViewById(R.id.ConfirmEmail);
        
        createSubmit = (Button) findViewById(R.id.CreateSubmit);
        createcancle = (Button) findViewById(R.id.Createcancle);
        
        createSubmit.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View arg0) {
				String cardNumber = createCardNumber.getText().toString();
				String userId = createUserId.getText().toString();
				String cvv = createCVV.getText().toString();
				String pwd = createPwd.getText().toString();
				String cfmPwd = confirmPwd.getText().toString();
				String email = createEmail.getText().toString();
				String cfmEmail = confirmEmail.getText().toString();
				Intent intent = new Intent();
				setResult(registerCODE,intent);
				finish();
				//msgValidation(cardNumber, userId, cvv, pwd, cfmPwd, email, cfmEmail);
				/*if(errorMsg == null){
				}else{*/
					/*new AlertDialog.Builder(RegisterPage.this)
		            .setIcon(android.R.drawable.ic_dialog_alert)
		            .setTitle("Error!")
		            .setMessage("123")
		            .setNegativeButton("OK!", null)
		            .show();*/
				//}
				
			}
		});
        
        createcancle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(RegisterPage.this,MainPage.class);
				startActivity(intent);
			}
		});
    }

    private void msgValidation(String cardNumber, String userId, String cvv, String pwd, String cfmPwd,
    		String email, String cfmEmail){
	    if(cardNumber == null || cardNumber.trim().length() == 0 || cardNumber.trim().equals("")){
	    	errorMsg.append("Card Number can't be null !"+"\n");
	    }else if (userId == null || userId.trim().length() == 0 || userId.trim().equals("")){
			errorMsg.append("User Id can't be null !"+"\n");
		}else if (cvv == null || cvv.trim().length() == 0 || cvv.trim().equals("")){
			errorMsg.append("CVV can't be null !"+"\n");
		}else if (pwd == null || pwd.trim().length() == 0 || pwd.trim().equals("")){
			errorMsg.append("Password can't be null !"+"\n");
		}else if (cfmPwd == null || cfmPwd.trim().length() == 0 || cfmPwd.trim().equals("")){
			errorMsg.append("Confirm Password can't be null !"+"\n");
		}else if (!pwd.equals(cfmPwd)){
			errorMsg.append("Confirm Password != Password !"+"\n");
		}else if (email == null || email.trim().length() == 0 || email.trim().equals("")){
			errorMsg.append("Email can't be null !"+"\n");
		}else if (cfmEmail == null || cfmEmail.trim().length() == 0 || cfmEmail.trim().equals("")){
			errorMsg.append("Confirm Email can't be null !"+"\n");
		}else if (!email.trim().equals(cfmEmail.trim())){
			errorMsg.append("Confirm Email != Email !");
		}
	}

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}