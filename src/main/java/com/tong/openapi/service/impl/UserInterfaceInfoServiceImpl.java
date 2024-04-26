package com.tong.openapi.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tong.openapi.common.ErrorCode;
import com.tong.openapi.exception.BusinessException;
import com.tong.openapi.mapper.UserInterfaceInfoMapper;
import com.tong.openapi.model.dto.userinterfaceinfo.UserInterfaceInfoQueryRequest;
import com.tong.openapi.model.entity.InterfaceInfo;
import com.tong.openapi.model.entity.UserInterfaceInfo;
import com.tong.openapi.model.vo.InterfaceInfoVO;
import com.tong.openapi.model.vo.UserInterfaceInfoVO;
import com.tong.openapi.service.UserInterfaceInfoService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Tong
 * @description 针对表【user_interface_info(用户接口关系表)】的数据库操作Service实现
 * @createDate 2024-04-26 09:28:25
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建时，所有参数必须非空
        if (add) {
            if (userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户或接口不存在");
            }
        }
        if (userInterfaceInfo.getLeftNum() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数必须大于0");
        }
    }

    @Override
    public QueryWrapper<UserInterfaceInfo> getQueryWrapper(UserInterfaceInfoQueryRequest userInterfaceInfoQueryRequest) {
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        if (userInterfaceInfoQueryRequest == null) {
            return queryWrapper;
        }
        Long userId = userInterfaceInfoQueryRequest.getUserId();
        Long interfaceInfoId = userInterfaceInfoQueryRequest.getInterfaceInfoId();
        Integer totalNum = userInterfaceInfoQueryRequest.getTotalNum();
        Integer leftNum = userInterfaceInfoQueryRequest.getLeftNum();
        Integer status = userInterfaceInfoQueryRequest.getStatus();
        // 拼接查询条件
        queryWrapper.eq(userId != null, "user_id", userId);
        queryWrapper.eq(interfaceInfoId != null, "interface_nfoId", interfaceInfoId);
        queryWrapper.ge(totalNum != null, "total_num", totalNum);
        queryWrapper.ge(leftNum != null, "left_num", leftNum);
        queryWrapper.eq(ObjectUtils.isNotEmpty(status), "status", status);

        return queryWrapper;
    }

    @Override
    public UserInterfaceInfoVO getUserInterfaceInfoVO(UserInterfaceInfo userInterfaceInfo, HttpServletRequest request) {
        return BeanUtil.copyProperties(userInterfaceInfo, UserInterfaceInfoVO.class);
    }

    @Override
    public Page<UserInterfaceInfoVO> getUserInterfaceInfoVOPage(Page<UserInterfaceInfo> userInterfaceInfoPage, HttpServletRequest request) {
        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoPage.getRecords();
        Page<UserInterfaceInfoVO> interfaceInfoVOPage = new Page<>(
                userInterfaceInfoPage.getCurrent(), userInterfaceInfoPage.getSize(), userInterfaceInfoPage.getTotal());
        if (CollectionUtils.isEmpty(userInterfaceInfoList)) {
            return interfaceInfoVOPage;
        }
        interfaceInfoVOPage.setRecords(BeanUtil.copyToList(userInterfaceInfoList, UserInterfaceInfoVO.class));
        return interfaceInfoVOPage;
    }

    @Override
    public boolean invokeOneCount(Long interfaceInfoId, Long userId) {
        // 判断
        if(interfaceInfoId<=0 || userId<=0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户或接口不存在");
        }
        boolean success = lambdaUpdate()
                .eq(UserInterfaceInfo::getUserId, userId)
                .eq(UserInterfaceInfo::getInterfaceInfoId, interfaceInfoId)
                .gt(UserInterfaceInfo::getLeftNum, 0)
                .setSql("left_num = left_num - 1, total_num = total_num + 1")
                .update();
        return success;
    }
}




