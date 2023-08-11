package mystruct;

import lombok.Data;

/**
 * @author cjj
 * @date 2023/8/11 11:14
 * @description
 **/
@Data
public class StudentVO {
    private Integer id;
    private String studentName;
    private Address address;
    private String addressJsonStr;
    private String birthDateStr;
    private String heightStr;
    private String dateTimeStr;
}
