package pl.javadevmatt.tutorialclicker.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.HttpMethods;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.net.HttpRequestBuilder;

import pl.javadevmatt.tutorialclicker.IRequestCallback;

public class FeatureFlagService {
	
	public static final String REQUEST_URL = "http://javadevmatt.pythonanywhere.com/tutorialclicker/api/v1.0/features";
	public static final String FEATURE_SHOP = "FEATURE_SHOP";
	
	private boolean shop = false;

	public void makeFeatureFlagsRequest(final IRequestCallback requestCallback){
		HttpRequestBuilder requestBuilder = new HttpRequestBuilder();
		HttpRequest httpRequest = requestBuilder.newRequest().method(HttpMethods.GET).url(REQUEST_URL).build();
		Gdx.net.sendHttpRequest(httpRequest, new HttpResponseListener() {
			
			@Override
			public void handleHttpResponse(HttpResponse httpResponse) {
				System.out.println("Result:");
				System.out.println(httpResponse.getResultAsString());
				System.out.println("----------------------");
				
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
	
	public boolean hasShop() {
		return shop;
	}

	public void setShop(boolean shop) {
		this.shop = shop;
	}
	
}