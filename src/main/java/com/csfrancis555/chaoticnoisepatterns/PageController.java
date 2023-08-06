
package com.csfrancis555.chaoticnoisepatterns;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("message", "hello noisy world");
        return "chaos";
    }//end home()
    
}
