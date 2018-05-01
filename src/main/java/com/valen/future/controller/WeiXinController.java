package com.valen.future.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.valen.future.service.WechatService;



@Controller
@RequestMapping("/weixin")
public class WeiXinController {
	
    //WeiXinHandler为内部类不能使用非final类型的对象  
    final String TOKEN="sharetime";  

    //final HttpServletRequest final_request = null;   
    //final HttpServletResponse final_response = null; 
    
    @Autowired
    WechatService wechatService;
    
    
	@RequestMapping(path="/valid",method=RequestMethod.GET)
	public void Valid(HttpServletRequest request, HttpServletResponse response ) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		//ModelAndView mav = new ModelAndView();
	  
        String echostr=request.getParameter("echostr");  
        if(null==echostr||echostr.isEmpty()){  
            responseMsg(request,response);  
        }else{  
            if(this.checkSignature(request)){  
                this.print(response,echostr);  
            }else{  
                this.print(response,"error");                                                                                                                                                                                                                                                                                                                                           
            }  
        }  
		
		
		//mav.setViewName("weixin/validresult");
		
		//return mav;
	}
	
    //自动回复内容  
    public void responseMsg(HttpServletRequest request,HttpServletResponse response ){  
        String postStr=null;  
        try{  
            postStr=this.readStreamParameter(request.getInputStream());  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        //System.out.println(postStr);  
        if (null!=postStr&&!postStr.isEmpty()){  
            Document document=null;  
            try{  
                document = DocumentHelper.parseText(postStr);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            if(null==document){  
                this.print(response,"");  
                return;  
            }  
            Element root=document.getRootElement();  
            String fromUsername = root.elementText("FromUserName");  
            String toUsername = root.elementText("ToUserName");  
            String keyword = root.elementTextTrim("Content");  
            String time = new Date().getTime()+"";  
            String textTpl = "<xml>"+  
                        "<ToUserName><![CDATA[%1$s]]></ToUserName>"+  
                        "<FromUserName><![CDATA[%2$s]]></FromUserName>"+  
                        "<CreateTime>%3$s</CreateTime>"+  
                        "<MsgType><![CDATA[%4$s]]></MsgType>"+  
                        "<Content><![CDATA[%5$s]]></Content>"+  
                        "<FuncFlag>0</FuncFlag>"+  
                        "</xml>";               
              
            if(null!=keyword&&!keyword.equals(""))  
            {  
                String msgType = "text";  
                String contentStr = "Welcome to wechat world!";  
                String resultStr = textTpl.format(textTpl, fromUsername, toUsername, time, msgType, contentStr);  
                this.print(response,resultStr);  
            }else{  
                this.print(response,"Input something...");  
            }  
  
        }else {  
            this.print(response,"no message");  
        }  
    }  
    //微信接口验证  
    public boolean checkSignature(HttpServletRequest request){  
        String signature = request.getParameter("signature");  
        String timestamp = request.getParameter("timestamp");  
        String nonce = request.getParameter("nonce");  
        String token=TOKEN;  
        String[] tmpArr={token,timestamp,nonce};  
        Arrays.sort(tmpArr);  
        String tmpStr=this.ArrayToString(tmpArr);  
        tmpStr=this.SHA1Encode(tmpStr);  
        if(tmpStr.equalsIgnoreCase(signature)){  
            return true;  
        }else{  
            return false;  
        }  
    }  
    //向请求端发送返回数据  
    public void print(HttpServletResponse response,String content){  
        try{  
        	response.getWriter().print(content);  
        	response.getWriter().flush();  
        	response.getWriter().close();  
        }catch(Exception e){  
              
        }  
    }  
    //数组转字符串  
    public String ArrayToString(String [] arr){  
        StringBuffer bf = new StringBuffer();  
        for(int i = 0; i < arr.length; i++){  
         bf.append(arr[i]);  
        }  
        return bf.toString();  
    }  
    //sha1加密  
    public String SHA1Encode(String sourceString) {  
        String resultString = null;  
        try {  
           resultString = new String(sourceString);  
           MessageDigest md = MessageDigest.getInstance("SHA-1");  
           resultString = byte2hexString(md.digest(resultString.getBytes()));  
        } catch (Exception ex) {  
        }  
        return resultString;  
    }  
    public final String byte2hexString(byte[] bytes) {  
        StringBuffer buf = new StringBuffer(bytes.length * 2);  
        for (int i = 0; i < bytes.length; i++) {  
            if (((int) bytes[i] & 0xff) < 0x10) {  
                buf.append("0");  
            }  
            buf.append(Long.toString((int) bytes[i] & 0xff, 16));  
        }  
        return buf.toString().toUpperCase();  
    }  
    //从输入流读取post参数  
    public String readStreamParameter(ServletInputStream in){  
        StringBuilder buffer = new StringBuilder();  
        BufferedReader reader=null;  
        try{  
            reader = new BufferedReader(new InputStreamReader(in));  
            String line=null;  
            while((line = reader.readLine())!=null){  
                buffer.append(line);  
            }  
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            if(null!=reader){  
                try {  
                    reader.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return buffer.toString();  
    }  
   
    /**
     * 接收来自微信发来的消息
     * 
     * @param out
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(path="/valid", method = RequestMethod.POST)
    public void wechatServicePost(PrintWriter out, HttpServletRequest request, HttpServletResponse response) {
        String responseMessage = wechatService.processRequest(request);
        out.print(responseMessage);
        out.flush();
    }    

    
    /**
     * 将xml转化为Map集合
     * 
     * @param request
     * @return
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        InputStream ins = null;
        try {
            ins = request.getInputStream();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Document doc = null;
        try {
            doc = reader.read(ins);
        } catch (DocumentException e1) {
            e1.printStackTrace();
        }
        Element root = doc.getRootElement();
        @SuppressWarnings("unchecked")
        List<Element> list = root.elements();
        for (Element e : list) {
            map.put(e.getName(), e.getText());
        }
        try {
            ins.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return map;
    }    
}
