package com.example.spring.impl;

import com.example.spring.model.Пользователь;
import com.example.spring.repository.ПользовательRepository;
import com.example.spring.service.ПользовательService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Primary
public class ПользовательServiceImpl implements ПользовательService {
    private final ПользовательRepository пользовательRepository;
    @Override
    public List<Пользователь> findAll() {
        return пользовательRepository.findAll();
    }

    @Override
    public Пользователь saveПользователь(Пользователь пользователь) {
        return пользовательRepository.save(пользователь);
    }

    @Override
    public boolean existsByЛогин(String логин) {
        return пользовательRepository.existsByЛогин(логин);
    }

    @Override
    public Optional<Пользователь> findByЛогин(String логин) {
        return пользовательRepository.findByЛогин(логин);
    }
}
//    @Override
//    public ОбъемПродукции saveObem(ОбъемПродукции obem) {
//        return obemRepository.save(obem);
//    }

//    @Override
//    public Obem_product findObemId(String id_obem) {
//        return obemRepository.findByIdObem(id_obem);
//    }

//    @Override
//    public void deleteObem(String id_obem) {
//        obemRepository.deleteById(id_obem);
//    }

//    @Override
//    public ОбъемПродукции updateObem(ОбъемПродукции obem) {
//        return obemRepository.save(obem);
//    }

