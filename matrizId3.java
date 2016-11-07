package tp2;

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.Id3;
import weka.core.Instances;

public class matrizId3 {
	
	public double [][] matrizSimples() throws Exception{
		double [][] m = new double[2][2];
		baseDados base = new baseDados();
		Instances exemplosId3 = base.tuplaDados();
		exemplosId3.setClassIndex(8);
		//exemplosId3 = exemplosId3.resample(new Random());
		Id3 arvore = new Id3();
		arvore.buildClassifier(exemplosId3);
		Evaluation evolucao = new Evaluation(exemplosId3);
		evolucao.evaluateModel(arvore,exemplosId3);
		m = evolucao.confusionMatrix();		
		return m;		
	}
	
	public double [][] matrizCruzada() throws Exception{
		double [][] m = new double[2][2];
		int dobras = 5;
		Random rand = new Random(1);
		baseDados base = new baseDados();
		Instances exemplosId3 = base.tuplaDados();
		exemplosId3.setClassIndex(8);
		//exemplosId3 = exemplosId3.resample(new Random());
		Id3 arvore = new Id3();
		arvore.buildClassifier(exemplosId3);
		Evaluation evolucao = new Evaluation(exemplosId3);
		evolucao.crossValidateModel(arvore, exemplosId3, dobras, rand);
		m = evolucao.confusionMatrix();		
		return m;		
	}

}
