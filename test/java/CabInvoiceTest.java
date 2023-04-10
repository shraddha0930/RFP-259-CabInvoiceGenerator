import org.example.CabInvoice;
import org.example.Ride;
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
}