package com.example.demo.services;

import com.example.demo.modal.Klient;
import com.example.demo.repository.KlientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class KlientService {
    private final KlientRepository klientRepository;

    public KlientService(KlientRepository klientRepository) {
        this.klientRepository = klientRepository;
    }

    public List<Klient> findAll(){
        List<Klient> klients = new ArrayList<>();
        for (Klient klient : klientRepository.findAll()){
            klients.add(klient);
        }
        return klients;
    }
}
