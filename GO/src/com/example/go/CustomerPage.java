package com.example.go;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.slide.SlidingLayout;


public class CustomerPage extends Activity {

	private TextView infoName;
	private TextView infoAddress;
	private TextView infoCN;
	private TextView infoStatus;
	private TextView infoID;
	private TextView infoED;
	private TextView infoCB;
	private TextView infoMoc;
	private TextView infoEL;
	private TextView infoPhone;
	private TextView infoSMS;

    private Button btnLoginOut;
    private ProgressDialog proDialog;

    private SlidingLayout slidingLayout;
    private LinearLayout customerHome;
    private RelativeLayout menu;

    private ImageView menuLink;
    private ImageView payLink;

    private ListView contentListView;

    
    //.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.customer);

        slidingLayout = (SlidingLayout)findViewById(R.id.slidingLayout);
        menuLink = (ImageView)findViewById(R.id.menuLink);
        payLink = (ImageView)findViewById(R.id.payLink);

        customerHome = (LinearLayout)findViewById(R.id.customerHome);

        contentListView = (ListView)findViewById(R.id.menuList);
        int[] menuImage = new int[] {R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,
                R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,
                R.drawable.menu1,R.drawable.menu2,R.drawable.menu3};
        String[] menuName = new String[] {"Menu1","Menu2","Menu3",
                "Menu4","Menu5","Menu6","Menu7","Menu8","Menu9"};
        List<Map<String,Object>> itemList = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < menuImage.length; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("menuImage",menuImage[i]);
            map.put("menuName", menuName[i]);
            itemList.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, itemList, R.layout.items,
                new String[]{"menuName", "menuImage"}, new int[]{R.id.menuName,R.id.menuImage});
        contentListView.setAdapter(simpleAdapter);

        menu = (RelativeLayout)findViewById(R.id.menu);
        slidingLayout.setScrollEvent(menu);

        menuLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (slidingLayout.isLeftLayoutVisible()) {
                    slidingLayout.scrollToRightLayout();
                } else {
                    slidingLayout.scrollToLeftLayout();
                }
            }
        });
        payLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 new AlertDialog.Builder(CustomerPage.this)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Pay Function")
                            .setMessage("Need to be extended...")
                            .setNegativeButton("OK!", null)
                            .show();
            }
        });
        customerHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (slidingLayout.isLeftLayoutVisible()) {
                    slidingLayout.scrollToRightLayout();
                }
            }
        });

        infoName = (TextView) findViewById(R.id.infoName);
        infoAddress = (TextView) findViewById(R.id.infoAddress);
        infoCN = (TextView) findViewById(R.id.infoCN);
        infoStatus = (TextView) findViewById(R.id.infoStatus);
        infoID = (TextView) findViewById(R.id.infoID);
        infoED = (TextView) findViewById(R.id.infoED);
        infoCB = (TextView) findViewById(R.id.infoCB);
        infoMoc = (TextView) findViewById(R.id.infoMoc);
        infoEL = (TextView) findViewById(R.id.infoEL);
        infoPhone = (TextView) findViewById(R.id.infoPhone);
        infoSMS = (TextView) findViewById(R.id.infoSMS);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        infoName.setText(bundle.getString("userName"));
        infoAddress.setText(bundle.getString("address"));
        infoCN.setText(bundle.getString("cardNumber"));
        infoStatus.setText(bundle.getString("status"));
        infoID.setText(bundle.getString("issueDate"));
        infoED.setText(bundle.getString("expireDate"));
        infoCB.setText(bundle.getString("balance"));
        infoMoc.setText(bundle.getString("methodOfContact"));
        infoEL.setText(bundle.getString("email"));
        infoPhone.setText(bundle.getString("phone"));
        infoSMS.setText(bundle.getString("sms"));
       
        btnLoginOut = (Button) findViewById(R.id.LoginOut);
        btnLoginOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proDialog = new ProgressDialog(CustomerPage.this);
                proDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                proDialog.setMessage("Login out...");
                proDialog.show();
                Intent intent = new Intent();
                intent.setClass(CustomerPage.this, MainPage.class);
                startActivity(intent);
            }
        });

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }

}