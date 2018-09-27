package gov.yangkw.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;

import gov.yangkw.service.DefaultService;
import gov.yangkw.util.Encrypt;
import gov.yangkw.util.Page;
import gov.yangkw.util.StringUtil;

@RestController
@RequestMapping("/default")
public class DefaultController {
	@Autowired
	private DefaultService defaultService;
	
	public static ModelAndView mv = new ModelAndView();
	
	@RequestMapping(value="/")
	public ModelAndView index(){
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView checkRecordList(HttpServletRequest request){
		mv.clear();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ship_name", StringUtil.emptyToNull(request.getParameter("ship_name")));
		map.put("imo", StringUtil.emptyToNull(request.getParameter("imo")));
		map.put("harbour", StringUtil.emptyToNull(request.getParameter("harbour")));
		map.put("checker", StringUtil.emptyToNull(request.getParameter("checker")));
		map.put("customs_no", StringUtil.emptyToNull(request.getParameter("customs_no")));
		map.put("start_time", StringUtil.emptyToNull(request.getParameter("start_time")));
		map.put("end_time", StringUtil.emptyToNull(request.getParameter("end_time")));
		
		long count = PageHelper.count(()->defaultService.checkRecord(map));
		Page page = new Page(Page.toInt(request.getParameter("pageNum")), Page.toInt(request.getParameter("pageSize")), (int)count);
		
		PageHelper.startPage(page.getPageNum(),page.getPageSize());
		List<Map<String, Object>> list = defaultService.checkRecord(map);
		mv.setViewName("index");
		mv.addObject("list", list);	
		mv.addObject("search_record", map);
		mv.addObject("page", page);
		return mv;
	}
	
	@RequestMapping(value="/page")
	public ModelAndView targetPage(String page){
		mv.clear();
		mv.setViewName(page);
		return mv;
	}
	
	@RequestMapping(value="/add")
	public String addRecord(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ship_name", request.getParameter("ship_name"));
		map.put("imo", request.getParameter("imo"));
		map.put("harbour", request.getParameter("harbour"));
		map.put("checker", request.getParameter("checker"));
		map.put("customs_no", request.getParameter("customs_no"));
		map.put("start_time", request.getParameter("start_time"));
		map.put("end_time", request.getParameter("end_time"));
		map.put("check_report", URLEncoder.encode(StringUtil.nullToEmpty(request.getParameter("check_report")).toString(), "UTF-8"));
		defaultService.addRecord(map);
		return "1";		
	}

	@RequestMapping(value="/query")
	public ModelAndView queryRecord(String id){
		mv.clear();
		Map<String, Object> record = defaultService.queryRecord(id);
		System.out.println(record);
		mv.setViewName("edit");
		mv.addObject("record", record);
		mv.addObject("decode", new Encrypt());
		return mv;
	}
	
	@RequestMapping(value="/update")
	public String updateRecord(HttpServletRequest request) throws UnsupportedEncodingException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", request.getParameter("id"));
		map.put("ship_name", request.getParameter("ship_name"));
		map.put("imo", request.getParameter("imo"));
		map.put("harbour", request.getParameter("harbour"));
		map.put("checker", request.getParameter("checker"));
		map.put("customs_no", request.getParameter("customs_no"));
		map.put("start_time", request.getParameter("start_time"));
		map.put("end_time", request.getParameter("end_time"));
		map.put("check_report", URLEncoder.encode(StringUtil.nullToEmpty(request.getParameter("check_report")).toString(), "UTF-8"));
		System.out.println(map);
		defaultService.updateRecord(map);
		return "1";
	}
}
