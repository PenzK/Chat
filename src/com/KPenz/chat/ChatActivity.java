package com.KPenz.chat;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ChatActivity extends Activity{
	private MessageAdapter mAdapter;
	private EditText mSendEditText;
	public final static List<Message> sMessages = new ArrayList<Message>();
	static{
		sMessages.add(new Message("LOL","You","BLA BLA BLA"));
		sMessages.add(new Message("MuMu","You","WoooHoooo"));
		sMessages.add(new Message("Dart_Weider","You","U'll die !!!Ha...ha...ha..."));
	}
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_chat);
	    mSendEditText= (EditText)findViewById(R.id.chat_write_text);
	    mAdapter = new MessageAdapter(this,sMessages);
	    ListView listview=(ListView)findViewById(R.id.chat_list);
	    listview.setAdapter(mAdapter);
	    Button buttonSend = (Button)findViewById(R.id.chat_send_button);
	    buttonSend.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			String sendText = mSendEditText.getText().toString();
				if(sendText==null || sendText.trim().length()==0){
					Toast.makeText(ChatActivity.this, "Enter text!", Toast.LENGTH_SHORT).show();
				}
				else{
					Message m = new Message("DartWeider","You",sendText);
					sMessages.add(m);
					mAdapter.notifyDataSetChanged();
					mSendEditText.setText(new String());
					
				}
			}
		});
	}
	
	
}
