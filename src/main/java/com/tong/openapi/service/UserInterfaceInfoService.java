package com.tong.openapi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tong.openapi.model.dto.userinterfaceinfo.UserInterfaceInfoQueryRequest;
import com.tong.openapi.model.entity.UserInterfaceInfo;
import com.tong.openapi.model.vo.UserInterfaceInfoVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author Tong
* @description 针对表【user_interface_info(用户接口关系表)】的数据库操作Service
* @createDate 2024-04-26 09:28:25
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 校验
     *
     * @param userInterfaceInfo
     * @param add
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 获取查询条件
     *
     * @param userInterfaceInfoQueryRequest
     * @return
     */
    QueryWrapper<UserInterfaceInfo> getQueryWrapper(UserInterfaceInfoQueryRequest userInterfaceInfoQueryRequest);

    /**
     * 获取帖子封装
     *
     * @param userInterfaceInfo
     * @param request
     * @return
     */
    UserInterfaceInfoVO getUserInterfaceInfoVO(UserInterfaceInfo userInterfaceInfo, HttpServletRequest request);

    /**
     * 分页获取帖子封装
     *
     * @param userInterfaceInfoPage
     * @param request
     * @return
     */
    Page<UserInterfaceInfoVO> getUserInterfaceInfoVOPage(Page<UserInterfaceInfo> userInterfaceInfoPage, HttpServletRequest request);

    /**
     * 调用一次接口
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeOneCount(Long interfaceInfoId, Long userId);

}
