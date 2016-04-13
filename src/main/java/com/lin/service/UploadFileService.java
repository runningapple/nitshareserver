package com.lin.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * <p>ClassName: UploadFileService.java<p>
 * <p>文件上传<p>
 * @author linzj
 * @createTime 2016年4月13日  下午2:13:42
 */
public interface UploadFileService {
	
	/**
	 * 上传文件到指定路径
	 * @param destinationDir 目标路径
	 * @param file
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public boolean uploadFile(String destinationDir, MultipartFile file, String filename);
}
