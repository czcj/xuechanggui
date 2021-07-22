package com.caojing.xuechanggui.controller;

import com.alibaba.fastjson.JSON;
import com.caojing.xuechanggui.echart.Serie;
import com.caojing.xuechanggui.po.XcgResponse;
import com.caojing.xuechanggui.qo.XcgRequest;
import com.caojing.xuechanggui.qo.XcgTableListRequest;
import com.caojing.xuechanggui.qo.XcgTableRequest;
import com.caojing.xuechanggui.service.EchartService;
import com.caojing.xuechanggui.service.XcgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class XcgController {

    @Autowired
    private XcgService xcgService;
    @Autowired
    private EchartService echartService;

    @RequestMapping("/xcg/add")
    public String add(Model model,XcgRequest request){
        Integer id = xcgService.insert(request);
        XcgResponse response = xcgService.selectById(id);
        return "redirect:../chart.html";
    }
    @RequestMapping("/tables.html")
    public String tableList(Model model, XcgTableListRequest request){
        List<XcgResponse> xcgResponseList = xcgService.getTableList(request);
        System.out.println(JSON.toJSONString(request));
        model.addAttribute("xcgList",xcgResponseList);
        return "tables";
    }
    @RequestMapping("/xcg/table/getxcgtable")
    @ResponseBody
    public Object getAllDataForTableB(XcgTableRequest request){
        if(null != request.getNames() && request.getNames().size()>0){
            List<XcgResponse> xcgResponseList = xcgService.getAllData(request);
            return echartService.componData(xcgResponseList,request);
        }else{
            return "";
        }

    }

}
