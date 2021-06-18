package com.edu.iua.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.iua.model.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer>{

}
