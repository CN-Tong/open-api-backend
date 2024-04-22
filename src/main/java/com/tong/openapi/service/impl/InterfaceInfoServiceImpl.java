package com.tong.openapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tong.openapi.service.InterfaceInfoService;
import com.tong.openapi.model.entity.InterfaceInfo;
import com.tong.openapi.mapper.InterfaceInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Tong
* @description 针对表【interface_info(open_api_db.`interface_info`)】的数据库操作Service实现
* @createDate 2024-04-22 11:43:02
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

}




