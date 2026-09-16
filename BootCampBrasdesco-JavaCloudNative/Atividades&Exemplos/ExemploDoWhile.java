import java.util.Random;

public class ExemploDoWhile {
    public static void main(String[] args) {
        System.out.println("Buscando Lojas...");

        do {
            System.out.println("Vericando Rede de Dados...");
        }
        while (buscando());
            System.out.println("10 Lojas encontradas na sua Região.");
    }
    
    private static boolean buscando() {
        boolean encontado = new Random().nextInt(3)==1;
            System.out.println("Lojas não encontadas!? "+ encontado);
        return ! encontado;
    }
    

    }
