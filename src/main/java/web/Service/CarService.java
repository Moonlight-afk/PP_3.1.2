package web.Service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService implements CarInterface {
    private final List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(1, "BMW", "O777OO"));
        cars.add(new Car(2, "Lada", "A111AA"));
        cars.add(new Car(3, "Audi", "V151OV"));
        cars.add(new Car(4, "Lexus", "M124TT"));
        cars.add(new Car(5, "Mercedes", "B175YF"));
    }

    public List<Car> show(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
