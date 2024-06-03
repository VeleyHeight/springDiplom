package com.example.spring.impl;

import com.example.spring.model.ОбъемПродукции;
import com.example.spring.repository.ОбъемRepository;
import com.example.spring.service.ОбъемService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class ОбъемServiceImpl implements ОбъемService {
    private final ОбъемRepository объемRepository;
    @Override
    public List<ОбъемПродукции> findAll() {
        return объемRepository.findAll();
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

