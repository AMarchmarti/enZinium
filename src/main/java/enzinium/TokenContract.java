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
        private double COSTE = 5.0;

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

        public PublicKey owner(){ return this.owner;}


        //LÓGICA

        @Override
        public String toString(){
            return "\n" + "name = " + name() +"\n"+
                    "symbol = " + symbol() + "\n" +
                    "totalSupply = " + totalSupply() + "\n"+
                    "owner Pk = " + owner().hashCode();
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
            if ((cantidad > getBalances().get(owner())))
                throw new AssertionError();
        }


        public void changeTokens(PublicKey key, Double cantidad){
            setTotalSupply(totalSupply() - cantidad);
            getBalances().replace(owner(), totalSupply());
            if (!getBalances().containsKey(key)){
                getBalances().put(key, cantidad);
            }else{
                getBalances().replace(key, getBalances().get(key) + cantidad);

            }
        }


        public void require(PublicKey keyVendedor, Double cantidad){
            if (cantidad > getBalances().get(keyVendedor)){
                throw new AssertionError();
            }
        }

        public void transfer(PublicKey kVendedor, PublicKey kComprador, Double cantidad){
            try{
                require(kVendedor, cantidad);
                getBalances().replace(kVendedor, getBalances().get(kVendedor) - cantidad);
                if(!getBalances().containsKey(kComprador)){
                    getBalances().put(kComprador, cantidad);
                }else{
                    getBalances().replace(kComprador, getBalances().get(kComprador) + cantidad);
                }
            }catch (AssertionError e){}
        }


        public void owners(){
            for (PublicKey pKey : getBalances().keySet()){
                if (!pKey.equals(owner())){
                    System.out.println("Owners = " + pKey.hashCode() + " " + getBalances().get(pKey) + " " + symbol());
                }
            }
        }


        public Double totalTokensSold(){
            double cont = 0d;
            for (PublicKey pKey : getBalances().keySet()){
                if(!pKey.equals(owner())){
                    cont += getBalances().get(pKey);
                }
            }
            return cont;
        }


        public void payable(PublicKey pKey, Double cantidad){
            if ((cantidad % COSTE) == 0){
                transfer(pKey, cantidad / COSTE);
                address.transferEZI(owner(), cantidad);}
        }

}
