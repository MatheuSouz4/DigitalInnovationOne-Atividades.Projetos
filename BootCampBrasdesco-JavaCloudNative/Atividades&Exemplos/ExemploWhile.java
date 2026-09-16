import java.util.concurrent.ThreadLocalRandom;

public class ExemploWhile {
    public static void main(String[] args) {
        double limite = 75.0;

        while(limite > 0){
            double valorCompra = valorAleatorio();
            if (valorCompra > limite)
                valorCompra = limite;

            System.out.println("Compra de "+ valorCompra + " foi efetuada. Valor será deduzido do seu limite de "+ limite);
            limite = limite - valorCompra;
        }

        System.out.println("Limite Insuficiente!");
    }

    private static double valorAleatorio() {
            return ThreadLocalRandom.current().nextDouble(5,13);
        }
}
