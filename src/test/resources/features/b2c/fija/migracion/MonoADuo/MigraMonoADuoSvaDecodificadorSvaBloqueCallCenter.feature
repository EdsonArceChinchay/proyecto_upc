 #language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP: GDAP-1256
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: MARIA SANCHEZ
##FECMOD: 30/03/2023

 @BERSERKERS @DoneDevOps @DoneDevOpsPI14 @Sanity28
 Característica: Migracion mono a duo sva Decodificador + sva Bloque CANAL CALL CENTER

   @MigracionMonoDuoSvaDecodificadorSvaBloqueCallCenter
   Esquema del escenario: Migracion mono a duo sva Decodificador + sva Bloque CANAL CALL CENTER
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
     Y        doy click en el boton "Confirmar direccion"
     Y        selecciono tipo de oferta
     Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
     Y        selecciono la oferta "<plan>"
     Y        doy click en Cambiar plan hogar
     Y        valido que este en el resumen de venta
     Y        doy click en añadir SVA
     Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
     Y        agrego SVA decodificador "<decodificador>"
     Y        agrego SVA bloque "<bloque>"
     Y        doy click en el boton Guardar cambios
     Cuando   doy click en el boton Iniciar registro
     Y        valido que me encuentre en la pantalla agendamiento
     Y        ingreso los datos de agendamiento
     Y        presiono el boton confirmar agendamiento
     Y        ingreso correo electronico "<correo>"
     Y        ingreso nuevamente el correo electronico "<correo>"
     Y        doy click en Validar contrato "hogar"
     Y        me muestra en pantalla el contrato solicitado
     Cuando   doy clic en si acepto
     Y        doy click en el boton de continuar
     Entonces visualizo en pantalla el mensaje de exito de la venta generada

     Ejemplos:
       | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | correo                | tipoPlanHogar | plan                                    | bloque         | decodificador   |
       | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 123456766      | tester_123@tester.com | Duo           | DÚO INTERNET ESTÁNDAR RA 1D D22 50 MBPS | Bloque estelar | Punto Adicional |