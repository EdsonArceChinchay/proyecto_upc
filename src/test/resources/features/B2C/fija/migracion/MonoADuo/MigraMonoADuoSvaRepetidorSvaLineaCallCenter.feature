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

   Antecedentes:
     Dado     que abro la pagina de movistar

   @MigracionMonoADuoCallCenter_1
   Esquema del escenario: Migracion de Mono a Duo en canal Retail
     Cuando   presiono el boton Iniciar Sesion
     Y        selecciono el tipo de usuario "<tipoUsuario>"
     Y        ingreso el usuario "<userName>"
     Y        ingreso el password "<password>"
     E        ingreso el captcha
     Y        presiono el boton Continuar hacia el home
     Y         valido el login exitoso mediante el mensaje "<msgHome>"
   # Y        valido que se presente el canal "<tiendaAsesor>"
     Cuando   selecciono el tipo de documento "<tipoDocumento>"
     Y        ingreso el documento "<documento>"
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
#	 Y        ingreso correo electronico "<correo>"
#	 Y        ingreso nuevamente el correo electronico "<correo>"
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
       | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor      | tipoDocumento | documento   | correo            | tipoPlanHogar | plan                         |
       | usuario externo | userNameCC | passCC   | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 10021231242 | tester@tester.com | Duo           | DÚO MOVISTAR VOZ INTERNET RA |