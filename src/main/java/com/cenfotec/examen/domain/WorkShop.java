package com.cenfotec.examen.domain;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Set;

@Entity
public class WorkShop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String autor;
    private String objetivo;
    private String keyword1;
    private String keyword2;
    private String keyword3;
    private LocalTime duracionTotal = LocalTime.of(0,0);

   @ManyToOne
   @JoinColumn(name="cart_id", nullable = false)
   private Category category;

   @OneToMany(fetch=FetchType.LAZY, mappedBy="workshop")
   private Set<Activity> activity;

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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1;
    }

    public String getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(String keyword2) {
        this.keyword2 = keyword2;
    }

    public String getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(String keyword3) {
        this.keyword3 = keyword3;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Activity> getActivity() {
        return activity;
    }

    public void setActivity(Set<Activity> activity) {
        this.activity = activity;
    }

    public LocalTime getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(LocalTime duracionTotal) {
        this.duracionTotal = duracionTotal;
    }
}
