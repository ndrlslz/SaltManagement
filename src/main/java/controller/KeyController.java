package controller;

import domain.key.Keys;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.key.KeyService;

import java.util.logging.Logger;

@Controller
@RequestMapping("/key")
public class KeyController {
    private Logger logger = Logger.getLogger(KeyController.class.getName());

    @RequestMapping("/list")
    public String listKeys(ModelMap map) {
        Keys keys = getKeyService().getKeys().getList().get(0).getKeysData().getKeys();
        if (!StringUtils.isEmpty(keys)) {
            map.put("keys", keys);
            map.put("minionsCount", keys.getMinions().size());
            map.put("minionsPreCount", keys.getMinionsPre().size());
            map.put("minionsDeniedCount", keys.getMinionsDenied().size());
            map.put("minionsRejectedCount", keys.getMinionsRejected().size());
        }
        return "/key/list";
    }

    @RequestMapping("/accept")
    public ModelAndView acceptKey(@RequestParam String minionId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/key/list.do");
        Keys keys = getKeyService().acceptKey(minionId).getList().get(0).getKeysData().getKeys();
        if (keys == null) {
            modelAndView.addObject("accept", false);
        }

        return modelAndView;
    }

    public KeyService getKeyService() {
        return new KeyService();
    }
}
