package gov.yangkw.util;

public class Page {
	public int pageNum; //页码
	public int pageSize; //页面大小
	public int count; //总条数
	public int pageCount; //总页数
	
	public Page(int pageNum, int pageSize, int count){
		pageSize = pageSize==1 ? 3 : pageSize;
		
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.count = count;
		this.pageCount = (count%pageSize) > 0 ? count/pageSize+1 : count/pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public static int toInt(String obj){
		if (obj==null || obj=="") {
			return 1;
		}
		return Integer.parseInt(obj);
	}
	
}
