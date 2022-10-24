package juno.kma.lunch.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@Getter @Setter
@ToString(exclude = "restaurantMenus")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class Menu {

    @Comment("식당 코드")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuCd;

    @Comment("메뉴 이름")
    @Column(length = 30, nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private Set<RestaurantMenu> restaurantMenus = new LinkedHashSet<>();
}
