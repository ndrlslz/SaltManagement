package controller;

import domain.key.Keys;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.key.KeyService;
import service.run.RunService;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/run")
public class RunController {
    private Logger logger = Logger.getLogger(RunController.class.getName());

    @RequestMapping("/main")
    public String run(ModelMap map) {
        map.put("minions", getMinions());
        return "/run/main";
    }

    public List<String> getMinions() {
        Keys keys = getKeyService().getKeys().getList().get(0).getKeysData().getKeys();
        if (keys != null) {
            return keys.getMinions();
        }
        return null;
    }

    @RequestMapping("/runCommand")
    @ResponseBody
    public String runCommand(@RequestParam String minion, @RequestParam String command) {
        return getRunService().commandRun(minion, command);
    }

    public KeyService getKeyService() {
        return new KeyService();
    }

    public RunService getRunService() {
        return new RunService();
    }




}
