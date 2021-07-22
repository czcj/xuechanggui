package com.caojing.xuechanggui.service;

import com.caojing.xuechanggui.po.XcgResponse;
import com.caojing.xuechanggui.qo.XcgRequest;
import com.caojing.xuechanggui.qo.XcgTableListRequest;
import com.caojing.xuechanggui.qo.XcgTableRequest;

import java.util.List;

public interface XcgService {
    Integer insert(XcgRequest xcgRequest);

    XcgResponse selectById(Integer id);

    List<XcgResponse> getAllData(XcgTableRequest xcgTableRequest);

    List<XcgResponse> getTableList(XcgTableListRequest request);
}
