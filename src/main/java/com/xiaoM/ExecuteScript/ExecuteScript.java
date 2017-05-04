package com.xiaoM.ExecuteScript;

import java.lang.reflect.InvocationTargetException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ExecuteScript {
	public AppiumDriver <MobileElement> driver;
	
	public  ExecuteScript(){
	}
	
	public  ExecuteScript(AppiumDriver <MobileElement> driver) {
		this.driver = driver;
	}
	/**
	 * 执行指定的方法
	 * @param MethodName 方法名
	 */
	public void doRun(String MethodName){
		Class< ? extends ExecuteScript> run = this.getClass();
		try {	 
			run.getMethod(MethodName).invoke(this); 
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

	public void Demo(){
		System.out.println("********************");
		System.out.println("*      test        *");
		System.out.println("********************");
	}
}
