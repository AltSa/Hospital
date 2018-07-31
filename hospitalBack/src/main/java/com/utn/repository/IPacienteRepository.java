package com.utn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.utn.modelo.Paciente;

@Repository
@Component
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {

}
