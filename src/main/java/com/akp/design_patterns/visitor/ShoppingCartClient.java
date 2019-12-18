package com.akp.design_patterns.visitor;

public class ShoppingCartClient {
    public static void main(String[] args) {
        ItemElement[] itemElements = new ItemElement[]{
                new Book(20, "1234"), new Book(30, "abcd"),
                new Fruit("orange", 10, 1),
                new Fruit("mango", 20, 2)
        };

        int total = 0;
        total = calculatePrice(itemElements);
        System.out.println("Total Cost : " + total);
    }

    private static int calculatePrice(ItemElement[] itemElements) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for (ItemElement itemElement : itemElements) {
            sum += itemElement.accept(visitor);
        }
        System.out.println("sum : " + sum);
        return sum;
    }
}
