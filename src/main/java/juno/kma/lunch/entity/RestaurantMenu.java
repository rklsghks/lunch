package juno.kma.lunch.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Builder
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@IdClass(RestaurantMenuId.class)
@Entity
public class RestaurantMenu {

    @Comment("식당 코드")
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_cd")
    @JsonBackReference
//    @JsonManagedReference
    private Restaurant restaurant;

    @Comment("메뉴 코드")
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_cd")
    @JsonBackReference
//    @JsonManagedReference
    private Menu menu;
}