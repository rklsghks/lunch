package juno.kma.lunch.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter @Setter @ToString(exclude = "restaurantMenuList")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
//@IdClass(RestaurantMenu.class)
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuCd;

//    @Column(name = "restaurant_cd")
//    private Long restaurantCd;

    @Column(length = 30, nullable = false)
    private String name;

    @MapsId
    @OneToMany(mappedBy = "menu")
    private List<RestaurantMenu> restaurantMenuList = new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(name = "restaurant_cd")
//    private Restaurant restaurant;
}
