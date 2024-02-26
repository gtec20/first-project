package com.gtec20.firstproject.controller.api;

import com.gtec20.firstproject.application.dto.login.LoginDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    List<String> nameList = List.of("최승우", "채승주", "유정하");
    List<String> idList = List.of("seungwoo", "seungjoo", "jeongha");
    List<String> pwList = List.of("123", "456", "789");

    @GetMapping("")
    public String isLogin(@ModelAttribute("loginDto") LoginDto loginDto) {
        String sAnswer= idCheck(loginDto.getId(), loginDto.getPw());
        return sAnswer;
    }

    private String idCheck(String loginId, String loginPw) {
        String sId = loginId;
        String sPw = loginPw;
        for (int i = 0; i < idList.size(); i++) {
            if(idList.get(i).equals(sId)) {
                if(pwList.get(i).equals(sPw)) {
                    return "환영합니다 " + nameList.get(i) + "님";
                }else {
                    return "비밀번호가 일치하지 않습니다";
                }
            }
        }
        return "존재하지 않는 아이디 입니다";
    }


}
