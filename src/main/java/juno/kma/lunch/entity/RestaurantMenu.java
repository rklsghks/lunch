package juno.kma.lunch.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Builder
@Getter
@Setter
@ToString(exclude = {"restaurant", "menu"})
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class RestaurantMenu implements Serializable {

    @Id
    @ManyToOne
//    @OneToOne
    @JoinColumn(name = "restaurant_cd")
    @EqualsAndHashCode.Include
    private Restaurant restaurant;

    @Id
    @ManyToOne
    @JoinColumn(name = "menu_cd")
    @EqualsAndHashCode.Include
    private Menu menu;
}
