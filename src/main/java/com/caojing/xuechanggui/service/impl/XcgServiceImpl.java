package com.caojing.xuechanggui.service.impl;

import com.caojing.xuechanggui.dao.XcgMapper;
import com.caojing.xuechanggui.po.XcgResponse;
import com.caojing.xuechanggui.pojo.Xcg;
import com.caojing.xuechanggui.qo.XcgRequest;
import com.caojing.xuechanggui.qo.XcgTableListRequest;
import com.caojing.xuechanggui.qo.XcgTableRequest;
import com.caojing.xuechanggui.service.XcgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class XcgServiceImpl implements XcgService {
    @Autowired
    private XcgMapper xcgMapper;

    @Override
    public Integer insert(XcgRequest xcgRequest) {
        Xcg xcg = new Xcg();
        xcg.setBxb(xcgRequest.getBxb());
        xcg.setHxb(xcgRequest.getHxb());
        xcg.setXhdb(xcgRequest.getXhdb());
        xcg.setXxb(xcgRequest.getXxb());
        xcg.setLbjdz(xcgRequest.getLbjdz());
        xcg.setZxjdz(xcgRequest.getZxjdz());
        if(StringUtils.hasLength(xcgRequest.getCreateDate())){
            String createDate = xcgRequest.getCreateDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date createData = sdf.parse(createDate);
                xcg.setCreateDate(new Timestamp(createData.getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }else{
            xcg.setCreateDate(new Timestamp(System.currentTimeMillis()));
        }
        Integer id = xcgMapper.insert(xcg);
        return xcg.getId();
    }

    @Override
    public XcgResponse selectById(Integer id) {
        XcgResponse xcg = xcgMapper.selectByPrimaryKey(id);
        return xcg;
    }

    @Override
    public List<XcgResponse> getAllData(XcgTableRequest request) {
        List<XcgResponse> response = xcgMapper.selectAllForTable(request);
        return response;
    }

    @Override
    public List<XcgResponse> getTableList(XcgTableListRequest request) {
        return xcgMapper.selectAllForTableList(request);
    }
}
