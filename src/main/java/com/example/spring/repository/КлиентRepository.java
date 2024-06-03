package com.example.spring.repository;

import com.example.spring.model.Клиент;
import com.example.spring.model.Пользователь;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

@Table(name = "Клиент")
public interface КлиентRepository extends JpaRepository<Клиент,Integer> {
    Клиент findByПользователь(Пользователь user);

}
//    void deleteById(String id_obem);
//    Obem_product findByIdObem(String id_obem);

