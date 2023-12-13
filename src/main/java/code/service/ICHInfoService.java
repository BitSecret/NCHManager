package code.service;

import code.domain.ICHInfo;
import code.repository.ICHInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ICHInfoService {
    @Autowired
    private ICHInfoRepository ichInfoRepository;    //jpa查询接口


    /**
     * 返回所有非遗信息
     * @return 所有非遗信息
     */
    public List<ICHInfo> findAll(){
        return ichInfoRepository.findAll();
    }

    public ICHInfo findByIchId(Integer ichId){
        List<ICHInfo> ichInfo = ichInfoRepository.findByIchId(ichId);
        if (ichInfo.size() > 0){
            return ichInfoRepository.findByIchId(ichId).get(0);
        }
        return null;
    }

    /**
     * 根据ichId删除非遗信息
     * @param ichId 非遗信息ID
     * @return 执行结果true/false
     */
    public boolean deleteByIchId(Integer ichId){
        if (ichInfoRepository.deleteByIchId(ichId) != null){
            return true;
        }
        return false;
    }

    /**
     * 保存非遗信息
     * @param ichInfo 非遗信息
     * @return ichId
     */
    public Integer save(ICHInfo ichInfo){
        ICHInfo newICHInfo = ichInfoRepository.save(ichInfo);
        return newICHInfo.getIchId();
    }
}
