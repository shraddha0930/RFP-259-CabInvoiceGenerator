import org.example.CabInvoice;
import org.example.Invoice;
import org.example.Ride;
import org.example.RideRepository;
import org.junit.Test;
import org.testng.Assert;

public class CabInvoiceTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.calculateTotalFare(10.0,4.0);
        Assert.assertEquals(104.0,totalFare);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare(){
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.calculateTotalFare(0.1,1.0);
        Assert.assertEquals(5.0,totalFare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnAggregateTotalFare(){
        CabInvoice cabInvoice = new CabInvoice();
        Ride[] rides = {new Ride(10.0,4.0),new Ride(5.0,5.0),new Ride(0.1,1.0)};
        double aggregateTotalFare = cabInvoice.calculateTotalFare(rides);
        Assert.assertEquals(164.0,aggregateTotalFare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoice(){
        CabInvoice cabInvoice = new CabInvoice();
        Ride[] rides = {new Ride(10.0,4.0),new Ride(12.0,5.0),new Ride(0.1,1.0)};
        Invoice expectedInvoice = new Invoice(3,234.0,78.0);
        Invoice actualInvoice = cabInvoice.generateInvoice(rides);
        Assert.assertEquals(expectedInvoice,actualInvoice);
    }

    @Test
    public void givenUserId_ShouldReturnInvoice(){
        RideRepository rideRepository = new RideRepository();
        Ride[] ride1 = {new Ride(10.0,4.0),new Ride(12.0,5.0),new Ride(0.1,1.0)};
        Ride[] ride2 = {new Ride(12.0,3.0),new Ride(14.0,5.0),new Ride(0.1,3.0)};
        rideRepository.addRides(1,ride1);
        rideRepository.addRides(2,ride2);
        Invoice expectedInvoice1 = new Invoice(3,234.0,78.0);
        Invoice expectedInvoice2 = new Invoice(3,273.0,91.0);
        Invoice actualInvoice1 = rideRepository.getInvoiceFromUserId(1);
        Invoice actualInvoice2 = rideRepository.getInvoiceFromUserId(2);
        Assert.assertEquals(expectedInvoice1,actualInvoice1);
        Assert.assertEquals(expectedInvoice2,actualInvoice2);
    }
}