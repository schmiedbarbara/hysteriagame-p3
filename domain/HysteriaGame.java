import java.util.Set;

public class HysteriaGame {
	    private int size;
	    private int[] colores;
	    private Tablero board;

	    public HysteriaGame() {
	        this.size = 5; 
	        this.colores = new int[size * size]; 
	        this.board = new Tablero(size * size);
	        conectarNodos(board, size);
	    }  
    
	    private static void conectarNodos(Tablero board, int size) {
		
	    	for (int i = 0; i < size; i++) {
	    		for (int j = 0; j < size; j++) {
	    			int nodoActual = i * size + j;
	    			if (i > 0) board.agregarArista(nodoActual, (i - 1) * size + j); // conecta nodos de arriba
	    			if (i < size - 1) board.agregarArista(nodoActual, (i + 1) * size + j); // conecta nodos de abajo
	    			if (j > 0) board.agregarArista(nodoActual, i * size + (j - 1)); // conecta nodos a la izquierda
	    			if (j < size - 1) board.agregarArista(nodoActual, i * size + (j + 1)); // conecta nodos a la derecha
	    		}
	    	}
		
	    }
	
	    private static void cambiarColor(int nodo, Tablero board, int[] colores) {
	    	int nuevoColor = (int) (Math.random() * 6) + 1; // genero un random entre 1 y 6
	    	colores[nodo] = nuevoColor; 
	    	Set<Integer> vecinos = board.vecinos(nodo); // obtengo los vecinos del nodo
	    	boolean conflicto = false;      // los vecinos no tienen el mismo color asignado
	    	for (int vecino : vecinos) {
	    		if (colores[vecino] == nuevoColor) {
	    			conflicto = true;
	    			break;				
	    		}
	    	}
	    	if (conflicto) {
	    		colores[nodo]= 0;//si hay conflicto setea el color a 0 (apagado) de todos los vecinos
	    		for (int vecino : vecinos) {
                    colores[vecino] = 0;  //aca apaga el vecino
                }
       
	    		//si no hay conflicto de color, lo pinta
	    	}
	    }
	    
	    public void cambiarColor(int nodo) { // esto lo hicimos para poder llamarlo desde el MainForm
	    	cambiarColor(nodo, board, colores);
	    }
	    
	    public int darColor(int nodo) { // esto lo hicimos para poder llamarlo desde el MainForm
	    	return colores[nodo];
	    }
	    
	    public Set<Integer> obtenerVecinos(int nodo) {
	    	return board.vecinos(nodo);  // Utiliza el método de la clase Tablero para obtener vecinos
	    }
	    
	    public int[] obtenerColores() {
	    	return this.colores;
	    }
	
	    public static boolean ganaste(int[] colores, int size) {
		
	    	for(int i=0; i <(size*size)-1; i++) { // ver como se hacia un contain
	    		if(colores[i]==0)
	    			return false;
	    	}
	    	return true;
	    }
	
}
