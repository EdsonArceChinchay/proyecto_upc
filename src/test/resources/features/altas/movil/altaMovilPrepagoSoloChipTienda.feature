#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Sanity28 @DROP

Característica: AT-DT028_Alta Movil Prepago solo chip Tienda


  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaMovilPrepagoSoloChipTienda_CE
  Esquema del escenario: Alta movil por call center con nuevo cliente con documento CE
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos   | genero   |
      | Ana     | Lopez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Prepago" que desea
    Y        doy click en el boton Siguiente
    Y        selecciono la oferta de plan movil "<oferta>"
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
#    Y        presiono el boton descargar contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tiendaAsesor | tipoDocumento | documento  | oferta       | nombrePlan |
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | CAJAMARCA    | CE            | 1042464781 | PLAN PREPAGO | Preplan    |
#      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | CAJAMARCA    | CE            | 1000000006 | PLAN PREPAGO | Prepago con Tarifa |
