package juno.kma.lunch.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@ToString(exclude = "restaurantMenuList")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
//@IdClass(RestaurantMenu.class)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantCd;

    @Column(length = 30, nullable = false)
    private String name;

//    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Menu> menuList = new ArrayList<>();
    @MapsId
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    private List<RestaurantMenu> restaurantMenuList = new ArrayList<>();
//    @OneToOne(mappedBy = "restaurant")
//    private RestaurantMenu restaurantMenu;

//    public void add(RestaurantMenu restaurantMenu) {
//        restaurantMenu.setRestaurant(this);
//        this.getRestaurantMenuList().add(restaurantMenu);
//    }
}
