/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.Reto3.Repositorio;

import com.backend.Reto3.Entidad.Client;
import com.backend.Reto3.Interface.ClientInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositorio {
    
    @Autowired
    private ClientInterface crudClient;
    
    public List<Client> getAll() {
        return (List<Client>) crudClient.findAll();
    }
    
    public Optional<Client> getClient(int id) {
        return crudClient.findById(id);
    }
    
    public Client save(Client client) {
        return crudClient.save(client);
    }
    
    public void delete(Client client) {
        crudClient.delete(client);
    }
}
