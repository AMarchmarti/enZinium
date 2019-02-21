package enzinium;

import com.sun.jndi.cosnaming.IiopUrl;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest
{

    @Test
    public void clssTest(){
        Address address = new Address();
        assertNotNull(address);
}

    @Test
    public void generateKeyTest(){
        Address address = new Address();
        address.generateKeyPair();
        assertNotNull(address.getPK());
        assertNotNull(address.getSK());
    }

    @Test
    public void transferEZI_test() {
        Address rick = new Address();
        rick.generateKeyPair();
        rick.addEZI(20d);
        assertEquals(20d, rick.getBalance(), 0);
        /*
        rick.transferEZI(20d);
        assertEquals(40d, rick.getBalance(), 0d);*/
    }
}

