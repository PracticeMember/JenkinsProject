package com.project.Utilities;
import java.util.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import javax.imageio.IIOImage;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;


public class ImageCompressor {
	 WebDriver driver;
	public ImageCompressor(WebDriver driver) {
		this.driver=driver;
	}
	
	public void compressImage() throws IOException {
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	BufferedImage image = ImageIO.read(screenshot);

	// Step 1: Reduce size
	int width = (int)(image.getWidth() * 0.8);
	int height = (int)(image.getHeight() * 0.8);
	Image tmp = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

	BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	Graphics2D g2d = resized.createGraphics();
	
	g2d.drawImage(tmp, 0, 0, null);
	g2d.dispose();

	// 👉 Step 2: Define destination path here
	File output = new File(System.getProperty("user.dir")+"//resized_ss.jpg");

	// Step 3: Compress & save
	Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
	ImageWriter writer = writers.next();
	ImageWriteParam param = writer.getDefaultWriteParam();
	param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	param.setCompressionQuality(0.5f);

	ImageOutputStream ios = ImageIO.createImageOutputStream(output);
	writer.setOutput(ios);
	writer.write(null, new IIOImage(resized, null, null), param);

	ios.close();
	writer.dispose();
  }
}
