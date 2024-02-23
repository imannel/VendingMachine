import org.example.Product;
import org.example.VendingMachine;
import org.example.exception.CoinNotValidException;
import org.example.exception.ProductNotAvailableException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {


    @Test
    public void shouldAcceptCoint() {
        VendingMachine vm = new VendingMachine();
        assertEquals(true, vm.isValidCoin(5));
    }

    @Test
    public void shouldNotAcceptCoint() {
        VendingMachine vm = new VendingMachine();
        assertEquals(false, vm.isValidCoin(3));
    }

    @Test
    public void testInsertCoint() {
        VendingMachine vm = new VendingMachine();
        assertDoesNotThrow(() -> vm.insertCoin(10));
        assertEquals(1, vm.getBalance().size());
    }

    @Test
    public void testInsertCointShouldThrowException() {
        VendingMachine vm = new VendingMachine();
        assertThrows(CoinNotValidException.class, () -> vm.insertCoin(3));
        assertEquals(0, vm.getBalance().size());
    }
    @Test
    public void shouldCalculeTotalBalance(){
        VendingMachine vm = new VendingMachine();
        vm.getBalance().add(10);
        vm.getBalance().add(5);
        vm.getBalance().add(2);
        vm.getBalance().add(2);
        assertEquals(19,vm.calculateTotalBalance());

    }
    @Test
    public void testSelectProduct(){
        VendingMachine vm = new VendingMachine();
        assertEquals("water", vm.selectProduct("water").getName());


    }
    @Test
    public void testSelectProductShouldThrowException(){
        VendingMachine vm = new VendingMachine();
        assertThrows(ProductNotAvailableException.class, ()->vm.selectProduct("pringls"));


    }
    @Test
    public void testCancelRequest(){
        VendingMachine vm = new VendingMachine();
        vm.selectProduct("water");
        vm.insertCoin(5);
        vm.cancelRequest();
        assertFalse(vm.getSelected());
        assertTrue(vm.getBalance().isEmpty());

    }
    @Test
    public void testBuyProduct(){
        VendingMachine vm = new VendingMachine();
        vm.insertCoin(5);
        vm.selectProduct("water");
        String result=vm.buyProduct(10);
        assertEquals("product is water and remain is 5",result);

    }
}
