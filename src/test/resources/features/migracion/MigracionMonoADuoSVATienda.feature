#language:es

##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT068
##GDAP: GDAP-889
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 31/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @RegresionPangea @Sanity28 @DROP-G08

Característica: AT-DT068_Migracion de Mono a Duo + sva por el canal Tienda

  Antecedentes:
    Dado     que abro la pagina de movistar

  @MigraMonoDuoSVATienda
  Esquema del escenario: Migracion de Mono a Duo con CE + sva
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro el popup de contraseña Única
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Confirmar direccion"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono la oferta "<plan>"
    Y        doy click en Cambiar plan hogar
    Y        valido que este en la seccion de registro
    #Y        doy click en agregar SVA Linea "<sva>"
    Y         doy clic en agregar sva "<Bloque>"
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

    Ejemplos:
      | tipoUsuario     | userName  | password     | msgHome    | tiendaAsesor      | tipoDocumento | documento  | correo            | tipoPlanHogar | plan                        | Bloque | sva                  |
      | usuario externo | userNameST | passST | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 1042464839 | tester@tester.com | Duo           | DÚO INTERNET ESTÁNDAR HD RA | HBO    | Plan Multidestino 20 |