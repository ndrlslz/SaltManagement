package service.http;

import utils.AccountConfig;

public class HttpClient extends PaaSClient {
    public HttpClient() {
        super();
    }

    public HttpClient(boolean isLogin) {
        super(isLogin);
    }

    @Override
    protected String getManagerURL() {
        return AccountConfig.getMaster();
    }
}
