/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.Reto3.Repositorio;

import com.backend.Reto3.ClasesReto5.ContadorClient;
import com.backend.Reto3.Entidad.Client;
import com.backend.Reto3.Entidad.Reservation;
import com.backend.Reto3.Interface.ReservationInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepositorio {
    
    @Autowired
    private ReservationInterface crudReservation;
    
    public List<Reservation> getAll() {
        return (List<Reservation>) crudReservation.findAll();
    }
    
    public Optional<Reservation> getReservation(int id) {
        return crudReservation.findById(id);
    }
    
    public Reservation save(Reservation reservation) {
        return crudReservation.save(reservation);
    }
    
    public void delete(Reservation reservation) {
        crudReservation.delete(reservation);
    }
    
    //----------------------RETO5----------------------//
    
    public List<Reservation> ReservationStatus(String status) {
        return crudReservation.findAllByStatus(status);
    }

    public List<Reservation> ReservacionTiempoRepositorio(Date a, Date b) {
        return crudReservation.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<ContadorClient> getClientesRepositorio() {
        List<ContadorClient> res = new ArrayList<>();
        List<Object[]> report = crudReservation.countTotalReservationsByClient();
        for (int i = 0; i < report.size(); i++) {
            res.add(new ContadorClient((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return res;
    }
}
