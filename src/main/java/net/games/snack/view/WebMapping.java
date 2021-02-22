package net.games.snack.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebMapping {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register.html")
    public String register() {
        return "register";
    }
}
