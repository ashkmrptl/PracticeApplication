package com.akp.design_patterns.visitor;

/**
 * Visitor pattern is one of the behavioural design pattern. It is basically used when we have
 * to perform an operation on a group of similar kind of objects. With the help of this design pattern,
 * we can move the operational logic to other class.
 * <p>
 * The visitor design patter consists of two parts.
 * a) A method called visit() which is implemented by every visitor and is called for every element
 * in the DataStructure.
 * <p>
 * b) Visitable classes providing accept() methods that accepts a visitor.
 */

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

    int cost = 0;

    @Override
    public int visit(Book book) {
        //Apply 5 RS discount if the book price is more than 50
        if (book.getPrice() > 50) {
            cost = book.getPrice() - 5;
        } else {
            cost = book.getPrice();
        }
        System.out.println("Book ISBN : " + book.getIsbnNumber() + " cost = " + cost);
        return 0;
    }

    @Override
    public int visit(Fruit fruit) {
        int cost = fruit.getPricePerKG() * fruit.getWeight();
        System.out.println(fruit.getName() + " cost = " + cost);
        return cost;
    }
}
