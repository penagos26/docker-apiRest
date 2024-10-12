package com.uptc.frw.lafabrica.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "LIBROS")
public class BookMy {

    @Id
    @Column(name = "ID_LIBRO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TITULO")
    private String title;
    @Column(name = "PRECIO")
    private Double price;

    public BookMy(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookMy{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
