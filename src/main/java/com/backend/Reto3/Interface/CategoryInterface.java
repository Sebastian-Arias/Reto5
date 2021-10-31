/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.Reto3.Interface;

import com.backend.Reto3.Entidad.Category;
import org.springframework.data.repository.CrudRepository;


public interface CategoryInterface extends CrudRepository <Category, Integer>{
    
}
