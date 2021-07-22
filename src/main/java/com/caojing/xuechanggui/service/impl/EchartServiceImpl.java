package com.caojing.xuechanggui.service.impl;

import com.caojing.xuechanggui.echart.Serie;
import com.caojing.xuechanggui.po.XcgResponse;
import com.caojing.xuechanggui.qo.XcgTableRequest;
import com.caojing.xuechanggui.service.EchartService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class EchartServiceImpl implements EchartService {

    public Object componData(List<XcgResponse> xcgResponseList, XcgTableRequest request) {
        List<String> createDatas = new ArrayList<>();
        List<Serie> series = new ArrayList<>();
        List<String> legends = new ArrayList<>();
        Serie bxbserie = new Serie();
        Serie hxbserie = new Serie();
        Serie xhdbserie = new Serie();
        Serie xxbserie = new Serie();
        Serie zxjdzserie = new Serie();
        Serie lbjdzserie = new Serie();
        ArrayList<Double> bxbs = new ArrayList<>();
        bxbserie.setData(bxbs);
        ArrayList<Double> hxbs = new ArrayList<>();
        hxbserie.setData(hxbs);
        ArrayList<Double> xhdbs = new ArrayList<>();
        xhdbserie.setData(xhdbs);
        ArrayList<Double> xxbs = new ArrayList<>();
        xxbserie.setData(xxbs);
        ArrayList<Double> zxjdzs = new ArrayList<>();
        zxjdzserie.setData(zxjdzs);
        ArrayList<Double> lbjdzs = new ArrayList<>();
        lbjdzserie.setData(lbjdzs);
        for(String serieName : request.getNames()){
            if("bxb".equals(serieName)){
                bxbserie.setName("白细胞");
                legends.add("白细胞");
                series.add(bxbserie);

            }
            if("hxb".equals(serieName)){
                hxbserie.setName("红细胞");
                legends.add("红细胞");
                series.add(hxbserie);

            }
            if("xhdb".equals(serieName)){
                xhdbserie.setName("血红蛋白");
                legends.add("血红蛋白");
                series.add(xhdbserie);

            }
            if("xxb".equals(serieName)){
                xxbserie.setName("血小板");
                legends.add("血小板");
                series.add(xxbserie);
            }
            if("zxjdz".equals(serieName)){
                zxjdzserie.setName("中性绝对值");
                legends.add("中性绝对值");
                series.add(zxjdzserie);

            }
            if("lbxbjdz".equals(serieName)){
                lbjdzserie.setName("淋巴细胞绝对值");
                legends.add("淋巴细胞绝对值");
                series.add(lbjdzserie);
            }
        }


        for(XcgResponse xcgResponse : xcgResponseList){
            if("tableA".equalsIgnoreCase(request.getTableName())){
                bxbs.add(xcgResponse.getBxb());
                hxbs.add(xcgResponse.getHxb());
                zxjdzs.add(xcgResponse.getZxjdz());
                lbjdzs.add(xcgResponse.getLbjdz());
            }
            if("tableB".equalsIgnoreCase(request.getTableName())){
                xhdbs.add(xcgResponse.getXhdb());
                xxbs.add(xcgResponse.getXxb());
            }
            createDatas.add(getTime(xcgResponse.getCreateDate()));

        }
        HashMap<String, Object> echartData = new HashMap<>();
        echartData.put("xAxisList",createDatas);
        echartData.put("series",series);
        echartData.put("legends",legends);
        return echartData;
    }

    public static String getTime(Timestamp timestamp) {
        Date currentTime = timestamp;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(currentTime);
        return dateString;
    }
}
