package com.xiaoM.BeginScript;

import org.testng.annotations.Test;

import com.xiaoM.Common.Utils.Run;
import com.xiaoM.Common.Utils.RunCases;
import com.xiaoM.Common.Utils.UseDevices;
import com.xiaoM.Report.utils.TestListener;


public class BeginScript{

	@Test
	public void run1() throws Exception{
		Object[] RunCase = RunCases.testcase();
		String device = UseDevices.Device();
		Run run = new Run();
		run.testCase(RunCase[0].toString(),RunCase[1].toString(),device);
		TestListener.deviceLists.add(device);
	}
	@Test
	public void run2() throws Exception{
		Object[] RunCase = RunCases.testcase();
		String device = UseDevices.Device();
		Run run = new Run();
		run.testCase(RunCase[0].toString(),RunCase[1].toString(),device);
		TestListener.deviceLists.add(device);
	}
	@Test
	public void run3() throws Exception{
		Object[] RunCase = RunCases.testcase();
		String device = UseDevices.Device();
		Run run = new Run();
		run.testCase(RunCase[0].toString(),RunCase[1].toString(),device);
		TestListener.deviceLists.add(device);
	}
	@Test
	public void run4() throws Exception{
		Object[] RunCase = RunCases.testcase();
		String device = UseDevices.Device();
		Run run = new Run();
		run.testCase(RunCase[0].toString(),RunCase[1].toString(),device);
		TestListener.deviceLists.add(device);
	}
}
