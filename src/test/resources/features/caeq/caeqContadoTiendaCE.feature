#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP: GDAP-1423
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 07/11/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI12

Característica: CAEQ contado con CE por canal Tienda

  @CaeqContadoTienda @RegreDito
  Esquema del escenario: Como usuario <userName> de la Tienda <tiendaAsesor> deseo consultar el cliente con <tipoDocumento>: <documento>
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
#    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Y        selecciona el boton de detalle del numero de celular existente "<EncontrarCelular>"
    Y        presiono el boton Renovar Plan
    Y        valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        presiona el boton anadir equipo
    Y        selecciono tipo de pago Al Contado
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName |
      | 12 meses    | Al Contado | MOTOROLA   |
    Y        valido que existan resultados busqueda de equipos
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        cierro pop up de CU
    Y        doy click en el boton "Mantener Plan"
    Y        doy click en iniciar registro
    #Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "prueba_qa@gmail.com"
    Y        ingreso nuevamente el correo electronico "prueba_qa@gmail.com"
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Y        guardo el numero de solicitud
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    #Y        doy clic para descargar el contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName | password | msgHome    | tipoDocumento | documento  | EncontrarCelular |
      | usuario externo | nishuizas | $t3l3f0n1c4$ | Bienvenid@  | CE            | 1042464674 | 984683790|
#      | usuario interno |          |          | Bienvenid@ | CE            | 1100000310 | 984683790        |

   #   | tipoUsuario     | userName  | password     | msgHome    | tipoDocumento | documento  | tipoPlan | nombrePlan                     |
    #  | usuario externo | nishuizas | $t3l3f0n1c4$ | Bienvenid@ | CE            | 1042464721 | Postpago | Plan Movil Movistar Total ilim |

