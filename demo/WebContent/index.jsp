<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
</head>
<body>
<div id="main" style="width: 800px; height: 600px"></div>
<script type="text/javascript">
 var myChart = echarts.init(document.getElementById("main"));
 var url ="go5";
 $.getJSON(url).done(function(json) {
	    salesVolume = json.salesVolume;//销量  
		bussinessVolume = json.bussinessVolume;//营业额  
		months = json.months;//月份  
		var option = {
				title : {
					text : 'ECharts 入门示例'
				},
				tooltip : {},
				legend : {
					data : [ '销量' ],
					data : [ '营业额' ]
				},
				xAxis : {
					data : months
				},
				yAxis : {},
				series : [ {
					name : '销量',
					type : 'bar',
					data : salesVolume
				}, {
					name : '营业额',
					type : 'line',
					data : bussinessVolume
				} ],
				toolbox : {
					show : true,
					feature : {
						mark : {
							show : true
						},
						dataView : {
							show : true,
							readOnly : false
						},
						magicType : {
							show : true,
							type : [ 'line', 'bar' ]
						},
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
			}
			myChart.setOption(option);
 })
</script>
</body>
</html>