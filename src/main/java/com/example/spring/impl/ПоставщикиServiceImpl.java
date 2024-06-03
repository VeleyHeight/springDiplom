package com.example.spring.impl;

import com.example.spring.model.Поставщики;
import com.example.spring.repository.ОбъемRepository;
import com.example.spring.repository.ПоставщикиRepository;
import com.example.spring.service.ПоставщикиService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@Primary
public class ПоставщикиServiceImpl implements ПоставщикиService {
    private final ПоставщикиRepository поставщикиRepository;
    @Override
    public List<Поставщики> findAll() {
        return поставщикиRepository.findAll();
    }
}
