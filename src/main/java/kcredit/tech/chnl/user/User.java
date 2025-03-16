package kcredit.tech.chnl.user;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@TableName("tech_chnl.user")
@Data
@Accessors(chain = true)
public class User {
    @TableId
    private Long no;
    private String name;
    private UserGrade grade;
    private Date regDate;
}
