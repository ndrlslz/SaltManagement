package service.key;

import domain.key.KeyBody;
import domain.key.KeysReturn;
import service.http.Entity;
import service.http.HttpClient;

public class KeyService {
    private HttpClient httpClient;

    public KeyService() {
        httpClient = new HttpClient();
    }

    public KeysReturn getKeys() {
        KeyBody keyBody = new KeyBody("key.list_all");
        return httpClient.doGet("/", Entity.json(keyBody), KeysReturn.class);
    }

    public KeysReturn acceptKey(String minionId) {
        KeyBody keyBody = new KeyBody("key.accept", minionId);
        return httpClient.doGet("/", Entity.json(keyBody), KeysReturn.class);
    }
}
