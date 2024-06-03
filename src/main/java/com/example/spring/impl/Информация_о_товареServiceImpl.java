package com.example.spring.impl;

import com.example.spring.model.ИнформацияОТоваре;
import com.example.spring.repository.ИнформацияОтовареRepository;
import com.example.spring.service.ИнформацияОТовареService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class Информация_о_товареServiceImpl implements ИнформацияОТовареService {
    private final ИнформацияОтовареRepository информацияОтовареRepository;

    @Override
    public List<ИнформацияОТоваре> findAll() {
        return информацияОтовареRepository.findAll();
    }

    @Override
    public List<Object[]> findAllWithName() {
        return информацияОтовареRepository.findAllWithName();
    }

    @Override
    public ИнформацияОТоваре findById(int id) {
        return информацияОтовареRepository.findById(id).orElse(null);
    }
}
