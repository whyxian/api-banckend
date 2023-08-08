package com.whyxian.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whyxian.project.common.ErrorCode;
import com.whyxian.project.exception.BusinessException;
import com.whyxian.project.mapper.InterfaceInfoMapper;
import com.whyxian.project.service.InterfaceInfoService;
import com.whyxian.apicommon.model.entity.InterfaceInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 接口信息服务实现类
 *

 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }
    
}




