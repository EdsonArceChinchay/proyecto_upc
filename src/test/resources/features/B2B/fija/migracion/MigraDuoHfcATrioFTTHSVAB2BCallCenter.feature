#language:es
##CREADOR: Edson Arce
##APP: DITO
##MODULO:
##FUNCIONALIDAD: CAMBIO
##ESTADO: ACTIVO
##CODIGO: AT-DT064
##GDAP: GDAP-888
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: Edson Arce
##FECMOD: 31/03/2023

@BERSERKERS @DoneDevOps
Característica: AT-DT064_Migracion de Duo HFC a Trio HFC + Sva Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @migracionDuoTrioRUCCallCenter @MVP12 @Global
  Esquema del escenario: Migración Upsell Dúo voz + internet 30mbps con tecnología HFC a Trío 50 Mbps con tecnología HFC + SVA pla multidestino, con ruc, en call center, con flujo biometrico
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        selecciono el ID de Cliente nro "<nro>"
    Y        selecciono el tipo de documento "<tipoDocRepLegal>" del Representante Legal
    E        ingreso el numero del documento "<numDocRepLegal>" del Representante Legal
    Y        doy click en Validar Representa Legal
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Confirmar direccion"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono la oferta "<plan>"
    Y        doy click en Cambiar plan hogar
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Agregar SVA
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA linea "<sva>"
    Y        doy click en el boton Guardar cambios
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento para RUC
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic en el boton validar identidad representante legal
    Y        ingreso los datos solicitados para la validacion del cliente
      | nombreMadre | nombrePadre | distritoNac          |
      | BERTHA      | LEOBILDO    | LA BANDA DE SHILCAYO |
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y       doy click en Finalizar registro
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento   | nro | tipoDocRepLegal | numDocRepLegal | correo            | tipoPlanHogar | plan                        | sva                  |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | RUC           | 20100323002 | 1   | DNI             | 75447576       | tester@tester.com | TRIO          | TRIO MOV. VOZ INT. ESTANDAR | Plan Multidestino 20 |
