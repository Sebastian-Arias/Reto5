/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.Reto3.Repositorio;

import com.backend.Reto3.Entidad.Category;
import com.backend.Reto3.Interface.CategoryInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositorio {
    
    @Autowired
    private CategoryInterface crudCategory;
    
    public List<Category> getAll(){
        return (List<Category>) crudCategory.findAll();
    }
    
    public Optional<Category> getCategory(int id){
        return crudCategory.findById(id);
    }
    
    public Category save(Category categoria) {
        return crudCategory.save(categoria);
    }

    public void delete(Category categoria) {
        crudCategory.delete(categoria);
    }
}
