<!DOCTYPE html>
<html>
<head>
<title>船舶登临信息管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style>
	table{
		border-width: 1px;
		border-color: #D3D3D3;
 	    border-collapse: collapse;
	}
	tr{
		height:35px;
	}
</style>
<script type="text/javascript" src="/scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript" src="/scripts/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function update(tar){
		var id = $("#id").val();
		var ship_name = $("#ship_name").val();
		var imo = $("#imo").val();
		var harbour = $("#harbour").val();
		var checker = $("#checker").val();
		var customs_no = $("#customs_no").val();
		var start_time = $("#start_time").val();
		var end_time = $("#end_time").val();
		var req = "/default/add";
		
		if(tar == 1) req = "/default/update";
		
		$.ajax({
			url:req,
			data:{"id":id,"ship_name":ship_name,"imo":imo,"harbour":harbour,"checker":checker,"customs_no":customs_no,"start_time":start_time,"end_time":end_time},
			type:"post",
			success:function(str){
				if(str=="1"){
					alert("提交成功");
					window.location.href="/default/list";
					//$('#submitForm')[0].reset();
				}else{
					alert(str);
				}
			}
		});
	}
</script>
</head>
<body style="font-size:12px;font-family:'微软雅黑';">
	<form id="submitForm" name="submitForm" action="#" method="post">
		<input type="hidden" id="id" name="id" value="${record.id}" >
		<table border="1">
			<tr style="background-color: #AFEEEE;">
				<td>船名</td>
				<td><input type="text" id="ship_name" value=${record.SHIP_NAME} ></td>
				<td>&nbsp;&nbsp;IMO</td>
				<td><input type="text" id="imo" value=${record.IMO} ></td>
			</tr>
			
			<tr style="background-color: #F5F5DC;">
				<td>港口</td>
				<td><input type="text" id="harbour" value=${record.HARBOUR} ></td>
				<td>&nbsp;&nbsp;检查员</td>
				<td><input type="text" id="checker" value=${record.CHECKER} ></td>
			</tr>
			
			<tr style="background-color: #AFEEEE;">
				<td>报关单号</td>
				<td colspan="3"><input type="text" id="customs_no" value=${record.CUSTOMS_NO}></td>
			</tr>
			
			<tr style="background-color: #F5F5DC;">
				<td>开始时间</td>
				<td><input type="text" id="start_time" value="${record.START_TIME}" onclick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true,errDealMode:1})"/></td>
				<td>&nbsp;&nbsp;结束时间</td>
				<td><input type="text" id="end_time" value="${record.END_TIME}" onclick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true,errDealMode:1})"/></td>
			</tr>
			<tr style="background-color: #AFEEEE;">
				<td>检查经过及情况</td>
				<td colspan="3">
				<textarea style="width:98%;height:200px;" id="check_report" name="check_report" maxlength="2000" wrap="hard" rows="2" cols="50">
				<#if record.CHECK_REPORT?exists>
				${decode(record.CHECK_REPORT)}
				</#if>
				
				</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
				<input type="button" value="返回" onclick="window.location.href='/default/list';"/>
				<input type="reset" value="重置" id="reset_btn"/>
				<#if record?exists>
				<input type="button" value="提交" onclick="update(1)" />
				<#else>
				<input type="button" value="提交" onclick="update(0)"/>
				</#if>
				</td>
			</tr>		
		</table>
	</form>
</body>
</html>