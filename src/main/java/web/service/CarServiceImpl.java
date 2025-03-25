package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> cars;

    public CarServiceImpl() {
        this.cars = new ArrayList<>(List.of(
                new Car(1, "Volkswagen", 2011),
                new Car(2, "BMW", 2012),
                new Car(3, "Mercedes", 2013),
                new Car(4, "Audi", 2014),
                new Car(5, "Skoda", 2015)));
    }

    @Override
    public List<Car> getCars(int count) {
        return cars.subList(0, Math.min(count, cars.size()));
    }
}
