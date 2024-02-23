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
##FECMOD: 22/02/2024

 @BERSERKERS @DoneDevOps
 Característica: Migracion de MONO (INTERNET) a DUO (INTERNET + VOZ) con documento CE por el Canal Retail

   @MigracionMonoADuoRetail
   Esquema del escenario: Migracion de Mono Internet a DUO con documento CE por el Canal Retail
     Dado     que abro la pagina de movistar
     Cuando   presiono el boton Iniciar Sesion
     Y        selecciono el tipo de usuario "<tipoUsuario>"
     Y        ingreso el usuario "<userName>"
     Y        ingreso el password "<password>"
     Y        presiono el boton Continuar hacia el home
     Y         valido el login exitoso mediante el mensaje "<msgHome>"
   # Y        valido que se presente la tienda "<tiendaAsesor>"
     Cuando   selecciono el tipo de documento "<tipoDocumento>"
     Y        ingreso el documento "<documento>"
     Y        doy click en el boton consultar
     Y        selecciono la cartilla del plan activo
     Y        selecciono el boton Mostrar ofertas
    #Y        verifico la direccion "SAN MIGUEL,LIMA ,LIMA PE" actual del servicio
     Y        doy click en el boton "Confirmar direccion"
     Y        selecciono tipo de oferta
     Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
     Y        selecciono la oferta "<plan>"
     Y        doy click en Cambiar plan hogar
     Y        valido que este en la seccion de registro
     Cuando   doy clic a iniciar registro
     Y        valido que me encuentre en la pantalla agendamiento
     Y        ingreso los datos de agendamiento
     Y        presiono el boton confirmar agendamiento
     Y        ingreso un correo electronico "<correo>"
     Y        ingreso nuevamente el correo electronico "<correo>"
     Y        doy clic para validar contrato hogar
     Y        me muestra en pantalla el contrato solicitado
     Y        imprimo el texto del contrato solicitado
     Y        guardo el numero de solicitud
     Cuando   doy clic en si acepto
     Y        doy click en el boton de continuar
     Y         presiono el boton Registrar venta
     Entonces visualizo en pantalla el mensaje de exito de la venta generada
     Y        doy click en ver detalle del pedido
     Y        valido que se muestre el detalle del pedido del "Servicio Hogar"

     Ejemplos:
       | tipoUsuario     | userName    | password | msgHome    | tiendaAsesor      | tipoDocumento | documento | correo            | tipoPlanHogar | plan                                      |
       | usuario externo | userNameDLC | passDLC  | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 202300015 | tester@tester.com | Duo           | DUO MOVISTAR VOZ INTERNET RA S23 300 MBPS |