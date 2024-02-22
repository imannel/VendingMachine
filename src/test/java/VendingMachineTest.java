import org.example.Product;
import org.example.VendingMachine;
import org.example.exception.CoinNotValidException;
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


    }
}
