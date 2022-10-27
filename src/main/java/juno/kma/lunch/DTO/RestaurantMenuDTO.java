package juno.kma.lunch.DTO;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestaurantMenuDTO {

    private RestaurantDTO restaurant;
    private MenuDTO menu;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class RestaurantDTO {
        private Long restaurantCd;
        private String restaurantName;
        private LocalDate lastVisitDate;
        private String signatureMenu;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class MenuDTO {
        private Long menuCd;
        private String menuName;
    }

}

