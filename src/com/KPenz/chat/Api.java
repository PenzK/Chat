package com.KPenz.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.KPenz.chat.Parser.ParserException;

import android.util.Log;

public class Api {
	private static final String BASE_URL="http://188.0.150.89:6606";
	private AuthInfo mAuthInfo;
	private boolean isAuth=false;
	public void reg(Person p){
    	connect(BASE_URL+"/reg?email="+p.mEmail+"&pass="+p.mPass+"&sex="+p.mSex+"&age="+p.mAge+"&nick="+p.mNickname);
    	
	}
    public void auth(String email, String pass) throws ApiException{
    	if(isAuth==false){
    		isAuth=true;
    		
    		 try {
    			 String resp = connect(BASE_URL+"/auth?email="+email+"&pass="+pass);
    			 mAuthInfo = Parser.Auth(resp);
    		 }
    		 catch(Exception e){
    			
    			throw new ApiException(e); 
    			
    		 }
    		 
    	}
    	else{
    		throw new ApiException("Already logged in!");
    	}
    }
	public static String connect(String url)
	{

	    HttpClient httpclient = new DefaultHttpClient();

	    // Prepare a request object
	    HttpGet httpget = new HttpGet(url); 

	    // Execute the request
	    HttpResponse response;
	    try {
	        response = httpclient.execute(httpget);
	        // Examine the response status
	        Log.i("Praeda",response.getStatusLine().toString());

	        // Get hold of the response entity
	        HttpEntity entity = response.getEntity();
	        // If the response does not enclose an entity, there is no need
	        // to worry about connection release

	        if (entity != null) {

	            // A Simple JSON Response Read
	            InputStream instream = entity.getContent();
	            String result= convertStreamToString(instream);
	            // now you have the string representation of the HTML request
	            instream.close();
	            return result;
	        }
	        throw new RuntimeException();

	    } catch (Exception e) {
	    	throw new RuntimeException();
	    }
	}

	    private static String convertStreamToString(InputStream is) {
	    /*
	     * To convert the InputStream to String we use the BufferedReader.readLine()
	     * method. We iterate until the BufferedReader return null which means
	     * there's no more data to read. Each line will appended to a StringBuilder
	     * and returned as String.
	     */
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();

	    String line = null;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return sb.toString();
	}
	    
	    class ApiException extends Exception{
	    	ApiException(Throwable t){
	    		super (t);
	    	}
	    	ApiException(String t){
	    		super (t);
	    	}
	    }
	    
	    public List<Room> getRooms() throws ParserException{
	    	List<Room> list = new ArrayList<Room>();
	    	String jsonResp=connect(BASE_URL+"/rooms?"+mAuthInfo.mToken);
	    	Parser.getRooms(jsonResp, list);
	    	return list;
	    }
}
