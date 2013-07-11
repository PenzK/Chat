package com.KPenz.chat;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.KPenz.chat.Room.Status;


public class Parser {
	public static AuthInfo Auth(String jsonString) throws ParserException {
		try {
			JSONObject json = new JSONObject(jsonString);
			if(json.getString("status").equals("ok")){
				return new AuthInfo(json.getString("token"),json.getString("nick"));
			}
			else{
				throw new IllegalArgumentException("D'OH!!! Wrong Email or Password.");
			}
		} catch (JSONException e) {
			throw new IllegalArgumentException(e);
		}
		
	}
	static class  ParserException extends Exception{
		public final int errCode;
		ParserException(int errCode){
			this.errCode=errCode;
		}
		ParserException(String message){
			super(message);
			errCode=-1;
		}
		ParserException(Throwable t){
			super(t);
			errCode=-1;
		}
	}
	public static void getRooms(String jsonString,List<Room> list) throws ParserException{
		try {
			JSONObject json = new JSONObject(jsonString);
			JSONArray arr=json.getJSONArray("rooms");
			if(json.getString("status").equals("ok")){
				for(int i = 0;i<arr.length();i++){
					JSONObject j = (JSONObject)arr.get(i);
					list.add(new Room(j.getString("name")).setPeopleCount(j.getInt("people_count")).setStatus(Status.valueOf(j.getString("status"))));
				
				}
			}
			else{
				throw new IllegalArgumentException("D'OH!!! Wrong Email or Password.");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException(e);
		}
	}
	
}
