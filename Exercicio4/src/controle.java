import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;

public class controle {
	Professor[] professores = new Professor[5];
	int posicao = 0;

	public void menu() {
		int opcao;
		String aux="Escolha uma opção:\n";
		aux+="1. Registrar professor\n";
		aux+="2. Pesquisar dados de um professor pelo CPF\n";
		aux+="3. Remover professor\n";
		aux+="4. Imprimir todos os professores\n";
		aux+="5. Finalizar\n";
	
		
		do {
			opcao=parseInt(showInputDialog(aux));
			if (opcao<1||opcao>5) {
				showMessageDialog(null, "Opção Inválida");
			}else {
				switch(opcao) {
				case 1:
					Registrar();
					break;
				case 2:
					Pesquisar();
					break;
				case 3:
					Remover();
					break;
				case 4:
					Todos();
					break;
				}
			}
		}while(opcao!=5);
	}

	public void Registrar() {
		int CPF = parseInt(showInputDialog("CPF a registrar"));
		boolean procurar = false;
		for (int i = 0; i < posicao; i++) {
			if (CPF == professores[i].CPF) {
				procurar = true;
				break; }
		}
		if (!procurar) {
			professores[posicao] = new Professor();
			professores[posicao].Nome = showInputDialog("Nome do professor:");
			professores[posicao].CPF = CPF;
			professores[posicao].Total = parseInt(showInputDialog("Total de aulas por semana: "));
			professores[posicao].Valor = Double.parseDouble(showInputDialog("Valor aula: "));
			posicao++;

		} else {
			showMessageDialog(null, "CPF já registrado.");
		}
	}
	
	public void Remover() {
			int indice =-1;
			int CPF = parseInt(JOptionPane.showInputDialog("CPF a remover: "));
			for (int i = 0; i < posicao; i++) {
				if (professores[i].CPF ==  CPF) {
					indice = i;
				}
			}
				if (indice == -1) {
					showMessageDialog(null, "Professor não cadastrado");
				}else {
					for( int j = indice; j < posicao; j++) {
					professores[j] = professores[j+1];
				}
				posicao--;
				showMessageDialog(null, "Professor removido");
				}
		
	}
	
	public void Pesquisar() {
			String aux= "";
			int CPF = parseInt(showInputDialog("CPF a pesquisar: "));
			int x = -1;
				for (int i = 0; i < posicao; i++) {
					if (professores[i].CPF ==  CPF) {
						x = i;
					}
					
			}
				if(x != -1) {
				aux += "Nome: " + professores[x].Nome + "\n";
				aux += "CPF: " + professores[x].CPF + "\n";
				aux += "Total de aulas: "  + professores[x].Total + "\n";
				aux += "Valor: " + professores[x].Valor + "\n";
				aux += "Salário:  " + professores[x].Salario() + "\n\n";
				}else {
					aux += "Professor não cadastrado";
				}
				showMessageDialog(null, aux);
		}
		
	public void Todos() {
		String aux = "";
		if (posicao < 1) {
			showMessageDialog(null, "Zero professores cadastrados");
		} else {
			for (int i = 0; i < posicao; i++) {
				aux += "Nome: " + professores[i].Nome + "\n";
				aux += "CPF: " + professores[i].CPF + "\n";
				aux += "Total de aulas: "  + professores[i].Total + "\n";
				aux += "Valor: " + professores[i].Valor + "\n";
				aux += "Salário:  " + professores[i].Salario() + "\n\n";
				aux += " ------------------------- \n\n";
				

			}
			showMessageDialog(null, aux);
		}
	}

}