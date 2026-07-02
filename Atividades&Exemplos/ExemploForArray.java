public class ExemploForArray {
    public static void main(String[] args) {
        String cardapio [] ={"Açai", "Sanduíche", "Refrigerante", "Pizza","Sorvete"};

        for (int x = 0; x < cardapio.length; x++){
            System.out.println("O item do Cardápio do indíce " + x + " é " + cardapio[x]);
        }
    }
}
