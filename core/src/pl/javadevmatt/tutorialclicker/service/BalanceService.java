package pl.javadevmatt.tutorialclicker.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.HttpMethods;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.net.HttpRequestBuilder;

import pl.javadevmatt.tutorialclicker.IRequestCallback;

public class BalanceService {
	
	public static final String REQUEST_URL = "http://javadevmatt.pythonanywhere.com/tutorialclicker/api/v1.0/balance";
	public static final String BALANCE_MONEY_CLICK = "BALANCE_MONEY_CLICK";
	
	private int moneyClickValue;
	
	public void makeBalanceServiceRequest(final IRequestCallback requestCallback){
		HttpRequestBuilder requestBuilder = new HttpRequestBuilder();
		HttpRequest httpRequest = requestBuilder.newRequest().method(HttpMethods.GET).url(REQUEST_URL).build();
		
		Gdx.net.sendHttpRequest(httpRequest, new HttpResponseListener() {
			
			@Override
			public void handleHttpResponse(HttpResponse httpResponse) {
				parseResponse(httpResponse.getResultAsString());
				requestCallback.onSucceed();
			}
			
			@Override
			public void failed(Throwable t) {
				System.out.println(t.getMessage());
				requestCallback.onError();
			}
			
			@Override
			public void cancelled() {
				requestCallback.onError();
			}
		});
	}
	
	private void parseResponse(String resultAsString) {
		try{
			JSONObject obj = new JSONObject(resultAsString);
			JSONArray jsonArray = obj.getJSONArray("balance");
			for(int i = 0; i < jsonArray.length(); i++){
				JSONObject innerObj = jsonArray.getJSONObject(i);
				if(innerObj.get("name").equals(BALANCE_MONEY_CLICK)){
					moneyClickValue = (Integer) innerObj.get("value");
					System.out.println("MoneyClickValue: " + moneyClickValue);
				}
			}
		} catch(JSONException e){
			e.printStackTrace();
		}
	}

	public int getMoneyClickValue() {
		return moneyClickValue;
	}

}
