package lab07;

public class Medicos extends Contribuinte{

	private double congressos;
	private int numPacientes;
	private double riquezaMedicos;
	private int numMedicos;
	
	public Medicos(String nome, String cod, double valorCasa, double valorCarro, int numPacientes, double desCongressos) {
		super(nome, cod, valorCasa, valorCarro);
		setNumPacientes(numPacientes);
		setDespesasCongressos(desCongressos);
		riquezaMedicos = this.riquezaGeral(riquezaMedicos);
		numMedicos++;
	}
	
	public void setDespesasCongressos(double valor) {
		congressos = valor;
	}
	
	public double getDespesasCongressos() {
		return congressos;
	}

	public int getNumPacientes() {
		return numPacientes;
	}

	public void setNumPacientes(int numPacientes) {
		this.numPacientes = numPacientes;
	}
	
	public double tributacao() {
		return numPacientes*10;
	}
	
	public double descontos() {
		return congressos;
	}
	
	public boolean sinalDeRiquezaExterior(){
		return this.mediaRiqueza(riquezaMedicos, numMedicos);
	}
}
