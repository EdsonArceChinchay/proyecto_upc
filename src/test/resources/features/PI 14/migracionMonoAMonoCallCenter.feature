#language:es

Característica: Migracion de Mono a Duo por el canal Call Center CE

  Antecedentes:
    Dado     que abro la pagina de movistar

  @MigracionMonoAMono_CallCenter
  Esquema del escenario: Migracion de Mono a Mono en canal call center
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
    Y        doy click en en el boton "Confirmar direccion"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono la oferta "<plan>"
    Y        doy click en Cambiar plan hogar
    Y        valido que este en la seccion de registro
#    Y        doy click en añadir SVA
#    Y        doy click en agregar Bloque "<bloque>"
#    Y        doy click en Guardar cambios
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
    Y         presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido


    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor      | tipoDocumento | documento  | correo            | tipoPlanHogar | plan                          |bloque|
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 1042464993 | tester@tester.com | Mono           | TV ESTÁNDAR DIGITAL RA D22  | HBO |