package mystruct;

import cn.bigsmart.common.util.MapstructUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author cjj
 * @date 2023/8/11 11:18
 * @description mapstruct对象复制映射接口
 **/
@Mapper(uses = MapstructUtil.class)
public interface StudentMapper {

    StudentMapper INSTANCT = Mappers.getMapper(StudentMapper.class);

    /**
     * 没有声明属性映射规则，则使用默认的映射规则
     */
    StudentVO toStudentVO(StudentDO studentDO);

    //属性名称相同，会自动复制，可以不声明
    @Mapping(target = "id", source = "id")
    //属性名称不同的映射
    @Mapping(target = "studentName", source = "name")
    @Mapping(target = "dateTimeStr", source = "dateTime")
    //忽略字段复制的映射 ignore
    @Mapping(target = "address", ignore = true)
    //时间格式化的映射 dateFormat
    @Mapping(target = "birthDateStr", source = "birthDate", dateFormat = "yyyy/MM/dd")
    //数字格式化的映射 numberFormat
    @Mapping(target = "heightStr", source = "height", numberFormat = "#0.00")
    //自定义格式化的映射 qualifiedByName
    @Mapping(target = "addressJsonStr", source = "address", qualifiedByName = "toJsonString")
    StudentVO toStudentVO2(StudentDO studentDO);
}
