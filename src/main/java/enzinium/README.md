# APP
Ésta clase no se puede modificar su código, ya que expone los resultados por pantalla y en el código se encuentra las diversas interacciones con las otras clases del programa. 
Es una guía de como llevar el código ordenado y por pasos, además te proporciona las historias de usuario que debes seguir durante el proyecto.

***NO MODIFIQUES SU CÓDIGO***


# GenSig
Es una clase de apoyo que sirve para crear las claves publicas y privadas del programa,  no se puede modificar su código. Además te proporciona, si se desea, las funciones para firmar y verificar con las claves privadas

***NO MODIFIQUES SU CÓDIGO***


# Address
*Es la dirección que cada usuario tiene en nuestro sistema.*

### ATRIBUTOS:
- ```PublicKey PK``` es la clave pública de la dirección desde la que se envían o reciben enziniums.

- ```PrivateKey SK``` es la clave privada de la dirección desde la que se envían o reciben enziniums.

- ```balance``` es la cantidad de enzniums que posee esta dirección.

- ```symbol``` es el símbolo del enZinium EZI.

### MÉTODOS:
*Si programas las historias de usuario indicadas en App.java construirás los getters y setters necesarios.*

- ```toString()``` devuelve la representación en String de un objeto de la clase Address.

- ```addEZI(Double EZI)``` añade EZI al balance de esta dirección.

- ```transferEZI(Double EZI)``` transfiere la cantidad de EZI a esta dirección.

- ```send(TokenContract contract, Double EZI)``` envia EZI desde esta dirección a un contrato inteligente.



# Clase TokenContract
Esta clase representa un contrato inteligente en nuestra plataforma. Lleva un control del número de tokens que existen de un producto, por ejemplo una entrada de concierto, y a quién pertenecen. Todo contrato tiene un propietario.

### ATRIBUTOS
Todos los que exijan los métodos de la clase.

```balances``` contiene una tabla que hace el seguimiento de cuántos tokens pertenecen a cada propietario.

### MÉTODOS

- ```name``` devuelve el nombre del token de forma human-readable (p.e., “US Dollars”).
- ```symbol()``` devuelve el nombre del símbolo del token de forma human-readable (p.e., “USD”).
- ```totalSupply()``` devuelve el total de unidades de este token que actualmente existen.
- ```addOwner(PublicKey PK, Double units)``` añade un propietario a balances.
- ```numOwners()``` devuelve el numero de propietarios en balances.
- ```balanceOf(PublicKey owner)``` devuelve el numero de tokens de un propietario.
- ```transfer(PublicKey recipient, Double units)``` transfiere tokens del propietario del contrato a la dirección de destino.
- ```transfer(PublicKey sender, PublicKey recipient, Double units)``` transfiere tokens del sender al recipient.
- ```require(Boolean holds)``` throws Exception lanza una excepción cuando holds es false.
- ```owners()``` muestra en consola todos los propietarios.
- ```payable(PublicKey recipient, Double enziniums)``` envía los tokens a la dirección recipient y envía los enziniums al propietario del contrato.
