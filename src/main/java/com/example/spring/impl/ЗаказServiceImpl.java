package com.example.spring.impl;

import com.example.spring.model.Заказ;
import com.example.spring.model.ИнформацияОТоваре;
import com.example.spring.model.Клиент;
import com.example.spring.repository.ЗаказRepository;
import com.example.spring.repository.ИнформацияОтовареRepository;
import com.example.spring.repository.КлиентRepository;
import com.example.spring.service.ЗаказService;
import com.example.spring.service.КлиентService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Primary
public class ЗаказServiceImpl implements ЗаказService {
    private final ЗаказRepository заказRepository;
    private final ИнформацияОтовареRepository информацияОтовареRepository;
    private final КлиентRepository клиентRepository;
    @Override
    public List<Заказ> findAll() {
        return заказRepository.findAll();
    }

    @Override
    public Заказ saveЗаказ(Заказ заказ) {
        return заказRepository.save(заказ);
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

