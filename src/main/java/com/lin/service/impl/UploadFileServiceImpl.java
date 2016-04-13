package com.lin.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lin.service.UploadFileService;

@Service("uploadFileService")
public class UploadFileServiceImpl implements UploadFileService {

	@Override
	public boolean uploadFile(String destinationDir, MultipartFile file,
			String filename){
		try{
			saveFileFromInputStream(file.getInputStream(), destinationDir, filename);
		} catch (IOException ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 保存文件
	 * @param is
	 * @param path
	 * @param filename
	 * @throws IOException
	 */
	private void saveFileFromInputStream(InputStream stream, String path, String filename) throws IOException{
		FileOutputStream fileOutputStream = new FileOutputStream(path + "/" + filename);
		int byteCount = 0;
		byte[] bytes = new byte[1024];
		while ((byteCount = stream.read(bytes)) != -1){
			fileOutputStream.write(bytes, 0, byteCount);
		}
		fileOutputStream.close();
		stream.close();
	}
}
