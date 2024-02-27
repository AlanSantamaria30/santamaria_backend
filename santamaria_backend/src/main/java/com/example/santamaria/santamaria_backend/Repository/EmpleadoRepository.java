package com.example.santamaria.santamaria_backend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.santamaria.santamaria_backend.Entity.Empleado;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}