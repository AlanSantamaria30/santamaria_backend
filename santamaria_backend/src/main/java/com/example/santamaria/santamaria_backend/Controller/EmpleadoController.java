package com.example.santamaria.santamaria_backend.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.santamaria.santamaria_backend.Entity.Empleado;
import com.example.santamaria.santamaria_backend.ResponseController.ApiResponse;
import com.example.santamaria.santamaria_backend.Service.EmpleadoService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService; 

    // Endpoint para obtener todos los empleados
    @GetMapping
    public ApiResponse obtenerTodosLosEmpleados() {
        ApiResponse response = new ApiResponse();
        try {
            List<Empleado> empleados = empleadoService.obtenerTodosLosEmpleados();
            response.setStatus(true);
            response.setMsg("Empleados encontrados total: " + empleados.size());
            response.setData(empleados);
        } catch (Exception e) {
            response.setStatus(false);
            response.setMsg("Error al obtener los empleados: " + e.getMessage());
            response.setData(null);
        }
        return response;
    }

    // Endpoint para obtener un empleado por su ID
    @GetMapping("/{id}")
    public Empleado obtenerEmpleadoPorId(@PathVariable Long id) {
        return empleadoService.obtenerEmpleadoPorId(id);
    }

    // Endpoint para crear un nuevo empleado
    @PostMapping
    public ApiResponse crearEmpleado(@RequestBody Empleado empleado) {
        ApiResponse response = new ApiResponse();

        try {
            empleadoService.crearEmpleado(empleado);
            List<Empleado> empleados = empleadoService.obtenerTodosLosEmpleados();
            response.setStatus(true);
            response.setMsg("Empleados encontrados total: " + empleados.size());
            response.setData(empleados);
        } catch (Exception e) {
            response.setStatus(false);
            response.setMsg("Error al obtener los empleados: " + e.getMessage());
            response.setData(null);
        }
        return response;
    }

    // Endpoint para actualizar un empleado existente
    @PutMapping("/{id}")
    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        return empleadoService.actualizarEmpleado(id, empleado);
    }

    // Endpoint para eliminar un empleado existente
    @DeleteMapping("/{id}")
    public ApiResponse eliminarEmpleado(@PathVariable Long id) {

        ApiResponse response = new ApiResponse();

        try {
            Empleado empleados = empleadoService.obtenerEmpleadoPorId(id);
            if(empleados != null){
                empleadoService.eliminarEmpleado(id);
                response.setStatus(true);
                response.setMsg("Empleado eliminado con el Id: " + id);
            }else{
                response.setStatus(false);
                response.setMsg("No existe el empleado con el Id: " + id);
            }
            
        } catch (Exception e) {
            response.setStatus(false);
            response.setMsg("Error al obtener los empleados: " + e.getMessage());
            response.setData(null);
        }
        return response;
        
    }
}
