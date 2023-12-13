package code.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 信息和通知表
 */
@Entity
@Table(name = "message")    //数据库表，必须与@Id注解同时使用
@Data                        //Lombok插件简化代码，不用写set和get
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //为一个实体生成一个唯一标识的主键
    private Integer msgId;
    private String title;
    private String content;
    private Integer status;
    private String attachment;
    private String sendTime;
    private String readTime;
    private Integer senderUserId;
    private Integer readerUserId;
}
