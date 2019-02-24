package enzinium;

import java.security.PrivateKey;
import java.security.PublicKey;

public class Address {

        private PublicKey PK = null;
        private PrivateKey SK = null;
        private double balance = 0d;
        private String symbol = "EZI";


        //SETTERS


        public void setPK(PublicKey PK) {
            this.PK = PK;
        }

        public void setSK(PrivateKey SK) {
            this.SK = SK;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        //GETTERS

        public PublicKey getPK() {
            return PK;
        }

        public PrivateKey getSK() {
            return SK;
        }

        public double getBalance() {
            return this.balance;
        }

        public String getSymbol() {
            return this.symbol;
        }


        //LÓGICA

        public void generateKeyPair(){
            setPK(GenSig.generateKeyPair().getPublic());
            setSK(GenSig.generateKeyPair().getPrivate());
        }


        @Override
        public String toString(){
            return "\n" + "PK = " + getPK().hashCode() +  "\n"+
                    "Balance = " + getBalance() + getSymbol() + "\n";
        }


        public void addEZI(Double cantidad){
             this.balance += cantidad;
        }


        public void send(TokenContract ricknillos, Double enziniums){
            try{
                ricknillos.require(enziniums > getBalance() );
                this.balance -= enziniums;
                ricknillos.payable(getPK(), enziniums);
            }catch (AssertionError e){}

        }

        public void transferEZI(Double cantidad){
            this.balance += cantidad;
        }
    }
