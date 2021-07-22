$(function() {
    var chartData = function() {
        var names1 = $selected1.val();
        var tableAstart = $tableAstart.val();
        var tableAend = $tableAend.val();
        var names2 = $selected2.val();
        var tableBstart = $tableBstart.val();
        var tableBend = $tableBend.val();
        //异步请求
        $.post(
            "/xcg/table/getxcgtable",//访问地址
            {tableName: 'tableA',names: names1,tableAstart:tableAstart,tableAend:tableAend},//携带的参数
            function (data) {
                var echartsA = echarts.init(document.getElementById('tpl-echarts-A'));
                option = {

                    tooltip: {
                        trigger: 'axis',
                    },
                    legend: {
                        data: data.legends
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis: [{
                        type: 'category',
                        boundaryGap: true,
                        data: data.xAxisList
                    }],

                    yAxis: [{
                        type: 'value'
                    }],
                    series: data.series
                };
                echartsA.setOption(option);
            },
            "json"
        ),
            //异步请求
            $.post(
                "/xcg/table/getxcgtable",//访问地址
                {tableName: 'tableB',names: names2,tableBstart:tableBstart,tableBend:tableBend},//携带的参数
                function (data) {
                    var echartsA = echarts.init(document.getElementById('tpl-echarts-B'));
                    option = {

                        tooltip: {
                            trigger: 'axis',
                        },
                        legend: {
                            data: data.legends
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                        },
                        xAxis: [{
                            type: 'category',
                            boundaryGap: true,
                            data: data.xAxisList
                        }],

                        yAxis: [{
                            type: 'value'
                        }],
                        series: data.series
                    };
                    echartsA.setOption(option);
                },
                "json"
            );
    }
    var tableListData = function(tableListstart,tableListend){
        //异步请求
        $.post(
            "/tables.html",//访问地址
            {start:tableListstart,end:tableListend},//携带的参数
            "json"
        );
    }


    // 读取body data-type 判断是哪个页面然后执行相应页面方法，方法在下面。
    var dataType = $('body').attr('data-type');
    console.log(dataType);
    var $selected1 = $('#xcgzxt1');
    var $selected2 = $('#xcgzxt2');
    var $tableAstart = $('#tableAstart');
    var $tableAend = $('#tableAend');
    var $tableBstart = $('#tableBstart');
    var $tableBend = $('#tableBend');
    var $tableListstart = $('#tableListstart');
    var $tableListend = $('#tableListend');
    for (key in pageData) {
        if (key == dataType) {
            pageData[key]();
        }
    }
    autoLeftNav();
    $(window).resize(function() {
        autoLeftNav();
        console.log($(window).width())
    });
    chartData();
    $selected1.on('change', function() {
        chartData();
    });
    $selected2.on('change', function() {
        chartData();
    });
    $tableAstart.on('change', function() {
        chartData();
    });
    $tableAend.on('change', function() {
        chartData();
    });
    $tableBstart.on('change', function() {
        chartData();
    });
    $tableBend.on('change', function() {
        chartData();
    });
    $tableListstart.on('change', function() {
        tableListData($tableListstart.val(),$tableListend.val());
    });
    $tableListend.on('change', function() {
        tableListData($tableListstart.val(),$tableListend.val());
    });

})

// 页面数据
var pageData = {
    // ===============================================
    // 首页
    // ===============================================
    // 'index':  function chartData() {
    //     //异步请求
    //     $.post(
    //         "/xcg//table/tableA",//访问地址
    //         // {start: start, end: end},//携带的参数
    //         function (data) {
    //             var echartsA = echarts.init(document.getElementById('tpl-echarts-A'));
    //             option = {
    //
    //                 tooltip: {
    //                     trigger: 'axis',
    //                 },
    //                 legend: {
    //                     data: ['白细胞', '红细胞','中性绝对值', '淋巴绝对值']
    //                 },
    //                 grid: {
    //                     left: '3%',
    //                     right: '4%',
    //                     bottom: '3%',
    //                     containLabel: true
    //                 },
    //                 xAxis: [{
    //                     type: 'category',
    //                     boundaryGap: true,
    //                     data: data.xAxisList
    //                 }],
    //
    //                 yAxis: [{
    //                     type: 'value'
    //                 }],
    //                 series: data.series
    //             };
    //             echartsA.setOption(option);
    //         },
    //         "json"
    //     );
    //
    //     $.post(
    //         "/xcg/table/tableB",//访问地址
    //         // {start: start, end: end},//携带的参数
    //         function (data) {
    //             var echartsB = echarts.init(document.getElementById('tpl-echarts-B'));
    //             option = {
    //                 tooltip: {
    //                     trigger: 'axis',
    //                 },
    //                 legend: {
    //                     data: ['血红蛋白','血小板']
    //                 },
    //                 grid: {
    //                     left: '3%',
    //                     right: '4%',
    //                     bottom: '3%',
    //                     containLabel: true
    //                 },
    //                 xAxis: [{
    //                     type: 'category',
    //                     boundaryGap: true,
    //                     data: data.xAxisList
    //                 }],
    //
    //                 yAxis: [{
    //                     type: 'value'
    //                 }],
    //                 series: data.series
    //             };
    //             echartsB.setOption(option);
    //         },
    //         "json"
    //     );
    // },
    // // ===============================================
    // // 图表页
    // // ===============================================
    // 'chart': function chartData() {
    //     //异步请求
    //     $.post(
    //         "/xcg//table/tableA",//访问地址
    //         // {start: start, end: end},//携带的参数
    //         function (data) {
    //             var echartsA = echarts.init(document.getElementById('tpl-echarts-A'));
    //             option = {
    //
    //                 tooltip: {
    //                     trigger: 'axis',
    //                 },
    //                 legend: {
    //                     data: ['白细胞','红细胞','中性绝对值','淋巴细胞绝对值']
    //                 },
    //                 grid: {
    //                     left: '3%',
    //                     right: '4%',
    //                     bottom: '3%',
    //                     containLabel: true
    //                 },
    //                 xAxis: [{
    //                     type: 'category',
    //                     boundaryGap: true,
    //                     data: data.xAxisList
    //                 }],
    //
    //                 yAxis: [{
    //                     type: 'value'
    //                 }],
    //                 series: data.series
    //             };
    //             echartsA.setOption(option);
    //         },
    //         "json"
    //     );
    //
    //     $.post(
    //         "/xcg/table/tableB",//访问地址
    //         // {start: start, end: end},//携带的参数
    //         function (data) {
    //             var echartsB = echarts.init(document.getElementById('tpl-echarts-B'));
    //             option = {
    //                 tooltip: {
    //                     trigger: 'axis',
    //                 },
    //                 legend: {
    //                     data: ['血红蛋白','血小板']
    //                 },
    //                 grid: {
    //                     left: '3%',
    //                     right: '4%',
    //                     bottom: '3%',
    //                     containLabel: true
    //                 },
    //                 xAxis: [{
    //                     type: 'category',
    //                     boundaryGap: true,
    //                     data: data.xAxisList
    //                 }],
    //
    //                 yAxis: [{
    //                     type: 'value'
    //                 }],
    //                 series: data.series
    //             };
    //             echartsB.setOption(option);
    //         },
    //         "json"
    //     );
    // }
}


// 风格切换

$('.tpl-skiner-toggle').on('click', function() {
    $('.tpl-skiner').toggleClass('active');
})

$('.tpl-skiner-content-bar').find('span').on('click', function() {
    $('body').attr('class', $(this).attr('data-color'))
    saveSelectColor.Color = $(this).attr('data-color');
    // 保存选择项
    storageSave(saveSelectColor);

})




// 侧边菜单开关


function autoLeftNav() {



    $('.tpl-header-switch-button').on('click', function() {
        if ($('.left-sidebar').is('.active')) {
            if ($(window).width() > 1024) {
                $('.tpl-content-wrapper').removeClass('active');
            }
            $('.left-sidebar').removeClass('active');
        } else {

            $('.left-sidebar').addClass('active');
            if ($(window).width() > 1024) {
                $('.tpl-content-wrapper').addClass('active');
            }
        }
    })

    if ($(window).width() < 1024) {
        $('.left-sidebar').addClass('active');
    } else {
        $('.left-sidebar').removeClass('active');
    }
}


// 侧边菜单
$('.sidebar-nav-sub-title').on('click', function() {
    $(this).siblings('.sidebar-nav-sub').slideToggle(80)
        .end()
        .find('.sidebar-nav-sub-ico').toggleClass('sidebar-nav-sub-ico-rotate');
})