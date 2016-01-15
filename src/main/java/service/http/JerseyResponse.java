package service.http;


import com.sun.jersey.api.client.ClientResponse;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class JerseyResponse implements PaaSResponse {

	private ClientResponse response;

	public JerseyResponse(ClientResponse response) {
		this.response = response;
	}

	@Override
	public <T> T getEntity(Class<T> returnType) {
		if (response.hasEntity() && returnType != null && Void.class != returnType) {
			return ResponseBuilder.fromJson(returnType, response.getEntity(String.class));
		} else {
			return null;
		}
		
	}

	@Override
	public InputStream getInputStream() {
		if (response.hasEntity()) {
			return response.getEntityInputStream();
		} else {
			return null;
		}
	}

	@Override
	public String header(String name) {
		return response.getHeaders().getFirst(name);
	}

	@Override
	public Map<String, String> headers() {
		Map<String, String> headers = new HashMap<String, String>();
		for (String k : response.getHeaders().keySet()) {
			headers.put(k, response.getHeaders().getFirst(k));
		}
		return headers;
	}

	@Override
	public int getStatus() {
		return response.getStatus();
	}
	
	
}
