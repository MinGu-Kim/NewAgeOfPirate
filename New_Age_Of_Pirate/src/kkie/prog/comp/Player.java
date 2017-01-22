/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkie.prog.comp;

public class Player {

    public String name;
    public int money;
    public int power;
    public int crews;
    public int weight;

    public int waterN;
    public int foodN;
    public int goldN;
    public int fishN;
    public int fruitN;
    public int silkN;

    public void setPlayer(String name, int money, int power, int crews, int weight, int waterN, int foodN, int goldN, int fishN, int fruitN, int silkN) {
        this.name = name;
        this.money = money;
        this.power = power;
        this.crews = crews;
        this.weight = weight;

        this.waterN = waterN;
        this.foodN = foodN;
        this.goldN = goldN;
        this.fishN = fishN;
        this.fruitN = fruitN;
        this.silkN = silkN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setCrews(int crews) {
        this.crews = crews;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setWaterN(int waterN) {
        this.waterN = waterN;
    }

    public void setFoodN(int foodN) {
        this.foodN = foodN;
    }

    public void setGoldN(int goldN) {
        this.goldN = goldN;
    }

    public void setFishN(int fishN) {
        this.fishN = fishN;
    }

    public void setFruitN(int fruitN) {
        this.fruitN = fruitN;
    }

    public void setSilkN(int silkN) {
        this.silkN = silkN;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getPower() {
        return power;
    }

    public int getCrews() {
        return crews;
    }

    public int getWeight() {
        return weight;
    }

    public int getWaterN() {
        return waterN;
    }

    public int getFoodN() {
        return foodN;
    }

    public int getGoldN() {
        return goldN;
    }

    public int getFishN() {
        return fishN;
    }

    public int getFruitN() {
        return fruitN;
    }

    public int getSilkN() {
        return silkN;
    }
    

}
