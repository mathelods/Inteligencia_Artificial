package tp2;

import java.io.FileReader;
//import java.util.Random;

import weka.core.Instance;
import weka.core.Instances;

public class baseDados{
		
	public Instances tuplaDados() throws Exception{
		FileReader leitor = new FileReader("Obitos_Nascimentos2.arff");
		Instances linhas = new Instances(leitor);
		return linhas;		
			
	}
	
	public Instance exemplo() throws Exception{
		Instances exemplos = tuplaDados();
		exemplos.setClassIndex(8);
		Instance Novo_exemplo = exemplos.instance(1);
		Novo_exemplo.setClassMissing();
		AtributosdaBase teste = new AtributosdaBase();
		int a = teste.janela(teste.FXIDMAE, 1);
		int b = teste.janela(teste.FXPESO, 2);
		int c = teste.janela(teste.FXQFMORT, 3);
		int d = teste.janela(teste.FXQFVIVO, 4);
		int e = teste.janela(teste.GEST, 5);
		int f = teste.janela(teste.GRAV, 6);
		int g = teste.janela(teste.IDANOM, 7);
		int h = teste.janela(teste.TPPARTO, 8);
		
		Novo_exemplo.setValue(0, a);
		Novo_exemplo.setValue(1, b);
		Novo_exemplo.setValue(2, c);
		Novo_exemplo.setValue(3, d);
		Novo_exemplo.setValue(4, e);
		Novo_exemplo.setValue(5, f);
		Novo_exemplo.setValue(6, g);
		Novo_exemplo.setValue(7, h);
		
		return Novo_exemplo;
		
	}

}
