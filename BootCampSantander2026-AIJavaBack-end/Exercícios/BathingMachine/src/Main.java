import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private final static BathingMachine bathingMachine = new BathingMachine();

    public static void main(String[] args) {
        
        var option = -1;

        do {
            System.out.println("======== Selecione uma das Opções ========");
            System.out.println("1 - Iniciar Banho.");
            System.out.println("2 - Abastacer Água.");
            System.out.println("3 - Abastecer Shampoo.");
            System.out.println("4 - Verificar nível de Água.");
            System.out.println("5 - Verificar nível de Shampoo.");
            System.out.println("6 - Verificar se tem banho em andamento.");
            System.out.println("7 - Adicionar Pet na máquina.");
            System.out.println("8 - Retirar Pet da máquina.");
            System.out.println("9 - Realizar limpeza na Máquina.");
            System.out.println("0 - Sair");
            option = scanner.nextInt();

            switch (option){
                case 1 -> bathingMachine.takeAShower();
                case 2 -> setWater();
                case 3 -> setShampoo();
                case 4 -> verifyWater();
                case 5 -> verifyShampoo();
                case 6 -> checkifHasPetInMachine();
                case 7 -> setPetInBathingMachine();
                case 8 -> bathingMachine.removePet();
                case 9 -> bathingMachine.washMachine();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida.");
            }

        } while (true);
    }


    private static void setWater() {
        System.out.println("Adicionando Água na Máquina.");
        bathingMachine.addWater();
    }


    private static void setShampoo() {
        System.out.println("Adicionando Shampoo na Máquina.");
        bathingMachine.addShampoo();
    }


    private static void checkifHasPetInMachine() {
        var hasPet = bathingMachine.hasPet();
        System.out.println(hasPet ? "Tem Pet no Banho." : "Não tem Pet no banho.");
    }
    

    public static void setPetInBathingMachine(){
        var name = "";
        while(name == null || name.isEmpty()){
            System.out.println("Informe o nome do Pet.");
            name = scanner.next();
        }
        var pet = new Pet(name);
        bathingMachine.setPet(pet);
        System.out.println(pet.getName() + " foi colocado para o banho.");
    }

    private static void verifyShampoo() {
        var amount = bathingMachine.getShampoo();
        System.out.println("A máquina está no momento com " + amount + " litro(s) de shampoo.");
    }

    private static void verifyWater() {
        var amount = bathingMachine.getWater();
        System.out.println("A máquina está no momento com " + amount + " litro(s) de Água.");
    }
}
