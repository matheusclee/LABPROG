package lab07;

public abstract class Rodoviarios extends Contribuinte{

	private double kmRodados;
	
	public Rodoviarios(String nome, String cod, boolean temCasa, boolean temCarro, double kmRodados) {
		super(nome, cod, temCasa, temCarro);
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
