package com.KPenz.chat;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MessageAdapter  extends BaseAdapter{
	private final Context mC;
	private final List<Message> mL;
	native public void calc();
	MessageAdapter(Context c, List<Message> l){
		mC=c;
		mL=l;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mL.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return mL.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View maskedView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Message item = mL.get(position);
		if (maskedView==null){
			maskedView=LayoutInflater.from(mC).inflate(R.layout.message_row, null);
		}
		((TextView)maskedView.findViewById(R.id.message_row_nick)).setText(String.valueOf(item.getSender()));
		((TextView)maskedView.findViewById(R.id.message_row_time)).setText(String.valueOf(item.time));
		((TextView)maskedView.findViewById(R.id.message_row_text)).setText(String.valueOf(item.getText()));
		
		return maskedView;
	}
}
