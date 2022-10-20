package juno.kma.lunch.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter @Setter
@ToString(exclude = "restaurantMenuList")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuCd;

    @Column(length = 30, nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private List<RestaurantMenu> restaurantMenuList = new ArrayList<>();
}
