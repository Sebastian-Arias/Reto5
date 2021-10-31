/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.Reto3.Repositorio;

import com.backend.Reto3.Entidad.Ortopedic;
import com.backend.Reto3.Interface.OrtopedicInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrtopedicRepositorio {
    
    @Autowired
    private OrtopedicInterface crudOrtopedic;

    public List<Ortopedic> getAll(){
        return (List<Ortopedic>) crudOrtopedic.findAll();
    }

    public Optional<Ortopedic> getOrtopedic(int id){
        return crudOrtopedic.findById(id);
    }

    public Ortopedic save(Ortopedic ortopedic){
        return crudOrtopedic.save(ortopedic);
    }
    public void delete(Ortopedic ortopedic){
        crudOrtopedic.delete(ortopedic);
    }
    
}
