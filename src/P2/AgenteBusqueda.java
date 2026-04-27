package P2;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class AgenteBusqueda {
		 private Queue<String> planDeAccion = new LinkedList<>();
		 private boolean yaCalculado = false;
		 
		 public String pensar(Entorno entorno) {
		 // Solo calculamos la ruta completa en el primer ciclo
		 if (!yaCalculado) {
		 System.out.println("Agente calculando ruta...");
		 //BusquedaAnchura buscador = new BusquedaAnchura();
		 //BusquedaProfundidad buscador = new BusquedaProfundidad();
		 //BusquedaA buscador = new BusquedaA();
		 BusquedaAMejorado buscador = new BusquedaAMejorado();
		 
		 List<String> camino = buscador.resolver(entorno);
		 if (camino != null) {
		 planDeAccion.addAll(camino);
		 } else {
		 System.out.println("No hay ruta.");
		 }
		 yaCalculado = true;
		 }
		 // Ejecutamos el siguiente paso del plan
		 if (!planDeAccion.isEmpty()) {
		 return planDeAccion.poll();
		 }
		 return null;
		 }

}
