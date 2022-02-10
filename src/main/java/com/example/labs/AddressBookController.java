package com.example.labs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookController{
    @GetMapping("/buddyForm")
    public String buddyForm(Model model){
        model.addAttribute("buddy", new BuddyInfo());
        return "buddyForm";
    }

    @PostMapping("/buddyForm")
    public String buddySubmit(@ModelAttribute BuddyInfo buddy, Model model) {
        model.addAttribute("buddy", buddy);
        return "buddyAddResult";
    }


//    @GetMapping("/main")
//    public String home(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
//    @GetMapping("/fetch")
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }
}
