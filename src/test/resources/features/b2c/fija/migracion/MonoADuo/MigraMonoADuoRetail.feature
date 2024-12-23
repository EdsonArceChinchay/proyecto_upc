 #language:es
##CREADOR: CARLOS VICENTE
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO:
##GDAP: GDAP-1142
##SPRINT CREADO: PI14_SP
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: CARLOS RUIZ
##FECMOD: 06/05/2024

 @BERSERKERS @DoneDevOps  @RegresionLegacy
 Característica: Migracion de MONO (INTERNET) a DUO (INTERNET + VOZ) a cliente con CE por el canal Retail

   @MigracionMonoADuoRetail
   Esquema del escenario: Migracion de Mono Internet a DUO a cliente con CE por el canal Retail
     Dado     que abro la pagina de movistar
     Cuando   presiono el boton Iniciar Sesion
     Y        selecciono el tipo de usuario "<userType>"
     Y        ingreso el usuario "<userName>"
     Y        ingreso el password "<userPassword>"
     E        ingreso el captcha
     Y        presiono el boton Continuar hacia el home
     Y        valido el login exitoso mediante el mensaje "<msgHome>"
     Y        valido que se presente el canal "<channelType>"
     Cuando   selecciono el tipo de documento "<documentType>"
     Y        ingreso el documento "<documentNumber>"
     Y        doy click en el boton Consultar
     Y        selecciono la cartilla del plan activo
     Y        selecciono el boton Mostrar ofertas
     Y        doy click en el boton "ACTUALIZAR DIRECCION"
     Y        ingreso la referencia de la direccion "."
     Y        presiono el boton Consultar ubicacion
     Y        presiono el boton Consultar cobertura
     Y        doy click en el boton "ENTENDIDO"
     Y        selecciono tipo de oferta
     Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
     Y        selecciono el plan "<plan>"
     Y        doy click en Cambiar plan hogar
     Y        valido que este en el resumen de venta
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
     Y        doy clic para descargar el contrato
     Y        doy click en el boton Registrar venta
     Entonces visualizo en pantalla el mensaje de exito de la venta generada
     Y        doy click en ver detalle del pedido
     Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
     Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
     Y        valido que se muestre el detalle del pedido de "Información adicional"

     Ejemplos:
       | userType | userName    | userPassword    | msgHome    | channelType | documentType | documentNumber | correo            | tipoPlanHogar | plan                         |
       | userType | userNameDLC | userPasswordDLC | Bienvenid@ | Retail      | CE           | 202300015      | tester@tester.com | Duo           | DUO MOVISTAR VOZ INTERNET RA |