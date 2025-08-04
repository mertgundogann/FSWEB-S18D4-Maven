package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    private final BurgerDao burgerDao;
    @Autowired
    public BurgerController(BurgerDao burderDao){
        this.burgerDao = burderDao;
    }
    @PostMapping
    public Burger save(@RequestBody Burger burger){
        BurgerValidation.checkName(burger.getName());
        return burgerDao.save(burger);
    }
    @GetMapping
    public List<Burger> findAll(){
        return burgerDao.findAll();

    }
    @GetMapping("/{id}")
    public Burger find(@PathVariable long id){
        return burgerDao.findById(id);

    }
    @PutMapping
    public Burger update(@RequestBody Burger burger){
        BurgerValidation.checkName(burger.getName());
        return burgerDao.update(burger);
    }
    @DeleteMapping("/{id}")
    public Burger remove (@PathVariable long id){
        return burgerDao.remove(id);

    }
}
