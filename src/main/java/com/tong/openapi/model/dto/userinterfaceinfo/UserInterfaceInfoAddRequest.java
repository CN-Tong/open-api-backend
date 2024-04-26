package com.tong.openapi.model.dto.userinterfaceinfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 创建请求
 *
 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {

    /**
     * 调用用户
     */
    private Long userId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 被调用的接口
     */
    private Long interfaceInfoId;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;


    private static final long serialVersionUID = 1L;
}