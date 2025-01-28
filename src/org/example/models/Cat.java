package org.example.models;

import java.util.ArrayList;

public class Cat extends org.example.models.Pet {

    public Cat(String name, String birthday, double weight, String type) {
        super(name, birthday, weight, type);
    }

    @Override
    public ArrayList<String> getCommand_animal() {
        command_animal.add("Climb");
        return command_animal;
    }

}