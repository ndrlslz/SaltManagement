package service.http;

public interface PaaSTokenProvider {
	String getToken();
	void expireToken();
}
