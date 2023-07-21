package org.javierherrera.model;

import java.io.Serializable;

public class Tamagotchi extends Egg implements Serializable {
    
    private int life, happiness, boredom, intelligence, hungry,sleepiness;
    private int weight;
    private long lifeTime;
    
    public Tamagotchi() {
    }

    public Tamagotchi(int life, long lifeTime, int weight, int happiness, int boredom, int intelligence, String name, String gender, int hungry, int sleepiness) {
        super(name, gender);
        this.life = life;
        this.lifeTime = lifeTime;
        this.weight = weight;
        this.happiness = happiness;
        this.boredom = boredom;
        this.intelligence = intelligence;
        this.hungry = hungry;
        this.sleepiness = this.sleepiness;
    }

    public int getLife() {
        return life;
    }

    public int getSleepiness() {
        return sleepiness;
    }

    public void setSleepiness(int sleepiness) {
        this.sleepiness = sleepiness;
    }
    
    public int getHungry() {
        return hungry;
    }

    public void setHungry(int hungry) {
        this.hungry = hungry;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public long getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(long lifeTime) {
        this.lifeTime = lifeTime;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getBoredom() {
        return boredom;
    }

    public void setBoredom(int boredom) {
        this.boredom = boredom;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
