package berger.projectlist.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class HelloController {
    
    @GetMapping("/version")
    public String showVersion() {
        return "This is beta version";
    }
}
