package code.service;

import code.domain.UserIdentity;
import code.repository.UserIdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserIdentityService{
    @Autowired
    private UserIdentityRepository userIdentityRepository;    //jpa查询接口

    /**
     * 验证用户名和密码
     * @param account 登录账号
     * @param password 密码
     * @return UserIdentity列表
     */
    public List<UserIdentity> verifyLogin(String account, String password){
        return userIdentityRepository.findByAccountAndPassword(account, password);
    }


    public Integer findStatusByUserId(Integer userId){
        return userIdentityRepository.findByUserId(userId).get(0).getStatus();
    }
}
