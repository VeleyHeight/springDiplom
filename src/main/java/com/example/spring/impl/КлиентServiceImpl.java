package com.example.spring.impl;

import com.example.spring.model.Клиент;
import com.example.spring.model.ОбъемПродукции;
import com.example.spring.model.Пользователь;
import com.example.spring.repository.КлиентRepository;
import com.example.spring.repository.ОбъемRepository;
import com.example.spring.service.КлиентService;
import com.example.spring.service.ОбъемService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class КлиентServiceImpl implements КлиентService {
    private final КлиентRepository клиентRepository;
    @Override
    public List<Клиент> findAll() {
        return клиентRepository.findAll();
    }

    @Override
    public Клиент saveКлиент(Клиент клиент) {
        return клиентRepository.save(клиент);
    }

    @Override
    public Клиент findById(int id) {
        return клиентRepository.findById(id).orElse(null);
    }


    @Override
    public Клиент findByПользователь(Пользователь user) {
        return клиентRepository.findByПользователь(user);
    }

    @Override
    public Клиент updateКлиент(int clientCode, String firm, String mainOrganization, String inn, String kpp, String address, String region, String companyFormUR, String companyFormIP, String clientSurname, String clientName, String clientPatronymic, String phoneNumber, String email) {
        Клиент клиент = клиентRepository.findById(clientCode).orElseThrow(() -> new RuntimeException("Клиент не найден"));

        клиент.setНаименование(firm);
        клиент.setField(mainOrganization);
        клиент.setИнн(inn);
        клиент.setКпп(Integer.parseInt(kpp));
        клиент.setАдрес(address);
        клиент.setРегион(region);
        клиент.setField1(companyFormUR);
        клиент.setField1(companyFormIP);
        клиент.getField3().setФамилия(clientSurname);
        клиент.getField3().setИмя(clientName);
        клиент.getField3().setОтчество(clientPatronymic);
        клиент.getField3().setТелефон(phoneNumber);
        клиент.getField3().setEmail(email);

        return клиентRepository.save(клиент);
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

