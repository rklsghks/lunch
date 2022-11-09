package juno.kma.lunch.controller;

import juno.kma.lunch.DTO.RestaurantMenuDTO;
import juno.kma.lunch.Service.RestaurantMenuService;
import juno.kma.lunch.Service.RestaurantService;
import juno.kma.lunch.entity.Menu;
import juno.kma.lunch.entity.Restaurant;
import juno.kma.lunch.entity.RestaurantMenu;
import juno.kma.lunch.repository.RestaurantMenuRepository;
import juno.kma.lunch.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RequestMapping("restaurant")
@RestController
public class RestaurantController {

    private RestaurantService restaurantService;
    private RestaurantRepository restaurantRepository;
    private RestaurantMenuRepository restaurantMenuRepository;
    private RestaurantMenuService restaurantMenuService;

    /* 식당 추가 */
    @PostMapping("add")
    public void addRestaurant(Restaurant restaurant) {

        log.info(restaurant);

        restaurantRepository.save(restaurant);
    }

    /* 식당 리스트 조회 */
    @GetMapping("list")
    public List<RestaurantMenuDTO> getRestaurantList() {

        List<RestaurantMenuDTO> restaurantMenuDTOList = restaurantMenuService.findAllEntityGraph();
        log.info(restaurantMenuDTOList);

        return restaurantMenuDTOList;
    }

    @PostMapping("menu/add")
    public void addRestaurantMenu(RestaurantMenu restaurantMenu) {
        restaurantMenuRepository.save(restaurantMenu);
    }

}