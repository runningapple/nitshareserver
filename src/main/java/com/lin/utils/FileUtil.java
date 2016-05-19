package com.lin.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.web.multipart.MultipartFile;

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
	
	/**
	 * 保存上传的文件
	 * @param stream
	 * @param path
	 * @param fileName
	 * @throws IOException
	 */
	public static void saveFile(String fileName, MultipartFile file){
		String picDir = PropertiesUtil.getConfig("savePicUrl");
		
		File fileDir = new File(picDir);
		if (!fileDir.exists()){
			fileDir.mkdirs();
		}
		
		try{
			FileOutputStream out = new FileOutputStream(picDir + "\\" + fileName);
			out.write(file.getBytes());
			out.flush();
			out.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
