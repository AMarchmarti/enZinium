# Address
*Es la dirección que cada usuario tiene en nuestro sistema.*

### ATRIBUTOS:
- PublicKey PK es la clave pública de la dirección desde la que se envían o reciben enziniums.

- PrivateKey SK es la clave privada de la dirección desde la que se envían o reciben enziniums.

- balance es la cantidad de enzniums que posee esta dirección.

- symbol es el símbolo del enZinium EZI.

### MÉTODOS:
*Si programas las historias de usuario indicadas en App.java construirás los getters y setters necesarios.*

- toString() devuelve la representación en String de un objeto de la clase Address.

- addEZI(Double EZI) añade EZI al balance de esta dirección.

- transferEZI(Double EZI) transfiere la cantidad de EZI a esta dirección.

- send(TokenContract contract, Double EZI) envia EZI desde esta dirección a un contrato inteligente.
