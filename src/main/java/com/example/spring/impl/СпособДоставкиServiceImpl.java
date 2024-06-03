package com.example.spring.impl;

import com.example.spring.model.Заказ;
import com.example.spring.model.СпособДоставки;
import com.example.spring.repository.ЗаказRepository;
import com.example.spring.repository.ИнформацияОтовареRepository;
import com.example.spring.repository.КлиентRepository;
import com.example.spring.repository.СпособДоставкиRepository;
import com.example.spring.service.ЗаказService;
import com.example.spring.service.СпособДоставкиService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class СпособДоставкиServiceImpl implements СпособДоставкиService {
    private final СпособДоставкиRepository способДоставкиRepository;

    @Override
    public List<СпособДоставки> findAll() {
        return способДоставкиRepository.findAll();
    }

    @Override
    public СпособДоставки saveСпособДоставки(СпособДоставки способДоставки) {
        return способДоставкиRepository.save(способДоставки);
    }

    @Override
    public СпособДоставки findById(int id) {
        return способДоставкиRepository.findById(id).orElse(null);
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

