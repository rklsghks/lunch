package juno.kma.lunch.controller;

import juno.kma.lunch.Service.MenuService;
import juno.kma.lunch.entity.Menu;
import juno.kma.lunch.repository.MenuRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RequestMapping("menu")
@RestController
public class MenuController {

    private MenuService menuService;
    private MenuRepository menuRepository;

    @PostMapping("add")
    public void add(Menu menu) {

        menuRepository.save(menu);
    }

    @GetMapping("list")
    public List<Menu> getMenuList() {

        return menuRepository.findAll();
    }
}