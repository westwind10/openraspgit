package com.baidu.openrasp.plugin.js;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
/*
import wingsoft.core.sysdef.WinMenuNodeDef;
import wingsoft.tool.common.CommonOperation;
import wingsoft.tool.common.MyMD5;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.ActionInvocation;
import org.apache.tomcat.util.codec.binary.Base64;
 */

public class WFInterceptor {
	
	private static final long serialVersionUID = -7507485512877886403L;
	private String picListShow(String inStr, String hashpwd){
		String key = hashpwd;
    	return PicList.decode(inStr, key);
// 切换加密和非加密的地方 ——上面加密，下面非加密。java代码中唯一一处。
//    	return inStr;
    }
	/*
	public String intercept(ActionInvocation invocation)throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();//
		HttpServletResponse response = ServletActionContext.getResponse();

		String userid = "";
		try {
			userid = (String) request.getSession().getAttribute("userId");
			if (userid == null) {
				System.out.println("userNotExistIlleagal");
				return "illeagal";
			}
		} catch (Exception e) {
			System.out.println("userNotExistIlleagal");
			return "illeagal";
		}


    	String actionName = invocation.getInvocationContext().getName();
		Enumeration paramNames = request.getParameterNames();
		String hashpwd = (String)request.getSession().getAttribute("hashpwd");

		boolean needCheckUser = false;

		List<String> paramNameList = new ArrayList<>();

		String funcno = "";
		String projid = "";

		while (paramNames.hasMoreElements()) {
	    	String paramName =(String) paramNames.nextElement();
	    	if(paramName != null && paramName.endsWith("eEc")){
	    		needCheckUser = true;
			}
        	//System.out.println("*--Before Decode Param. Name:" + paramName + " Value:" + request.getParameter(paramName));
        	String encryParamValue = request.getParameter(paramName);
        	String decryParamName = picListShow(paramName, hashpwd);
        	//System.out.println("*--decryParamName:"+decryParamName+" encryParamValue:" + encryParamValue);
//			String value = WFInterceptor.aesDecrypt(encryParamValue, "8NONwyJtHesysWpM");
//			String paramValue = "";
//			if(value == null){
//					paramValue = picListShow(encryParamValue, hashpwd);
//				}else{
//					paramValue = picListShow(value, hashpwd);
//			}
			String paramValue = picListShow(encryParamValue, hashpwd);

        	//System.out.println("*--After Decode Param. Value:" + paramValue + " key:" + hashpwd);
	        paramName=picListShow(paramName, hashpwd);

			//判断发起请求的用户，是否为后台session所存在的用户，判断前后端用户是否一致
			paramNameList.add(paramName);
//			if ("a".equals(paramName) && !request.getRequestURI().endsWith("loadRolesMenu.action")) {
//				if (!paramValue.equalsIgnoreCase(MyMD5.getMD5(userid.getBytes()))) {
//					System.out.println("paramValue:" + paramValue);
//					System.out.println("md5:" + MyMD5.getMD5(userid.getBytes()));
//					System.out.println("userid:" + userid);
//					System.out.println("userErrorIlleagal");
//					return "illeagal";
//				}
//			}

//			if (actionName.startsWith("commonQuery_doQuery")) {
//				Pattern p = Pattern.compile("(\\b(select|update|union|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|drop|execute)\\b)", Pattern.CASE_INSENSITIVE);
//				Matcher m = p.matcher(paramValue);
//				if (m.find()) {
//					System.out.println("sqlCheckIlleagal");
//					return "illeagal";
//				}
//			}

	        if (paramValue!=null){
				request.setAttribute(paramName, paramValue);
	        	//System.out.println("Read Param. Name:" + paramName + " Value:" + paramValue);
	        }

			if("funcno".equalsIgnoreCase(paramName) && CommonOperation.isEmpty(funcno)){
				funcno = paramValue;
			}
			if ("rawFuncno".equalsIgnoreCase(paramName)) {
				funcno = paramValue;
			}
			if("projectid".equalsIgnoreCase(paramName) || "projid".equalsIgnoreCase(paramName)){
				projid = paramValue;
			}
	    }

		if(!CommonOperation.isEmpty(funcno)){
			if(!WinMenuNodeDef.checkFuncAuthority(funcno, projid)){
				return "";
			}
		}

//		if (!paramNameList.contains("a")  && needCheckUser) {
//			System.out.println("userCheckIlleagal");
//			return "illeagal";
//		}


		Map se = invocation.getInvocationContext().getSession();
		if((se.get("userContextStr") != null) && (se.get("userId") !=null )){

			if (actionName.startsWith("fileSystem_")) {
				Enumeration paraNamesToBlock = request.getParameterNames();
				while (paraNamesToBlock.hasMoreElements()) {
					String paramName =(String) paraNamesToBlock.nextElement();
					String paramValue = request.getParameter(paramName);
					Pattern p = Pattern.compile("\\s('|and|exec|insert|select|delete|update|count|\\*|\\%|chr|mid|master|truncate|char|declare|dbms\\.|union|waitfor\\sdelay|;|or|-|\\+|,)\\s", Pattern.CASE_INSENSITIVE);
					Matcher m = p.matcher(paramValue);
					if (m.find()) {
						return "illeagal";
					}
				}
			}

			//给response加上content-type
			String result = invocation.invoke();

			return result;
		}else{
			System.out.println("noLoginIlleagal");
			return "illeagal";
		}
	}

	 */

	/**
	 * aes解密
	 * @param encrypt	内容
	 * @return
	 * @throws Exception
	 */
	public static String aesDecrypt(String encrypt) throws Exception {
		return aesDecrypt(encrypt, "8NONwyJtHesysWpM");
	}

	/*
	/**
	 * aes加密
	 * @param content
	 * @return
	 * @throws Exception

	public static String aesEncrypt(String content) throws Exception {
		return aesEncrypt(content, "8NONwyJtHesysWpM");
	}
	*/

	/**
	 * 将byte[]转为各种进制的字符串
	 * @param bytes byte[]
	 * @param radix 可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
	 * @return 转换后的字符串
	 */
	public static String binary(byte[] bytes, int radix){
		return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
	}

	/*
	/**
	 * base 64 encode
	 * @param bytes 待编码的byte[]
	 * @return 编码后的base 64 code

	public static String base64Encode(byte[] bytes){
		return Base64.encodeBase64String(bytes);
	}
	*/

	/**
	 * base 64 decode
	 * @param base64Code 待解码的base 64 code
	 * @return 解码后的byte[]
	 * @throws Exception
	 */
	public static byte[] base64Decode(String base64Code) throws Exception{
		return StringUtils.isEmpty(base64Code) ? null : new BASE64Decoder().decodeBuffer(base64Code);
	}


	/**
	 * AES加密
	 * @param content 待加密的内容
	 * @param encryptKey 加密密钥
	 * @return 加密后的byte[]
	 * @throws Exception
	 */
	public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));

		return cipher.doFinal(content.getBytes("utf-8"));
	}

	/*
	/**
	 * AES加密为base 64 code
	 * @param content 待加密的内容
	 * @param encryptKey 加密密钥
	 * @return 加密后的base 64 code
	 * @throws Exception

	public static String aesEncrypt(String content, String encryptKey) throws Exception {
		return base64Encode(aesEncryptToBytes(content, encryptKey));
	}
	*/

	/**
	 * AES解密
	 * @param encryptBytes 待解密的byte[]
	 * @param decryptKey 解密密钥
	 * @return 解密后的String
	 * @throws Exception
	 */
	public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128);

			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
			byte[] decryptBytes = cipher.doFinal(encryptBytes);
			return new String(decryptBytes);
		} catch (Exception e) {
			return null;
		}
	}


	/**
	 * 将base 64 code AES解密
	 * @param encryptStr 待解密的base 64 code
	 * @param decryptKey 解密密钥
	 * @return 解密后的string
	 * @throws Exception
	 */
	public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
		return StringUtils.isEmpty(encryptStr) ? null : aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
	}

	public static void main(String[] args) throws Exception {
		String key = "8NONwyJtHesysWpM";
		String src = "=VABC0XE3XoQe1FdVR=TeEc";//9561
		WFInterceptor wfInterceptor = new WFInterceptor();
		System.out.println(wfInterceptor.picListShow(src, key));


	}
}
