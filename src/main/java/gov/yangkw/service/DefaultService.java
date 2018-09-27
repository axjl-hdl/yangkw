package gov.yangkw.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.yangkw.map.DefaultMapper;

@Service
public class DefaultService {
	
	@Autowired
	private DefaultMapper defaultMapper;
	
	public List<Map<String, Object>> checkRecord(Map<String, Object> map){
		return defaultMapper.checkRecord(map);
	}
	
	public Map<String, Object> queryRecord(String id){
		return defaultMapper.queryRecord(id);
	}
	
	public void addRecord(Map<String, Object> map){
		defaultMapper.addRecord(map);
	}
	
	public void updateRecord(Map<String, Object> map){
		defaultMapper.updateRecord(map);
	}
}
