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

        //loginDto에서 id랑 pw 가져오기
        //일단 idList에서 id를 넣고 이 id에 일치하는 인덱스를 가져옴 변수에 넣기
        //idList에 id가 존재하고 해당 인덱스가 pwList 보자 작다면
        //그 인덱스 번호를 pwList에서 가져와 저장해둔다.
        //만약 저장해둔 인덱스와 사용자가 입력한 pw가 일치한다면 로그인 성공

        String id = loginDto.getId();
        String pw = loginDto.getPassword();

        if (id != null && pw != null) {
            int idx = idList.indexOf(id);
            if (idx != -1 && idx < pwList.size()) {
                String savePassword = pwList.get(idx);
                if (savePassword.equals(pw)) {
                    return "로그인 성공";
                }
            }
        }
        return "로그인 실패";
    }

}
