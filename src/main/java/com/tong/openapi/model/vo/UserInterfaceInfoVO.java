package com.tong.openapi.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 帖子视图
 *
 */
@Data
public class UserInterfaceInfoVO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 调用用户
     */
    private Long userId;

    /**
     * 被调用的接口
     */
    private Long interfaceInfoId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 状态（0 - 禁用 1 - 正常）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
