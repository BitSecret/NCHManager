package code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class HttpRequestController {
    /**登录*/
    @GetMapping("login")
    public String login(){ return "/login/login"; }


    /**通用*/
    @GetMapping("")
    public String homeDefault(){ return "/general/home"; }

    @GetMapping("home")
    public String home(){ return "/general/home"; }

    @GetMapping("general_list")
    public String generalList(){ return "/general/general_list"; }


    /**我的*/
    @GetMapping("personal_info")
    public String personalInfo(){ return "/my/personal_info"; }

    @GetMapping("change_password")
    public String changePassword(){ return "/my/change_password"; }


    /**消息*/
    @GetMapping("message_list")
    public String msgList(){ return "/message/message_list"; }

    @GetMapping("message_detail")
    public String msgDetail(){ return "/message/message_detail"; }

    @GetMapping("publish_msg")
    public String publicMsg(){ return "/message/publish_msg"; }

    @GetMapping("published_msg_list")
    public String publishedMsgList(){ return "/message/published_msg_list"; }


    /**user业务*/
    @GetMapping("apply")
    public String apply(){ return "/business_for_user/apply"; }

    @GetMapping("apply_detail")
    public String applyDetail(){ return "/business_for_user/apply_detail"; }

    @GetMapping("apply_list")
    public String applyList(){ return "/business_for_user/apply_list"; }


    /**staff业务*/
    @GetMapping("investigate_detail")
    public String investigateDetail(){ return "/business_for_investigator/investigate_detail"; }

    @GetMapping("investigate_list")
    public String investigateList(){ return "/business_for_investigator/investigate_list"; }


    /**manager业务*/
    @GetMapping("table_apply")
    public String table_apply(){ return "/business_for_manager/table_apply"; }

    @GetMapping("table_ich_data")
    public String table_ich_data(){ return "/business_for_manager/table_ich_data"; }

    @GetMapping("table_ich_dataOp/add")    //table_ich_data页面的子页面
    public String table_ich_data_add(){ return "/business_for_manager/table_ich_data_add"; }

    @GetMapping("table_ich_dataOp/view/{ichId}")    //table_ich_data页面的子页面
    public String table_ich_data_view(@PathVariable Integer ichId){ return "/business_for_manager/table_ich_data_view"; }

    @GetMapping("table_ich_dataOp/update/{ichId}")    //table_ich_data页面的子页面
    public String table_ich_data_update(@PathVariable Integer ichId){ return "/business_for_manager/table_ich_data_update"; }

    @GetMapping("table_log")
    public String table_log(){ return "/business_for_manager/table_log"; }

    @GetMapping("table_msg")
    public String table_msg(){ return "/business_for_manager/table_msg"; }

    @GetMapping("table_user_data")
    public String table_user_data(){ return "/business_for_manager/table_user_data"; }

    @GetMapping("table_user_identity")
    public String table_user_identity(){ return "/business_for_manager/table_user_identity"; }
}
