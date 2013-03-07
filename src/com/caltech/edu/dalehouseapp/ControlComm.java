package com.caltech.edu.dalehouseapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import android.os.AsyncTask;
import android.util.Log;

public class ControlComm extends AsyncTask<Void, Void, Void>{

	public static int serverport = 7000; 
	public static String serverip = "someip";
	Socket s; 
	public DataInputStream dis; 
	public DataOutputStream dos; 
	public String message; 
	
	@Override
	protected Void doInBackground(Void... arg0) {
		try{
			s = new Socket(serverip, serverport);
			
		}catch (Exception e){
			Log.i("Connection", "Cannot make socket");
		}
		
		if (s.isConnected()){
			try {
				dis = (DataInputStream) s.getInputStream(); 
				dos = (DataOutputStream) s.getOutputStream(); 
				Log.i("Connection", "Streams created");
				
			}
			catch (IOException e){
				Log.i("Connection", "Cannot get streams");
			}
		}
		
		return null;
	}
	
	public void writeToStream(String sendMessage){
		try {
			if (s.isConnected()){
				dos.writeChars(sendMessage);  
			}
		}
		catch (Exception e){
			Log.i("Connected", "writeToStream failed"); 
		}
	}
	
	public byte[] readFromStream(){
		byte[] buffer = null; 
		try {
			if (s.isConnected()){
				dis.read(buffer);
			}
		} catch (Exception e){
			
		}
		return buffer; 
	}

}
