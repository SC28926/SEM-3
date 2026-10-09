package polymorphism.assigment_problems;

public class Character {
    private final int maxHealth;
    private int currentHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            this.currentHealth = Math.max(0, this.currentHealth - amount);
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            this.currentHealth = Math.min(this.maxHealth, this.currentHealth + amount);
        }
    }

    public int getHealth() {
        return this.currentHealth;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        
        c.takeDamage(30);
        System.out.println("After taking 30 damage, health = " + c.getHealth());
        
        c.heal(50);
        System.out.println("After healing 50, health = " + c.getHealth());
        
        c.takeDamage(150);
        System.out.println("After taking 150 damage, health = " + c.getHealth());
    }
}