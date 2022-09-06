#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI12

Característica: Consultar direccion por coordenadas DITO WEB

  @ConsultarCoordenadas
  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo consultar el cliente con <tipoDocumento>: <documento>
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Ejemplos:
      | tipoUsuario     | userName     | password       | msgHome    | tiendaAsesor                 | tipoDocumento | documento | cliente                         |
      | usuario externo | jpachaot     | $t3l3f0n1c4$   | Bienvenid@ | CANAL ONLINE-CALL CENTER GSs | DNI           | 41524632  | LUIGI GUSTAVO REYNOSO DEXTRE    |
      | usuario externo | lterrazosce  | Telefonica2021 | Bienvenid@ | CAJAMARCA                    | C             | 123456742 | Cuatro De Dos                  |
      | usuario externo | evillanuevag | $t3l3f0n1c4$   | Bienvenid@ | CAJAMARCA                    | DNI           | 09822102  | JONNY RAUL NAVARRO ESPEJO       |
      | usuario externo | djormeno     | $t3l3f0n1c4$   | Bienvenid@ | CAJAMARCA                    | C             | 123456753 | Cinco De Tres                   |
      | usuario externo | lterrazosce  | Telefonica2021 | Bienvenid@ | CAJAMARCA                    | DNI           | 09822100  | GIOVANNA MARIBEL OCOLA ASENCIO  |
