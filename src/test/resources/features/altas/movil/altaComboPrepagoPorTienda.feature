#language:es
@BERSERKERS @DoneDevOps @DoneDevOpsPI13S4
Característica: AT-DT022_Alta Combo Prepago por Tienda
  Yo como asesor de Tienda
  Quiero hacer un alta combo prepago a un usuario con CE sin parque en movistar

  Antecedentes:
    Dado     que abro la pagina de movistar

  @altaComboPrepagoPorTienda
  Esquema del escenario: Alta movil prepago combo por tienda con cliente nuevo con documento CE
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
      | nombres | apellidos     | genero    |
      | Jose   | Black Label | Masculino |
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Prepago" que desea
    Y        doy click en el boton Siguiente
    Y        selecciono añadir equipos
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia     | tipoPago   | equipoName               |
      | sin permanencia | Al Contado | HUAWEI P30 AZUL ELLE-L04 |
    Y        doy click en el boton seleccionar
    Y        selecciono la cartilla Linea Nueva
    Y        selecciono el boton de iniciar registro
    Y        ingreso un correo electronico "prueba@prueba.com"
    Y        ingreso nuevamente el correo electronico "prueba@prueba.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion                   |
      | 12/12/2000 | soltero     | Alemania     | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 460 |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        presiono continuar
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido
    #Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Ejemplos:
      | tipoUsuario     | userName  | password     | msgHome    | tipoDocumento | documento  | nombrePlan      |
      | usuario externo | evillanuevag | $t3l3f0n1c4$ | Bienvenid@ | CE         | 1042464882 | Prepago preplan |
