#language:es

##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT096
##GDAP: GDAP-NNN
##SPRINT CREADO: PI21
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 06/01/2025

@BERSERKERS @QAN
Característica:  Visualizacion de Ofertas Movil - CE por canal Call Center

  @sanity_programado
  Esquema del escenario: Alta movil Postpago solo chip
    Dado     que abro la pagina de movistar
    Y        ingreso los datos para la bitacora
      | Analista QA        | HU           | Test        | Transaccion                    | Tipo Venta |
      | Jefferson Riobueno | TIQLT-23032 | TIQLT-20770 | Visualizacion de Ofertas Movil | CONTADO    |
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
#    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres      | apellidos    | genero    |
      | QATIPROD QAN | veinticuatro | masculino |
#    Y        guardo el nombre del cliente
#    Y        cierro popup de aviso
#    Y        valido que muestre el nombre completo del cliente "<nombreCliente>"
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan movil "<tipoPlanMovil>"
#    Y        selecciono un plan movil "<nombrePlan>"
    Y        selecciono un plan "<nombrePlan>" movil
    Y        visualizo los detalles del plan seleccionado

    Ejemplos:
      | tipoUsuario     | userName     | password | msgHome    | tipoDocumento | documento  | tipoPlanMovil | nombrePlan                              |
      | usuario externo | userNameQAN8 | passQAN8 | Bienvenid@ | CE            | 1100000765 | Postpago      | RV Plan Ilimitado Mi Movistar S/ 74.9 V |
#      | usuario interno | userNameQAN4 | passQAN4 | Bienvenid@ | CE            | 1100002324 | Postpago      | RV Plan Ilimitado Mi Movistar S/ 74.9 V |

