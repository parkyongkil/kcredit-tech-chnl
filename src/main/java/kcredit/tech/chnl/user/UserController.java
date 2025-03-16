package kcredit.tech.chnl.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;

    @PostMapping("user/insertOrUpdate")
    public String insert(Model model, @ModelAttribute("user") User user) {
        userMapper.insertOrUpdate(user);
        model.addAttribute("user", user);
        return "user/userInfo";
    }
}
