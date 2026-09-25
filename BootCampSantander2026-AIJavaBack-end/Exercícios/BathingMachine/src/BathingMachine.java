public class BathingMachine {

    private boolean clean = true;

    private int water = 30;

    private int shampoo = 10;

    private Pet pet;

    public void takeAShower(){
        if(this.pet == null){
            System.out.println("Coloque um Pet para iniciar o banho.");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;
        pet.setClean(true);
        System.out.println("O " + pet.getName() + " está limpo.");
    }

    public void addWater(){
        if(water == 30){
        System.out.println("Capacidade de Água no Máximo.");
        return;
    }

    water += 2;
    
    }

    public void addShampoo(){
        if(shampoo == 10){
        System.out.println("Capacidade de Shampoo no Máximo.");
        return;
    }

    shampoo += 2;
    
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }


    public boolean hasPet(){
        return pet != null;
    }

    public void setPet(Pet pet) {
        if(!this.clean){
            System.out.println("Máquina de Banho suja, realize a limpeza para utilizar novamente.");
        }
        if(hasPet()){
            System.out.println("o" + this.pet.getName() + "está no banho no momento.");
        }


        this.pet = pet;
    }

    public void removePet(){
        this.clean = this.pet.isClean();
        System.out.println("Banho do " + this.pet.getName() + " foi finalizado.");
        this.pet = null;
    }

    public void washMachine(){

        this.water -= 3;
        this.shampoo -= 1;
        this.clean = true;
        System.out.println("Máquina foi limpa.");
    }
    
}
