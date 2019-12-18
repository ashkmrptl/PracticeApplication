package com.akp.design_patterns.visitor;


public class Fruit implements ItemElement {
    private String name;
    private int pricePerKG;
    private int weight;

    public Fruit(String name, int pricePerKG, int weight) {
        this.name = name;
        this.pricePerKG = pricePerKG;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getPricePerKG() {
        return pricePerKG;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
