# Packet Transfer

- [Packet Transfer](#packet-transfer)
  - [TLDR](#tldr)
  - [Cosas que tenemos que saber](#cosas-que-tenemos-que-saber)
    - [Paquetes](#paquetes)
    - [Tabla de enrutamiento](#tabla-de-enrutamiento)
    - [Peticiones ARP](#peticiones-arp)
    - [Envío de  paquetes](#envío-de--paquetes)
  - [Ejemplo Simple](#ejemplo-simple)
  - [Ejemplo Complejo](#ejemplo-complejo)

Vamos a trabajar con esta red de ejemplo:

![red](img/red-ejemplo-enrutamiento.PNG)

## TLDR

Para poder enviar un mensaje entre dos equipos necesitamos saber las mac respectivas. La primera parte de la conexión siempre es descubrir la mac de destino.

Vamos a ir preguntando (*ARP*) por el host de destino hasta que este nos conteste con su dirección. Una vez la tengamos la comunicación puede iniciarse.

Si no obtenemos respuesta a la pregunta, reenviamos el mensaje por el default.

> Cada vez que queremos mandarle algo a alguien, aunque sea un intermediario, tenemos que conseguir su mac.

## Cosas que tenemos que saber

### Paquetes

![paquete](img/paquete-ejemplo-enrutamiento.PNG)

Tienen las ip de destino y de origen más la carga del mensaje.

### Tabla de enrutamiento

![tabla enrutamiento](img/tabla-de-enrutamiento-direct-hop.PNG)

| destino       | máscara        | next hop      | iface             |
| ------------- | -------------- | ------------- | ----------------- |
| ip de destino | máscara de red | ip del router | puerto del router |

> Si no hay router intermediario, el next hop es ***directo***

> El destino ***default*** es aquel al que vamos si no encontramos el host que buscamos a partir de la tabla.

### Peticiones ARP

![petición arp simple](img/peticion-arp-simple.PNG)
![tabla enrutamiento de A](img/respuesta-arp-simple.PNG)

ARP permite hacer peticiones y respuestas para obtener la dirección física de un host.

La pregunta se hace con destino broadcast y la respuesta va dirigida a la mac que hizo la pregunta.

> para hacer la pregunta enviamos `00::00` en el campo a preguntar

### Envío de  paquetes

![envío paquete](img/paquete-A-R1-enrutamiento.PNG)

El orden de la ristra de nombres de *dst* y *src* es:

- nombre del **host**
- **puerto**
- **mac** o **ip**

## Ejemplo Simple

- A **construye el paquete** que quiere enviar:

  ![paquete](img/paquete-ejemplo-enrutamiento.PNG)

- Buscamos a B:
  - Consulta a la **tabla de enrutamiento**:
  
    ![tabla enrutamiento](img/tabla-de-enrutamiento-direct-hop.PNG)

    El destino *default* es adonde mandamos nuestro paquete si no encontramos otro destino.
  - **Petición ARP** para encontrar a B dentro de la misma red:

     ![petición arp simple](img/peticion-arp-simple.PNG)

     El primer paso siempre es buscar el destino dentro de la propia red. Para ello hacemos un broadcast.

     El `00::00` es una pregunta, le estamos pidiendo a B que rellene con su mac.
- B contesta con **respuesta ARP**:

  ![respuesta arp simple](img/respuesta-arp-simple.PNG)

  B responde ya de forma directa a A con su mac.

- Se envía el paquete:

    ![envío del paquete](img/envio-paquete-simple.PNG)

## Ejemplo Complejo

- A **construye el paquete** que quiere enviar *(igual que en el simple)*.
- Buscamos C:
  - A consulta su tabla de enrutamiento:

    ![tabla enrutamiento de A](img/tabla-de-enrutamiento-A-default.PNG)
  
    Igual en el 1er ejemplo, A pregunta dentro de su red por C. Al no obtener respuesta le pregunta a default.
  - A obtiene la mac de R1 (router conectado a A) con ARP.
  - Se le envía el paquete a R1:

    ![envío paquete](img/paquete-A-R1-enrutamiento.PNG)

    El destino es el **puerto** eth0 **router** R1.
    > Como siempre, para enviar el paquete lo hacemos con la mac.
  - R1 extrae el paquete.
  - R1 consulta su tabla:

    ![tabla de enrutamiento de R1](img/tabla-de-enrutamiento-R1-para-C.PNG)

    Aplicando la máscara de red a la ip de C, R1 determina a quien le tiene que enviar el mensaje.

  - R1 averigua por ARP la mac de R3 y le reenvía el mensaje.
  
    ![envío del paquete](img/paquete-R1-R3-enrutamiento.PNG)
  - R3 consulta su tabla y pregunta por C
- Una vez encontrado C:
  - R3 obtiene la mac de C con ARP
  - R3 le encapsula el paquete y se lo envía a C
  - C contesta a A con su mac

---

> Go back to the [index](.index.md#index).
