package code.domain;

import lombok.Data;


/**
 * 这个类用于初始化模板，传递用户身份、消息等
 * 这是是组合的数据的表，这个表并不在数据库中存在
 */
@Data                        //Lombok插件简化代码，不用写set和get
public class InitPageMsg {
    private Integer userId;    //user_id
    private Integer statusCode;    //用户权限

    private String photoPath;    //用户信息
    private String username;

    private Integer publicMsgCount;    //消息
    private Integer privateMsgCount;

    public void defaultMsgForTourist(){
        statusCode = 0;
    }
}
