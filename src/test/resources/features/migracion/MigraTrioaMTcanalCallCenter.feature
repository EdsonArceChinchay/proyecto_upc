#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11

Característica: Migracion de Trio a MT por Canal Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @migracionTrioAmtCallCenter
  Esquema del escenario: Migracion de Trio a MT con CE  sin productos asociados sin biometria
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        verifico la direccion "SAN MIGUEL,LIMA ,LIMA PE" actual del servicio
    Y        doy click en en el boton "Confirmar direccion"
#    Y        selecciono plan Movistar Total para ver las ofertas
#    Y        selecciono un plan y doy click en el boton seleccionar oferta
    Y        luego doy click en la cartilla ir a Movistar Total
    Cuando   doy clic a iniciar registro
    #Y        valido que me encuentre en la pantalla agendamiento
    #Y        ingreso los datos de agendamiento
    #Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en validar identidad del titular
    #Y        elijo el tipo de validacion a realizar "<tipoValidacion>"
    #Y        ingreso los datos del supervisor
    #  | numdoc   | user        | password     |
    #  | 42770472 | rdelatorreg | $t3l3f0n1c4$ |
    Y        ingreso los datos solicitados para la validacion del cliente
      | nombrePadre   | nombreMadre   | distritoNac   |
      | <nombrePadre> | <nombreMadre> | <distritoNac> |
    Entonces valido que me muestre el boton con el texto de identidad validada
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en Finalizar registro
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac | tipoPlanHogar |
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | DNI           | 75447343  | correo@gmail.com | discapacitado  | ROSA        | RUFINO      | BELLAVISTA  | Trío          |
