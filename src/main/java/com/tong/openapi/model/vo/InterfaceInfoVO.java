package com.tong.openapi.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tong.openapi.model.entity.Post;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 帖子视图
 *
 */
@Data
public class InterfaceInfoVO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 接口名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 请求类型
     */
    private String method;

    /**
     * 请求参数
     */
    private String requestParams;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 响应头
     */
    private String responseHeader;

    /**
     * 接口状态（0 - 关闭 1 - 开启）
     */
    private Integer status;

    /**
     * 创建用户id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    // /**
    //  * 包装类转对象
    //  *
    //  * @param postVO
    //  * @return
    //  */
    // public static Post voToObj(InterfaceInfoVO postVO) {
    //     if (postVO == null) {
    //         return null;
    //     }
    //     Post post = new Post();
    //     BeanUtils.copyProperties(postVO, post);
    //     List<String> tagList = postVO.getTagList();
    //     if (tagList != null) {
    //         post.setTags(GSON.toJson(tagList));
    //     }
    //     return post;
    // }
    //
    // /**
    //  * 对象转包装类
    //  *
    //  * @param post
    //  * @return
    //  */
    // public static InterfaceInfoVO objToVo(Post post) {
    //     if (post == null) {
    //         return null;
    //     }
    //     InterfaceInfoVO postVO = new InterfaceInfoVO();
    //     BeanUtils.copyProperties(post, postVO);
    //     postVO.setTagList(GSON.fromJson(post.getTags(), new TypeToken<List<String>>() {
    //     }.getType()));
    //     return postVO;
    // }
}
