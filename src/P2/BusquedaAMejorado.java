package P2;

import java.util.LinkedList;
import java.util.List;

public class BusquedaAMejorado extends Busqueda{
	//insertar ordenado, removeFirst
	protected int calcularH(int f, int c, Entorno mapa) {
		int difFilas=f-mapa.metaF;
		int difColumnas=c-mapa.metaC;
		int costeFila;
		int costeColumna;
		//Math.abs(f - mapa.metaF) + Math.abs(c - mapa.metaC)
		//subir 2, bajar 1
		if(difFilas>0) {
			costeFila=Math.abs(difFilas)*1;
		}else {
			costeFila=Math.abs(difFilas)*2;
		}
		
		//izquierda  2, derecha 1
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