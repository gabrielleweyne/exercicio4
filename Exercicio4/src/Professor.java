
public class Professor {
	
	String Nome;
	int CPF;
	int Total;
	double Valor;

	public double Salario() {
		double salariobase;
		double horatividade;
		double descanso;
		double salariototal;

		salariobase = Total * Valor * 4.5;
		horatividade = salariobase * 1.05;
		descanso = (salariobase + horatividade)/6;
		salariototal = salariobase + horatividade + descanso;
		return salariototal;
	}
}
