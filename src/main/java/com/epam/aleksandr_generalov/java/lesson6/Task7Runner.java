package com.epam.aleksandr_generalov.java.lesson6;

import com.epam.aleksandr_generalov.java.lesson6.models.Car;
import com.epam.aleksandr_generalov.java.lesson6.models.LightCar;
import com.epam.aleksandr_generalov.java.lesson6.models.WeightCar;
import com.epam.aleksandr_generalov.java.lesson6.utils.CollectionUtils;
import com.epam.aleksandr_generalov.java.lesson6.utils.NegativeNumberException;
import com.epam.aleksandr_generalov.java.lesson6.utils.Serializator;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class Task7Runner {

    private static Scanner scanner = new Scanner(System.in);
    private static final String lightCar = "com.epam.aleksandr_generalov.java.lesson6.models.LightCar";
    private static final String weightCar = "com.epam.aleksandr_generalov.java.lesson6.models.WeightCar";

    public static void main(String[] args) {
        Task7Runner runner = new Task7Runner();
        runner.startApplication();
    }

    private void startApplication() {
        try {
            System.out.println("Please enter number of light cars:");
            int numberOfCars = scanner.nextInt();
            if (numberOfCars < 0) {
                throw new NegativeNumberException(numberOfCars);
            }
            ArrayList<LightCar> lightCars = (ArrayList<LightCar>) createArrayOfCars(lightCar, numberOfCars);
            System.out.println("Please enter number of weight cars:");
            numberOfCars = scanner.nextInt();
            if (numberOfCars < 0) {
                throw new NegativeNumberException(numberOfCars);
            }
            ArrayList<WeightCar> weightCars = (ArrayList<WeightCar>) createArrayOfCars(weightCar, numberOfCars);
            if (lightCars != null && weightCars != null) {
                while (true) {
                    System.out.println("Please enter action: 'add' - add information, 'edit' - edit information, " +
                            "'remove' - remove information, 'cost' - get sum of all car's costs, 'sort' - sort cars by fuel consumption," +
                            " 'find' - find car by parameters, 'read' - read information about car from file, " +
                            "'write' - write information about car in file, 'exit' - exit from application");
                    String action = scanner.nextLine();
                    String carType;
                    int index;
                    switch (action) {
                        case "add":
                            carType = chooseTypeOfCar();
                            if (carType != null && carType.equals(LightCar.class.getName())) {
                                lightCars.add((LightCar) addSingleCar(carType));
                            } else {
                                weightCars.add((WeightCar) addSingleCar(carType));
                            }
                            break;
                        case "edit":
                            carType = chooseTypeOfCar();
                            index = enterIndex();
                            if (carType != null && carType.equals(LightCar.class.getName())) {
                                lightCars.set(index, (LightCar) addSingleCar(carType));
                            } else {
                                weightCars.set(index, (WeightCar) addSingleCar(carType));
                            }
                            break;
                        case "remove":
                            carType = chooseTypeOfCar();
                            index = enterIndex();
                            if (carType != null && carType.equals(LightCar.class.getName())) {
                                lightCars.remove(index);
                            } else {
                                weightCars.remove(index);
                            }
                            break;
                        case "cost":
                            showParkCost(lightCars, weightCars);
                            break;
                        case "sort":
                            carType = chooseTypeOfCar();
                            if (carType != null && carType.equals(LightCar.class.getName())) {
                                lightCars.sort(LightCar.LightCarComparator);
                                CollectionUtils.print(lightCars);
                            } else {
                                weightCars.sort(WeightCar.WeightCarComparator);
                                CollectionUtils.print(weightCars);
                            }
                            break;
                        case "find":
                            carType = chooseTypeOfCar();
                            if (carType != null && carType.equals(LightCar.class.getName())) {
                                LightCar enteredLightCar = (LightCar) addSingleCar(lightCar);
                                if (enteredLightCar != null && lightCars.contains(enteredLightCar)) {
                                    System.out.println(enteredLightCar.toString());
                                }
                            } else {
                                WeightCar enteredWeightCar = (WeightCar) addSingleCar(weightCar);
                                if (enteredWeightCar != null && weightCars.contains(enteredWeightCar)) {
                                    System.out.println(enteredWeightCar.toString());
                                }
                            }
                            break;
                        case "read":
                            System.out.println("Enter name of file");
                            System.out.println(Serializator.readFile(scanner.nextLine()));
                            break;
                        case "write":
                            carType = chooseTypeOfCar();
                            if (carType != null && carType.equals(LightCar.class.getName())) {
                                System.out.println("Please enter index for light car:");
                                index = scanner.nextInt();
                                System.out.println("Enter name of file");
                                scanner.nextLine();
                                Serializator.writeFile(scanner.nextLine(), lightCars.get(index));
                            } else {
                                System.out.println("Please enter index for weight car:");
                                index = scanner.nextInt();
                                System.out.println("Enter name of file");
                                scanner.nextLine();
                                Serializator.writeFile(scanner.nextLine(), weightCars.get(index));
                            }
                            break;
                        case "exit":
                            return;
                        default:
                            System.out.println("Please enter correct action!");
                    }
                }
            }
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }

    private void showParkCost(ArrayList<LightCar> lightCars, ArrayList<WeightCar> weightCars) {
        Integer totalCost = 0;
        for (LightCar lightCar : lightCars) {
            totalCost += lightCar.getCost();
        }
        for (WeightCar weightCar : weightCars) {
            totalCost += weightCar.getCost();
        }
        System.out.println("Total park cost is " + totalCost);
    }

    private int enterIndex() {
        try {
            System.out.println("Please enter index:");
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Unhandled exception!");
        }
        return 0;
    }

    private String chooseTypeOfCar() {
        try {
            while (true) {
                System.out.println("Please choose car type: 'l' - light, 'w' - weight");
                String action = scanner.nextLine();
                switch (action) {
                    case "l":
                        return lightCar;
                    case "w":
                        return weightCar;
                    default:
                        System.out.println("Please enter correct type!");
                }
            }
        } catch (Exception e) {
            System.out.println("Unhandled exception!");
        }
        return null;
    }

    private ArrayList<?> createArrayOfCars(String templateClass, int size) {
        try {
            ArrayList<Object> listOfCars = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                listOfCars.add(addSingleCar(templateClass));
            }
            return listOfCars;
        } catch (Exception e) {
            System.out.println("Unhandled exception!");
        }
        return null;
    }

    private Object addSingleCar(String templateClass) {
        try {
            Car commonInformation = enterCommonInformationAboutCar();
            if (commonInformation != null) {
                if (templateClass.equals(LightCar.class.getName())) {
                    return new LightCar(commonInformation.getName(), commonInformation.getDefaultFuelConsuption(), commonInformation.getCost(),
                            commonInformation.getNameOfMark(), commonInformation.getNameOfModel(), readArrayOfWeightsForLightCar());
                } else {
                    return new WeightCar(commonInformation.getName(), commonInformation.getDefaultFuelConsuption(), commonInformation.getCost(),
                            commonInformation.getNameOfMark(), commonInformation.getNameOfModel(), readArrayOfWeightsForWeightCar());
                }
            }
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Car enterCommonInformationAboutCar() throws NegativeNumberException {
        Car car = new Car();
        System.out.println("Enter car's name:");
        scanner.nextLine();
        car.setName(scanner.nextLine());
        System.out.println("Enter default fuel consumption:");
        Integer defaultFuelConsumption = scanner.nextInt();
        if (defaultFuelConsumption < 0) {
            throw new NegativeNumberException(defaultFuelConsumption);
        } else {
            car.setDefaultFuelConsuption(defaultFuelConsumption);
        }
        System.out.println("Enter car's cost:");
        Integer cost = scanner.nextInt();
        if (cost < 0) {
            throw new NegativeNumberException(cost);
        } else {
            car.setCost(cost);
        }
        System.out.println("Enter name of car's mark:");
        scanner.nextLine();
        car.setNameOfMark(scanner.nextLine());
        System.out.println("Enter name of car's model:");
        car.setNameOfModel(scanner.nextLine());
        return car;
    }

    private Integer[] readArrayOfWeightsForLightCar() throws NegativeNumberException {
        System.out.println("Please number of weights for passengers:");
        int arraySize = scanner.nextInt();
        if (arraySize < 0) {
            throw new NegativeNumberException(arraySize);
        }
        Integer[] result = new Integer[arraySize];
        for (int i = 0; i < result.length; i++) {
            System.out.println("Please enter weight of passenger:");
            int weight = scanner.nextInt();
            if (weight < 0) {
                throw new NegativeNumberException(weight);
            } else {
                result[i] = weight;
            }
        }
        return result;
    }

    private Pair[] readArrayOfWeightsForWeightCar() throws NegativeNumberException {
        System.out.println("Please number of weights for cargoes:");
        int arraySize = scanner.nextInt();
        if (arraySize < 0) {
            throw new NegativeNumberException(arraySize);
        }
        Pair[] result = new Pair[arraySize];
        for (int i = 0; i < result.length; i++) {
            System.out.println("Please enter coefficient:");
            int coefficient = scanner.nextInt();
            if (coefficient < 0) {
                throw new NegativeNumberException(coefficient);
            }
            System.out.println("Please enter weight:");
            int weight = scanner.nextInt();
            if (weight < 0) {
                throw new NegativeNumberException(weight);
            }
            result[i] = new Pair(coefficient, weight);
        }
        return result;
    }
}