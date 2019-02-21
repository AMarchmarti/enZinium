package enzinium;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.sun.jndi.cosnaming.IiopUrl;
import org.junit.Test;

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
}

