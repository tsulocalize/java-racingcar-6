package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager {
    private final List<Car> cars;

    public CarManager(InputManager inputManager) {
        List<Car> cars = new ArrayList<>();
        for (String name: inputManager.getNames()) {
            cars.add(new Car(name));
        }
        this.cars = cars;
    }

    public void runCars() {
        for (Car car: cars) {
            car.run();
        }
    }

    public void printWinner() {
         int maxPosition = cars.stream()
                 .max(Comparator.comparing(Car::getPosition))
                 .orElseThrow()
                 .getPosition();

         List<String> winner = cars.stream()
                 .filter(car -> car.getPosition() == maxPosition)
                 .map(Car::getName)
                 .collect(Collectors.toList());

         System.out.println(String.join(", ", winner));
    }

    public void printResult() {
        for (Car car: cars) {
            System.out.printf("%s : ", car.getName());
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}