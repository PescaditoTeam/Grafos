package generadores;

public class MatrizSimetrica {

	private int[] vector;
	private int tama�oVector;
	private int orden;
	
	public MatrizSimetrica(int orden){
		tama�oVector = (orden*(orden-1))/2;
		this.orden = orden;
		vector = new int[tama�oVector];
		ceroEnVector();
	}
	
	public void ceroEnVector(){
		for (int i = 0; i < tama�oVector; i++) {
			vector[i]=0;
		}
	}
	
	public void setValor(int i, int  j){
		vector[(int) ((i * orden) + j - ((Math.pow(i, 2) + (3*i)+2 )/2))] = 1;
	}
	
	public int getValor(int i , int j){
		return vector[(int) ((i * orden) + j - ((Math.pow(i, 2) + (3*i)+2 )/2))];
	}
	
	public int getTama�o(){
		return tama�oVector;
	}

}
