 #language:es

##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP: GDAP-569
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 31/03/2023

 @BERSERKERS @DoneDevOps
 Característica: Migracion de Mono a DUO +SVA por el canal  Retail CE

   Antecedentes:
     Dado     que abro la pagina de movistar

   @MigracionMonoADuo_SVA_RETAIL
   Esquema del escenario: Migracion de Mono a Duo + SVA en canal Retail
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
     Y        doy click en añadir SVA
     Y        doy click en agregar Bloque "<bloque>"
     Y        doy click en Guardar cambios
     Cuando   doy clic a iniciar registro
     Y        valido que me encuentre en la pantalla agendamiento
     Y        ingreso los datos de agendamiento
     Y        presiono el boton confirmar agendamiento
#	 Y        ingreso un correo electronico "<correo>"
#	 Y        ingreso nuevamente el correo electronico "<correo>"
     Y        doy clic para validar contrato hogar
     Y        me muestra en pantalla el contrato solicitado
     Cuando   doy clic en si acepto
     Y        doy click en el boton de continuar
     Y         presiono el boton Registrar venta
     Entonces visualizo en pantalla el mensaje de exito de la venta generada
     Y        valido que se muestre el detalle del pedido

     Ejemplos:
       | tipoUsuario     | userName    | password | msgHome    | tiendaAsesor      | tipoDocumento | documento   | correo            | tipoPlanHogar | plan                                     | bloque |
       | usuario externo | userNameDLC | passDLC  | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 10021231242 | tester@tester.com | Duo           | DÚO INTERNET ESTÁNDAR HD RA D22 150 MBPS | HBO    |