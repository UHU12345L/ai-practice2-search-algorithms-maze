package P2;

import java.util.LinkedList;
import java.util.List;

public class Busqueda {
	//sobreescribir por Anchura, profundidad , A, A mejorado
	protected String getNombre() {
	    return "Busqueda";
	}
	//sobreescribir por Anchura, profundidad , A, A mejorado
	protected void insertarEnAbiertos(LinkedList<Nodo> abiertos, Nodo nodo) {
		abiertos.addLast(nodo);
	}
	
	public List<String> resolver(Entorno mapa) {
		 LinkedList<Nodo> abiertos =new LinkedList<>();
		 LinkedList<Nodo> cerrados =new LinkedList<>();
		 int af = mapa.agenteF;
	     int ac = mapa.agenteC;
	     
	     int paso = 1;
	     int nodosExpandidos = 0;
	     int maxAbiertos = 0;
	     long tiempoInicio = System.nanoTime();
	     
	     //heuristica: cada algoritmo el suyo (anchura y profundidad 0)
	     Nodo inicial = new Nodo(af, ac, null, null, 0, calcularH(af,ac, mapa));
	     abiertos.addLast(inicial);
		 
	     System.out.println("Iniciando busqueda" + getNombre());
	     System.out.println("Origen: ("+af+","+ac+") -> Meta: ("+mapa.metaF+","+mapa.metaC+")");
		 //mientras hay nodos en abiertos
	     while (abiertos.size()>0) {
			 Nodo actual = abiertos.removeFirst();
			 cerrados.addLast(actual);
			 nodosExpandidos++;
			 
			// actualizar el maximo de abiertos
			    if (abiertos.size() > maxAbiertos) {
			        maxAbiertos = abiertos.size();
			    }

			    System.out.println("[PASO " + paso + "] \nSeleccionado: (" + actual.f + "," + actual.c + ")"
			            + " [f=" + actual.valorF + ", g=" + actual.g + ", h=" + actual.h + "]");

			    //comprobar si actual es meta para cálculos finales
			    if (mapa.esMeta(actual.f, actual.c)) {
			        long tiempoFin = System.nanoTime();
			        double ms = (tiempoFin - tiempoInicio) / 1000000.0; //nano a mili s
			        List<String> camino = reconstruirCamino(actual);
			        
			        //connstruir camino de meta a inicio siguiendo a pa
			        String caminoRecorrido="[";
			        Nodo n =actual;
			        LinkedList<Nodo> nodos=new LinkedList<>();
			        while (n!=null) {
			        	nodos.addFirst(n);
			        	n=n.padre;
			        }
			        for(int i=0;i<nodos.size();i++) {
			        	caminoRecorrido=caminoRecorrido + "["+nodos.get(i).f+", "+nodos.get(i).c+"]";
			        	//coma si no es el ultimo
			        	if(i<nodos.size()-1) {
			        		caminoRecorrido=caminoRecorrido+", ";
			        	}
			        }
			        caminoRecorrido=caminoRecorrido+"]";

			        System.out.println("\n--- ESTADISTICAS FINALES ---");
			        System.out.println("Solucion encontrada usando " + getNombre());
			        System.out.println("Camino recorrido (x,y): "+ caminoRecorrido);
			        System.out.println("Coste total del camino: " + actual.g);
			        System.out.println("Nodos expandidos: " + nodosExpandidos);
			        System.out.println("Tamaño maximo de ABIERTOS: " + maxAbiertos);
			        System.out.println("Tiempo de ejecucion: " + ms + " ms.");

			        return camino;
			    }

			    List<Nodo> sucesores = getSucesores(actual, mapa);
			    
			    String hijosAntes="";
			    for (int j = 0; j < sucesores.size(); j++) {
		            hijosAntes = hijosAntes + "(" + sucesores.get(j).f + "," + sucesores.get(j).c + ")";
		            if (j < sucesores.size() - 1) {
		                hijosAntes = hijosAntes + ", ";
		            }
			    }
	            System.out.println("Generados hijos antes de quitar repetidos: " + hijosAntes);
			    List<Nodo> sucesoresSin = quitarRepetidos(sucesores, abiertos, cerrados);

			    // imprimir hijos generados
			    if (sucesoresSin.size() == 0) {
			        System.out.println("Generados hijos: Ninguno");
			    } else {
			        String hijos = "";
			        for (int i = 0; i < sucesoresSin.size(); i++) {
			            hijos = hijos + "(" + sucesoresSin.get(i).f + "," + sucesoresSin.get(i).c + ")";
			            if (i < sucesoresSin.size() - 1) {
			                hijos = hijos + ", ";
			            }
			        }
			        System.out.println("Generados hijos: " + hijos);
			    }

			    for (int i = 0; i < sucesoresSin.size(); i++) {
			        insertarEnAbiertos(abiertos, sucesoresSin.get(i));
			    }

			    // imprimir estado de abiertos
			    String estadoAbiertos = "[";
			    for (int i = 0; i < abiertos.size(); i++) {
			        estadoAbiertos = estadoAbiertos + "(" + abiertos.get(i).f + "," + abiertos.get(i).c + ")";
			        if (i < abiertos.size() - 1) {
			            estadoAbiertos = estadoAbiertos + ", ";
			        }
			    }
			    estadoAbiertos = estadoAbiertos + "]";
			    System.out.println("Estado ABIERTOS: " + estadoAbiertos);

			    // imprimir estado de cerrados
			    String estadoCerrados = "[";
			    for (int i = 0; i < cerrados.size(); i++) {
			        estadoCerrados = estadoCerrados + "(" + cerrados.get(i).f + "," + cerrados.get(i).c + ")";
			        if (i < cerrados.size() - 1) {
			            estadoCerrados = estadoCerrados + ", ";
			        }
			    }
			    estadoCerrados = estadoCerrados + "]\n";
			    System.out.println("Estado CERRADOS: " + estadoCerrados);

			    paso++;
		 }	 
		 
	 return null;
	 }
	
    protected int calcularH(int f, int c, Entorno mapa) {
        return 0; // anchura y profundidad no usan heuristica
    }
	 
	// genera los 4 sucesores transitables del nodo actual
	    private List<Nodo> getSucesores(Nodo actual, Entorno mapa) {
	        List<Nodo> sucesores = new LinkedList<>();
	        int f = actual.f;
	        int c = actual.c;
	        //int g = actual.g + 1; // coste = pasos dados + 1

	        if (mapa.esTransitable(f-1, c)) sucesores.add(new Nodo(f-1, c, actual, "N", actual.g+2, calcularH(f-1, c, mapa)));
	        if (mapa.esTransitable(f+1, c)) sucesores.add(new Nodo(f+1, c, actual, "S", actual.g+1, calcularH(f+1, c, mapa)));
	        if (mapa.esTransitable(f, c+1)) sucesores.add(new Nodo(f, c+1, actual, "E", actual.g+1, calcularH(f, c+1, mapa)));
	        if (mapa.esTransitable(f, c-1)) sucesores.add(new Nodo(f, c-1, actual, "O", actual.g+2, calcularH(f, c-1, mapa)));

	        return sucesores;
	    }

	    // elimina sucesores que ya estan en Abiertos o Cerrados para evitar ciclos
	    private List<Nodo> quitarRepetidos(List<Nodo> sucesores, LinkedList<Nodo> abiertos, LinkedList<Nodo> cerrados) {
	        List<Nodo> resultado = new LinkedList<>();
	        for (int i = 0; i < sucesores.size(); i++) {
	            Nodo s = sucesores.get(i);
	            if (!abiertos.contains(s) && !cerrados.contains(s)) {
	                resultado.add(s);
	            }else {
	            	System.out.println(" [REPETIDO DESCARTADO]: (" +s.f+","+s.c+")");	            }
	        }
	        return resultado;
	    }
	 
	 private List<String> reconstruirCamino(Nodo meta) {
		 LinkedList<String> camino = new LinkedList<>();
		 Nodo actual = meta;
		 
		 
		 while (actual.padre != null) {
			 camino.addFirst(actual.accion);
			 actual = actual.padre;
		 }
		 System.out.println("Coste total del camino: " + meta.g);
		 return camino;
	 }
	}