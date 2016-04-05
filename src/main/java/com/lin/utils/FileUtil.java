package com.lin.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <p>ClassName: FileUtil.java<p>
 * <p>文件处理类<p>
 * @author linzj
 * @createTime 2016年4月5日  下午1:22:49
 */
public class FileUtil {
	List<String> result = new ArrayList<String>();
	
	public void getFile(String path){
		File file = new File(path);
		
		File[] array = file.listFiles();
		
		for (int i = 0; i < array.length; i++){
			if (array[i].isFile()){
				result.add(array[i].getPath());
			}else if(array[i].isDirectory()){
				this.getFile(array[i].getPath());
			}
		}
	}

	public List<String> getResult() {
		return result;
	}
	
}
