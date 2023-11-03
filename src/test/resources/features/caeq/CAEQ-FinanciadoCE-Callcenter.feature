#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP: GDAP-1422
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 03/11/2023

@BERSERKERS @DoneDevOps
Característica: CAEQ Financiado con CE por Canal Callcenter

  @CaeqFinanciadoCECallcenter
  Esquema del escenario: CAEQ Financiado con CE por Canal Callcenter
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    #Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1042464926"
    Y        doy click en el boton consultar
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el plan movil "Prepago"
    Y        selecciono la opcion "Prepago con Tarifa Única"
    Y        doy click en el boton seleccionar oferta
    Y        selecciono añadir equipos
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia     | tipoPago             | equipoName |
      | Sin permanencia | Financiado 12 cuotas | SAMSUNG    |
    Y        presiono el boton Ver detalle valido contenido y selecciono
    #Y        cierro pop up de Cliente Exonerado
    #Y        doy click en el boton continuar
    Y        doy click en el boton "Mantener Plan"
    #Y        valido que se presente el detalle de el plan
    Y        doy click en iniciar registro
    Y        ingreso email "tester_qa@gmail.com" y lo confirmo
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Y        guardo el numero de solicitud
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por el documento
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | tipoUsuario     | userName | password     |
      | usuario externo | jpachaot | $t3l3f0n1c4$ |