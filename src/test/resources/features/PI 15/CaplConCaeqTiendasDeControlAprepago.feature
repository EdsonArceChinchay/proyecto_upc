#language:es
##APP: DITO
##MODULO:
##CREADOR: PATRICIA CABELLO
##CODIGO: AT-DT050
##GDAP: GDAP-1380
##SPRINT CREADO: SP1
##FUNCIONALIDAD: REALIZAR UN CAMBIO DE PLAN Y CAMBIO DE EQUIPO A UN CE CON MOVIL AL CONTADO  Y PASARLO A PREPAGO
##FRECUENCIA: NO ESPECIFICA
##TAG : @DITO
##DATA: REUSABLE
##ENCARGADO: Patricia
##FECMOD: 13/04/2023
@BERSERKERS @DoneDevOps @DoneDevOpsPI15SP1
Característica: AT-DT050_CAPL con CAEQ por canal Tienda de un Control a Prepago

  @CaplconCaeqTiendaControlAprepago
  Esquema del escenario: CAPL con CAEQ por canal Tienda de un Control a Prepago
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    #Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1042464936"
    Y        doy click en el boton consultar
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el plan movil "Prepago"
    Y        selecciono la opcion "Preplan"
    Y        doy click en el boton seleccionar oferta
    Y        selecciono añadir equipos
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName |
      | 12 meses    | Al Contado | HUAWEI P30 |
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        doy click en el boton "Cambiar Plan"
    Y        valido que se presente el detalle de el plan
    Y         doy click en iniciar registro
    Y        ingreso email "tester_qa@gmail.com" y lo confirmo
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName     | password     |
      | usuario externo | evillanuevag | #o2Wy23oA1458|