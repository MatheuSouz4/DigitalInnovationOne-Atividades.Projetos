public class Car {

    private boolean on;
    private int speed;
    private int gear; // Marchas de 0 a 6

    public Car() {
        // Regra: Começa desligado, em ponto morto (0) e velocidade 0
        this.on = false;
        this.speed = 0;
        this.gear = 0;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }
}