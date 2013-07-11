package com.KPenz.chat;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;

abstract public class BaseActivity extends Activity {
	
	ProgressDialog pd;
	Handler h;
	private ServiceConnection mSrvConn;
	protected ChatService mCore;
	protected void onCreate (Bundle b){
		super.onCreate(b);
		setContentView(R.layout.activity_base);
		Intent intent = new Intent();
		intent.setClass(this,ChatService.class);
		startService(intent);
		mSrvConn= new ServiceConnection() {
			
			@Override
			public void onServiceDisconnected(ComponentName name) {
				// TODO Auto-generated method stub
				finish();
			}
			
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				// TODO Auto-generated method stub
				mCore=((ChatService.SelfBinder)service).srv;
				onConnectedToService();
				
			}
		};
		bindService(intent, mSrvConn, Service.BIND_AUTO_CREATE);
	}
	abstract protected void onConnectedToService();
	public void onDestroy(){
		unbindService(mSrvConn);
		super.onDestroy();
	}
//	public void onCLick(View v){
//		switch(v.getId()){
//		case R.id.base_spinner_button:
//			pd= new ProgressDialog(this);
//			pd.setTitle("Di@log!?");
//			pd.setMessage("Let's spin, bro !!!");
//			pd.setButton(Dialog.BUTTON_POSITIVE, "O.K.", new OnClickListener() {
//				
//				@Override
//				public void onClick(DialogInterface dialog, int which) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//			pd.show();
//			break;
//		case  R.id.base_progrbar_button:
//			pd=new ProgressDialog(this);
//			pd.setTitle("Di@log!?");
//			pd.setMessage("Let's progress, bro !!!");
//			pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//			pd.setMax(2148);
//			pd.setIndeterminate(true);
//			pd.show();
//			h= new Handler(){
//				
//				public void handleMessage(android.os.Message msg){
////					super.hand
//					pd.setIndeterminate(false);
//					if(pd.getProgress()<pd.getMax()){
//						pd.incrementProgressBy(50);
//						pd.incrementSecondaryProgressBy(75);
//						h.sendEmptyMessageDelayed(0, 100);	
//					}
//					else {
//						pd.dismiss();
//					}
//				}
//			};
//			h.sendEmptyMessageDelayed(0, 2000);
//			break;
//		default:
//			break;
//		}
//	}
}
