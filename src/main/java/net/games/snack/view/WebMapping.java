package net.games.snack.view;

import net.games.snack.service.mail.EmailRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebMapping {
    @Autowired
    private EmailRegistrationService registrationService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register.html")
    public String register() {
        return "register";
    }

    @PostMapping("submit_register.html")
    public String processRegister(@RequestParam("inputEmail") String email) {
        registrationService.sendRegistrationEmail(email);
        return "gameSelector";
    }
}
