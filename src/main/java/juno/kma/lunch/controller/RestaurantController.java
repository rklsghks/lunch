package juno.kma.lunch.controller;

import juno.kma.lunch.Service.MenuService;
import juno.kma.lunch.Service.RestaurantService;
import juno.kma.lunch.entity.Menu;
import juno.kma.lunch.entity.Restaurant;
import juno.kma.lunch.entity.RestaurantMenu;
import juno.kma.lunch.repository.MenuRepository;
import juno.kma.lunch.repository.RestaurantMenuRepository;
import juno.kma.lunch.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.BatchSize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@Log4j2
@AllArgsConstructor
@RequestMapping("restaurant")
@RestController
public class RestaurantController {

    private RestaurantService restaurantService;
    private RestaurantRepository restaurantRepository;
    private RestaurantMenuRepository restaurantMenuRepository;

    @PostMapping("add")
    public void addRestaurant(Restaurant restaurant) {

        RestaurantMenu restaurantMenu = RestaurantMenu.builder()
                .restaurant(restaurant)
                .build();
//        restaurant.setRestaurantMenuList();

        restaurantService.save(restaurant);
    }

    @BatchSize(size = 1)
    @GetMapping("list")
    public List<Restaurant> getRestaurantList() {

        return restaurantRepository.findAll();
    }

    @PostMapping("menu/add")
    public void addRestaurantMenu() {

        Restaurant restaurant = Restaurant.builder()
                .restaurantCd(1L)
                .build();

        Menu menu = Menu.builder()
                .menuCd(1L)
                .build();

        RestaurantMenu restaurantMenu = RestaurantMenu.builder()
                .restaurant(restaurant)
                .menu(menu)
                .build();

        restaurantMenuRepository.save(restaurantMenu);
    }

}