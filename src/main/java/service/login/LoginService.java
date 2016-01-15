package service.login;

import domain.auth.Auth;
import domain.auth.AuthReturn;
import org.springframework.stereotype.Service;
import service.http.Entity;
import service.http.HttpClient;

@Service
public class LoginService {
    private HttpClient httpClient;

    public LoginService() {
        httpClient = new HttpClient(true);
    }

    public boolean auth(String username, String password) {
        Auth auth = new Auth(username, password, "pam");
        AuthReturn authReturn = httpClient.doPost("/login", Entity.json(auth), AuthReturn.class);
        return authReturn != null;
    }

}
