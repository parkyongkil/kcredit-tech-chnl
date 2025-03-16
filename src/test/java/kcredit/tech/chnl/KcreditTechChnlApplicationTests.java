package kcredit.tech.chnl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import kcredit.tech.chnl.user.SearchUser;
import kcredit.tech.chnl.user.User;
import kcredit.tech.chnl.user.UserGrade;
import kcredit.tech.chnl.user.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class KcreditTechChnlApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void insert() {
        User user = new User().setGrade(UserGrade.A).setName("예쁜희");
        userMapper.insert(user);
        System.out.println("user = " + user);
    }

    @Test
    void selectPage() {
        Page<User> page = new Page<>(3, 3);
        LambdaQueryWrapper<User> qw = Wrappers.<User>lambdaQuery().ge(User::getNo, 1).like(User::getName, "").orderByAsc(User::getNo);
        userMapper.selectPage(page, qw);
        page.getRecords().forEach(System.out::println);
        System.out.println("page = " + page);
        System.out.println("page.pages = " + page.getPages());
    }

    @Test
    void selectUserPage() {
        Page<User> page = new Page<>(1, 10);
        page.setSearchCount(true);
        SearchUser searchUser = new SearchUser().setEndDate(new Date());
        int i = 0;
        while (true) {
            page = userMapper.selectUserPage(page, searchUser);
            page.getRecords().forEach(System.out::println);
            System.out.println("page = " + page.getCurrent() + " / " + page.getPages());
            if (page.getCurrent() > page.getPages()) break;
            page.setCurrent(page.getCurrent() + 1);
        }
    }
}
