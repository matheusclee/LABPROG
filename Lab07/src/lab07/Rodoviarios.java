package lab07;

public abstract class Rodoviarios extends Contribuinte{

	private double kmRodados;
	
	public Rodoviarios(String nome, String cod, double valorCasa, double valorCarro, double kmRodados) {
		super(nome, cod, valorCasa, valorCarro);
		setKmRodados(kmRodados);
	}
	
	public void setKmRodados(double num){
		kmRodados = num;
	}
	
	public double getKmRodados(){
		return kmRodados;
	}
	
	public double descontos(){
		return kmRodados*0.01;
	}
}
