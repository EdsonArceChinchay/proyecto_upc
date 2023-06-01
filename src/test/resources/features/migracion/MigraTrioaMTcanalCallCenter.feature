#language:es

##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT080
##GDAP: GDAP-730
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Sanity28 @DROP

Característica: AT-DT080_Migracion de Trio a MT por Canal Call Center

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
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        verifico la direccion "JR, JULIO CESAR TELLO, 469, LINCE , LIMA , LIMA , PE" actual del servicio
    Y        doy click en el boton "Confirmar direccion"
    Entonces me muestra la pantalla de ofertas sugeridos
#    Y        selecciono plan Movistar Total para ver las ofertas
#    Y        selecciono un plan y doy click en el boton seleccionar oferta
    Y        luego doy click en la cartilla ir a Movistar Total
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    #Y        presiono el boton confirmar agendamiento
    Y        presiono el boton confirmar agendamiento
#    Entonces me muestra la pantalla para ingresar la direccion
#    Y        selecciono el departamento donde sera la instalacion "15"
#    Y        selecciono la provincia donde sera la instalacion "1501"
#    Y        selecciono el distrito donde sera la instalacion "150116"
#    Y        ingreso la direccion donde sera la instalacion "JIRON JULIO CESAR TELLO 469"
    #Y        ingreso la referencia de la direccion "Inkafarma"
    #Y        presiono el boton Consultar ubicacion
    #Y        ingreso la informacion del lugar de instalacion
     # | mz | lote | vivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
      #| A  | 1    | casa     | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    #Y        Consulto ubicacion
    #Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    #Y        selecciono horario "2pm-7pm"
    #E        ingreso telefono del titular "998877665"
    #E        ingreso instrucciones de delivery "cerca al parque"
    #Y        doy clic en confirmar delivery
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
    #Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento | correo           | tipoValidacion | nombreMadre | nombrePadre | distritoNac | tipoPlanHogar |
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | DNI           | 42464702  | correo@gmail.com | discapacitado  | ELISA       | MARIO      | OCOBAMBA      | Trío          |
