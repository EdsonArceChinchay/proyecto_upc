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
 Característica: Migracion de MONO (INTERNET) a DUO (INTERNET + VOZ) con documento CE por el Canal Retail

   @MigracionMonoADuoRetail
   Esquema del escenario: Migracion de Mono Internet a DUO con documento CE por el Canal Retail
     Dado     que abro la pagina de movistar
     Cuando   presiono el boton Iniciar Sesion
     Y        selecciono el tipo de usuario "<tipoUsuario>"
     Y        ingreso el usuario "<userName>"
     Y        ingreso el password "<password>"
     E        ingreso el captcha
     Y        presiono el boton Continuar hacia el home
     Y        valido el login exitoso mediante el mensaje "<msgHome>"
     Y        valido que se presente el canal "<channelType>"
     Cuando   selecciono el tipo de documento "<tipoDocumento>"
     Y        ingreso el documento "<documento>"
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
       | tipoUsuario     | userName    | password | msgHome    | channelType | tipoDocumento | documento | correo            | tipoPlanHogar | plan                         |
       | usuario externo | userNameDLC | passDLC  | Bienvenid@ | Retail      | CE            | 202300015 | tester@tester.com | Duo           | DUO MOVISTAR VOZ INTERNET RA |