package com.altia.a3ASESORparser.model.pizza;

import lombok.Data;

@Data
public class Order {

    private String pizzaType;
    private double pizzaPrice;
    private String orderStatus;
    private String customerName;
    private String customerPhone;
    private boolean ingredientCheese;
    private boolean ingredientOlives;
    private boolean ingredientPepper;
    private boolean ingredientSalami;
    private boolean ingredientMushrooms;
    private boolean ingredientVegetables;

}
