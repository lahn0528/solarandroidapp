package com.caltech.edu.dalehouseapp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.widget.TextView;

class RequestTask extends AsyncTask<String, String, String>{

	String responseString = "what";
	EnergyActivity target = null;
    public RequestTask(EnergyActivity energyActivity) {
    	target = energyActivity;
	}

	@Override
    protected String doInBackground(String... uri) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response;
        try {
            response = httpclient.execute(new HttpGet(uri[0]));
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                responseString = out.toString();
            } else{
                //Closes the connection.
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (ClientProtocolException e) {
            //TODO Handle problems..
        } catch (IOException e) {
            //TODO Handle problems..
        }
        return responseString;
    }
    
    public String getstr() {
    	return responseString;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        
        TextView textview = new TextView(target);
        textview.setText(responseString);
        target.setContentView(textview);
        //Do anything with response..
    }
}