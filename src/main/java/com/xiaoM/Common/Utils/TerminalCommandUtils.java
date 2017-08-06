package com.xiaoM.Common.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalCommandUtils {
	
	/**
     * 在终端上运行命令后获取结果
     * @param command 运行命令
     * @return 执行命令后，所产生的日志
     */
    public static String executeCommand(String command){
    	String line = "";
        String allLine = "";
    	try {
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream())); 
			while ((line = r.readLine()) != null) {
			    allLine = allLine + "" + line + "\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return allLine;
    }
    
    public static void main(String[] args) throws IOException {
		System.out.println(executeCommand("node -v"));
	}
}
