package com.example.santamaria.santamaria_backend.ResponseController;

import java.util.List;

import com.example.santamaria.santamaria_backend.Entity.Empleado;

public class ApiResponse {
    private boolean status;
    private String msg;
    private List<Empleado> data;
    public ApiResponse() {
    }

    public ApiResponse(boolean status, String msg, List<Empleado> data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    // Getters y setters
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Empleado> getData() {
        return data;
    }

    public void setData(List<Empleado> data) {
        this.data = data;
    }
}
