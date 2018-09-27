<!-- <div class="ui_flt" style="height: 30px; line-height: 30px;">
	
</div> -->
<div class="ui_frt">
	<input type="hidden" id="pageNum" name="pageNum" value="${page.pageNum}">
	<input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}">
	共${page.count}条&nbsp;
	当前第<span class="ui_txt_bold04">${page.pageNum}/${page.pageCount}</span>页
	<!--    如果是第一页，则只显示下一页、尾页 -->					
	<input type="button" value="首页" class="ui_input_btn01" onclick="pageTarget(1)"/>
	<input type="button" value="上一页" class="ui_input_btn01" onclick="pageTarget(${page.pageNum - 1})"/>
	<input type="button" value="下一页" class="ui_input_btn01" onclick="pageTarget(${page.pageNum + 1})" />
	<input type="button" value="尾页" class="ui_input_btn01" onclick="pageTarget(${page.pageCount})" />
				
	<!--     如果是最后一页，则只显示首页、上一页 -->
	转到第<input type="text" id="jumpNumTxt" class="ui_input_txt01" />
	页<input type="button" class="ui_input_btn01" value="跳转" onclick="pageTarget($('#jumpNumTxt').val())" />
</div>
<script>
	function pageTarget(pageNum){
		var pageCount = ${page.pageCount};
		if(pageNum < 1){
			pageNum = 1;
		} 
		if(pageNum > pageCount){
			pageNum = pageCount;
		} 
		$("#pageNum").val(pageNum); 
		$("#submitForm").submit();
	}
</script>