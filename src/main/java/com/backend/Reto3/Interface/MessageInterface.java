/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.Reto3.Interface;

import com.backend.Reto3.Entidad.Message;
import org.springframework.data.repository.CrudRepository;


public interface MessageInterface extends CrudRepository <Message, Integer>{
    
}
