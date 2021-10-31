/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.Reto3.Servicio;

import com.backend.Reto3.Entidad.Category;
import com.backend.Reto3.Repositorio.CategoryRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServicio {
    
    @Autowired
    private CategoryRepositorio metodosCrud;

    public List<Category> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Category> getCategory(int categoryId) {
        return metodosCrud.getCategory(categoryId);
    }
    
    public Category save(Category category) {
        if (category.getId() == null) {
            return metodosCrud.save(category);
        } else {
            Optional<Category> categoria = metodosCrud.getCategory(category.getId());
            if (categoria.isEmpty()) {
                return metodosCrud.save(category);
            } else {
                return category;
            }
        }
    }
    
    //RETO4 UPDATE(PUT), BORRAR(DELETE)
    
        public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>cambiar=metodosCrud.getCategory(category.getId());
            if(!cambiar.isEmpty()){
                if(category.getDescription()!=null){
                    cambiar.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    cambiar.get().setName(category.getName());
                }
                return metodosCrud.save(cambiar.get());
            }
        }
        return category;
    }
        
    public boolean deletecategory(int categoryId) {
        Boolean eliminar = getCategory(categoryId).map(category -> {
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return eliminar;
    }
    
}
