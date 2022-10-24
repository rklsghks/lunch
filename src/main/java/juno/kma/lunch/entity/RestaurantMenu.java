package juno.kma.lunch.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@IdClass(RestaurantMenuId.class)
@Entity
public class RestaurantMenu {

    @Comment("식당 코드")
    @Id
    @ManyToOne
    @JoinColumn(name = "restaurant_cd")
    @JsonBackReference
    private Restaurant restaurant;

    @Comment("메뉴 코드")
    @Id
    @ManyToOne
    @JoinColumn(name = "menu_cd")
    @JsonBackReference
    private Menu menu;
}
