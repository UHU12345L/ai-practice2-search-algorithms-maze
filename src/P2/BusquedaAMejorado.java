package P2;

import java.util.LinkedList;

public class BusquedaAMejorado extends Busqueda{
	//insertar ordenado, removeFirst
	protected int calcularH(int f, int c, Entorno mapa) {
		int difFilas=f-mapa.metaF;
		int difColumnas=c-mapa.metaC;
		int costeFila;
		int costeColumna;
		//Math.abs(f - mapa.metaF) + Math.abs(c - mapa.metaC)
		//compensar costes asimetricos, sobreestima en MAPA_GRANDE
		//bajar 1, subir 2
		if(difFilas>0) {
			costeFila=Math.abs(difFilas)*1;
		}else {
			costeFila=Math.abs(difFilas)*2;
		}
		
		//derecha 1, izquierda  2
		if(difColumnas>0) {
			costeColumna=Math.abs(difColumnas)*1;
		}else {
			costeColumna=Math.abs(difColumnas)*2;
		}
	     return costeFila+costeColumna;
	}

	protected String getNombre() {
	    return "A Mejorado";
	}
	
    // abiertos: ordenado de menor a mayor valorF (g+h)
	//empate: coger el de menor h
    protected void insertarEnAbiertos(LinkedList<Nodo> abiertos, Nodo nuevo) {
        int i = 0;
        while (i < abiertos.size()) {
        	if (abiertos.get(i).valorF < nuevo.valorF ) {
        		i++;
        	} else if (abiertos.get(i).valorF == nuevo.valorF && abiertos.get(i).h <= nuevo.h) {
        		i++;
        	} else {
        		break;
        	}
            
        }
        abiertos.add(i, nuevo);
    }


}