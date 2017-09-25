package com.oa.web.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.oa.service.SystemConfigService;

public class QuartzDelFileExecute {

	@Autowired
	private SystemConfigService systemConfigService;
	
	public void execute() throws Exception{
		String filePath = systemConfigService.findBasicinfoById("1001");  //1001:导出文件物理路径
//		String fileWebPath = systemConfigService.findBasicinfoById("1002"); //1002:导出文件web下载目录
		deletefile(filePath);
//		deletefile("E:\\upload\\linshi\\");
	}

	public boolean deletefile(String delpath) throws FileNotFoundException, IOException {
		try {
			File file = new File(delpath);
			if (!file.isDirectory()) {
				file.delete();
			} else if(file.isDirectory()) {
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					File delfile = new File(delpath + "\\" + filelist[i]);
					if (!delfile.isDirectory()) {
//						System.out.println("path=" + delfile.getPath());
//						System.out.println("absolutepath=" + delfile.getAbsolutePath());
//						System.out.println("name=" + delfile.getName());
						delfile.delete();
					} else if (delfile.isDirectory()) {
						deletefile(delpath + "\\" + filelist[i]);
					}
				}
//				file.delete();
			}
		} catch (FileNotFoundException e) {
			System.out.println("deletefile() Exception:" + e.getMessage());
		}
		return true;
	}
}
