package code.service;

import code.domain.UserInfo;
import code.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;    //jpa查询接口

    /**
     * 返回用户资料
     * @param user_id 用户ID
     * @return UserInfo列表
     */
    public UserInfo findUserInfoById(Integer user_id){
        List<UserInfo> userInfo = userInfoRepository.findByUserId(user_id);
        if (userInfo.size() > 0){
            return userInfo.get(0);
        }
        return null;
    }


    public void save(UserInfo userInfo){
        userInfoRepository.saveAndFlush(userInfo);
    }
}
