package service.http;

public interface PaaSConnector {
	
	public <T> PaaSResponse request(PaaSRequest<T> request);
	
}
