package P2;

import java.util.LinkedList;

public class BusquedaA extends Busqueda{
	//insertar ordenado, removeFirst
	//distancia Manhattan, no sobreestima
	protected int calcularH(int f, int c, Entorno mapa) {
	     return Math.abs(f - mapa.metaF) + Math.abs(c - mapa.metaC);
	}

	protected String getNombre() {
	    return "A";
	}
	
    // abiertos: ordenado de menor a mayor valorF (g+h)
	//empate: coger el de menor h (mas cerca de meta, no coste acumulado)
	protected void insertarEnAbiertos(LinkedList<Nodo> abiertos, Nodo nuevo) {
        int i = 0;
        while (i < abiertos.size()) {
        	if (abiertos.get(i).valorF < nuevo.valorF ) {
        		i++;
        	} else if (abiertos.get(i).valorF == nuevo.valorF && abiertos.get(i).h <= nuevo.h) {
        		i++;
        	}else {
        		break; //no bucle infinito si no cumple if
        	}
        }
        abiertos.add(i, nuevo);
    }


}