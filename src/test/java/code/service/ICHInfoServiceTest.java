package code.service;

import code.DemoApplication;
import code.domain.ICHInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ICHInfoServiceTest {

    @Autowired
    ICHInfoService ichInfoService;

    @Test
    void findAll() {
        Integer currentCount = 716;
        List<ICHInfo> ichInfo = ichInfoService.findAll();
        Assertions.assertEquals(ichInfo.size(), currentCount);    //测试是否全部取到
    }

    @Test
    void findByIchId() {
        ICHInfo ichInfo = ichInfoService.findByIchId(10);
        Assertions.assertEquals(ichInfo.getIchId(), 10);    //测试是否取到正确的信息

        ichInfo = ichInfoService.findByIchId(100);
        Assertions.assertEquals(ichInfo.getIchId(), 100);    //测试是否取到正确的信息

        ichInfo = ichInfoService.findByIchId(1000);
        Assertions.assertNull(ichInfo);    //测试是否取到正确的信息
    }

    @Test
    void saveThenDeleteByIchId() {
        ICHInfo ichInfo = new ICHInfo();
        ichInfo.setName("测试name");
        Integer ichId = ichInfoService.save(ichInfo);
        Assertions.assertNotEquals(ichId, 0);     //返回零，证明存储失败

        Boolean result = ichInfoService.deleteByIchId(ichId);
        Assertions.assertTrue(result);    //返回true，证明操作成功
    }

}