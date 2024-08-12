#language:es
##CREADOR: Edson Arce
##APP: DITO
##MODULO:
##FUNCIONALIDAD: CAMBIO
##ESTADO: ACTIVO
##CODIGO: AT-DT069
##GDAP: GDAP-1141
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: Maria Sanchez
##FECMOD: 31/08/2023

@BERSERKERS @DoneDevOps
Característica: AT-DT069_Migracion de Mono a Mono por el canal Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @MigracionMonoAMonoSVACallCenter @MVP19  @Global @General
  Esquema del escenario: Migracion (mono a mono) + sva en canal CALL CENTER
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y         valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
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
    Entonces doy click en el boton Agregar SVA
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA bloque "<bloque>"
    Y        doy click en el boton Guardar cambios
    Cuando   doy click en el boton Iniciar registro
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
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | channelType | tipoDocumento | documento | correo            | tipoPlanHogar | plan             | bloque |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | Call Center | CE            | 123456766 | tester@tester.com | Mono          | TV HOGAR DIGITAL | HBO    |