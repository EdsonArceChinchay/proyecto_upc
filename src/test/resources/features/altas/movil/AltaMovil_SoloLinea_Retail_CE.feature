#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROP35

Característica: AT-DT031_Alta Movil Postpago solo chip Retail


  Antecedentes:
    Dado     que abro la pagina de movistar

  @MVP_Alta_movil_SoloSim_CanalRetail
  Esquema del escenario: Alta movil por call center con nuevo cliente con documento CE
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres  | apellidos      | genero   |
      | Teresita | Collasos Lopez | femenino |
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y         selecciono el boton de eleccion de planes
    Y        seleccion oferta Postpago
    Y        selecciono un plan movil "<nombrePlan>"
    Y        selecciono el boton de iniciar registro
    Y        ingreso un correo electronico "tester@tester.com"
    Y        ingreso nuevamente el correo electronico "tester@tester.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion                   |
      | 12/12/1980 | soltero     | Albania      | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 460 |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        presiono continuar
    Y        presiono el boton descargar contrato
    Y        presiono el boton Registrar venta
 #   Entonces visualizo en pantalla el mensaje de exito de la venta generada
 #   Y        valido que se muestre el detalle del pedido
    Ejemplos:
      | tipoUsuario     | userName     | password     | msgHome    | tipoDocumento | documento   | nombrePlan                              |
      | usuario externo | evillanuevag | $t3l3f0n1c4$ | Bienvenid@ | CE            | 10004544006 | RV Plan Ilimitado Mi Movistar S/69.9 II |

