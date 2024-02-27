package com.example.santamaria.santamaria_backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.santamaria.santamaria_backend.Entity.Empleado;
import com.example.santamaria.santamaria_backend.Repository.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Método para obtener todos los empleados
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepository.findAll();
    }

    // Método para obtener un empleado por su ID
    public Empleado obtenerEmpleadoPorId(Long id) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        return empleadoOptional.orElse(null);
    }

    // Método para crear un nuevo empleado
    public Empleado crearEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    // Método para actualizar un empleado existente
    public Empleado actualizarEmpleado(Long id, Empleado empleado) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        if (empleadoOptional.isPresent()) {
            Empleado empleadoExistente = empleadoOptional.get();
            empleadoExistente.setNombre(empleado.getNombre());
            empleadoExistente.setApellido(empleado.getApellido());
            empleadoExistente.setFechaNacimiento(empleado.getFechaNacimiento());
            empleadoExistente.setPuesto(empleado.getPuesto());
            empleadoExistente.setSueldo(empleado.getSueldo());
            return empleadoRepository.save(empleadoExistente);
        } else {
            return null;
        }
    }

    // Método para eliminar un empleado existente
    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}