package generadores;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class GeneradorGrafoAleConProbArista {


	private int matrizAdy[][];
	private int cantNodos;
	private double probAdy;
	private int cantAristas;
	private int vectorGrados[];
	private double porcAdy;
	
	public void generarMatriz(){
			
			Scanner in = new Scanner(System.in);
			System.out.println("Generador de grafos aleatorios dados N y una probabilidad para cada arista...\n");
			System.out.println("Ingresar N: ");
			cantNodos=in.nextInt();
			
			System.out.println("\nIngresar Probabilidad: ");
			probAdy=in.nextDouble();
			
			matrizAdy= new int[cantNodos][cantNodos];
			
			for(int i=0;i<=cantNodos-2;i++){
				for(int j=i+1;j<=cantNodos-1;j++){
					double aux=Math.random();
					if(aux<probAdy){
						matrizAdy[i][j]=1;
						matrizAdy[j][i]=1;
						cantAristas++;
					}
				}
			}
			//cantAristas/=2;
			in.close();
	}
	
	public void recorrerMatriz(String path){
		
		FileWriter fw = null;
		PrintWriter pw=null;
		
		try{
		 fw= new FileWriter(path);
		 pw = new PrintWriter(fw); 
		 
		 
		 vectorGrados = new int[cantNodos];
		 for(int i=0;i<cantNodos;i++){
			 for(int j=0;j<cantNodos;j++){
				 if(matrizAdy[i][j]==1)
					 vectorGrados[i]++;
				 }
			 }
		 
		 
		 int max=vectorGrados[0];
		 int min=vectorGrados[0];
		 
		 for(int i=0;i<vectorGrados.length;i++){
			 if(vectorGrados[i]<min){
				 min=vectorGrados[i];
			 }
			 if(vectorGrados[i]>max){
				 max=vectorGrados[i];
			 }
		 }
		
		 
		 double maxAristas=((cantNodos*(cantNodos-1))/2);
		 porcAdy=cantAristas/maxAristas;
		 
		 pw.println(""+cantNodos + " "+ cantAristas + " "+porcAdy+" "+ max + " "+min);
		 
		 for(int i=0;i<cantNodos;i++){
			 for(int j=i+1;j<cantNodos;j++){
				 if(matrizAdy[i][j]==1)
					 pw.println(""+i+" "+j);
			 }
		 }
		 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fw!=null)
					fw.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		GeneradorGrafoAleConProbArista gr = new GeneradorGrafoAleConProbArista();
		gr.generarMatriz();
		gr.recorrerMatriz("GrafoPrueba.txt");
	}
}
