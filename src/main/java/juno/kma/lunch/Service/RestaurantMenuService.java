package juno.kma.lunch.Service;

import juno.kma.lunch.DTO.RestaurantMenuDTO;
import juno.kma.lunch.entity.Restaurant;
import juno.kma.lunch.entity.RestaurantMenu;
import juno.kma.lunch.repository.RestaurantMenuRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@AllArgsConstructor
@Service
public class RestaurantMenuService {

    private ModelMapper modelMapper;
    private RestaurantMenuRepository restaurantMenuRepository;


    public List<RestaurantMenuDTO> findAllEntityGraph() {

        List<RestaurantMenuDTO> restaurantMenuDTOList
                = restaurantMenuRepository.findAllEntityGraph().stream()
                .map(restaurantMenuEntity -> modelMapper.map(restaurantMenuEntity, RestaurantMenuDTO.class))
                .collect(Collectors.toList());

        return restaurantMenuDTOList;
    }
}