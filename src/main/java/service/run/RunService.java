package service.run;

import domain.run.RunBody;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import service.http.Entity;
import service.http.HttpClient;

@Service
@Scope("prototype")
public class RunService {
    private HttpClient httpClient;

    public RunService() {
        httpClient = new HttpClient();
    }

    public String commandRun(String minion, String command) {
        RunBody runBody = new RunBody(minion, command);
        String response =  httpClient.doPost("/", Entity.yaml(runBody), String.class);
        return afterRun(response, minion);
    }

    public String afterRun(String response, String minion) {
        if (!"*".equals(minion) && !response.contains(minion)) {
            return "can not ping this minion: " + minion;
        }
        return response.replaceAll("\'", "\r\n    ");
    }

    //TODO use filter chain to disable some command like 'vim',
    //
    public void preRun(String command) {

    }
}
