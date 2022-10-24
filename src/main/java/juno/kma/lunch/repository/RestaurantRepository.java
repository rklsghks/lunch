package juno.kma.lunch.repository;

import juno.kma.lunch.entity.Restaurant;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    /* fetch join */
    @Query("select r from Restaurant r join fetch r.restaurantMenus")
    List<Restaurant> findAllFetchJoin();

    @EntityGraph(attributePaths = {"restaurantMenus.menu"})
    @Query("select r from Restaurant r")
    List<Restaurant> findAllEntityGraph();
}
