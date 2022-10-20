package juno.kma.lunch.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@IdClass(RestaurantMenuId.class)
@Entity
public class RestaurantMenu {

    @Id
    @ManyToOne
    @JoinColumn(name = "restaurant_cd")
    @JsonBackReference
    private Restaurant restaurant;

    @Id
    @ManyToOne
    @JoinColumn(name = "menu_cd")
    @JsonBackReference
    private Menu menu;
}
