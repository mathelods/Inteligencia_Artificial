package tp2;

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.Id3;
import weka.core.Instance;
import weka.core.Instances;

public class testenavebays {

	public static void main(String[] args) throws Exception{
		baseDados base = new baseDados();
		Instances exemplos = base.tuplaDados();
		exemplos.setClassIndex(8);
		//alterar aleatoriamente a ordem dos exemplos
		exemplos = exemplos.resample(new Random());
		
		//cria o classificador naivebayes						
		NaiveBayes arvore = new NaiveBayes();
		//treina o classificador com a base dadaos exemplos
		arvore.buildClassifier(exemplos);
		//Cria uma avaliacao
		Evaluation evolucao = new Evaluation(exemplos);
		//Aplica a avaliacao simples usando o navivebayes e a base exemplos
		evolucao.evaluateModel(arvore,exemplos);
		//imprimi a matriz confusao e o sumarios
		System.out.println(evolucao.toMatrixString());
		System.out.println(evolucao.toSummaryString());
		
		//cria a matriz confusao da avaliacao simples
		double[][] dadosmatriz = new double[2][2];
		dadosmatriz = evolucao.confusionMatrix();
		System.out.println(dadosmatriz[0][0]);
		System.out.println(dadosmatriz[0][1]);
		System.out.println(dadosmatriz[1][0]);
		System.out.println(dadosmatriz[1][1]);
		
		//imprimi exemplos corretos e incorretos
		System.out.println("Exemplo Corretos: " + evolucao.correct());
		System.out.println("Exemplo InCorretos: " + evolucao.incorrect());
		
		System.out.println("-x-x-x-x-Inicia validacao cruzada naivebais-x-x-x-x-");
		
		//Cria um random para a validacao cruzada
		Random rand = new Random(1);
		//instancia o numero de dobras(partes)
		int dobras = 10;
		//Aplica a avaliacao cruzada 
		evolucao.crossValidateModel(arvore, exemplos, dobras, rand);
		//imprimi a matriz confusao e o sumarios
		System.out.println(evolucao.toMatrixString());
		System.out.println(evolucao.toSummaryString());
		
		//cria a matriz confusao da avaliacao cruzada
		dadosmatriz = evolucao.confusionMatrix();
		System.out.println(dadosmatriz[0][0]);
		System.out.println(dadosmatriz[0][1]);
		System.out.println(dadosmatriz[1][0]);
		System.out.println(dadosmatriz[1][1]);
				
		//imprimi exemplos corretos e incorretos
		System.out.println("Exemplo Corretos: " + evolucao.correct());
		System.out.println("Exemplo InCorretos: " + evolucao.incorrect());
		
		System.out.println("-x-x-x-x-x-x-Inicia o exemplo naivebais-x-x-x-x-x-x-");
		
		Instance exemplo = base.exemplo();
		System.out.println("Exemplo Navebays: " + exemplo);
		System.err.println("Teste: " + exemplo.stringValue(0));
		System.out.println("-x-x-x-x-x-x-x-x-x-x-x-x-x-x- ");
		double classe = arvore.classifyInstance(exemplo);
		String resultado = "";
		if (classe == 0.0) {
			resultado = "Obito";
			
		} else {
			resultado = "Não Obito";
		}
		System.err.println("Resultado para Navebays: " + resultado);
		
		System.out.println("-x-x-x-x-x-x-x-x-Inicia Classificador Id3-x-x-x-x-x-x- ");		
		
		//cria um classificador id3
		Id3 arvore2 = new Id3();
		//treina o classificador id3
		arvore2.buildClassifier(exemplos); 
		//System.out.println(arvore2);
		
		
		//Aplica a avaliacao simples usando o id3 e a base exemplos
		evolucao.evaluateModel(arvore2,exemplos);
		//imprimi a matriz confusao e o sumarios
		System.out.println(evolucao.toMatrixString());
		System.out.println(evolucao.toSummaryString());
				
		//cria a matriz confusao da avaliacao simples
		dadosmatriz = evolucao.confusionMatrix();
		System.out.println(dadosmatriz[0][0]);
		System.out.println(dadosmatriz[0][1]);
		System.out.println(dadosmatriz[1][0]);
		System.out.println(dadosmatriz[1][1]);
				
		//imprimi exemplos corretos e incorretos
		System.out.println("Exemplo Corretos: " + evolucao.correct());
		System.out.println("Exemplo InCorretos: " + evolucao.incorrect());
				
		System.out.println("-x-x-x-x-x-x-x-x-Inicia a validacao cruzada Id3-x-x-x-x-x-");
				
		//Cria um random para a validacao cruzada
		//Aplica a avaliacao cruzada 
		evolucao.crossValidateModel(arvore2, exemplos, dobras, rand);
		//imprimi a matriz confusao e o sumarios
		System.out.println(evolucao.toMatrixString());
		System.out.println(evolucao.toSummaryString());
				
		//cria a matriz confusao da avaliacao cruzada
		dadosmatriz = evolucao.confusionMatrix();
		System.out.println(dadosmatriz[0][0]);
		System.out.println(dadosmatriz[0][1]);
		System.out.println(dadosmatriz[1][0]);
		System.out.println(dadosmatriz[1][1]);
						
		//imprimi exemplos corretos e incorretos
		System.out.println("Exemplo Corretos: " + evolucao.correct());
		System.out.println("Exemplo InCorretos: " + evolucao.incorrect());
				
		System.out.println("-x-x-x-x-Incia a classificacao exemplo id3-x-x-x-x-x-");
		
		System.out.println("Exemplo Id3: " + exemplo);
		double classe2 = arvore2.classifyInstance(exemplo);
		String resultado2 = "";
		if (classe2 == 0.0) {
			resultado2 = "Obito";
			
		} else {
			resultado2 = "Não Obito";
		}
		System.out.println("-x-x-x-x-x-x-x-x-x-x-x-x-x-x- ");
		System.err.println("Resultado Id3: " + resultado2);
		System.out.println("-x-x-x-x-x-x-x-x-x-x-x-x-x-x- ");
		int numero_instancias = exemplos.numInstances();
		System.out.println("Numero de instancias: " + numero_instancias);
		Instance primeira = exemplos.firstInstance();
		System.out.println("primeira de instancia: " + primeira);
		Instance ultima = exemplos.lastInstance();
		System.out.println("ultima de instancia: " + ultima);

	}

}
