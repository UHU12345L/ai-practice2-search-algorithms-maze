package P2;
import java.util.*;

import P2.Entorno;
public class Tron {

// --- MAPAS DE PRUEBA ---
    
    // Mapa trampa: La casilla (1,1) al Este lleva a un callejón sin salida
    static final String MAPA_CALLEJON =
            "#########\n" +
            "#E      #\n" + 
            "# ##### #\n" + 
            "# #   # #\n" + 
            "#     S #\n" +
            "#########";

    static final String MAPA_GRANDE =
            "####################\n" +
            "#E  #              #\n" +
            "# # # ###### ##### #\n" +
            "# #   #      #     #\n" +
            "# ##### ###### ### #\n" +
            "#     #        #   #\n" +
            "# ### ######## # # #\n" +
            "#   #          #   #\n" +
            "# ############## S #\n" +
            "####################";
    static final String mapaTexto =
		    "#######\n" +
		    "#E    #\n" +
		    "# ### #\n" +
		    "#   #S#\n" +
		    "#######";

    public static void main(String[] args) throws InterruptedException {
    	String mapaProbar = MAPA_CALLEJON;
    	 Entorno juego = new Entorno(mapaProbar);
    	 AgenteBusqueda agente = new AgenteBusqueda(); // Nuestro nuevo agente
    	 System.out.println("--- Inicio de la Simulación ---");
    	 boolean juegoActivo = true;
    	 int ciclos = 0;
    	 while (juegoActivo && ciclos < 100) {
    	 System.out.println("\n\n--- Ciclo " + ciclos + " ---");
    	 juego.dibujar();
    	 String accion = agente.pensar(juego);

    	 if (accion == null) {
    		 System.out.println("El agente se ha quedado sin plan o no encontró ruta.");
    		 break;
         }

            System.out.println("Agente decide: " + accion);
            
            // Mover
            boolean exito = juego.moverAgente(accion);

            // Verificar estado
            if (!exito) {
                
                    System.out.println(">>> ¡CRASH! El agente se ha estrellado.");
                    juegoActivo = false;
               
            } else if (juego.hemosGanado()) {
                System.out.println(">>> ¡VICTORIA! Meta alcanzada.");
                juego.dibujar();
                juegoActivo = false;
            }

            // Pausa 
            
             Thread.sleep(300); 
           
            ciclos++;
        }
    }
    
}