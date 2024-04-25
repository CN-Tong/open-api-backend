package com.tong.openapi.service.impl;
import java.util.Date;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.tong.openapi.common.ErrorCode;
import com.tong.openapi.constant.CommonConstant;
import com.tong.openapi.exception.BusinessException;
import com.tong.openapi.exception.ThrowUtils;
import com.tong.openapi.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.tong.openapi.model.entity.*;
import com.tong.openapi.model.entity.InterfaceInfo;
import com.tong.openapi.model.vo.InterfaceInfoVO;
import com.tong.openapi.model.vo.InterfaceInfoVO;
import com.tong.openapi.model.vo.UserVO;
import com.tong.openapi.service.InterfaceInfoService;
import com.tong.openapi.model.entity.InterfaceInfo;
import com.tong.openapi.mapper.InterfaceInfoMapper;
import com.tong.openapi.service.UserService;
import com.tong.openapi.utils.SqlUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
* @author Tong
* @description 针对表【interface_info(open_api_db.`interface_info`)】的数据库操作Service实现
* @createDate 2024-04-22 11:43:02
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    @Autowired
    private UserService userService;

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        // 创建时，参数不能为空
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(name), ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口名称过长");
        }
    }

    @Override
    public QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest) {
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        if (interfaceInfoQueryRequest == null) {
            return queryWrapper;
        }
        String name = interfaceInfoQueryRequest.getName();
        String description = interfaceInfoQueryRequest.getDescription();
        String url = interfaceInfoQueryRequest.getUrl();
        String method = interfaceInfoQueryRequest.getMethod();
        Integer status = interfaceInfoQueryRequest.getStatus();
        Long userId = interfaceInfoQueryRequest.getUserId();
        // 拼接查询条件
        queryWrapper.like(StringUtils.isNotBlank(name), "name", name);
        queryWrapper.like(StringUtils.isNotBlank(description), "description", description);
        queryWrapper.like(StringUtils.isNotBlank(url), "url", url);
        queryWrapper.like(StringUtils.isNotBlank(method), "method", method);
        queryWrapper.eq(ObjectUtils.isNotEmpty(status), "status", status);
        queryWrapper.eq(ObjectUtils.isNotEmpty(userId), "user_id", userId);

        return queryWrapper;
    }

    @Override
    public Page<InterfaceInfo> searchFromEs(InterfaceInfoQueryRequest interfaceInfoQueryRequest) {
        throw new BusinessException(ErrorCode.SYSTEM_ERROR, "功能未完成");
    }

    @Override
    public InterfaceInfoVO getInterfaceInfoVO(InterfaceInfo interfaceInfo, HttpServletRequest request) {
        return BeanUtil.copyProperties(interfaceInfo, InterfaceInfoVO.class);
    }

    @Override
    public Page<InterfaceInfoVO> getInterfaceInfoVOPage(Page<InterfaceInfo> interfaceInfoPage,
                                                        HttpServletRequest request) {
        List<InterfaceInfo> interfaceInfoList = interfaceInfoPage.getRecords();
        Page<InterfaceInfoVO> interfaceInfoVOPage = new Page<>(
                interfaceInfoPage.getCurrent(), interfaceInfoPage.getSize(), interfaceInfoPage.getTotal());
        if (CollectionUtils.isEmpty(interfaceInfoList)) {
            return interfaceInfoVOPage;
        }
        interfaceInfoVOPage.setRecords(BeanUtil.copyToList(interfaceInfoList, InterfaceInfoVO.class));
        return interfaceInfoVOPage;
    }
}




