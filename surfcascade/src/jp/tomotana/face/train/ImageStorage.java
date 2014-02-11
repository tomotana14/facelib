package jp.tomotana.face.train;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class ImageStorage {
	/**
	 * 
	 * @param dir
	 * @return
	 */
	public static Sample[] samplePositive(String dir) {
		File fDir = new File(dir);
		File[] files = fDir.listFiles();
	    Sample[] feat = new Sample[files.length];
		
	    for (int i = 0; i < files.length; i++) {
	    	Mat img = Highgui.imread(files[i].toString(), Highgui.IMREAD_GRAYSCALE);
	    	feat[i] = new Sample(1, files[i].toString(), img.reshape(1, 576));
	    } 
	    return feat;
	}
	
	/**
	 * 
	 * @param dir
	 * @return
	 */
	public static Sample[] sampleNegative(String dir) {
		File fDir = new File(dir);
		File[] files = fDir.listFiles();
	    Sample[] feat = new Sample[files.length];
		
	    for (int i = 0; i < files.length; i++) {
	    	Mat img = Highgui.imread(files[i].toString(), Highgui.IMREAD_GRAYSCALE);
	    	feat[i] = new Sample(-1, files[i].toString(), img.reshape(1,576));
	    } 
	    return feat;
	}
	
	/**
	 * 
	 * @param pos
	 * @param neg
	 * @param path
	 */
	public static void writeLibLinearFormatFile(Sample[] pos, Sample[] neg, String path) {
		try {
			File file = new File(path);
			FileWriter fw = new FileWriter(file);			
			//positive
			for (Sample s : pos) {
				String line = "+1 ";
				int count = 1;
				for (int i = 0; i < s.feat.rows(); i++) {
					double[] val = s.feat.get(count -1, 0);
					if ((int) val[0] != 0) {
						line += String.format("%d:%d ", count, (int) val[0]);
					}
					count++;
				}
				line += "\n";
				fw.write(line);
			}
			//negative
			for (Sample s : neg) {
				String line = "-1 ";
				int count = 1;
				for (int i = 0; i < s.feat.rows(); i++) {
					double[] val = s.feat.get(count -1, 0);
					if ((int) val[0] != 0) {
						line += String.format("%d:%d ", count, (int) val[0]);
					}
					count++;
				}
				line += "\n";
				fw.write(line);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
