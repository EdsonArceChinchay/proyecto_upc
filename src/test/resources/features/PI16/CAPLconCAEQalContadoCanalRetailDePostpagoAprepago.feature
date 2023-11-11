#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT0114
##GDAP: GDAP-1387
##SPRINT CREADO: SPRINT 1
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: PATRICIA CABELLO HUAYTA
##FECMOD: 03/07/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI16SP1
Característica: AT-DT0114_CAPL con CAEQ por canal Retail de un Postpago a Prepago

  @CaplconCaeqCanalRetailPostpagoAprepago
  Esquema del escenario: CAPL con CAEQ por canal Retail de un Postpago a Prepago
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    #Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "77654580"
    Y        doy click en el boton consultar
    #Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Y        selecciono el boton Ver detalle del servicio "650023363"
    Y        doy click en el boton "Renovar plan"
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el plan movil "Prepago"
    Y        selecciono la opcion "Preplan"
    Y        doy click en el boton seleccionar oferta
    Y        selecciono añadir equipos
    #Y        selecciono el boton Ver detalle del servicio "VIVO V21 NEGRO 5G C/PACK"
    E        ingreso permanencia, tipo de pago y equipo
    | permanencia     | tipoPago   | equipoName                              |
    | Sin permanencia | Al Contado | VIVO V21 NEGRO 5G C/PACK |
    Y        presiono el boton seleccionar
    #Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        doy click en el boton "Cambiar Plan"
    Y        valido que se presente el detalle de el plan
    Y         doy click en iniciar registro
    Y        ingreso email "prueba_qa@gmail.com" y lo confirmo
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName     | password     |
      | usuario externo | evillanuevag | $t3l3f0n1c4$ |