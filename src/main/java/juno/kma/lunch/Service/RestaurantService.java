package juno.kma.lunch.Service;

import juno.kma.lunch.DTO.RestaurantMenuDTO;
import juno.kma.lunch.entity.Restaurant;
import juno.kma.lunch.repository.RestaurantMenuRepository;
import juno.kma.lunch.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@AllArgsConstructor
@Service
public class RestaurantService {

    private ModelMapper modelMapper;
    private RestaurantRepository restaurantRepository;
    private RestaurantMenuRepository restaurantMenuRepository;

    public void save(Restaurant restaurant) {

        restaurantRepository.save(restaurant);
    }

    public List<Restaurant> findAll() {

        return restaurantRepository.findAll();
    }

    public List<RestaurantMenuDTO> findAllEntityGraph() {

        log.info(restaurantRepository.findAllEntityGraph());

        List<RestaurantMenuDTO> restaurantMenuDTOList
                = restaurantRepository.findAllEntityGraph().stream()
                .map(restaurantMenu -> modelMapper.map(restaurantMenu, RestaurantMenuDTO.class))
                .collect(Collectors.toList());

        return restaurantMenuDTOList;
    }
}