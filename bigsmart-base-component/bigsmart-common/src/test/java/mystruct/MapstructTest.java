package mystruct;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author cjj
 * @date 2023/8/11 11:08
 * @description
 **/
public class MapstructTest {

    public static void main(String[] args) {
        StudentDO studentDO = new StudentDO();
        studentDO.setId(10);
        studentDO.setName("张三");
        studentDO.setBirthDate(LocalDate.now());
        studentDO.setHeight(new BigDecimal("169.557"));
        Address address = new Address();
        address.setId(1);
        address.setCode("00001");
        address.setCity("北京");
        studentDO.setAddress(address);

        StudentVO studentVO = StudentMapper.INSTANCT.toStudentVO(studentDO);
        StudentVO studentVO2 = StudentMapper.INSTANCT.toStudentVO2(studentDO);

        System.out.println(studentDO);
        System.out.println(studentVO);
        System.out.println(studentVO2);

    }
}
