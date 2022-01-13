package com.example.spring_project.exception.notfound;

import com.example.spring_project.exception.notfound.NotFoundException;

public class TypeNotFoundException extends NotFoundException {
    public TypeNotFoundException() {
        super("Type not found");
    }
}
