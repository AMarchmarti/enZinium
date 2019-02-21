package enzinium;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class TokenContract {

        private PublicKey owner = null;
        private Address address;
        private String name = null;
        private double totalSUpply = 0d;
        private String symbol = null;
        private Map<PublicKey, Double> balances = new HashMap<>();

        //CONSTRUCTOR
        public TokenContract (Address address){
            this.address = address;
            this.owner = address.getPK();

        }


        //SETTERS

        public void setName(String name) {
            this.name = name;
        }

        public void setTotalSupply(double totalSUpply) {
            this.totalSUpply = totalSUpply;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }


        //GETTERS


        public String name() {
            return this.name;
        }

        public double totalSupply() {
            return this.totalSUpply;
        }

        public String symbol() {
            return this.symbol;
        }

        public Map<PublicKey, Double> getBalances() {
            return this.balances;
        }


        //LÓGICA

        @Override
        public String toString(){
            return "\n" + "name = " + name() +"\n"+
                    "symbol = " + symbol() + "\n" +
                    "totalSupply = " + totalSupply() + "\n"+
                    "owner Pk = " + owner.hashCode();
        }


        public void addOwner(PublicKey key, Double entradas){
            getBalances().putIfAbsent(key, entradas);
        }


        public Integer numOwners(){
            return getBalances().size();
        }


        public Double balanceOf(PublicKey key){
            if (getBalances().containsKey(key)){
                return getBalances().get(key);
            }else{
                return 0d;
                }
        }


        public void transfer(PublicKey key, Double cantidad){
            try{
                require(cantidad);
                changeTokens(key, cantidad);
            }catch (AssertionError e){}
        }


        public void require(Double cantidad){
            if ((cantidad > getBalances().get(owner)))
                throw new AssertionError();
        }


        public void changeTokens(PublicKey key, Double cantidad){
            getBalances().replace(owner, totalSupply() - cantidad);
            if (!getBalances().containsKey(key)){
                getBalances().put(key, cantidad);
            }else{
                getBalances().replace(key, getBalances().get(key) + cantidad);

            }
        }

}
