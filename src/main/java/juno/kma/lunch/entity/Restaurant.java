package juno.kma.lunch.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@Getter @Setter
@ToString(exclude = {"restaurantMenus"})
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@DynamicInsert
@Entity
public class Restaurant {

    @Comment("식당 코드")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantCd;

    @Comment("식당 이름")
    @Column(length = 30, nullable = false)
    private String restaurantName;

    @Comment("대표 메뉴")
    @Column(length = 30)
    private String signatureMenu;

    @Comment("최근 방문 날짜")
    @ColumnDefault("(current_date)")
    private LocalDate restaurantLastVisitDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    private Set<RestaurantMenu> restaurantMenus = new LinkedHashSet<>();
}