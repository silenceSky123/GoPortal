package com.example.go;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainPage extends Activity {

	private Button btnLogin;
    private EditText userId;
    private TextView forgotUserId;
    private ImageView register;
    private Button btnHome;
    
    private boolean flag = true;
    
    private final int loginCODE = 1001;
    private final int forgotCODE = 1002;
    private final int registCODE = 1003;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        userId = (EditText) findViewById(R.id.UserId);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        forgotUserId = (TextView) findViewById(R.id.forgotUserId);
        register = (ImageView) findViewById(R.id.register);
        btnHome = (Button)findViewById(R.id.Home);

        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String _userId = userId.getText().toString().trim();
                userIdValidation(_userId);
                if(flag){
                Intent intent = new Intent(MainPage.this, LoginPage.class);
                Bundle bundle = new Bundle();
                bundle.putString("userId", _userId);
                intent.putExtras(bundle);
                startActivityForResult(intent, loginCODE);
                }
            }
        });

        forgotUserId.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, ForgotPage.class);
                startActivityForResult(intent, forgotCODE);
                /*Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);*/
            }
        });
        
        register.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent(MainPage.this, RegisterPage.class);
        		startActivityForResult(intent, registCODE);
        	}
        });

        btnHome.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == (loginCODE+10) && requestCode == loginCODE){
            Toast.makeText(getApplicationContext(),"User Id or Password is not correct!",Toast.LENGTH_LONG).show();
            userId.setText("");
        }else if (resultCode == (forgotCODE+10) && requestCode == forgotCODE) {
        	new AlertDialog.Builder(MainPage.this)
            .setIcon(android.R.drawable.ic_dialog_info)
            .setTitle("User ID")
            .setMessage("Your User Id: GO")
            .setNegativeButton("OK!", null)
            .show();
        	userId.setText("");
		}else if (resultCode == (loginCODE+13) && requestCode == loginCODE) {
        	new AlertDialog.Builder(MainPage.this)
            .setIcon(android.R.drawable.ic_dialog_info)
            .setTitle("Password")
            .setMessage("Your Password: 123")
            .setNegativeButton("OK!", null)
            .show();
        	userId.setText("");
		}else if (resultCode == (registCODE+10) && requestCode == registCODE) {
			new AlertDialog.Builder(MainPage.this)
            .setIcon(android.R.drawable.ic_dialog_info)
            .setTitle("Create successfully!")
            .setMessage("User Id: GO / Password: 123")
            .setNegativeButton("OK!", null)
            .show();
			userId.setText("");
		}
    }

    private void userIdValidation(String userId){
        if(userId == null || userId.trim().length() == 0 || userId.trim().equals("")){
            Toast.makeText(getApplicationContext(), "User Id can't be null !", Toast.LENGTH_SHORT).show();
            flag = false;
        }else{
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
