package com.xiaoM.Report.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.TestListenerAdapter;

import com.xiaoM.Common.Utils.IOMananger;
import com.xiaoM.Common.Utils.Log;
import com.xiaoM.appium.utils.AppiumComm;

import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestListener  extends TestListenerAdapter{
	Log log= new Log(this.getClass());
	public static List<String> messageList=new ArrayList<String>();
	public static List<String> screenMessageList=new ArrayList<String>();
	public static List<String> screenResourceList=new ArrayList<String>();
	public static List<String> ResourceList=new ArrayList<String>();
	public static List<String> mobileSuccessMessageList=new ArrayList<String>();
	public static List<String> deviceLists=new ArrayList<String>();
	public static List<Object[]> RunCases=new ArrayList<Object[]>();//执行测试case
	public static List<String> FailCasesName=new ArrayList<String>();
	public static  String TestCase;//测试用例
	public static String ProjectPath;//工程路径
	public static String CasePath;//TestCase路径
	public static String appName;//测试应用
	public static String ReportTile;//测试报告主题
	public static String Devices;//测试设备
	public static String TestType;//测试类型
	public static Object[][] RunCase;//执行测试case
	public static String DeviceType;
	//配置初始化
	static{
		Properties pp = new Properties();
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream("config.properties"),"UTF-8");
			pp.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String os = System.getProperty("os.name");
		if(os.contains("Mac")){	
            String appiumPath = pp.getProperty("APPIUM_JS_PATH");
            String adbPath = pp.getProperty("ADB_PATH");
            System.setProperty(AppiumServiceBuilder.APPIUM_PATH , appiumPath);
            AppiumComm.adb = adbPath;
		}
		Devices = pp.getProperty("DEVICES");
		String[] devices =  Devices.split(",");
		for(String device:devices){
			deviceLists.add(device);
		}
		ProjectPath = pp.getProperty("WORKSPAC_PATH");
		TestCase = pp.getProperty("TESTCASE");
		CasePath = ProjectPath +"/testcase/"+ TestCase;
		appName = pp.getProperty("APP_NAME");
		ReportTile = pp.getProperty("REPORT_TITLE");
		DeviceType = pp.getProperty("DEVICE_TYPE");
		TestType = pp.getProperty("TEST_TYPE");
		String logPath = ProjectPath+"/test-output/log/";
		File path = new File(logPath);
		IOMananger.deleteFile(path);//删除日志文件
		try {
			RunCase = IOMananger.runTime("TestCases", CasePath);
			for(int i=0;i<RunCase.length;i++){
				RunCases.add(RunCase[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
