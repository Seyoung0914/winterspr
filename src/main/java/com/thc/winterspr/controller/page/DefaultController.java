package com.thc.winterspr.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("")
@Controller
public class DefaultController {
    @GetMapping("/index")
    public String index(@RequestParam String name, @RequestParam int age, Model model) {
        System.out.println("name : " + name);
        model.addAttribute("name", name);
        return "index";
    }


    /// /calculate 라는 페이지 만들어서, a와 b 정수값 입력받아서 더한 값을 페이지에서 출력해보기!
    @GetMapping("/calculate")
    public String calculate(@RequestParam int a, @RequestParam int b, Model model) {
        int sum = a + b;
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        System.out.println("sum : " + sum);
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("sum", sum);

        return "calculate";
    }

    //idpw 라는 페이지 만들어서, id와 pw 문자열 값 입력받아서
// id는 winterspr, pw는 abcd1234 인지 확인해서 일치하는지 여부 화면에 띄우기
    @GetMapping("/idpw")
    public String idpw(@RequestParam String id, @RequestParam String pw, Model model) {
        boolean isCorrect = false;
        if (id.equals("winterspr") && pw.equals("abcd1234")) {
            isCorrect = true;
        }
        model.addAttribute("result", isCorrect);
        System.out.println("isCorrect : " + isCorrect);
        return "idpw";
    }
}