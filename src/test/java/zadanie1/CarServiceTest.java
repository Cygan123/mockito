/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie1;

import java.util.HashMap;import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
 /*
 * @author Mateusz
 */
public class CarServiceTest {
    
    private Car car = mock(Car.class); 
    private CarDAO carDAO = mock(CarDAO.class);
    private CarService carService = new CarService();
    private HashMap<String, Long> hash = new HashMap<String, Long>();
    public CarServiceTest() {
    }
    

    /**
     * Test of findMileageBetweenYears method, of class CarService.
     */
    @Test
    public void testFindMileageBetweenYears1() 
    {
        carService.setEntityManager(carDAO);
        hash.put("2016", 20000L);
        hash.put("2017", 32999L);
        hash.put("2018", 5001L);
        when(car.getYearMileage()).thenReturn(hash);
        when(carDAO.findById(anyLong())).thenReturn(car);
        long result = carService.findMileageBetweenYears(12L, "2016", "2018");
        verify(car).getYearMileage();
        verify(carDAO).findById(anyLong());
        System.out.println(result);
        assertEquals(58000L, result);
    }

    @Test
    public void testFindMileageBetweenYears2() 
    {
        carService.setEntityManager(carDAO);
        hash.put("2016", 20000L);
        hash.put("2017", 32999L);
        hash.put("2018", 5001L);
        when(car.getYearMileage()).thenReturn(hash);
        when(carDAO.findById(anyLong())).thenReturn(car);
        long result = carService.findMileageBetweenYears(12L, "2014", "2015");
        verify(car).getYearMileage();
        verify(carDAO).findById(anyLong());
        System.out.println(result);
        assertEquals(0L, result);
    }    
    /**
     * Test of setEntityManager method, of class CarService.
     */
    
}
