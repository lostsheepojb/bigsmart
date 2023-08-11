package mystruct;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author cjj
 * @date 2023/8/11 11:14
 * @description
 **/
@Data
public class StudentDO {
    private Integer id;
    private String name;
    private LocalDate birthDate;
    private BigDecimal height;
    private LocalDateTime dateTime;
    private Address address;
}
