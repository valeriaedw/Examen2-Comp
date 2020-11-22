package com.cenfotec.examen.domain;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String notes;
    private LocalTime hour;

    @ManyToOne
    @JoinColumn(name="workshop_actividad",nullable = false)
    private WorkShop workshop;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(String hour) {
        String[] time = hour.split(":");
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);


        this.hour = LocalTime.of(h,m);;
    }

    public WorkShop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(WorkShop workshop) {
        this.workshop = workshop;
    }

    @Override
    public String toString() {
        return
                "Nombre: " + name + '\n' +
                "Descripcion: " + description + '\n' +
                "Notas: " + notes + '\n' +
                "Hora: " + hour;
    }
}
