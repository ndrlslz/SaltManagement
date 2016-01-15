package domain.auth;


public class Auth {
    private String username;
    private String password;
    private String eauth;

    public Auth(String username, String password, String eauth) {
        this.username = username;
        this.password = password;
        this.eauth = eauth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEauth() {
        return eauth;
    }

    public void setEauth(String eauth) {
        this.eauth = eauth;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", eauth='" + eauth + '\'' +
                '}';
    }
}
