package com.assign.service.order;

import com.assign.entity.po.AssignPO;
import com.assign.entity.po.SkuManageInfoPO;
import com.assign.service.common.CommonService;
import com.baomidou.mybatisplus.extension.service.IService;

public interface SkuManageInfoService extends IService<SkuManageInfoPO> {
    SkuManageInfoPO getBySkuInfo(AssignPO po);

    void handleUrl(AssignPO po);
}
