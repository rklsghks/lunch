package juno.kma.lunch.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@EqualsAndHashCode(exclude = {"restaurant", "menu"})
public class RestaurantMenuId implements Serializable {

    private Long restaurant;
    private Long menu;
}