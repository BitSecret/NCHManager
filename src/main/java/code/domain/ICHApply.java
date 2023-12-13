package code.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 非遗信息表
 */
@Entity
@Table(name = "ich_apply")    //数据库表，必须与@Id注解同时使用
@Data                        //Lombok插件简化代码，不用写set和get
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ICHApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //为一个实体生成一个唯一标识的主键

    private Integer ichApplyId;
    private Integer ichId;
    private Integer status;
    private String attachment;
    private String reply;
    private String applyTime;
    private String approveTime;
    private Integer applyUserId;
    private Integer approveUserId;
}
