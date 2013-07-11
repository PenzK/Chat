package com.KPenz.chat;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;

public class RoomsAdapter extends BaseAdapter {
	private final Context mC;
	private final List<Room> mL;
	public RoomsAdapter(Context c, List <Room> l){
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
		
		return  mL.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View maskedView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Room item = mL.get(position);
		if(maskedView==null){
			maskedView=LayoutInflater.from(mC).inflate(R.layout.rooms_row, null);
		}
//		TextView nameView= (TextView)maskedView.findViewById(android.R.id.text1);
//		nameView.setText(item.name);
		if(position%2==1){
			maskedView.setBackgroundColor(0x66999999);
		}
		else{
			maskedView.setBackgroundColor(0x66555555);
		}
		((TextView)maskedView.findViewById(R.id.row_position)).setText(String.valueOf(position+1));
		if(item.getStatus().toString().equals("ok")){
			((ImageView)maskedView.findViewById(R.id.row_status)).setImageResource(R.drawable.okicon);
		}
		if(item.getStatus().toString().equals("inside")){
			((ImageView)maskedView.findViewById(R.id.row_status)).setImageResource(R.drawable.insideicon);
		}
		if(item.getStatus().toString().equals("banned")){
			((ImageView)maskedView.findViewById(R.id.row_status)).setImageResource(R.drawable.bannedicon);
		}
		((TextView)maskedView.findViewById(R.id.row_name)).setText(String.valueOf(item.name));
		((TextView)maskedView.findViewById(R.id.row_online)).setText(String.valueOf("Online: "+item.getPeopleCount()));
		return maskedView;
	}

}
