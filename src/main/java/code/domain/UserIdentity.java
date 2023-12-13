package code.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户身份信息表
 */
@Entity
@Table(name = "user_identity")    //数据库表，必须与@Id注解同时使用
@Data                        //Lombok插件简化代码，不用写set和get
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserIdentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //为一个实体生成一个唯一标识的主键

    private Integer userId;    //第一个变量作为默认主键
    private String account;
    private String password;
    private Integer status;
}
