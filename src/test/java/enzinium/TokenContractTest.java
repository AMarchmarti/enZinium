package enzinium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TokenContractTest {

    @Test
    public void clssTest(){
        Address address = new Address();
        TokenContract rick = new TokenContract(address);
        assertNotNull(rick);}

    @Test
    public void contractTest(){
        Address address = new Address();
        TokenContract ricknillos = new TokenContract(address);
        ricknillos.setName("Ricknillos");
        ricknillos.setSymbol("RNILL");
        ricknillos.setTotalSupply(100);
        assertEquals("Ricknillos", ricknillos.name());
        assertEquals("RNILL", ricknillos.symbol());
        assertEquals(100d, ricknillos.totalSupply(), 0);
    }

    @Test
    public void mapTest(){
        Address rick = new Address();
        TokenContract ricknillos = new TokenContract(rick);
        ricknillos.setTotalSupply(100);
        ricknillos.addOwner(rick.getPK(), ricknillos.totalSupply());
        ricknillos.setTotalSupply(500);
        ricknillos.addOwner(rick.getPK(), ricknillos.totalSupply());
        assertEquals(100, ricknillos.getBalances().get(rick.getPK()), 0);
    }

    @Test
    public void balanceNumTest(){
        Address rick = new Address();
        TokenContract ricknillos = new TokenContract(rick);
        ricknillos.setName("Ricknillos");
        ricknillos.setSymbol("RNILL");
        ricknillos.setTotalSupply(100);
        ricknillos.addOwner(rick.getPK(), ricknillos.totalSupply());
        assertEquals(1, ricknillos.numOwners(), 0);
        assertEquals(100d, ricknillos.balanceOf(rick.getPK()), 0);
    }

    @Test
    public void transferTest(){
        Address rick = new Address();
        rick.generateKeyPair();
        TokenContract ricknillos = new TokenContract(rick);
        ricknillos.setTotalSupply(100);
        ricknillos.addOwner(rick.getPK(), ricknillos.totalSupply());
        Address morty = new Address();
        morty.generateKeyPair();
        ricknillos.transfer(morty.getPK(), 2d);
        assertEquals(2d, ricknillos.getBalances().get(morty.getPK()), 0);
        assertEquals(98d, ricknillos.getBalances().get(rick.getPK()), 0);
        //Reventa test, aplicado aqui para aprovechar el codigo anterior
        Address jen = new Address();
        jen.generateKeyPair();
        ricknillos.transfer(morty.getPK(), jen.getPK(), 1d);
        assertEquals(1, ricknillos.getBalances().get(morty.getPK()), 0);
    }


    @Test
    public void payable_test() {

        Address rick = new Address();
        rick.generateKeyPair();
        TokenContract ricknillos = new TokenContract(rick);
        ricknillos.addOwner(rick.getPK(), 100d);
        Address morty = new Address();
        morty.generateKeyPair();

        morty.addEZI(20d);

        // verifico la transferencia de entradas
        ricknillos.payable(morty.getPK(), morty.getBalance());
        assertEquals(4d, ricknillos.balanceOf(morty.getPK()), 0d);

        // verifico la trasnferencia de EZI
        assertEquals(20d, ricknillos.owner().getBalance(), 0d);
    }
}
