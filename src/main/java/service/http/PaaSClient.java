package service.http;


import domain.exception.SaltException;
import org.apache.log4j.Logger;
import service.auth.AuthService;
import utils.JsonHelper;

import java.util.Map;
import java.util.Properties;

public abstract class PaaSClient {
    private static Logger logger = Logger.getLogger(PaaSClient.class);
    protected String managerUrl;
    protected PaaSConnector connector;
    protected Properties properties = new Properties();
    protected static PaaSConnector DEFAULT_CONNECTOR;
    protected ResponseMessage errorAccess;
    protected boolean isAuthenticated = false;
    protected PaaSTokenProvider tokenProvider;

    //private String regionName;

    static {
        DEFAULT_CONNECTOR = new JerseyConnector();
    }

    public PaaSClient() {
        this(false);
    }

    public PaaSClient(boolean isLogin) {
        this.connector = DEFAULT_CONNECTOR;
        if (!isLogin) {
            authenticateAndGetToken();
        } else {
            isAuthenticated = true;
        }
    }


    public <T> PaaSResponse request(PaaSRequest<T> request) {
        PaaSResponseException authException = null;
        request.managerUrl(getManagerURL());

        if (tokenProvider != null) {
            request.header("X-Auth-Token", tokenProvider.getToken());
        }

        logger.debug("OpenStack Request: " + request);
        try {
            return connector.request(request);
        } catch (PaaSResponseException e) {
            if (e.getStatus() != PaaSResponseStatus.NOT_AUTHORIZED || tokenProvider == null) {
                throw e;
            }
            authException = e;
            tokenProvider.expireToken();
        }

        throw authException;
    }


    public <T> T execute(PaaSRequest<T> request) {
        PaaSResponse response = request(request);
        Class<T> returnType = request.returnType();
        return (returnType != null && returnType != Void.class) ? response.getEntity(returnType) : null;
    }

    public void property(String property, String value) {
        properties.put(property, value);
    }


    public <R> R doGet(CharSequence path, Class<R> returnType) {
        if (isAuthenticated) {
            PaaSRequest<R> paaSRequest = new PaaSRequest<R>(this, HttpMethod.GET, path, null, returnType);
            logger.debug("Http method: " + HttpMethod.GET);
            logger.debug("Path: " + path);
            logger.debug("Return Type: " + returnType);
            R execute = paaSRequest.execute();
            logger.debug("Response: " + JsonHelper.toJson(execute));
            return execute;
        } else {
            throw new SaltException(Integer.parseInt(errorAccess.getErrorStatusCode()),
                    errorAccess.getRootCause(), errorAccess.getErrorMessage());
        }

    }

    public <R> R doGet(CharSequence path, Entity<?> entity, Class<R> returnType) {
        if (isAuthenticated) {
            PaaSRequest<R> paaSRequest = new PaaSRequest<R>(this, HttpMethod.GET, path, entity, returnType);
            logger.debug("Http method: " + HttpMethod.GET);
            logger.debug("Path: " + path);
            logger.debug("Entity: " + JsonHelper.toJson(entity));
            logger.debug("Return Type: " + returnType);
            R execute = paaSRequest.execute();
            logger.debug("Response: " + JsonHelper.toJson(execute));
            return execute;
        } else {
            throw new SaltException(Integer.parseInt(errorAccess.getErrorStatusCode()),
                    errorAccess.getRootCause(), errorAccess.getErrorMessage());
        }
    }


    public <R> R doGet(CharSequence path, Class<R> returnType, Map<String, String> queryParam) {
        if (isAuthenticated) {
            PaaSRequest<R> paaSRequest = new PaaSRequest<R>(this, HttpMethod.GET, path, null, returnType);
            for (Map.Entry<String, String> entry : queryParam.entrySet()) {
                paaSRequest.queryParam(entry.getKey(), entry.getValue());
            }
            logger.debug("Http method: " + HttpMethod.GET);
            logger.debug("Path: " + path);
            logger.debug("Return Type: " + returnType);
            logger.debug("Query Param: " + queryParam);
            R execute = paaSRequest.execute();
            logger.debug("Response: " + execute);
            return execute;
        } else {
            throw new SaltException(Integer.parseInt(errorAccess.getErrorStatusCode()),
                    errorAccess.getRootCause(), errorAccess.getErrorMessage());
        }
    }

    public <R> R doPut(CharSequence path, Entity<?> entity, Class<R> returnType, Map<String, String> queryParam) {
        if (isAuthenticated) {
            PaaSRequest<R> paaSRequest = new PaaSRequest<R>(this, HttpMethod.PUT, path, entity, returnType);
            for (Map.Entry<String, String> entry : queryParam.entrySet()) {
                paaSRequest.queryParam(entry.getKey(), entry.getValue());
            }
            logger.debug("Http method: " + HttpMethod.PUT);
            logger.debug("Path: " + path);
            logger.debug("Entity: " + JsonHelper.toJson(entity));
            logger.debug("Return Type: " + returnType);
            R execute = paaSRequest.execute();
            logger.debug("Response: " + execute);
            return execute;
        } else {
            throw new SaltException(Integer.parseInt(errorAccess.getErrorStatusCode()),
                    errorAccess.getRootCause(), errorAccess.getErrorMessage());
        }

    }

    public <R> R doPut(CharSequence path, Entity<?> entity, Class<R> returnType) {
        if (isAuthenticated) {
            PaaSRequest<R> paaSRequest = new PaaSRequest<R>(this, HttpMethod.PUT, path, entity, returnType);
            logger.debug("Http method: " + HttpMethod.PUT);
            logger.debug("Path: " + path);
            logger.debug("Entity: " + JsonHelper.toJson(entity));
            logger.debug("Return Type: " + returnType);
            R execute = paaSRequest.execute();
            logger.debug("Response: " + execute);
            return execute;
        } else {
            throw new SaltException(Integer.parseInt(errorAccess.getErrorStatusCode()),
                    errorAccess.getRootCause(), errorAccess.getErrorMessage());
        }
    }

    public <R> R doPost(CharSequence path, Entity<?> entity, Class<R> returnType) {
        if (isAuthenticated) {
            PaaSRequest<R> paaSRequest = new PaaSRequest<R>(this, HttpMethod.POST, path, entity, returnType);
            logger.debug("Http method: " + HttpMethod.POST);
            logger.debug("Path: " + path);
            logger.debug("Entity: " + JsonHelper.toJson(entity));
            logger.debug("Return Type: " + returnType);
            R execute = paaSRequest.execute();
            logger.debug("Response: " + execute);
            return execute;
        } else {
            throw new SaltException(Integer.parseInt(errorAccess.getErrorStatusCode()),
                    errorAccess.getRootCause(), errorAccess.getErrorMessage());
        }

    }

    public <R> R doDelete(CharSequence path, Class<R> returnType) {
        if (isAuthenticated) {
            PaaSRequest<R> paaSRequest = new PaaSRequest<R>(this, HttpMethod.DELETE, path, null, returnType);
            logger.debug("Http method: " + HttpMethod.DELETE);
            logger.debug("Path: " + path);
            logger.debug("Return Type: " + returnType);
            R execute = paaSRequest.execute();
            logger.debug("Response: " + execute);
            return execute;
        } else {
            throw new SaltException(Integer.parseInt(errorAccess.getErrorStatusCode()),
                    errorAccess.getRootCause(), errorAccess.getErrorMessage());
        }
    }

    public <R> R doDelete(CharSequence path, Class<R> returnType, Map<String, String> queryParam) {
        if (isAuthenticated) {
            PaaSRequest<R> paaSRequest = new PaaSRequest<R>(this, HttpMethod.DELETE, path, null, returnType);
            for (Map.Entry<String, String> entry : queryParam.entrySet()) {
                paaSRequest.queryParam(entry.getKey(), entry.getValue());
            }
            logger.debug("Http method: " + HttpMethod.DELETE);
            logger.debug("Path: " + path);
            logger.debug("Return Type: " + returnType);
            R execute = paaSRequest.execute();
            logger.debug("Response: " + execute);
            return execute;
        } else {
            throw new SaltException(Integer.parseInt(errorAccess.getErrorStatusCode()),
                    errorAccess.getRootCause(), errorAccess.getErrorMessage());
        }
    }


    public <R> R doAuth(CharSequence path, Entity<?> entity, Class<R> returnType) {
        PaaSRequest<R> paaSRequest = new PaaSRequest<R>(this, HttpMethod.POST, path, entity, returnType);
        logger.debug("Http method: " + HttpMethod.POST);
        logger.debug("Path: " + path);
        logger.debug("Entity: " + JsonHelper.toJson(entity));
        logger.debug("Return Type: " + returnType);
        R execute = paaSRequest.execute();
        logger.debug("Response: " + execute);
        return execute;
    }

    public void setTokenProvider(PaaSTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    public void token(String token) {
        setTokenProvider(new PaaSSimpleTokenProvider(token));
    }

    // override by subclass if needed
    protected void authenticateAndGetToken() {
        AuthService authService = new AuthService(this);
        String token = authService.getToken();
        if (token != null) {
            token(token);
            isAuthenticated = true;
            if (logger.isDebugEnabled()) {
                logger.debug("account auth success");
            }
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("account auth fail");
            }
        }
    }

    protected abstract String getManagerURL();

    @Override
    public String toString() {
        return "PaaSClient{" +
                "managerUrl='" + managerUrl + '\'' +
                ", connector=" + connector +
                ", properties=" + properties +
                ", errorAccess=" + errorAccess +
                ", isAuthenticated=" + isAuthenticated +
                ", tokenProvider=" + tokenProvider +
                '}';
    }
}
