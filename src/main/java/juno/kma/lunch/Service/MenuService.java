package juno.kma.lunch.Service;

import juno.kma.lunch.entity.Menu;
import juno.kma.lunch.repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MenuService {

    private MenuRepository menuRepository;
    public void save(Menu menu) {

        menuRepository.save(menu);
    }
}
