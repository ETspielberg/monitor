package ub.unidue.monitor.connector;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.json.JSONException;
import org.json.JSONObject;

public class Connection {
	
	public static int register(String process, String identifier,String status, String message) throws JSONException, HttpException, IOException {
		JSONObject json = new JSONObject();
		json.put("process", process)
			.put("identifier", identifier)
			.put("status",status)
			.put("message", message);
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("https://localhost:11883/process");
		RequestEntity entity = new StringRequestEntity(process.toString(),"application/json",null);
		post.setRequestEntity(entity);
		int response = client.executeMethod(post);
		return response;
	}
	
	public static int replace(int id, String process, String identifier,String status, String message) throws JSONException, HttpException, IOException {
		JSONObject json = new JSONObject();
		json.put("process", process)
			.put("identifier", identifier)
			.put("status",status)
			.put("message", message)
			.put("lastTouch", String.valueOf(System.currentTimeMillis()));
		HttpClient client = new HttpClient();
		PutMethod put = new PutMethod("https://localhost:11883/process" + String.valueOf(id));
		RequestEntity entity = new StringRequestEntity(process.toString(),"application/json",null);
		put.setRequestEntity(entity);
		int response = client.executeMethod(put);
		return response;
	}
	
	/*
	public static int update(int id, String field,String newValue) throws JSONException, HttpException, IOException {
		HttpClient client = new HttpClient();
		HttpPatch patch = new HttpPatch("https://localhost:11883/process/" + String.valueOf(id));
		String json = "{" + field + " : " + newValue + "}";
		RequestEntity entity = new StringRequestEntity(json,"application/json",null);
		patch.setRequestEntity(entity);
		int response = client.executeMethod(patch);
		return response;
	}
	*/

}
