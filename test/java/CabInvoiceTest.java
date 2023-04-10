import org.example.CabInvoice;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.calculateTotalFare(10.0,4.0);
        Assert.assertEquals(104.0,totalFare);
    }
}