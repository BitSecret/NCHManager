package code.repository;

import code.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    public List<UserInfo> findByUserId(Integer user_id);
}
