public class Operacoes {
    public static double adicao(double valor1, double valor2) {
        return valor1 + valor2;
    }

    public static double subtracao(double valor1, double valor2) {
        return valor1 - valor2;

    }
    public static double multiplicacao (double valor1, double valor2) {
        return valor1 * valor2;

    }
    public static double divisao (double valor1, double valor2) {
        double resultado;
        if (valor2 == 0){
            resultado = 0;
        } else {
            resultado = valor1 / valor2;
        }
        return resultado;

    }

    public static String limpar(){
        return "";
    }

}
