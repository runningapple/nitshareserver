package com.lin.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
* @ClassName: ImageUtil 
* @Description: 图片处理类
* @author linzj 
* @date 2016年4月4日 下午7:58:11 
*
 */
public class ImageUtil {
	
	/**
	 * 将原始图片转成统一大小的缩略图
	 * @param srcImgPath	原始图片路径
	 * @param disImgPath	生成缩略图路径
	 * @param width			缩略图的宽度
	 * @param height		缩略图的高度
	 * @throws IOException
	 */
	public static void resizeImage(String srcImgPath, String disImgPath, int width, int height) throws IOException{
		File srcFile = new File(srcImgPath);
		Image srcImg = ImageIO.read(srcFile);
		BufferedImage buffImg = null;
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		buffImg.getGraphics().drawImage(srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH),
				0, 0, null);
		ImageIO.write(buffImg, "JPEG", new File(disImgPath));
	}
}
