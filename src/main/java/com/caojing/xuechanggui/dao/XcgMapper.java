package com.caojing.xuechanggui.dao;

import com.caojing.xuechanggui.po.XcgResponse;
import com.caojing.xuechanggui.pojo.Xcg;
import com.caojing.xuechanggui.qo.XcgTableListRequest;
import com.caojing.xuechanggui.qo.XcgTableRequest;

import java.util.List;

public interface XcgMapper {

    Integer insert(Xcg xcg);

    XcgResponse selectByPrimaryKey(Integer id);

    List<XcgResponse> selectAllForTable(XcgTableRequest request);

    List<XcgResponse> selectAllForTableList(XcgTableListRequest request);
}
