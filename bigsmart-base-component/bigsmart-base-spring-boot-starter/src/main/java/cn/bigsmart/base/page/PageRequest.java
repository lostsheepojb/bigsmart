package cn.bigsmart.base.page;

import lombok.Data;

/**
 * 分页请求对象
 *
 * @author cjj
 * @date 2023-06-18
 */
@Data
public class PageRequest {

    /**
     * 当前页
     */
    private Long current;

    /**
     * 每页显示条数
     */
    private Long size;
}
