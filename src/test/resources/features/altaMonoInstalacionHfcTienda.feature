#language:es
  @BERSERKERS @DoneDevOpsPI11SP4

  Característica: Alta de Mono con instalación HFC por Canal tienda

    @ALtaMonoHfcTienda
    Escenario: Realizar una Alta de Mono con instalación HFC por Canal tienda
      Dado que abro la pagina de movistar
      Cuando presiono el boton Iniciar Sesion
      Y selecciono el tipo de usuario "usuario externo"
      Y ingreso el usuario "lterrazosce"
      Y ingreso el password "Telefonica2021"
      Y presiono el boton Continuar hacia el home
      Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
      Y valido que se presente la tienda "TIENDA SAN MIGUEL"
      Cuando selecciono el tipo de documento "CE"
      Y ingreso el documento "1000000006"
      Y doy click en el boton consultar
      Y ingreso los datos del cliente a registrar
        | nombres | apellidos   | genero   |
        | Ana     | Lopez Lopez | femenino |
      Y selecciono el boton Linea Nueva Hogar