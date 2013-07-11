package com.KPenz.chat;



import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.KPenz.chat.Api.ApiException;


public class AuthActivity extends BaseActivity {
	
//	ServiceConnection mSrvCon = new ServiceConnection(){
//		
//	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auth);
		findViewById(R.id.login).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				buttonlog();
			}
		});
		findViewById(R.id.Registration).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				buttonReg(v);
			}
		});
//		AuthActivity.connect("http://www.ex.ua/search?s=hello_world");
//		String json = connect("http://10.2.1.43:6606/auth?email=test@test.ua&pass=1234");
//		try{
//		Parser  p =new Parser();
//		AuthInfo auth=p.Auth(json);
//		Toast.makeText(this, "Token: "+auth.mNick+"Nick: "+auth.mToken, Toast.LENGTH_LONG).show();
//		}
//		catch(Exception e){
//			Toast.makeText(this, "Error: "+e.getMessage(), Toast.LENGTH_LONG).show();
//		}
		
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}
	public void buttonReg(View v)
	{
		switch (v.getId()) 
		{
		    case R.id.Registration:
		        Intent intent = new Intent(this, RegActivity.class);
		        startActivity(intent);
		        break;
	    }
	}
	public void buttonlog(){
		EditText email = (EditText) findViewById(R.id.email);
		EditText pass = (EditText) findViewById(R.id.password);
		try{
			mCore.getApi().auth(email.getText().toString(), pass.getText().toString());
			Toast.makeText(AuthActivity.this, "Welcome!!!", Toast.LENGTH_LONG).show();
			Intent i = new Intent(this,RoomsActivity.class);
			startActivity(i);
			finish();
		}
		catch(ApiException e){
			Toast.makeText(AuthActivity.this, "D'OH!!!", Toast.LENGTH_LONG).show();
		}
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		
		switch (item.getItemId()){
		case R.id.about:
			 
				
				toastAbout().show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public Toast toastAbout(){
		Toast toast = Toast.makeText(AuthActivity.this, 
				  "Created by Homer Simpson\n" +
				  "Date of creation:\n" +
				  "07/07/2013\n" +
				  "Dnipropetrovsk city\n" +
				  "    D'OH!!!!", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView lol = new ImageView(getApplicationContext());
		lol.setImageResource(R.drawable.hsimpson);
		toastView.addView(lol, 0);
		return toast;
	}

	@Override
	protected void onConnectedToService() {
		// TODO Auto-generated method stub
		
	}
	
}
