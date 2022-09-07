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
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos    | genero    |
      | Juan    | Lopez Anibal | masculino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        presiono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        doy click en en el boton "Ingresar coordenadas"
    Y        ingreso las coordenadas de Longitud X: "<longitud>" y Latitud Y:"<latitud>"
    Y        doy click en en el boton "Buscar"
    Ejemplos:
      | tipoUsuario     | userName     | password       | msgHome    | tiendaAsesor                 | tipoDocumento | documento | cliente                      | longitud      | latitud       |
      | usuario externo | jpachaot     | $t3l3f0n1c4$   | Bienvenid@ | CANAL ONLINE-CALL CENTER GSs | C             | 41524632  | LUIGI GUSTAVO REYNOSO DEXTRE | -77.03498486  | -12.09465486  |
#      | usuario externo | lterrazosce  | Telefonica2021 | Bienvenid@ | CAJAMARCA                    | C             | 123456742 | Cuatro De Dos                | -77.03839379  | -12.08616934  |
#      | usuario externo | evillanuevag | $t3l3f0n1c4$   | Bienvenid@ | CAJAMARCA                    | c             | 09822102  | JONNY RAUL NAVARRO ESPEJO    | -77.072328892 | -12.083588836 |
#      | usuario externo | djormeno     | $t3l3f0n1c4$   | Bienvenid@ | CAJAMARCA                    | C             | 123456753 | Cinco De Tres                  |              |              |
#      | usuario externo | lterrazosce  | Telefonica2021 | Bienvenid@ | CAJAMARCA                    | DNI           | 09822100  | GIOVANNA MARIBEL OCOLA ASENCIO |              |              |
