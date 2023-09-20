/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv.practicaweb07;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Johan
 */
@Named(value = "empleadoBean")
@SessionScoped
public class EmpleadoBean implements Serializable{
    
    private Empleado empleado;
    private EmpleadoDAO dao;
    
    public EmpleadoBean(){
        Empleado empleado=new Empleado();
        EmpleadoDAO dao =new EmpleadoDAO();
    }

    public Empleado getEmpleado(){
        return empleado;
    }
    
    public void setEmpleado(){
        this.empleado = empleado;
    }
    
    public void guardar(){
    
        boolean res=dao.guardar(empleado);
        if(res)
            System.out.println("Se guardo");
        else
            System.out.println("Error ...");
    }
    
    public void mensaje(String msg){
    
        FacesContext.getCurrentInstance().addMessage(null, new
                FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje ", msg));
    
    }
    
   
}
