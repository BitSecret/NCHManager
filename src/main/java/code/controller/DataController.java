package code.controller;

import code.domain.ICHInfo;
import code.domain.UserIdentity;
import code.domain.InitPageMsg;
import code.domain.UserInfo;
import code.helper.FileUpload;
import code.helper.Result;
import code.service.ICHInfoService;
import code.service.UserIdentityService;
import code.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping(value = "data_api")
@Slf4j
public class DataController {
    @Autowired
    UserIdentityService userIdentityService;    //用户身份信息
    @Autowired
    UserInfoService userInfoService;    //用户资料
    @Autowired
    ICHInfoService ichInfoService;    //用户资料

    /**
     * 验证用户名和密码  data_api/login
     * @param account 用户名
     * @param password 密码
     * @param request http请求
     * @return Result类型
     */
    @GetMapping(value = "login")
    public Result login(String account, String password, HttpServletRequest request){
        List<UserIdentity> userIdentities = userIdentityService.verifyLogin(account, password);

        if (userIdentities.size() > 0){    //验证成功
            UserIdentity userIdentity = userIdentities.get(0);    //获取账号信息

            HttpSession session = request.getSession();    //客户端追踪用户
            session.setAttribute("user_id", userIdentity.getUserId());
            session.setAttribute("account", userIdentity.getAccount());
            session.setAttribute("status", userIdentity.getStatus());

            return Result.ok();
        }
        return Result.error("登陆失败，用户名或密码错误。");
    }

    /**
     * 用户登出  data_api/loginOut
     * @param request Http请求
     * @return Result.ok()
     */
    @GetMapping(value = "loginOut")
    public Result loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("account");    //从session移除account，下次请求页面会被拦截
        return Result.ok();
    }



    /**
     * master.js的数据查询接口，用于初始化master.html模板的信息  data_api/initPageMsg
     * @param request Http请求
     * @return InitPageMsg类
     */
    @GetMapping(value = "initPageMsg")
    public InitPageMsg initPageMsg(HttpServletRequest request){
        InitPageMsg pageMsg = new InitPageMsg();

        String account = (String)request.getSession().getAttribute("account");

        if (account == null || account.equals("")) {     //未登录用户访问
            pageMsg.defaultMsgForTourist();    //游客访问
        }
        else {    //用户访问
            pageMsg.setUserId((Integer) request.getSession().getAttribute("user_id"));
            UserInfo userInfo = userInfoService.findUserInfoById(pageMsg.getUserId());
            pageMsg.setUserId(userInfo.getUserId());
            pageMsg.setPhotoPath(userInfo.getPhotoPath());
            pageMsg.setStatusCode(userIdentityService.findStatusByUserId(userInfo.getUserId()));
            pageMsg.setUsername(userInfo.getUsername());
            pageMsg.setPrivateMsgCount(0);    //消息数 先写死
            pageMsg.setPublicMsgCount(0);
        }

        return pageMsg;    //返回给前端master.js
    }



    /**
     * 接受用户Get请求，返回用户资料  data_api/user_info/user_id
     * @param user_id 用户id
     * @return 用户资料
     */
    @PostMapping(value = "getUserInfo")
    public UserInfo returnUserInfo(@RequestParam("user_id")Integer user_id){
        UserInfo userInfo = userInfoService.findUserInfoById(user_id);
        if (userInfo != null){
            return userInfo;
        }
        else{
            return new UserInfo();
        }
    }

    /**
     * 保存用户信息
     * @param userInfo 用户资料
     * @return 保存结果
     */
    @PutMapping(value = "saveUserInfo")
    public Result updateUserInfo(@Valid UserInfo userInfo){
        userInfoService.save(userInfo);
        return Result.ok();
    }



    /**
     * 接受用户post请求，上传文件
     * @param file 文件名
     * @return 文件在服务器内的地址
     */
    @PostMapping(value = "upload")
    public String upload(@RequestParam("file")MultipartFile file){
        return FileUpload.saveFile(file);    //上传文件并返回文件名
    }



    /**
     * 返回所有非遗信息
     * @return 非遗信息
     */
    @GetMapping(value = "getIchInfo")
    public List<ICHInfo> returnAllIchInfo(){
        return ichInfoService.findAll();
    }

    /**
     * 通过id查找非遗信息
     * @param ichId 非遗信息id
     * @return 非遗信息
     */
    @GetMapping(value = "getIchInfoByIchId/{ichId}")
    public ICHInfo returnOneIchInfo(@PathVariable Integer ichId){
        return ichInfoService.findByIchId(ichId);
    }

    /**
     * 对应前端的新增、修改操作
     * @return 执行结果Result
     */
    @PostMapping(value = "saveIchInfo")
    public Result saveIchInfo(@Valid ICHInfo ichInfo){
        if (ichInfoService.save(ichInfo) != 0){
            return Result.ok();
        }
        return Result.error("信息保存失败！");
    }

    /**
     * 删除非遗信息
     * @param ichId 非遗信息id
     * @return 执行结果Result
     */
    @DeleteMapping(value = "deleteICHInfoById/{ichId}")
    public Result deleteICHInfoById(@PathVariable Integer ichId){
        System.out.println(ichId);
        if (ichInfoService.deleteByIchId(ichId)){
            return Result.ok();
        }
        return Result.error("删除失败！");
    }
}
