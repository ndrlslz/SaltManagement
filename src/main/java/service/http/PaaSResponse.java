package service.http;

import java.io.InputStream;
import java.util.Map;

public interface PaaSResponse {

	public <T> T getEntity(Class<T> returnType);

	public InputStream getInputStream();

	public String header(String name);

	public Map<String, String> headers();
	
	public int getStatus();

}
