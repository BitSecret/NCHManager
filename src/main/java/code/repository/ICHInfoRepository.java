package code.repository;

import code.domain.ICHInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import java.util.List;

public interface ICHInfoRepository extends JpaRepository<ICHInfo,Integer> {
    public List<ICHInfo> findAll();
    public List<ICHInfo> deleteByIchId(Integer ichId);
    public List<ICHInfo> findByIchId(Integer ichId);
}
