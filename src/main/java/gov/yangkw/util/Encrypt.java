package gov.yangkw.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class Encrypt implements TemplateMethodModelEx{

	@Override
	public Object exec(List list) throws TemplateModelException {
		if (list.size()>0 || list.get(0)!=null || list.get(0)!="") {
			String str = list.get(0).toString();
			try {
				return URLDecoder.decode(str, "UTF-8");
			} catch (UnsupportedEncodingException e){
				e.printStackTrace();
			}
		}
		return null;
	}

}
