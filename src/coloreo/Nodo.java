package coloreo;

public class Nodo implements Comparable<Nodo> {
	private int numero;
	private String nombre;
	private int[] aristas;
	private int grado;
	private int color; 

	public Nodo(int id, String nombre, int grado, int[] aristas, int color) {
		super();
		this.color = color;
		this.aristas = aristas;
		this.nombre = nombre;
		this.grado = grado;
		this.numero = id;
	}

	public Nodo clone() {
		return new Nodo(numero, nombre, grado, aristas, color);
	}

	public String toString() {
		return String.valueOf("(" + numero + ") - " + grado);
	}

	public Nodo() {
		this(0, null, 0, null, 0);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int id) {
		this.numero = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public int[] getAristas() {
		return aristas;
	}

	public void setAristas(int[] aristas) {
		this.aristas = aristas;
	}

	public Nodo getNodo() {
		return this;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void aumentar_grado() {
		this.grado++;
	}

	@Override
	public int compareTo(Nodo aux) {
		if (this.numero < aux.getNumero()) {
			return -1;
		} else if (this.numero == aux.getNumero()) {
			return 0;
		} else {
			return 1;
		}
	}

}
