package coloreo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Coloreo {
	
	private int matrizAdy[][];
	private int cantNodos;
	private int cantAristas;
	private Nodo[] arrayDeNodosAColorear=null;

	
	public Coloreo(String path){
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try{
			archivo = new File(path);
			fr= new FileReader(archivo);
			br= new BufferedReader(fr);
			
			String datos[]=br.readLine().split(" ");
			
			cantNodos=Integer.parseInt(datos[0]);
			cantAristas=Integer.parseInt(datos[1]);
			
			arrayDeNodosAColorear = new Nodo[cantNodos];
			
			for(int indice=0;indice<cantNodos;indice++){
				Nodo aux = new Nodo();
				aux.setNumero(indice);
				arrayDeNodosAColorear[indice]=aux;
			}
			
			matrizAdy = new int[cantNodos][cantNodos];
			
			for(int idx=0;idx<cantAristas;idx++){
				String datos2[]=br.readLine().split(" ");
				matrizAdy[Integer.parseInt(datos2[0])][Integer.parseInt(datos2[1])]=1;
				matrizAdy[Integer.parseInt(datos2[1])][Integer.parseInt(datos2[0])]=1;
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fr!=null)
					fr.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}//bloque Constructor
	
	public void coloreoSecuencialAleatorio(int cantVecesaHacer) {
		int color = 0, nodosColoreados;
		for (int i = 0; i < cantVecesaHacer; i++) {
			nodosColoreados = 0;
			color = 0;
			barajar(0, cantNodos - 1);
			while (nodosColoreados < cantNodos) {
				color++;
				for (int indice = 0; indice < cantNodos; indice++) {
					if (arrayDeNodosAColorear[indice].getColor() == 0
							&& !(tieneAdyacenteConElMismoColor(
									arrayDeNodosAColorear[indice]
											.getNumero(),
									color))) {
						arrayDeNodosAColorear[indice].setColor(color);
						nodosColoreados++;
					}
				}
			}
			System.out.println("La cantidad de colores que se usaron fueron: "+color);
			despintar();
		}
	}
	
	public void despintar(){
		for (int i = 0; i < arrayDeNodosAColorear.length; i++) {
			arrayDeNodosAColorear[i].setColor(0);
		}
	}
	
	public void barajar(int inicio, int fin) {

		int cant = (fin - inicio + 1);
		for (int primera = inicio; primera < fin; primera++) {
			int segunda = (int) (Math.random() * cant + inicio);
			Nodo temp = arrayDeNodosAColorear[primera];
			arrayDeNodosAColorear[primera] = arrayDeNodosAColorear[segunda];
			arrayDeNodosAColorear[segunda] = temp;
		}
	}
	
	public boolean tieneAdyacenteConElMismoColor(int nodo, int color) {
		for (int i = 0; i < cantNodos; i++) {
			if (matrizAdy[nodo][arrayDeNodosAColorear[i]
					.getNumero()] == 1) {
				if (arrayDeNodosAColorear[i].getColor() == color) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Coloreo col = new Coloreo("GrafoPrueba.txt");
		col.coloreoSecuencialAleatorio(100000);
	}

}
