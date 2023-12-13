package code.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户资料表
 */
@Entity
@Table(name = "user_info")    //数据库表，必须与@Id注解同时使用
@Data                        //Lombok插件简化代码，不用写set和get
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //为一个实体生成一个唯一标识的主键
    private Integer userId;
    private String username;
    private String department;
    private String departmentPosition;
    private String photoPath;
    private String birthday;    //时间设置太麻烦，直接改成String类型
    private String phoneNumber;
    private String intro;
}
