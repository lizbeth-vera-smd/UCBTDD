package edu.ucb.tdd;

public class TresEnRaya {
    private Character[][] tablero = {{'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}};

    private char ultimoJugador = '+';
    private final int LIMITE = 3;

    public String  jugar(int x, int y) throws Exception{
        verificarEje(x);
        verificarEje(y);

        ultimoJugador = siguienteTurno();
        asignarPosicion(x,y,ultimoJugador);

        if(esVictoria()){
            return ultimoJugador + "es el ganador";
        }

        return "No hay ganador";
    }
    private void verificarEje(int eje) throws Exception{
        if(eje<1 || eje>LIMITE){
            throw new Exception(eje+"esta fuera del tablero");
        }
    }

    private void asignarPosicion(int x,int y, char ultimoJugador) throws Exception{
        if(tablero[x-1][y-1] !='0'){
            throw new Exception("Posicion ocupada");
        }else {
            tablero[x - 1][y - 1] = ultimoJugador;
            System.out.println("Asigando posicion" + x + ", " + y);
        }
    }

    public char siguienteTurno(){
        if(ultimoJugador == 'X'){
            return '+';
        }
        return 'X';
    }
     private boolean esVictoria(){
        int total = ultimoJugador *LIMITE;
         for (int i=0;i<LIMITE;i++){

             if (tablero[0][i]+ tablero[1][i] +tablero[2][i]==total){
                 return true;
             }else if (tablero[i][0]+ tablero[i][1] +tablero[i][2]==total){//Eje Horizontal
                return true;
             }
         }
         return false;
     }
}
