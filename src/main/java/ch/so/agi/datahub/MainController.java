package ch.so.agi.datahub;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping() {
        return "ping";
    }
    
//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    
    
    @GetMapping
    public String getIndexPage(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
                model.addAttribute("secretMessage", "Admin message is s3crEt");
            } else {
                model.addAttribute("secretMessage", "Lorem ipsum dolor sit amet");
            }
        }

        model.addAttribute("message", "AWS Cognito with Spring Security");

        return "index";
    }
}