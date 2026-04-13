package P2;

import java.util.LinkedList;


public class BusquedaAnchura extends Busqueda{
	//COLA: FIFO, addLast, removeFirst
	protected void insertarEnAbiertos(LinkedList<Nodo> abiertos, Nodo nodo) {
		abiertos.addLast(nodo);
	}
	
	protected String getNombre() {
	    return "Anchura";
	}
}
