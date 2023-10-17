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

   Antecedentes:
     Dado     que abro la pagina de movistar

   @MigracionMonoDuoSvaDecodificadorSvaBloqueCallCenter
   Esquema del escenario: Migracion mono a duo sva Decodificador + sva Bloque CANAL CALL CENTER
     Cuando   presiono el boton Iniciar Sesion
     Y        selecciono el tipo de usuario "<tipoUsuario>"
     Y        ingreso el usuario "<userName>"
     Y        ingreso el password "<password>"
     Y        presiono el boton Continuar hacia el home
     Y        valido el login exitoso mediante el mensaje "<msgHome>"
     Cuando   selecciono el tipo de documento "<tipoDocumento>"
     Y        ingreso el documento "<documento>"
     Y        doy click en el boton consultar
     Y        selecciono la cartilla del plan activo
     Y        selecciono el boton Mostrar ofertas
     Y        doy click en el boton "Confirmar direccion"
     Y        selecciono tipo de oferta
     Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
     Y        selecciono la oferta "<plan>"
     Y        doy click en Cambiar plan hogar
     Y        valido que este en la seccion de registro
     Y        doy click en añadir SVA
     Y        elegimos sva "<decodificador>"
     Y        doy click en agregar Bloque "<bloque>"
     Y        doy click en Guardar cambios
     Cuando   doy clic a iniciar registro
     Y        valido que me encuentre en la pantalla agendamiento
     Y        ingreso los datos de agendamiento
     Y        presiono el boton confirmar agendamiento
     Y        ingreso un correo electronico "<correo>"
     Y        ingreso nuevamente el correo electronico "<correo>"
     Y        doy clic para validar contrato hogar
     Y        me muestra en pantalla el contrato solicitado
     Cuando   doy clic en si acepto
     Y        doy click en el boton de continuar
	 #Y         presiono el boton Registrar venta
     Entonces visualizo en pantalla el mensaje de exito de la venta generada

     Ejemplos:
       | tipoUsuario     | userName | password     | msgHome    | tipoDocumento | documento | correo                | tipoPlanHogar | plan                                    | bloque         | decodificador |
       | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CE            | 123456766 | tester_123@tester.com | Duo           | DÚO INTERNET ESTÁNDAR RA 1D D22 50 MBPS | Bloque estelar | 9.90          |