package com.tong.openapi.service.impl;
import java.util.Date;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.tong.openapi.common.ErrorCode;
import com.tong.openapi.constant.CommonConstant;
import com.tong.openapi.exception.BusinessException;
import com.tong.openapi.exception.ThrowUtils;
import com.tong.openapi.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.tong.openapi.model.entity.InterfaceInfo;
import com.tong.openapi.model.entity.User;
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
        throw new BusinessException(ErrorCode.SYSTEM_ERROR, "功能未完成");
    }

    @Override
    public Page<InterfaceInfo> searchFromEs(InterfaceInfoQueryRequest interfaceInfoQueryRequest) {
        throw new BusinessException(ErrorCode.SYSTEM_ERROR, "功能未完成");
    }

    @Override
    public InterfaceInfoVO getInterfaceInfoVO(InterfaceInfo interfaceInfo, HttpServletRequest request) {
        throw new BusinessException(ErrorCode.SYSTEM_ERROR, "功能未完成");
    }

    @Override
    public Page<InterfaceInfoVO> getInterfaceInfoVOPage(Page<InterfaceInfo> interfaceInfoPage, HttpServletRequest request) {
        throw new BusinessException(ErrorCode.SYSTEM_ERROR, "功能未完成");
    }
}




