package juno.kma.lunch.repository;

import juno.kma.lunch.entity.Restaurant;
import juno.kma.lunch.entity.RestaurantMenu;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantMenuRepository extends JpaRepository<RestaurantMenu, Long> {

    @EntityGraph(attributePaths = {"restaurant", "menu"})
    @Query("select r from RestaurantMenu r")
    List<RestaurantMenu> findAllEntityGraph();
}
