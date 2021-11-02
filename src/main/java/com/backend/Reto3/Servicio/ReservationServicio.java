package com.backend.Reto3.Servicio;

import com.backend.Reto3.ClasesReto5.ContadorClient;
import com.backend.Reto3.ClasesReto5.StatusReservas;
import com.backend.Reto3.Entidad.Reservation;
import com.backend.Reto3.Repositorio.ReservationRepositorio;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sebastian Arias
 */
@Service
public class ReservationServicio implements Serializable {

    /**
     * creación de variable de tipo Repositorio con la anotación
     */
    @Autowired
    private ReservationRepositorio metodosCrud;

    /**
     * metodo para obtener todos los datos de la tabla reservaciones
     */
    public List<Reservation> getAll() {
        return metodosCrud.getAll();
    }

    /**
     * metodo para obtener dato de la tabla reservaciones por Id
     *
     * @param reservationId
     * @return Optional de clase Reservacion
     */
    public Optional<Reservation> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    /**
     * metodo para registrar valores en la tabla reservaciones
     *
     * @param reservation
     * @return valor de calse Reservacion
     */
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);
        } else {
            Optional<Reservation> dateVerify = metodosCrud.getReservation(reservation.getIdReservation());
            if (dateVerify.isEmpty()) {
                return metodosCrud.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    /**
     * metodo para actualizar un dato de la tabla Reservaciones
     *
     * @param reservation
     * @return valor de calse Reservacion
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> dateVerify = metodosCrud.getReservation(reservation.getIdReservation());
            if (!dateVerify.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    dateVerify.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    dateVerify.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    dateVerify.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(dateVerify.get());
                return dateVerify.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * metodo para borrar un dato de la tabla Reservaciones por Id
     *
     * @param reservationId
     * @return aBoolean
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;   
    }

    //----------------------RETO5----------------------//
    /**
     * Metodo para adquirir status
     *
     * @return StatusReservas
     */
    public StatusReservas getRepStatusRes() {
        List<Reservation> completed = metodosCrud.ReservationStatus("completed");
        List<Reservation> cancelled = metodosCrud.ReservationStatus("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());
    }

    /**
     * metodo para el reporte de tiempo
     *
     * @param datoA
     * @param datoB
     * @return ListaReservaciones
     */
    public List<Reservation> reporteTiempoServicio(String datoA, String datoB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date datoUno = new Date();
        Date datoDos = new Date();

        try {
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (datoUno.before(datoDos)) {
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * metodo para reporte de clientes
     *
     * @return listaClientes
     */
    public List<ContadorClient> reporteClientesServicio() {
        return metodosCrud.getClientesRepositorio();
    }
}


