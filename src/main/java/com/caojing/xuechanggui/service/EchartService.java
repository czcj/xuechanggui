package com.caojing.xuechanggui.service;

import com.caojing.xuechanggui.po.XcgResponse;
import com.caojing.xuechanggui.qo.XcgTableRequest;

import java.util.List;

public interface EchartService {

    public Object componData(List<XcgResponse> xcgResponseList, XcgTableRequest request);
}
