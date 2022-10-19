package juno.kma.lunch.Service;

import juno.kma.lunch.entity.Restaurant;
import juno.kma.lunch.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;
    public void save(Restaurant restaurant) {

        restaurantRepository.save(restaurant);
    }

    public List<Restaurant> findAll() {

        return restaurantRepository.findAll();
    }

}
