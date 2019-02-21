package enzinium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TokenContractTest {

    @Test
    public void clssTest(){
        Address address = new Address();
        TokenContract rick = new TokenContract();
        assertNotNull(rick);}


    public void contractTest(){
        Address address = new Address();
        TokenContract ricknillos = new TokenContract();
        ricknillos.setName("Ricknillos");
        ricknillos.setSymbol("RNILL");
        ricknillos.setTotalSupply(100);
        assertEquals("Ricknillos", ricknillos.name());
        assertEquals("RNILL", ricknillos.symbol());
        assertEquals(100d, ricknillos.totalSuplly(), 0);
    }
}
