package com.akp.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalClassExample {
    public static void main(String[] args) {
        ofAndOfNullable();
        objectCreation();
        checkingValues();
        orElseAndOrElseGetDifference();
    }

    /**
     * Optional.of() vs Optional.ofNullable() :
     * We should use Optional.of(obj) when we know for sure the obj will never null, else it throws null pointer exception.
     * And when we are not sure about obj, we should use Optional.ofNullable(obj)
     */
    private static void ofAndOfNullable() {
        final String message = "Hello World!";
        System.out.println("message -> " + message + "\n");

        final Optional<String> genderOptional = Optional.of(message);
        System.out.println("Optional.of(message) -> " + genderOptional);
        System.out.println("Optional.of(message).get() -> " + genderOptional.get());
        try {
            final Optional<Object> o = Optional.of(null);
        } catch (java.lang.NullPointerException e) {
            System.out.println("Optional.of(null) -> java.lang.NullPointerException \n");
        }

        System.out.println("Optional.empty() -> " + Optional.empty() + "\n");

        System.out.println("Optional.ofNullable(null) -> " + Optional.ofNullable(null));
        System.out.println("Optional.ofNullable(message) -> " + Optional.ofNullable(message));
        System.out.println("Optional.ofNullable(message).get() -> " + Optional.ofNullable(message).get());
    }

    private static void checkingValues() {
        final Optional<String> optional = Optional.of("Ashish");
        // Using isPresent()
        System.out.println("is value present : " + optional.isPresent());

        // ifPresent()
        optional.ifPresent(name -> System.out.println(name.length()));

        // Default value with orElse
        // orElse() is used to retrieve value wrapped inside an Optional instance
        // orElse() sets default value, if the value inside Optional is null then
        // default value is returned, else the value wrapped inside it is returned
        final String nullName = null;
        final String name = Optional.ofNullable(nullName).orElse("Patel");
        System.out.println("name : " + name);

        // orElseget() is similar to orElse() but instead of taking value to return is
        // the Optional value is not present, it takes a Supplier functional interface
        // which is invoked and the result of invocation is returned
        final String orElsegetName = Optional.ofNullable(nullName).orElseGet(() -> "ashish");
        System.out.println("orElsegetName : " + orElsegetName);

        // orElseThrow() unlike orElse() and orElseget() throws an exception when value
        // is not available
        //String returnStr = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
        //System.out.println("returnStr : " + returnStr);

        Optional<String> opt = Optional.ofNullable(nullName);
        try {
            System.out.println("value : " + opt.get());
        } catch (NoSuchElementException ex) {
            System.out.println("opt.get() : " + ex.getMessage());
        }

    }

    private static void orElseAndOrElseGetDifference() {
        // Another difference of orElse() and orElseGet() is, orElse() set default value
        // even if the Optional has value, but orElseGet() doesn't do that
        final String str1 = null;
        Optional.ofNullable(str1).orElse(getDefaultValue());
        Optional.ofNullable(str1).orElseGet(OptionalClassExample::getDefaultValue);

        final String str2 = "text";
        Optional.ofNullable(str2).orElse(getDefaultValue());
        Optional.ofNullable(str2).orElseGet(OptionalClassExample::getDefaultValue);
    }

    private static void orElseThrowExample() throws Exception {
        final List<String> list = new ArrayList<>();

        Optional.ofNullable(list).filter(List::isEmpty).orElseThrow(() -> new Exception("empty list"));
    }

    private static String getDefaultValue() {
        System.out.println("get default called");
        return "default";
    }

    private static void objectCreation() {
        // Creating empty Optional object
        final Optional<String> empty = Optional.empty();
        // isPresent() is used to check if there is a value inside optional object
        System.out.println("empty.isPresent() : " + empty.isPresent());

        // Creating Optional object using static method of()
        final String name = "Ashish";
        final Optional<String> optional = Optional.of(name);
        System.out.println("is present : " + optional.isPresent());
        System.out.println("value : " + optional.get());
        System.out.println(optional);
        // The value passed to the of() method can not be null, else it throws
        // NullPointerException
        // optional = Optional.of(null);

        // When we expect some null values then we can use ofNullable()
        final String str = "Kumar";
        Optional<String> opt = Optional.ofNullable(str);
        System.out.println(opt);
        // Using ofNnullable() we can send null value, in that case empty Optional class
        // is instantiated
        // and it doesn't throw NullPointerException
        opt = Optional.ofNullable(null);
        System.out.println(opt);
    }
}
