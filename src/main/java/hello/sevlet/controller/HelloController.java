package hello.sevlet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!!");
        return "hello"; // resources에 있는 hello.html로 이동, 위에 쓰여있는 model에 저장된 값을 가지고
                        // = model에 있는 값을 가지고 hello.html로 이동해서 렌더링해라(값을 가지고 hello.html을 화면에 실행시켜라)
        // 컨트롤러(현재페이지)에서
    }
}
