package mystruct;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    private String birthDateStr;
    private String birthDateJsonStr;
    private String heightStr;
}
