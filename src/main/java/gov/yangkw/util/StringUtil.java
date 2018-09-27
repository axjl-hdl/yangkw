package gov.yangkw.util;

public class StringUtil {
	
	public static boolean isNotEmpty(Object str){
		if (str==null||str=="") {
			return false;
		}
		return true;
	}
	
	public static Object nullToEmpty(Object str){
		if(str==null){
			return "";
		}
		return str;
	}
	
	public static Object emptyToNull(Object str){
		if (str=="") {
			return null;
		}
		return str;
	}
}
