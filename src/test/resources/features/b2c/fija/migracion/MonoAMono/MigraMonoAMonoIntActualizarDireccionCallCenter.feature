#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP: GDAP-1164
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023
@BERSERKERS @DoneDevOps
Característica: Migracion de Mono internet a Mono internet con Actualizar Direccion por el canal Call Center

  @MigracionMonoInternetAMonoInternetActualizarDireccion_CallCenter
  Esquema del escenario: Migracion de Mono internet a Mono interner con Actualizar Direccion por canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        verifico la direccion "JR, Julio Cesar tello, 469, LINCE, LIMA , LIMA, PE" actual del servicio
    Y        doy click en el boton "Actualizar direccion"
    Y        ingreso la direccion donde sera la instalacion "Jose Leal 500"
    Y        ingreso la referencia de la direccion "Inkafarma"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        valido que se presente el siguiente mensaje "Se actualizo la dirección del servicio correctamente"
    Y        doy click en el boton "Entendido"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono el plan "<plan>"
    Y        doy click en Cambiar plan hogar
    Y        valido que este en el resumen de venta
    Cuando   doy click en el boton Iniciar registro
    #Y        valido que me encuentre en la pantalla agendamiento
    #Y        ingreso los datos de agendamiento
    Y        ingreso correo electronico "prueba@gmail.com"
    Y        ingreso nuevamente el correo electronico "prueba@gmail.com"
    Y        doy click en Validar contrato "hogar"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | tipoPlanHogar | plan
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 1042464839     | Mono          | INTERNET MOVISTAR RA