package com.example.go;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vo.Data;

public class LoginPage extends Activity {

	private TextView userId;
	private EditText password;
	private Button loginLogin;
	private Button loginCancle;
	private TextView forgotPwd;
	
	private boolean flag = true;
	
	private final int loginCODE = 1011;
	private final int forgotPwdCODE = 1014;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);
		
		userId = (TextView) findViewById(R.id.UserID);
		password = (EditText) findViewById(R.id.Password);
		loginLogin = (Button) findViewById(R.id.loginLogin);
		loginCancle = (Button) findViewById(R.id.loginCancle);
		forgotPwd = (TextView) findViewById(R.id.ForgotPassword);
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		final String _userId = bundle.getString("userId").toUpperCase();
		userId.setText(_userId);
		
		loginLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String _pwd = password.getText().toString();
				passwordValidation(_pwd);
				if(flag && _userId.equals(Data.USER[0]) && _pwd.equals(Data.USER[1])){
					Intent intentLogin = new Intent(LoginPage.this, CustomerPage.class);
					Bundle bundles = new Bundle();
					bundles.putString("userName", Data.USER[2]);
					bundles.putString("address", Data.USER[3]);
					bundles.putString("cardNumber", Data.USER[4]);
					bundles.putString("status", Data.USER[5]);
					bundles.putString("issueDate", Data.USER[6]);
					bundles.putString("expireDate", Data.USER[7]);
					bundles.putString("balance", Data.USER[8]);
					bundles.putString("methodOfContact", Data.USER[9]);
					bundles.putString("email", Data.USER[10]);
					bundles.putString("phone", Data.USER[11]);
					bundles.putString("sms", Data.USER[12]);
					intentLogin.putExtras(bundles);
					startActivity(intentLogin);
					ProgressDialog proDialog = new ProgressDialog(LoginPage.this);
                    proDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    proDialog.setMessage("Login...");
                    proDialog.show();
				}else{
					Intent intent = new Intent();
	                setResult(loginCODE,intent);
	                finish();
				}
			}
		});
		
		loginCancle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(LoginPage.this,MainPage.class);
				startActivity(intent);
			}
		});
		
		forgotPwd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				setResult(forgotPwdCODE,intent);
				finish();
			}
		});
		
		
	}
	private void passwordValidation(String password){
	    if(password == null || password.trim().length() == 0 || password.trim().equals("")){
	    	Toast.makeText(getApplicationContext(), "Password can't be null !", Toast.LENGTH_SHORT).show();
	    	flag = false;
	    }else {
			flag = true;
		}
	}
	 //shield back
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
