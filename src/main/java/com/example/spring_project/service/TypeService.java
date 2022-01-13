package com.example.spring_project.service;

import com.example.spring_project.exception.alreadyexists.TypeAlreadyExistsException;
import com.example.spring_project.exception.notfound.TypeNotFoundException;
import com.example.spring_project.model.Type;
import com.example.spring_project.repository.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TypeService {
    private TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Type addType(Type type) {
        checkUniqueType(type);
        typeRepository.addType(type);
        return getTypeByName(type.getName());
    }

    public List<Type> getAllTypes() {
        return typeRepository.getAllTypes();
    }

    public Type getTypeById(Long id) {
        Optional<Type> typeOptional = typeRepository.getTypeById(id);
        if (typeOptional.isPresent()){
            return typeOptional.get();
        } else {
            throw new TypeNotFoundException();
        }
    }

    public void deleteTypeById(Long id) {
        int result = typeRepository.deleteTypeById(id);
        if (result == 0) {
            throw new TypeNotFoundException();
        }
    }

    public Type updateType(Type type) {
        Optional<Type> typeOptional = typeRepository.getTypeById(type.getId());
        if (typeOptional.isEmpty()){
            throw new TypeNotFoundException();
        }
        checkUniqueType(type);
        typeRepository.updateType(type);
        return getTypeByName(type.getName());
    }

    private void checkUniqueType(Type type) {
        Optional<Type> typeOptional = typeRepository.getTypeByName(type.getName());
        if (typeOptional.isPresent()){
            throw new TypeAlreadyExistsException();
        }
    }

    private Type getTypeByName(String name) {
        Optional<Type> typeOptional = typeRepository.getTypeByName(name);
        if (typeOptional.isPresent()){
            return typeOptional.get();
        } else {
            throw new TypeNotFoundException();
        }
    }
}
