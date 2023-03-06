package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Dao.CarDao;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {
    private final CarDao carDao;
    @Autowired
    public CarsController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping("/cars")
    public String show(@RequestParam(value = "count", defaultValue = "5",required = false) int count, Model Car) {
        System.out.println(count);
        Car.addAttribute("cars",carDao.show(count));
        return "cars";
    }
}