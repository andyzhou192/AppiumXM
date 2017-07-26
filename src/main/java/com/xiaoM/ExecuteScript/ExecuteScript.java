package com.xiaoM.ExecuteScript;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ExecuteScript  {
	public AppiumDriver <MobileElement> driver;
	public String[]  datas = null;

	public  ExecuteScript(){
	}

	public  ExecuteScript(AppiumDriver <MobileElement> driver) {
		this.driver = driver;
	}
	/**
	 * 执行指定的方法
	 * @param MethodName 方法名
	 * @param data 指定参数
	 */
	public void doRun(String MethodName){
		try {
			Class< ? > run = Class.forName("com.xiaoM.ExecuteScript.ExecuteScript");	 
			Object x = run.newInstance(); 
			if(MethodName.contains("(")){  
				Pattern p = Pattern.compile("(?<=\\()(.+?)(?=\\))"); 
				Matcher m = p.matcher(MethodName); 
				String data = null;
				while(m.find()) { 
					data = m.group().replace("\"", "");
				}
				if(data.contains(",")){
					Object[] args = data.split(",");
					@SuppressWarnings("rawtypes")
					Class[] argsClass = new Class[args.length];      
					for (int i = 0, j = args.length; i < j; i++) {      
						argsClass[i] = args[i].getClass();                 
					}      
					Method method = run.getMethod(MethodName.split("\\(")[0],argsClass);
					method.invoke(x,args);	
				}else{
					Method method = run.getMethod(MethodName.split("\\(")[0],String.class);
					method.invoke(x,data);
				}	
			}else{
				Method method = run.getMethod(MethodName);
				method.invoke(x);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {	
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}

//	public void iosDemo(){
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		HashMap<String, String> scrollObject = new HashMap<String, String>();
//		scrollObject.put("direction", "down");
//		js.executeScript("mobile: scroll", scrollObject);
//
//	}
//	@SuppressWarnings("deprecation")
//	public void  iosDemo2(){
//		driver.tap(1, 8, 349, 1000);//坐标点击
//	}
	
	public void DemoNoArgs(){
		System.out.println("无参数方法加载");	
	}
	public void DemoOneArgs(String a){	
		System.out.println("只有一个参数："+ a);
	}
	public void DemoTwoArgs(String a,String b){
		System.out.println("第一个参数："+a);	
		System.out.println("第一个参数："+b);	
	}
	
	public static void main(String[] args) {
		ExecuteScript a = new ExecuteScript();
		a.doRun("DemoNoArgs");
		a.doRun("DemoOneArgs(\"This is args one\")");
		a.doRun("DemoTwoArgs(\"参数1\",\"参数2\")");
	}
}
