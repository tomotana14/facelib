package jp.tomotana.face.train;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;

public class HelpFun {
	
	/**
	 * showImage 
	 * @param img : Mat形式の画像
	 */
	public static void showImage(Mat img) {
		MatOfByte matOfByte = new MatOfByte();
		Highgui.imencode(".jpg", img, matOfByte);
		byte[] byteArray = matOfByte.toArray();
		BufferedImage bufImage = null;
		try {
	        InputStream in = new ByteArrayInputStream(byteArray);
	        bufImage = ImageIO.read(in);
	        JFrame frame = new JFrame();
	        frame.getContentPane().add(new JLabel(new ImageIcon(bufImage)));
	        frame.pack();
	        frame.setVisible(true);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * getJpgList
	 * @path
	 */
	public static File[] getJpgList(String path) {
		final String _extension = "jpg";
		FilenameFilter ff = new FilenameFilter() {
			public boolean accept(File file, String name) {
				boolean ret = name.endsWith(_extension);
				return ret;
			}
		};
		File dir = new File(path);
		File[] files = dir.listFiles(ff);
	    return files;
	}
}
