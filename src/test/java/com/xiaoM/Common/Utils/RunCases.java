package com.xiaoM.Common.Utils;

import java.util.List;

import com.xiaoM.Report.utils.TestListener;

public class RunCases {
	static List<Object[]> testcases;
	static Object[] testcase;
	
	public synchronized static Object[] testcase (){
		testcases = TestListener.RunCases;
		testcase = testcases.get(0);
		testcases.remove(0);
		return testcase;	
	}
}
