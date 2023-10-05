package seminars.second.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    public void testCarIsInstanceOfVehicle() {
        Car car = new Car("Dodge", "Ram", 2010);
        Assertions.assertTrue(car instanceof Vehicle);
    }

    @Test
    public void testCarsNumWheels() {
        Car car = new Car("Dodge", "Ram", 2010);
        assertEquals(4, car.getNumWheels());
    }

    @Test
    public void testMotorCycleNumWheels() {
        Motorcycle motorcycle = new Motorcycle("Suzuki", "Hayabusa", 2018);
        assertEquals(2, motorcycle.getNumWheels());
    }

    @Test
    public void testCarSpeed() {
        Car car = new Car("Dodge", "Ram", 2010);
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    public void testMotorCycleSpeed() {
        Motorcycle motorcycle = new Motorcycle("Suzuki", "Hayabusa", 2018);
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    @Test
    public void testCarSpeedAfterPark() {
        Car car = new Car("Dodge", "Ram", 2010);
        car.testDrive();
        assertEquals(60, car.getSpeed());
        car.park();
        assertEquals(0, car.getSpeed());
    }

    @Test
    public void testMotorCycleSpeedAfterPark() {
        Motorcycle motorcycle = new Motorcycle("Suzuki", "Hayabusa", 2018);
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }

}