package edu.ucb.tdd;

public class Calculadora {

    private final static int MAX = 1000;

    public String suma(String sumados) throws Exception{
        if(sumados!=null && sumados.equals("")){
            return "0";
        }

        int total = 0;
        String[] sums = sumados.split(",");
        for(int i =0;i<sums.length; i++){
            int s = Integer.parseInt(sums[i]);
            if(s<MAX){
                total = total + s;
            }
            if(s<0){
                throw new Exception("El resultado es negativo");
            }
        }
        return (new Integer(total)).toString();
    }
}
