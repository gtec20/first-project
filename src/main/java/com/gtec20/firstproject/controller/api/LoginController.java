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
        int idx = getIdIndex(loginDto.getId());
        if(idx == -1) {
            return "로그인에 실패하였습니다. \n존재하지 않는 아이디 입니다.";
        }

        if(!isPwCheck(idx, loginDto.getPw())) {
            return "로그인에 실패하였습니다. \n비밀번호를 잘못 입력하셨습니다.";
        }

        return String.format("로그인에 성공하였습니다. \n %s님 환영합니다!", nameList.get(idx));
    }

    private int getIdIndex(String inputId) {
        for(int i = 0; i < idList.size(); i++) {
            String nowId = idList.get(i);
            if(nowId.equals(inputId)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isPwCheck(int idx, String inputPw) {
        if(pwList.get(idx).equals(inputPw)) {
            return true;
        }
        return false;
    }
}
