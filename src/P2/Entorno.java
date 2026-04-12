package P2;

public class Entorno {
	char[][] grid; //cuadricula: # muro, '' libre, A agente, S meta, . rastro
    int filas, cols; //dimensiones
    int agenteF, agenteC; //fila y columna actual
    int metaF, metaC; //fila y columna meta

    public Entorno(String mapa) {
    	//convertir mapa en grid
        String[] lineas = mapa.trim().split("\n"); //divide por saltos de linea
        filas = lineas.length;
        cols = lineas[0].length();
        grid = new char[filas][cols];
        //recorrer celdas de mapa para inicializar el grid
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
            		 char celda = lineas[i].charAt(j);
            		 grid[i][j] = celda;
            		 if (celda == 'E' || celda == 'A') { agenteF = i; agenteC = j; grid[i][j] = 'A';}
            		 if (celda == 'S') {metaF = i ; metaC=j;}

            }
        }
    }

    public boolean esTransitable(int f, int c) {
        if (f < 0 || f >= filas || c < 0 || c >= cols) return false;
        // Transitable si es espacio, meta o monedas (si hubiera)
        // No transitable si es Muro (#) o Rastro (.) o fuera de mapa
        return grid[f][c] != '#' && grid[f][c] != '.' && grid[f][c] != 'E' ;
    }
    
    public char verCasilla(int f, int c) {
        if (f < 0 || f >= filas || c < 0 || c >= cols) return '#';
        return grid[f][c];
    }

    //agente en misma casilla que meta
    public boolean hemosGanado() { 
    	return agenteF == metaF && agenteC == metaC; 
    }

    public boolean esMeta(int f, int c) {
    	 return f == metaF && c == metaC;
    	}
    //mueve agente, false si choca
    public boolean moverAgente(String accion) {
        int nf = agenteF, nc = agenteC;
        //nueva posicion segun accion
        if (accion.equalsIgnoreCase("N")) nf--;
        if (accion.equalsIgnoreCase("S")) nf++;
        if (accion.equalsIgnoreCase("E")) nc++;
        if (accion.equalsIgnoreCase("O")) nc--;

        //si nueva posicion no es transitable devuelve false
        if (!esTransitable(nf, nc)) return false;

        grid[agenteF][agenteC] = '.'; // Deja rastro por donde pasa
        agenteF = nf; agenteC = nc; //actualiza posicion del agente
        
        if (grid[nf][nc] != 'S') grid[nf][nc] = 'A'; //pinta A en la nueva casilla
        return true;
    }

    //visualizar estado actual
    public void dibujar() {
        for (char[] fila : grid) {
        	System.out.println(new String(fila));
        }
    }
}