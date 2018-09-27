package gov.yangkw.map;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import gov.yangkw.util.StringUtil;

public interface DefaultMapper {
	
/*	+ "<script>select * from check_record where 1=1" 
 			+ "<if test='#{ship_name} != null'>and SHIP_NAME LIKE CONCAT('%',#{ship_name},'%') </if>"
			+ "<if test='#{imo} != null'>and IMO = #{imo} </if>"
			+ "<if test='#{harbour} != null'>and HARBOUR = #{harbour} </if>"
			+ "<if test='#{checker} != null'>and CHECKER = #{checker} </if>"
			+ "<if test='#{customs_no} != null'>and CUSTOMS_NO = #{customs_no} </if>"
			+ "<if test='#{start_time} != null '>and START_TIME &gt;= #{start_time} </if>"
			+ "<if test='#{end_time} != null '>and END_TIME &lt;= #{end_time} </if></script>"*/
	
	//@Select("SELECT * FROM check_record ")
	@SelectProvider(type=DefaultProvider.class, method="checkRecord")
	public List<Map<String, Object>> checkRecord(Map<String, Object> map);
	
	@Select("SELECT * FROM check_record WHERE id = #{id}")
	public Map<String, Object> queryRecord(String id);
	
	@Insert("INSERT INTO check_record (SHIP_NAME,IMO,HARBOUR,CHECKER,CUSTOMS_NO,START_TIME,END_TIME,CHECK_REPORT) VALUES(#{ship_name},#{imo},#{harbour},#{checker},#{customs_no},#{start_time},#{end_time},#{check_report})")
	public void addRecord(Map<String, Object> map);
	
	@Update("UPDATE check_record SET SHIP_NAME=#{ship_name}, IMO=#{imo}, HARBOUR= #{harbour}, CHECKER=#{checker}, CUSTOMS_NO=#{customs_no}, START_TIME=#{start_time}, END_TIME=#{end_time}, CHECK_REPORT=#{check_report} WHERE id = #{id}")
	public void updateRecord(Map<String, Object> map);
	
	class DefaultProvider{
		public String checkRecord(Map<String, Object> map){
			StringBuilder sql = new StringBuilder("SELECT * FROM check_record WHERE 1=1 ");
			if(StringUtil.isNotEmpty(map.get("ship_name"))){
				sql.append(" and SHIP_NAME LIKE CONCAT('%',#{ship_name},'%') ");
			}
			if (StringUtil.isNotEmpty(map.get("imo"))) {
				sql.append(" and IMO = #{imo} ");
			}
			if(StringUtil.isNotEmpty(map.get("harbour"))){
				sql.append(" and HARBOUR = #{harbour} ");
			}
			if(StringUtil.isNotEmpty(map.get("checker"))){
				sql.append(" and CHECKER = #{checker} ");
			}
			if(StringUtil.isNotEmpty(map.get("customs_no"))){
				sql.append(" and CUSTOMS_NO = #{customs_no} ");
			}
			if(StringUtil.isNotEmpty(map.get("start_time"))){
				sql.append(" and START_TIME >= #{start_time} ");
			}
			if(StringUtil.isNotEmpty(map.get("end_time"))){
				sql.append(" and END_TIME <= #{end_time} ");
			}
			return sql.toString();
		}
	}
}
