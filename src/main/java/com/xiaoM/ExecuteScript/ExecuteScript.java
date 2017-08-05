package com.xiaoM.ExecuteScript;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
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
			Class< ? extends ExecuteScript> run = this.getClass();
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
					run.getMethod(MethodName.split("\\(")[0],argsClass).invoke(this,args);	
				}else{
					run.getMethod(MethodName.split("\\(")[0],String.class).invoke(this,data);
				}	
			}else{
				run.getMethod(MethodName).invoke(this);
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
		}
	}

//	public void iosDemo(){
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		HashMap<String, String> scrollObject = new HashMap<String, String>();
//		scrollObject.put("direction", "down");
//		js.executeScript("mobile: scroll", scrollObject);
//
//	}
	public void  iosDemo() throws InterruptedException{
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);              
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'QQ邮箱' AND name == 'QQ邮箱'")).click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeTextField' AND value == '支持QQ号/邮箱/手机号登录'")).click();
		driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeTextField' AND value == '支持QQ号/邮箱/手机号登录'")).sendKeys("1025165571");
	}
	
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
		a.doRun("iosDemo");
		a.doRun("DemoOneArgs(\"This is args one\")");
		a.doRun("DemoTwoArgs(\"参数1\",\"参数2\")");
	}
}
