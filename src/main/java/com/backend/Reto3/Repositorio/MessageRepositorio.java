/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.Reto3.Repositorio;

import com.backend.Reto3.Entidad.Message;
import com.backend.Reto3.Interface.MessageInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepositorio {
    
    @Autowired
    private MessageInterface crudMessage;
    
    public List<Message> getAll() {
        return (List<Message>) crudMessage.findAll();
    }
    
    public Optional<Message> getMessage(int id) {
        return crudMessage.findById(id);
    }
    
    public Message save(Message message) {
        return crudMessage.save(message);
    }
    
    public void delete(Message message) {
        crudMessage.delete(message);
    }
}
