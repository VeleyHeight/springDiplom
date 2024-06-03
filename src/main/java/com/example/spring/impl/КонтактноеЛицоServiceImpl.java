package com.example.spring.impl;

import com.example.spring.model.КонтактноеЛицо;
import com.example.spring.model.ОбъемПродукции;
import com.example.spring.repository.КонтактноеЛицоRepository;
import com.example.spring.repository.ОбъемRepository;
import com.example.spring.service.КонтактноеЛицоService;
import com.example.spring.service.ОбъемService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class КонтактноеЛицоServiceImpl implements КонтактноеЛицоService {
    private final КонтактноеЛицоRepository контактноеЛицоRepository;
    @Override
    public List<КонтактноеЛицо> findAll() {
        return контактноеЛицоRepository.findAll();
    }

    @Override
    public КонтактноеЛицо saveКонтактноеЛицо(КонтактноеЛицо контактноеЛицо) {
        return контактноеЛицоRepository.save(контактноеЛицо);
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

