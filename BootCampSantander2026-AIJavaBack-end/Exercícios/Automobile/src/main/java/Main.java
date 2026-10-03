import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private final static CarAction carAction = new CarAction();

    public static void main(String[] args) {

        var option = -1;

        do {
            System.out.println("\n======== Controle do Carro ========");
            System.out.println("1 - Entrar no Carro (Criar)");
            System.out.println("2 - Ligar o carro");
            System.out.println("3 - Desligar o carro");
            System.out.println("4 - Acelerar (+1 km/h)");
            System.out.println("5 - Diminuir a velocidade (-1 km/h)");
            System.out.println("6 - Subir marcha (+1)");
            System.out.println("7 - Reduzir marcha (-1)");
            System.out.println("8 - Virar para a esquerda");
            System.out.println("9 - Virar para a direita");
            System.out.println("10 - Verificar painel (Velocidade/Marcha)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> createCar();
                case 2 -> carAction.turnOn();
                case 3 -> carAction.turnOff();
                case 4 -> carAction.accelerate();
                case 5 -> carAction.decelerate();
                case 6 -> carAction.shiftGearUp();
                case 7 -> carAction.shiftGearDown();
                case 8 -> carAction.turn("Esquerda");
                case 9 -> carAction.turn("Direita");
                case 10 -> carAction.checkPanel();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida.");
            }

        } while (true);
    }

    private static void createCar() {
        if (carAction.hasCar()) {
            System.out.println("Você já possui um carro no sistema.");
            return;
        }
        var car = new Car();
        carAction.setCar(car);
        System.out.println("Carro instanciado! Ele está desligado, em ponto morto (0) e a 0 km/h.");
    }
}