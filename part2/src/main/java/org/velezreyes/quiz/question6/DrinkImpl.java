package org.velezreyes.quiz.question6;

public class DrinkImpl implements Drink{
    private final String name;
    private final boolean isFizzy;
    private final int price;

    public DrinkImpl(String name, boolean isFizzy, int price) {
        this.name = name;
        this.isFizzy = isFizzy;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isFizzy() {
        return isFizzy;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
