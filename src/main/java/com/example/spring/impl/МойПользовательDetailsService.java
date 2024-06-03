package com.example.spring.impl;

import com.example.spring.config.МойПользовательDetails;
import com.example.spring.model.Пользователь;
import com.example.spring.repository.ПользовательRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class МойПользовательDetailsService implements UserDetailsService {
    @Autowired
    private ПользовательRepository пользовательRepository;

    @Override
    public UserDetails loadUserByUsername(String логин) throws UsernameNotFoundException {
//        Пользователь пользователь = пользовательRepository.findByЛогин(логин)
//                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
//        return new МойПользовательDetails(пользователь);
        Optional<Пользователь> user = пользовательRepository.findByЛогин(логин);
        return user.map(МойПользовательDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(логин + " not found"));
    }
}
