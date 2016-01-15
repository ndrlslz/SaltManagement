package service.auth;

import domain.auth.Auth;
import domain.auth.AuthReturn;
import service.http.Entity;
import service.http.PaaSClient;
import utils.AccountConfig;

public class AuthService {
    private PaaSClient httpClient;

    public AuthService(PaaSClient httpClient) {
        this.httpClient = httpClient;
    }

    public String getToken() {
        Auth auth = new Auth(AccountConfig.getUsername(), AccountConfig.getPassword(), "pam");
        AuthReturn authReturn = httpClient.doAuth("/login", Entity.json(auth), AuthReturn.class);
        if (authReturn != null) {
            return authReturn.getList().get(0).getToken();
        }
        return null;
    }
}
