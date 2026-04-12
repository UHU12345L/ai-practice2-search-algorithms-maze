package P2;

import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import P2.Entorno;

public class BusquedaProfundidad extends Busqueda{
	//COLA: LIFO, addFirst, removeFirst
	protected void insertarEnAbiertos(LinkedList<Nodo> abiertos, Nodo nodo) {
		abiertos.addFirst(nodo);
	}
	
	protected String getNombre() {
	    return "Profundidad";
	}
}
