package P2;

import java.util.LinkedList;
import java.util.List;

public class BusquedaA extends Busqueda{
	//insertar ordenado, removeFirst
	protected int calcularH(int f, int c, Entorno mapa) {
	     return Math.abs(f - mapa.metaF) + Math.abs(c - mapa.metaC);
	}

	protected String getNombre() {
	    return "A";
	}
	
    // inserta el nodo en abiertos en la posicion correcta segun valorF (g+h)
    // recorre abiertos hasta encontrar un nodo con valorF mayor y lo inserta antes
    // asi abiertos siempre esta ordenado de menor a mayor valorF
    protected void insertarEnAbiertos(LinkedList<Nodo> abiertos, Nodo nuevo) {
        int i = 0;
        while (i < abiertos.size() && abiertos.get(i).valorF <= nuevo.valorF) {
            i++;
        }
        abiertos.add(i, nuevo);
    }


}