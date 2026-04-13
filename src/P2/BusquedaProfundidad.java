package P2;
import java.util.LinkedList;

public class BusquedaProfundidad extends Busqueda{
	//COLA: LIFO, addFirst, removeFirst
	protected void insertarEnAbiertos(LinkedList<Nodo> abiertos, Nodo nodo) {
		abiertos.addFirst(nodo);
	}
	
	protected String getNombre() {
	    return "Profundidad";
	}
}
