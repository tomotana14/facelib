package jp.tomotana.face.train;

import java.io.File;

import de.bwaldvogel.liblinear.Linear;
import de.bwaldvogel.liblinear.Model;
import de.bwaldvogel.liblinear.Parameter;
import de.bwaldvogel.liblinear.Problem;
import de.bwaldvogel.liblinear.SolverType;

public class LibLinearClient {
	
	/**
	 * 
	 * @throws Exception
	 */
	public static void train(String path) throws Exception {
		Parameter param = new Parameter(SolverType.L2R_LR, 1, 0.1);
		Problem prob = Problem.readFromFile(new File(path), -1);
		Model model = Linear.train(prob, param);
		String savePath = path + ".model";
		model.save(new File(savePath));
	}

}
