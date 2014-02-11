package jp.tomotana.face.train;

import org.opencv.core.Mat;

public class Sample {
	int label;
	String path;
	public Mat feat;
	
	Sample(int label, String path) {
		this.label = label;
		this.path = path;
	}
	
	Sample(int label, String path, Mat feat) {
		this.label = label;
		this.path = path;
		this.feat = feat;
	}
	
	public void setFeat(Mat mat) {
		this.feat = mat;
	}
	
}
