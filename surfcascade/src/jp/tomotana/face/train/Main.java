package jp.tomotana.face.train;

import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		// Load the native library.
	    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	    
	    //path
	    String facePath = "data/face";
	    String nFacePath = "data/non-face";
	    Sample[] posSample = ImageStorage.samplePositive(facePath);
	    Sample[] negSample = ImageStorage.sampleNegative(nFacePath);
	    
	    ImageStorage.writeLibLinearFormatFile(posSample, negSample, "data/hoge");
	    LibLinearClient.train("data/hoge");
	}

}
