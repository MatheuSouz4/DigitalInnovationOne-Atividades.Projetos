public class CarAction {

    private Car car;

    public boolean hasCar() {
        return car != null;
    }

    public void setCar(Car car) {
        if (hasCar()) {
            System.out.println("Você já está em um carro.");
            return;
        }
        this.car = car;
    }

    private boolean isCarAvailableAndOn() {
        if (!hasCar()) {
            System.out.println("Crie o carro primeiro para usar as funções.");
            return false;
        }
        if (!car.isOn()) {
            System.out.println("O carro está desligado. Nenhuma função pode ser realizada.");
            return false;
        }
        return true;
    }

    public void turnOn() {
        if (!hasCar()) {
            System.out.println("Crie o carro primeiro.");
            return;
        }
        if (car.isOn()) {
            System.out.println("O carro já está ligado.");
            return;
        }
        car.setOn(true);
        System.out.println("O carro foi ligado! Vrum vrum!");
    }

    public void turnOff() {
        if (!hasCar()) {
            System.out.println("Crie o carro primeiro.");
            return;
        }
        if (!car.isOn()) {
            System.out.println("O carro já está desligado.");
            return;
        }
        // Regra: O carro só desliga em ponto morto e a 0 km/h
        if (car.getGear() == 0 && car.getSpeed() == 0) {
            car.setOn(false);
            System.out.println("O carro foi desligado com segurança.");
        } else {
            System.out.println("Para desligar, coloque em ponto morto (marcha 0) e pare o carro (0 km/h).");
        }
    }

    public void accelerate() {
        if (!isCarAvailableAndOn()) return;

        if (car.getGear() == 0) {
            System.out.println("Você não pode acelerar em ponto morto.");
            return;
        }

        if (car.getSpeed() >= 120) {
            System.out.println("Velocidade máxima (120 km/h) atingida!");
            return;
        }

        int newSpeed = car.getSpeed() + 1;

        // Verifica se a nova velocidade estoura o limite da marcha atual
        if (newSpeed > getMaxSpeedForGear(car.getGear())) {
            System.out.println("Limite de velocidade da " + car.getGear() + "ª marcha atingido! Suba a marcha para continuar acelerando.");
        } else {
            car.setSpeed(newSpeed);
            System.out.println("Acelerou! Velocidade atual: " + car.getSpeed() + " km/h.");
        }
    }

    public void decelerate() {
        if (!isCarAvailableAndOn()) return;

        if (car.getSpeed() == 0) {
            System.out.println("O carro já está totalmente parado.");
            return;
        }

        int newSpeed = car.getSpeed() - 1;

        // Se não estiver em ponto morto, verifica se frear vai deixar a velocidade abaixo do limite da marcha
        if (car.getGear() != 0 && newSpeed < getMinSpeedForGear(car.getGear())) {
            System.out.println("Velocidade muito baixa para esta marcha! Reduza a marcha antes de diminuir mais a velocidade.");
        } else {
            car.setSpeed(newSpeed);
            System.out.println("Diminuiu a velocidade. Velocidade atual: " + car.getSpeed() + " km/h.");
        }
    }

    public void shiftGearUp() {
        if (!isCarAvailableAndOn()) return;

        int currentGear = car.getGear();
        if (currentGear == 6) {
            System.out.println("Você já está na última marcha (6).");
            return;
        }

        int targetGear = currentGear + 1;
        // Para subir a marcha, a velocidade atual deve estar perto ou dentro do limite da próxima marcha
        if (car.getSpeed() >= getMinSpeedForGear(targetGear) - 1) {
            car.setGear(targetGear);
            System.out.println("Marcha aumentada para: " + targetGear);
        } else {
            System.out.println("Velocidade insuficiente para a " + targetGear + "ª marcha. Acelere mais.");
        }
    }

    public void shiftGearDown() {
        if (!isCarAvailableAndOn()) return;

        int currentGear = car.getGear();
        if (currentGear == 0) {
            System.out.println("Você já está em ponto morto (0).");
            return;
        }

        int targetGear = currentGear - 1;
        // Para reduzir, verifica se a velocidade é suportada pela marcha de baixo
        if (targetGear == 0 || car.getSpeed() <= getMaxSpeedForGear(targetGear) + 1) {
            car.setGear(targetGear);
            System.out.println("Marcha reduzida para: " + targetGear);
        } else {
            System.out.println("Velocidade muito alta para a " + targetGear + "ª marcha. Diminua a velocidade primeiro.");
        }
    }

    public void turn(String direction) {
        if (!isCarAvailableAndOn()) return;

        int speed = car.getSpeed();
        if (speed >= 1 && speed <= 40) {
            System.out.println("O carro virou para a " + direction + " com segurança.");
        } else {
            System.out.println("Impossível virar! A velocidade deve estar entre 1 e 40 km/h. Sua velocidade é " + speed + " km/h.");
        }
    }

    public void checkPanel() {
        if (!hasCar()) {
            System.out.println("Crie o carro primeiro.");
            return;
        }
        System.out.println("\n--- PAINEL DO CARRO ---");
        System.out.println("Status: " + (car.isOn() ? "LIGADO" : "DESLIGADO"));
        System.out.println("Velocidade: " + car.getSpeed() + " km/h");
        System.out.println("Marcha: " + (car.getGear() == 0 ? "Ponto Morto (0)" : car.getGear()));
        System.out.println("-----------------------");
    }

    // Abstração: Métodos auxiliares para gerenciar as regras dos limites de velocidade
    private int getMinSpeedForGear(int gear) {
        switch (gear) {
            case 1: return 0;
            case 2: return 21;
            case 3: return 41;
            case 4: return 61;
            case 5: return 81;
            case 6: return 101;
            default: return 0; // Ponto morto
        }
    }

    private int getMaxSpeedForGear(int gear) {
        switch (gear) {
            case 1: return 20;
            case 2: return 40;
            case 3: return 60;
            case 4: return 80;
            case 5: return 100;
            case 6: return 120;
            default: return 120; // Ponto morto tem limite dinâmico caso desengate correndo
        }
    }
}