
package com.backend.Reto3.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class ortopedic
 */
@Entity
@Table(name = "ortopedic")
public class Ortopedic implements Serializable{
    
    /**
     * Columna idOrt
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /**
     * Columna name
     */
    @Column(length = 45)
    private String name;
    
    /**
     * Columna brand
     */
    @Column(length = 45)
    private String brand;

    /**
     * Columna year
     */
    @Column(length = 4)
    private Integer year;

    /**
     * Columna description
     */
    @Column(length = 250)
    private String description;
    
    /**
     * Relacion Category
     */ 
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("ortopedics")
    private Category category;
    
    /**
     * Relacion Messages
     */ 
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "ortopedic") 
    @JsonIgnoreProperties({"ortopedic", "client"}) 
    private List<Message> messages;
    
    /**
     * Relacion Reservation
     */ 
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "ortopedic")
    @JsonIgnoreProperties({"ortopedic", "client"})
    private List<Reservation> reservations;
    
    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand 
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year 
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category 
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * @param messages 
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * @return reservation
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * @param reservations 
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
