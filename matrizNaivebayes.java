package tp2;

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

public class matrizNaivebayes {	
	
	public double [][] matrizSimples() throws Exception{
		double [][] m = new double[2][2];
		baseDados base = new baseDados();
		Instances exemplosNaivebayes = base.tuplaDados();
		exemplosNaivebayes.setClassIndex(8);
		//exemplosNaivebayes = exemplosNaivebayes.resample(new Random());
		NaiveBayes arvore = new NaiveBayes();
		arvore.buildClassifier(exemplosNaivebayes);
		Evaluation evolucao = new Evaluation(exemplosNaivebayes);
		evolucao.evaluateModel(arvore,exemplosNaivebayes);
		m = evolucao.confusionMatrix();		
		return m;		
	}
	
	public double [][] matrizCruzada() throws Exception{
		double [][] m = new double[2][2];
		int dobras = 5;
		Random rand = new Random(1);
		baseDados base = new baseDados();
		Instances exemplosNaivebayes = base.tuplaDados();
		exemplosNaivebayes.setClassIndex(8);
		exemplosNaivebayes = exemplosNaivebayes.resample(new Random());
		NaiveBayes arvore = new NaiveBayes();
		arvore.buildClassifier(exemplosNaivebayes);
		Evaluation evolucao = new Evaluation(exemplosNaivebayes);
		evolucao.crossValidateModel(arvore, exemplosNaivebayes, dobras, rand);
		m = evolucao.confusionMatrix();		
		return m;		
	}

}
