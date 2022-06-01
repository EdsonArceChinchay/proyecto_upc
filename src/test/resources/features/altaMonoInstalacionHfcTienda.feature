#language:es
  @BERSERKERS @DoneDevOps @DoneDevOpsPI11SP4

  Característica: Alta de Mono con instalación HFC por Canal tienda

    @AltaMonoHfcTienda
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
      Y cierro popup de error
      Y ingreso los datos del cliente extranjero a registrar
        | nombres | apellidos   | genero   |
        | Ana     | Lopez Lopez | femenino |
      Y selecciono el boton Linea Nueva Hogar
      Y selecciono el boton Mostrar ofertas
      Entonces me muestra la pantalla para ingresar la direccion
      Y selecciono departamento "15" provincia "1501" distrito "150136" direccion "Calle Condesa de Chinchon 107" y referencia "parque"
      Y presiono el boton Consultar Ubicacion
      Y ingreso la informacion del lugar para la instalacion
        | mz | lote | vivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
        | A  | 1    | alex mancilla | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
      Y presiono el boton Consultar Cobertura
      Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
      Y selecciono el boton de eleccion de planes Plan Nuevo
      Y selecciono la opcion Mono
      Y selecciono el tipo de plan mono "Internet Movistar RA 100 Mbps" y presiono Seleccionar oferta
      Y presiono el boton Linea Nueva
      Y valido que se presente el detalle de el plan
      Y presiono el boton Iniciar Registro
      Y valido que se presente la pantalla agendamiento
      Y ingreso telefono de contacto
      Y presiono el boton Confirmar agendamiento
      Y ingreso email "edith@gmail.com" y lo repito
      Y doy click en datos del cliente
      Y completo los datos del cliente
        | fechaNac   | estadoCivil |
        | 12/12/1980 | casado      |
      Y presiono la opcion validar contrato
      Y me muestra en pantalla el contrato solicitado
      Cuando doy clic en si acepto
      Y doy click en el boton de continuar
      Y presiono el boton descargar contrato
      Y presiono el boton Registrar venta
      Entonces visualizo en pantalla el mensaje de exito de la venta generada