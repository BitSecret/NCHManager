package code.repository;

import code.domain.UserIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserIdentityRepository extends JpaRepository<UserIdentity,Integer> {
    public List<UserIdentity> findByAccountAndPassword(String account, String password);
    public List<UserIdentity> findByUserId(Integer userId);
}
