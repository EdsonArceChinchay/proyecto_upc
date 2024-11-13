#language:es
##CREADOR: Angel Medina
##APP: DITO
##MODULO: FIJA
##FUNCIONALIDAD: MIGRACION
##ESTADO: ACTIVO
##CODIGO: AT-DT059
##GDAP: GDAP-1169
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE(CANCELAR ORDEN EN VUELO)
##ENCARGADO: Angel Medina
##FECMOD: 21/10/2024

@BERSERKERS @DoneDevOps
Característica: AT-DT059_Migracion de Duo (Voz + Tv) a Duo (Internet +Tv) + SVA a cliente con CE por canal Call Center

  @MigraDuoADuoSVaCallcenter @MVP09 @Global @General
  Esquema del escenario: Migracion de Duo (Voz + Tv) a Duo (Internet +Tv) + SVA a cliente con CE por canal Call Center
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
    Y        doy click en el boton "ACTUALIZAR DIRECCION"
    Y        ingreso la direccion donde sera la instalacion "JR JULIO CESAR TELLO 469"
    Y        ingreso la referencia de la direccion "."
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        doy click en el boton "ENTENDIDO"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono el plan "<nombrePlan>"
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Agregar SVA
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA repetidor "WIFI"
    Y        doy click en el boton Guardar cambios
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en Validar contrato "hogar"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | correo            | tipoPlanHogar | nombrePlan           |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 1854264859     | tester@tester.com | Duo           | Duo Internet Flex HD |