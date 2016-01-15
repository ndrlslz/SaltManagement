package service.http;

public class PaaSSimpleTokenProvider implements PaaSTokenProvider {
	String token;

	public PaaSSimpleTokenProvider(String token){
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public void expireToken() {
		
	}
	
}
