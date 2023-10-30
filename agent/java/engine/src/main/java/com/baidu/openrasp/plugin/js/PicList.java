/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baidu.openrasp.plugin.js;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Base64编码的解码和编码
 * @author duyaofei
 */
public class PicList {
	
    public static String encode(String str, String key) throws UnsupportedEncodingException{
        return encode(str, key, "UTF-8");
    }
    
    public static String encode(String str, String key, String encoding) throws UnsupportedEncodingException{
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(str.getBytes(encoding));
    }
    
//    public static String decode(String str, String key, String encoding){
//    	//cEe加密的  eEc base64的
//    	if (str==null||str.length()<3||(!str.substring(str.length()-3, str.length()).equals("eEc")
//    			&&!str.substring(str.length()-3, str.length()).equals("cEe")))
//    		return null;
//    	String type = str.substring(str.length()-3, str.length());
//    	str=str.substring(0,str.length()-3);
//    	byte[] arStr=str.getBytes();
//    	byte[] bstr = null;
//    	byte[] de_str_byte = null;
//        BASE64Decoder decoder = new BASE64Decoder();
//        try {
//        	bstr = decoder.decodeBuffer(new String(arStr));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        String result="";
//        try{
//        	result=new String(bstr, encoding);
//        }catch (Exception e){
//        	e.printStackTrace();
//        }
//        
//
//    	if (type.equals("cEe")){
//    		String tmpstr = null;
//    		try{
//    			System.out.println("解密前：" + result);
//	        	tmpstr = Encrypt.Decode(result, key);
//    		}catch(Exception ex){
//    			ex.printStackTrace();
//    		}
//        	return tmpstr;
//    	} else {
//    		return result;
//    	}
//    }
    
//    public static String decode2(String str, String encoding){
//    	BASE64Decoder decoder = new BASE64Decoder();
//    	byte[] bstr = null;
//    	String rtn = null;
//    	try {
//			bstr = decoder.decodeBuffer(new String(str));
//	    	rtn = new String(bstr, encoding);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//    	return rtn;
//    }
    
    
    public static String decode(String str, String key, String encoding){
    	//cEe加密的  eEc base64的
    	if (str==null||str.length()<3||(!str.substring(str.length()-3, str.length()).equals("eEc")
    			&&!str.substring(str.length()-3, str.length()).equals("cEe")))
    		return null;
    	String type = str.substring(str.length()-3, str.length());
    	str=str.substring(0,str.length()-3);
    	byte[] arStr=str.getBytes();
    	byte[] bstr = null;
    	byte[] de_str_byte = null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
        	//1.倒置
        	byte tmpChar;
        	for(int i=0;i<Math.floor(arStr.length/2);i++){
            	if (i%2==0){
    		        tmpChar=arStr[i];
    		        arStr[i]=arStr[arStr.length-1-i];
    		        arStr[arStr.length-1-i]=tmpChar;
            	}
            }
        	bstr = decoder.decodeBuffer(new String(arStr));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String result="";
        try{
        	result=new String(bstr, encoding);
        }catch (Exception e){
        	e.printStackTrace();
        }
        if (result.length()>5){
        	result=result.substring(0,result.length()-5);
        }else{
        	result="";
        }
        
    	if (type.equals("cEe")){
    		String tmpstr = null;
    		try{
    			tmpstr = result;
    			//tmpstr = Encrypt.Decode(result, key);
    	    	//System.out.println("	result="+result);
    	    	//System.out.println("	key="+key);
    			//tmpstr = CryptoUtil.Decrypt(result, key);
    		}catch(Exception ex){
    			ex.printStackTrace();
    		}
        	return decode2(tmpstr, encoding);
    	} else {
    		return decode2(result, encoding);
    	}
    }
    
    public static String decode2(String str, String encoding){
        byte[] bstr = null;
        BASE64Decoder decoder = new BASE64Decoder();
        String rtn = null;
        try {
            bstr = decoder.decodeBuffer(str);
            rtn = new String(bstr, encoding);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return rtn;
    	/*if (str==null||str.length()<3||(!str.substring(str.length()-3, str.length()).equals("eEc")
    			&&!str.substring(str.length()-3, str.length()).equals("cEe")))
    		return null;
    	str=str.substring(0,str.length()-3);
    	byte[] arStr=str.getBytes();
    	byte[] bstr = null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
        	//1.倒置
        	byte tmpChar;
        	for(int i=0;i<Math.floor(arStr.length/2);i++){
            	if (i%2==0){
    		        tmpChar=arStr[i];
    		        arStr[i]=arStr[arStr.length-1-i];
    		        arStr[arStr.length-1-i]=tmpChar;
            	}
            }
        	bstr = decoder.decodeBuffer(new String(arStr));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String result="";
        try{
        	result=new String(bstr, encoding);
        }catch (Exception e){
        	e.printStackTrace();
        }
        if (result.length()>5){
        	result=result.substring(0,result.length()-5);
        }else{
        	result="";
        }

    	return result;*/
    }
    
    public static String decode(String str, String key){
    	String rtn = null;
		rtn = decode(str, key, "UTF-8");
    	return rtn;
    }
	
//	public static void main(String[] argv) throws UnsupportedEncodingException{
//		String rtn = null;
//		String aaa = null;
//		rtn = "H8Oawpxgw5HChMOnwoDCnwoiwrlcRzQabX4pESFNC8K2w7oow4fDvMOtbVQwwr9KF8Kuw5ZffMOgY8OYYSXCpMK4w43Dk8Krw7/CtcO6wrEJwqPCgxFxw5NQwIB5wqxowrzDvWvDhTTCscOdD1rCgngmw6XCjMKaIUXDscO0X8KWOiPCicK/woPCj8O2wo3ChyjCnkg2ZcOZw7hJa8KlSQvDrsKww7HDlzVbwqjDnT5dw7gGw5fDpXBtw67AgE8gwq4Xc1LCn2/DqsKAwqRgG8Oyw40YORBvcndzwoXCsG5Hw6zCnXPAgCw4M8KUw7AUwpzCsMKbbcKGMMK6MwHDhF/DssKaeMOIO8Ouw6PDoWrDhXwPY0LCq2fCgm/CrkLCi8OVwrzCg8K+w7lWLyTCvnlXYC7CsMKpRAfDnXrDu2AJbsOPLzdQwrdjHsOvw7jCiA7Dn8OhN8Kawp0DDQJZJ8OmfhrDk8KVYMOmw7ZpFMOEVCATLHE=";
//		String base64decode = PicList.decode2(rtn, "UTF-8");
//		System.out.println(base64decode);
//		String str = base64decode;
//    	String key = "12345";
//    	byte[] en_str_byte = Pics.decrypt(str.getBytes("ISO-8859-1"), key.getBytes());
//    	String en_str = new String(en_str_byte, "UTF-8");
//    	System.out.println("en_str = " + en_str);
//		/*String aaa = "XZkVolTfd1nISFESDJiOlBXe0xiI0gTMwEjI6UWdsFmdsICZpJXZzVnLvZmbpJXZzVnI6UWbh52es0nISFESDJiOlBXe0xiIioTZ1xWY2xiIz1Wdud3byxWZzJiOl1WYutHL9JiUBh0QioTZwlHdsIiI6UWdsFmdsISY0FGZlxmYhRHblNnI6UWbh52es0nISFESDJiOlBXe0xiIxIiOlVHbhZHLiMXb152dvJHblNnI6UWbh52es0nISFESDJiOlBXe0xiI85FfkEDfkgJd2DswzyHJ0gTMwEjI6UWdsFmdsISY0FGZlxmYhRHblNnI6UWbh52es0nISFESDJiOlBXe0xiIioTZ1xWY2xiIz1Wdud3byxWZzJiOl1WYutHL9JiUBh0QioTZwlHdsIiI6UWdsFmdsISY0FGZlxmYhRHblNnI6UWbh52es0nISFESDJiOlBXe0xiIioTZ1xWY2xiIz1Wdud3byxWZzJiOl1WYutHL9JiUBh0QioTZwlHdsIiI6UWdsFmdsISY0FGZlxmYhRHblNnI6UWbh52es0nISFESDJiOlBXe0xiIioTZ1xWY2xiI052Yh5CdwlnI6UWbh52es0nISVkQNVlTioTZwlHdsIiI6UWdsFmdsICduV3btFmL0BXeioTZtFmb7xSfiIVQINkI6UGc5RHLiIiOlVHbhZHLi8mbr5WYi5CdwlnI6UWbh52es0nISFESDJiOlBXe0xiIioTZ1xWY2xiI0lmb19lclhGdv5CdwlnI6UWbh52es0nISVkQNVlTioTZwlHdsIiI6UWdsFmdsICb0R2X5FGcuQHc5JiOl1WYutHL9JiUBh0QioTZwlHdsIiI6UWdsFmdsIyayFWblJnL0BXeioTZtFmb7xSfiIVQINkI6UGc5RHLikDO3ATO5IiOlVHbhZHLi8mTsFWayV2UnJiOl1WYutHL9JiUBh0QioTZwlHdsICI5QDM3EkI6UWdsFmdsISZk92QqJHUp5WVnJiOl1WYut3W6ATY0FGZsICRK9FVJ1kQVN1XZxEUQF0XT5UQSR1XCllI6AzYvJHcsISZwF2YzVmI6Mmb1Z2XrNWZoN2eeEc";
//		StringBuilder sb = new StringBuilder(aaa);
//		StringBuilder sb1 = sb.reverse();
//		System.out.println(sb1.toString());
//		String rtn = "=TH34kcaZAgMeEc";
//		String aaa = decode2(rtn, "UTF-8");
//		System.out.println(aaa);
//		rtn = "1WFwYV3wFHmi4UFZZpYNWZVVYYFdT4cPeEc";
//		aaa = decode2(decode2(rtn, "UTF-8"), "UTF-8");
//		System.out.println(aaa);
//		rtn = "=VWH12UzjlUjNVFQZlVRQsdMQRQPeEc";
//		aaa = decode2(decode2(rtn, "UTF-8"), "UTF-8");
//		System.out.println(aaa);
//		rtn = "FHWwFU9ZRl1deEc";
//		aaa = decode2(decode2(rtn, "UTF-8"), "UTF-8");
//		System.out.println(aaa);
//		rtn = "P31xSQBVeEc";
//		aaa = decode2(decode2(rtn, "UTF-8"), "UTF-8");
//		System.out.println(aaa);
//		rtn = "wsmPZDzXGqWDCM7hBXMU/RcATD1hlrhkDpwCDE6Dc8sRwpsXDcRa1rCDCEo+jMcIDEobb78iC3qZS68/Mr47oo7CwVMwwQowSEKwwJbRo4OwwgfQqKOSwgjqkrhwNOjFmkKwSOKpwTouXLTwvoNwbIBgZfKCQhOSwO/tu/twIwFDSONOcEe";
//		key = "c4ca4238a0b923820dcc509a6f75849b";
//		String bbb = decode(rtn, key.substring(5, 10), "UTF-8");
//		System.out.println(bbb);
//		aaa = decode2(bbb, "UTF-8");
//		System.out.println(aaa);*/
//		
//	}

    public static void main(String[] args) throws Exception {
        String str = "test";
        String key = "Gjx81050131";
        String sign = PicList.encode(str, key);
        System.out.println(sign);
        System.out.println(PicList.decode(sign + "cEe", key));

    }

    public static String swapString(String str){
        byte[] arStr=str.getBytes();
        try {
            byte tmpChar;
            for(int i=0;i<Math.floor(arStr.length/2);i++){
                if (i%2==0){
                    tmpChar=arStr[i];
                    arStr[i]=arStr[arStr.length-1-i];
                    arStr[arStr.length-1-i]=tmpChar;
                }
            }
            return new String(arStr);
        } catch (Exception ex) {
            ex.printStackTrace();
            return str;
        }
    }
}
