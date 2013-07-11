package com.KPenz.chat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

import com.KPenz.chat.Parser.ParserException;

public class RoomsActivity extends BaseActivity {
	private RoomsAdapter mAdapter;
	private ListView listview;
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_rooms);
	    
	    listview=(ListView)findViewById(R.id.list);
	    
	    
	   
	    listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View v, int position,
					long itemId) {
				// TODO Auto-generated method stub
				//Toast.makeText(rooms_activity.this, items[position], Toast.LENGTH_SHORT).show();
			}
		});
	    listview.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View v,
					int position, long itemId) {
			//	Toast.makeText(rooms_activity.this, items[position]+"LONGPRESSS", Toast.LENGTH_SHORT).show();
				return true;
			}
		});
	}
	@Override
	protected void onConnectedToService() {
		 try {
				mAdapter = new RoomsAdapter(this,mCore.getApi().getRooms());
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    listview.setAdapter(mAdapter);
	}
//	public boolean onCreateOptionsMenu(Menu menu){
//		getMenuInflater().inflate(R.menu.rooms_menu, menu);
//		return super.onCreateOptionsMenu(menu);
//	}
//	
//	public boolean onOptionsItemSelected(MenuItem item ){
//		switch(item.getItemId()){
//		case R.id.menu_rooms_add:
//			showDialog(1);
//			return true;
//		default:	
//			return super.onOptionsItemSelected(item);
//		}
//	}
//	public Dialog onCreateDialog(int id){
//		if(1==id){
//			return newAddRoomDialog();
//		}
//		return super.onCreateDialog(id);
//	}
//	private Dialog newAddRoomDialog(){
//		AlertDialog.Builder builder;
//		
//		builder = new AlertDialog.Builder(this);
//		builder.setTitle("Adding new room");
//		final View view = LayoutInflater.from(this).inflate(R.layout.dialog_room_add, null);
//		builder.setView(view);
//		builder.setPositiveButton("Submit", new OnClickListener() {
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				// TODO auto-generated method stub
//				String name= ((EditText)view.findViewById(R.id.dialog_rooms_add_name)).getText().toString();
//				if (name==null || name.trim().length()==0){
//					//ошибка о вводе имени
//					Toast.makeText(RoomsActivity.this, "Please enter room name",Toast.LENGTH_SHORT).show();
//				}
//				else{
//					String desc= ((EditText)view.findViewById(R.id.dialog_rooms_add_description)).getText().toString();
//					if (desc==null || desc.trim().length()==0){
//						Toast.makeText(RoomsActivity.this, "Please enter room desciption", Toast.LENGTH_SHORT);
//					}
//					else {
//						Room r = new Room(name);
//						r.setPeopleCount(1).setStatus(Status.inside);
//						sRooms.add(r);
//						mAdapter.notifyDataSetChanged();
//					}
//				}
//			}
//		});
//		builder.setNegativeButton("Cancel", null);
//		return builder.create();
//	}


}
