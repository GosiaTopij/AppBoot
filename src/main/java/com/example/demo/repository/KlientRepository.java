package com.example.demo.repository;

import com.example.demo.modal.Klient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface KlientRepository extends JpaRepository<Klient, Integer> {
}
