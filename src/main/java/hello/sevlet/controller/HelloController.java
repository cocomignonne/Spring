package hello.sevlet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","Spring!!"); // 키값, 벨류값
                        // resources에 있는 hello.html로 이동, 위에 쓰여있는 model에 저장된 값을 가지고
                        // = model에 있는 값을 가지고 hello.html로 이동해서 렌더링해라(값을 가지고 hello.html을 화면에 실행시켜라)
        return "hello";
        // 컨트롤러(현재페이지)에서 리턴값으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리를 해준다.
        // resources:templates/ +{ViewName}+ .html 파일이 화면에 열린다.
    }

    @GetMapping("hello-mvc")  // 외부에서 값을 받아올 때 requestParam 사용
    public String helloMVC(@RequestParam(value = "name", required = true) String name, Model model) { //
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody  // http에 헤더부 바디부가 있는데  바디부에 데이터를 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

//      진짜는 여기부터
//      API방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;  // 문자열이 아닌 객체를 리턴한다
        // 브라우저에서 확인해보면 key value방식으로 JSON형식이다
    }
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
