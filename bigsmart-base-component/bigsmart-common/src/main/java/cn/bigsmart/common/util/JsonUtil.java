package cn.bigsmart.common.util;

import cn.bigsmart.common.constant.DateTimePattern;
import com.google.gson.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author cjj
 * @date 2023/8/11 14:17
 * @description json工具类，基于Gson封装，封装目的是项目统一Json序列化/反序列化规则，也方便日后json工具的切换
 **/
public class JsonUtil {

    /**
     * 私有化Json工具类，避免被外部修改Json转换规则
     */
    private final static Gson JSONS;

    static {
        /**
         * 定义Gson序列化器
         */
        final JsonSerializer<LocalDateTime> DATE_TIME_SERIALIZER = (localDateTime, type, jsonSerializationContext)
                -> new JsonPrimitive(localDateTime.format(DateTimeFormatter.ofPattern(DateTimePattern.DATE_TIME)));
        final JsonSerializer<LocalDate> DATE_SERIALIZER = (localDate, type, jsonSerializationContext)
                -> new JsonPrimitive(localDate.format(DateTimeFormatter.ofPattern(DateTimePattern.DATE)));
        /**
         * 定义Gson反序列化器
         */
        final JsonDeserializer<LocalDateTime> DATE_TIME_DESERIALIZER = (jsonElement, type, jsonDeserializationContext)
                -> LocalDateTime.parse(jsonElement.getAsJsonPrimitive().getAsString(),
                DateTimeFormatter.ofPattern(DateTimePattern.DATE_TIME));
        final JsonDeserializer<LocalDate> DATE_DESERIALIZER = (jsonElement, type, jsonDeserializationContext)
                -> LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString(),
                DateTimeFormatter.ofPattern(DateTimePattern.DATE));

        JSONS = new GsonBuilder()
                //时间格式化
                .setDateFormat(DateTimePattern.DATE_TIME)
                //输出空对象
                .serializeNulls()
                //注册自定义序列化器
                .registerTypeAdapter(LocalDateTime.class, DATE_TIME_SERIALIZER)
                .registerTypeAdapter(LocalDate.class, DATE_SERIALIZER)
                .registerTypeAdapter(LocalDateTime.class, DATE_TIME_DESERIALIZER)
                .registerTypeAdapter(LocalDate.class, DATE_DESERIALIZER)
                .create();
    }

    /**
     * 对象转Json字符串
     */
    public static String toJsonString(Object o) {
        return JSONS.toJson(o);
    }

    /**
     * Json字符串转对象
     */
    public static <T> T parse(String jsonString, Class<T> classOfT) {
        return JSONS.fromJson(jsonString, classOfT);
    }

}
