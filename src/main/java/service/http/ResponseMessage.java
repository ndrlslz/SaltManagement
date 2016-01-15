package service.http;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import java.io.Serializable;

@JsonRootName("response")
public class ResponseMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2028833779711038038L;
	@JsonProperty("error_message")
	private String errorMessage;
	private String fullErrorMessage;
	@JsonProperty("status_code")
	private String errorStatusCode;
	@JsonProperty("cause")
	private String rootCause;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setFullErrorMessage(String fullErrorMessage) {
		this.fullErrorMessage = fullErrorMessage;
	}

	public String getFullErrorMessage() {
		return fullErrorMessage;
	}

	public String getErrorStatusCode() {
		return errorStatusCode;
	}

	public void setErrorStatusCode(String errorStatusCode) {
		this.errorStatusCode = errorStatusCode;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	@Override
	public String toString() {
		String toStringM = "";
		if (errorMessage != null) {
			toStringM = "ResponMessage [errorMessage=\"" + errorMessage + "\", fullErrorMessage=" + fullErrorMessage + ", errorStatusCode="
							+ errorStatusCode + ", rootCause=" + rootCause + "]";
		}
		return toStringM;
	}
}
