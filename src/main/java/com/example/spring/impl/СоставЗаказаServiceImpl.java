package com.example.spring.impl;

import com.example.spring.model.СоставЗаказа;
import com.example.spring.repository.СоставЗаказаRepository;
import com.example.spring.service.СоставЗаказаService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class СоставЗаказаServiceImpl implements СоставЗаказаService {
    private final СоставЗаказаRepository составЗаказаRepository;
    @Override
    public List<СоставЗаказа> findAll() {
        return составЗаказаRepository.findAll();
    }

    @Override
    public СоставЗаказа saveСоставЗаказа(СоставЗаказа составЗаказа) {
        return составЗаказаRepository.save(составЗаказа);
    }

    @Override
    public List<СоставЗаказа> saveAll(List<СоставЗаказа> составЗаказа) {
        return составЗаказаRepository.saveAll(составЗаказа);
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

