package P2;

import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import P2.Entorno;

public class BusquedaAnchura extends Busqueda{
	//COLA: FIFO, addLast, removeFirst
	protected void insertarEnAbiertos(LinkedList<Nodo> abiertos, Nodo nodo) {
		abiertos.addLast(nodo);
	}
	
	protected String getNombre() {
	    return "Anchura";
	}
}
