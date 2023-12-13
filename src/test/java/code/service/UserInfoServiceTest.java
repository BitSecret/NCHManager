package code.service;

import code.DemoApplication;
import code.domain.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserInfoServiceTest {

    @Autowired
    UserInfoService userInfoService;

    @Test
    void findUserInfoById() {
        Integer testUserId = 1;
        UserInfo userInfo = userInfoService.findUserInfoById(testUserId);
        Assertions.assertEquals(userInfo.getUserId(), testUserId);    //验证是否找到用户
    }

    @Test
    void save() {
        String testName = "testName";
        UserInfo userInfo = userInfoService.findUserInfoById(1);
        userInfo.setUsername(testName);    //改名
        userInfoService.save(userInfo);    //保存

        userInfo = userInfoService.findUserInfoById(1);
        Assertions.assertEquals(userInfo.getUsername(), testName);    //验证是否修改
    }
}