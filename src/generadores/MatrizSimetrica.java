package generadores;

public class MatrizSimetrica {

	private int[] vector;
	private int tamañoVector;
	private int orden;
	
	public MatrizSimetrica(int orden){
		tamañoVector = (orden*(orden-1))/2;
		this.orden = orden;
		vector = new int[tamañoVector];
		ceroEnVector();
	}
	
	public void ceroEnVector(){
		for (int i = 0; i < tamañoVector; i++) {
			vector[i]=0;
		}
	}
	
	public void setValor(int i, int  j){
		vector[(int) ((i * orden) + j - ((Math.pow(i, 2) + (3*i)+2 )/2))] = 1;
	}
	
	public int getValor(int i , int j){
		return vector[(int) ((i * orden) + j - ((Math.pow(i, 2) + (3*i)+2 )/2))];
	}
	
	public int getTamaño(){
		return tamañoVector;
	}

}
