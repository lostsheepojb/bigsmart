package cn.bigsmart.common.util;

import org.mapstruct.Named;

/**
 * @author cjj
 * @date 2023/8/11 13:53
 * @description Mapstruc对象复制工具类
 **/
public class MapstructUtil {

    @Named("toJsonString")
    public String toJsonString(Object o) {
        return JsonUtil.toJsonString(o);
    }

}
