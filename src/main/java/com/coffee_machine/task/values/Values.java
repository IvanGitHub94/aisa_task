package com.coffee_machine.task.values;

import org.springframework.beans.factory.annotation.Value;

public class Values {

    //@Value("${water.limit}")
    public static final int WATER_LIMIT = 1000;

    //@Value("${milk.limit}")
    public static final int MILK_LIMIT = 1000;

    //@Value("${coffee.grams.limit}")
    public static final int COFFEE_LIMIT = 1000;

}
