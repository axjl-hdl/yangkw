package gov.yangkw;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Test {
	
	private static class BigObject{
		byte[] bytes = new byte[1024*1024];
	}
	
	private static void keepInMemory(){
		List<BigObject> memList = new ArrayList<BigObject>();

        for(int i = 0; i < 55;i ++) {
            memList.add(new BigObject());
        }

	}
	
	public static void main(String[] args) {
		keepInMemory();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.gc();
	}

}
