 #language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP: GDAP-988
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 31/03/2023

 @BERSERKERS @DoneDevOps
 Característica: Migracion de Mono a DUO por el canal Call Retail CE

   Esquema del escenario: Migracion de Mono a Duo por canal Retail
     Dado     que abro la pagina de movistar
     Cuando   presiono el boton Iniciar Sesion
     Y        selecciono el tipo de usuario "<userType>"
     Y        ingreso el usuario "<userName>"
     Y        ingreso el password "<userPassword>"
     E        ingreso el captcha
     Y        presiono el boton Continuar hacia el home
     Y         valido el login exitoso mediante el mensaje "<msgHome>"
     Y        valido que se presente el canal "<channelType>"
     Cuando   selecciono el tipo de documento "<documentType>"
     Y        ingreso el documento "<documentNumber>"
     Y        doy click en el boton Consultar
     Y        selecciono la cartilla del plan activo
     Y        selecciono el boton Mostrar ofertas
    #Y        verifico la direccion "SAN MIGUEL,LIMA ,LIMA PE" actual del servicio
     Y        doy click en el boton "Confirmar direccion"
     Y        selecciono tipo de oferta
     Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
     Y        selecciono la oferta "<plan>"
     Y        doy click en Cambiar plan hogar
     Y        valido que este en el resumen de venta
     Y        doy click en añadir SVA
     Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
     Y        agrego SVA repetidor "Repetidor WIFI PLUS Venta"
     Y        agrego SVA linea "Plan Multidestino 20"
     Y        doy click en el boton Guardar cambios
     Cuando   doy click en el boton Iniciar registro
     Y        valido que me encuentre en la pantalla agendamiento
     Y        ingreso los datos de agendamiento
     Y        presiono el boton confirmar agendamiento
     Y        doy click en Validar contrato "hogar"
     Y        me muestra en pantalla el contrato solicitado
     Cuando   doy clic en si acepto
     Y        doy click en el boton de continuar
     Entonces visualizo en pantalla el mensaje de exito de la venta generada
     Y        doy click en ver detalle del pedido
     Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
     Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
     Y        valido que se muestre el detalle del pedido de "Información adicional"

     Ejemplos:
       | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | tipoPlanHogar | plan                         |
       | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 10021231242    | Duo           | DUO MOVISTAR VOZ INTERNET RA |