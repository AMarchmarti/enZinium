package enzinium;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class TokenContract {

        private PublicKey owner = null;
        private String name = null;
        private double totalSUpply = 0d;
        private String symbol = null;
        private Map<PublicKey, Double> balances = new HashMap<>();

        //CONSTRUCTOR
        public TokenContract (Address address){
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
}
