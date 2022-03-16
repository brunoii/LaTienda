package com.laTienda.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laTienda.dominio.*;


public interface ISesion extends JpaRepository<Sesion, Integer>{
}
