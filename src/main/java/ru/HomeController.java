package ru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {


    @RequestMapping("/")
    public String homePage() {
        System.out.println("ls");
        return "index";
    }

    @RequestMapping("/sendmail")
    public String sendMail(@RequestParam("message") String mess,
//                           @RequestParam("email") String receiveOfMail,
                           @RequestParam("name") String name,
                           Model model) {
        MailSender mailSender = new MailSender();
        model.addAttribute("personName", name);
        System.out.println(mess);
        mailSender.getJavaMailSender().send(mailSender.messageToMail(mess));
        return "greeting-message";
    }
}
