package com.KPenz.chat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegActivity extends Activity {
	String sex;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_reg);
	    // TODO Auto-generated method stub
	}
	public void onSubmitClick(View v ){
		EditText email = (EditText)findViewById(R.id.regEmail);
		EditText nickname = (EditText)findViewById(R.id.regNick);
		EditText age = (EditText)findViewById(R.id.regAge);
		EditText pass1 = (EditText)findViewById(R.id.regPass1);
		EditText pass2 = (EditText)findViewById(R.id.regPass2);
		
		RadioGroup rgp = (RadioGroup)findViewById(R.id.regRGroup);
		int rbchecked = rgp.getCheckedRadioButtonId();
		rgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int rbchecked) {
				// TODO Auto-generated method stub
				switch(rbchecked){
				case R.id.regRb1:
					sex="Male";
					break;
				case R.id.regRb2:
					sex="Female";
					break;
				}
				
			}
		});
		if (email.getText().toString().length()==0||nickname.getText().toString().length()==0||
			age.getText().toString().length()==0||pass1.getText().toString().length()==0||pass2.getText().toString().length()==0){
			Toast.makeText(this, "Fill all lines!!!", Toast.LENGTH_SHORT).show();
		}
		else{
		if(!pass1.getText().toString().equals(pass2.getText().toString())){
			Toast.makeText(this,"Passwords must be equal!!!", Toast.LENGTH_SHORT).show();
		}
		else{
			Person p = new Person(email.toString(),nickname.toString(),Integer.parseInt(age.toString()),sex.toString(),pass1.toString());
		}
			
		}
	}

}
