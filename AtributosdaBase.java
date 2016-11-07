package tp2;

import javax.swing.JOptionPane;

public class AtributosdaBase {
	Object[] FXIDMAE = {"ignorado", "nao se aplica", "sem informacao",
            "menos de 15", "de 15 a 19 anos", "de 20 a 24 anos",
            "de 25 a 29 anos", "de 30 a 34 anos", "de 35 a 39 anos",
            "de 40 a 44 anos", "45 a 49 anos", "50 ou mais"};
	
	Object[] FXPESO	= {"ignorado", "sem informacao", "menos de 500g", "de 500 a 999g",
			           "de 1000 a 1499g", "de 1500 a 2499g", "de 2500 a 2999g",
			           "de 3000 a 3499g", "de 3500 a 3999g", "de 4000g ou mais"};

	Object[] FXQFMORT = {"ignorado", "sem informacao", "0", "1", "2", "3", "de 4 a 7",
			              "de 8 a 10", "de 11 ou mais"};
	
	Object[] FXQFVIVO = {"ignorado", "sem informacao", "0", "1", "2", "3", "de 4 a 7", 
			             "de 8 a 10", "11 ou mais"};
	
	Object[] GEST = {"ignorado", "sem informacao", "menos de 22 semanas",
			        "de 22 a 27 semanas", "de 28 a 31", "de 32 a 36 semanas",
			        "de 37 a 41 semanas", "42 ou mais"};

	Object[] GRAV = {"ignorado", "sem informacao", "unica", "dupla", "tripla ou mais"};
	
	Object[] IDANOM = {"ignorado", "sem informacao", "Sim", "Não"}; 

	Object[] TPPARTO = {"ignorado", "nao se aplica", "sem informacao", "vaginal",
			             "cesareo"};
	String[] Rotulo = {"Faixa Etária da Mãe","Agrupamento do Peso ao Nascer",
			           "Grupo de Filhos Nascidos Mortos", "Grupo de Filhos Nascidos Vivos",
			           "Duração da Gestação","Numero de fetos na gravidez",
			           "Malformacao Congenita e/ou Anomalia Cromossomica","Tipo de parto"};


	
	public int janela(Object[] pergunta1, int j){
		int i = 0;
		String selecao = Rotulo[j-1];
		Object res = JOptionPane.showInputDialog(null, "Escolha um item" , selecao ,
				JOptionPane.PLAIN_MESSAGE , null ,pergunta1,"");
		while (!res.equals(pergunta1[i])) {
		    i++;			
		}			
		return i;		
	}


}
