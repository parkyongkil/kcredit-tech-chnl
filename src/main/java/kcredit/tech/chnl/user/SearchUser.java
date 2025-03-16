package kcredit.tech.chnl.user;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class SearchUser {
    private long no;
    private String name;
    private UserGrade grade;
    private Date startDate;
    private Date endDate;
}
