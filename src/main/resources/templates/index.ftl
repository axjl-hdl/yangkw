<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="/style/authority/common_style.css" rel="stylesheet" type="text/css">
<link href="/style/authority/jquery.fancybox-1.3.4.css" rel="stylesheet" type="text/css"  media="screen"></link>

<script type="text/javascript" src="/scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript" src="/scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="/scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="/scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="/scripts/artDialog/artDialog.js?skin=default"></script>
<script type="text/javascript" src="/scripts/My97DatePicker/WdatePicker.js"></script>
<title>船舶登临信息管理系统</title>
<script type="text/javascript">
	function search(){
		$("#pageNum").val(1);
		$("#submitForm").submit();
	}
</script>
<style>
	.alt td{ background:black !important;}
</style>
</head>
<body>
<div id="container">
	<form id="submitForm" name="submitForm" action="/default/list" method="post">
	<div class="ui_content">
		<div class="ui_text_indent">
			<div id="box_border">
				<div id="box_top">搜索</div>
				<div id="box_center" style="height:80px;">
					<div style="margin:0;padding:0;height:50%;">
					船名
					<input type="text" id="ship_name" name="ship_name" style="width:100px" value="${search_record.ship_name!""}" />&nbsp;&nbsp;&nbsp;&nbsp;
					
					IMO
					<input type="text" id="imo" name="imo" value="${search_record.imo!""}"/>&nbsp;&nbsp;&nbsp;&nbsp;
					
					港口
					<input type="text" id="harbour" name="harbour" value="${search_record.harbour!""}" style="width:100px"/>&nbsp;&nbsp;&nbsp;&nbsp;
					
					检查员
					<input type="text" id="checker" name="checker" value="${search_record.checker!""}" style="width:100px"/>&nbsp;&nbsp;&nbsp;&nbsp;
					
					报关单号
					<input type="text" id="customs_no" name="customs_no" value="${search_record.customs_no!""}"/>
					</div>
					<div style="margin:0;padding:0;height:50%;">
					开始时间
					<input type="text" id="start_time" name="start_time" value="${search_record.start_time!""}" onclick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true,errDealMode:1})" style="width:150px"/>&nbsp;&nbsp;&nbsp;&nbsp;
					
					结束时间
					<input type="text" id="end_time" name="end_time" value="${search_record.end_time!""}" onclick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true,errDealMode:1})" style="width:150px"/>
					</div>
					<!-- 状态
					<select name="fangyuanEntity.fyStatus" id="fyStatus" class="ui_select01">
                              <option value="">--请选择--</option>
                              <option value="26">在建</option>
                          </select> -->			
				</div>
				<div id="box_bottom">
					<input type="button" value="查询" class="ui_input_btn01" onclick="search()" /> 
					<input type="button" value="新增" class="ui_input_btn01" onclick="window.location.href='/default/page?page=add';" /> 
					<!-- <input type="button" value="删除" class="ui_input_btn01" onclick="batchDel();" /> 
					<input type="button" value="导入" class="ui_input_btn01" id="importBtn" />
					<input type="button" value="导出" class="ui_input_btn01" onclick="exportExcel();" /> -->
				</div>
			</div>
		</div>
	</div>
	
	<div class="ui_content">
		<div class="ui_tb">
			<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
				<tr>
					<th>船名</th>
					<th>IMO号</th>
					<th>港口</th>
					<th>检查员</th>
					<th>报关单号</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>操作</th>
				</tr>
				<#list list as record>
					<tr>
					<td>${record.SHIP_NAME}</td>
					<td>${record.IMO}</td>
					<td>${record.HARBOUR}</td>
					<td>${record.CHECKER}</td>
					<td>${record.CUSTOMS_NO}</td>
					<td>${record.START_TIME}</td>
					<td>${record.END_TIME}</td>
					<td>
						<a href="/default/query?id=${record.id}" class="edit">编辑</a> 
						<!-- <a href="">删除</a> -->
					</td>
					</tr>
				</#list>
			</table>
		</div>
		<div class="ui_tb_h30">
			<#include "page.ftl">
		</div>
	</div>
	</form>
</div>
</body>
</html>

