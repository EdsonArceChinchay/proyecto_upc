#language:es

  # CREADOR: Edson Arce


@BERSERKERS @DoneDevOps @AT-DT019
Característica: Alta Trío familiar 100 Mbps tecnología FTTH + SVA con ruc en tienda, financiado 100 % con flujo biométrico

  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaTrioRuCTienda @MVP10 @Global
  Esquema del escenario: Alta Trío familiar 100 Mbps tecnología FTTH + SVA con ruc en tienda, financiado 100 % con flujo biométrico
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    #Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        selecciono el ID de Cliente nro "<nro>"
    Y        selecciono el tipo de documento "<tipoDocRepLegal>" del Representante Legal
    E        ingreso el numero del documento "<numDocRepLegal>" del Representante Legal
    Y        doy click en Validar Representa Legal
    #Y        valido que me traiga los servicios contratados por el cliente
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | lote | vivienda | nombreVivienda  | piso | int | conjunto             | conjHabit  |
      | A  | 1    | EDIFICIO | Familia Barreto | 1    | 1   | URBANIZACION POPULAR | conjunto b |
    Y        presiono el boton consultar cobertura
#   Y        valido si el usuario aplica para upfront
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        selecciono la oferta "<plan>"
   #Y        doy click en Cambiar plan hogar
    Y        selecciono en linea Nueva
    #Y        selecciono el plan "<nombrePlan>"
    Y        doy click en agregar repetidor
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento para RUC
   #Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy clic en el boton validar identidad representante legal
    Y        elijo el tipo de validacion a realizar "<tipoValidacion>"
    #Y        ingreso los datos del supervisor
     # | numdoc   | user        | password     |
     #| 42770472 | rdelatorreg | $t3l3f0n1c4$ |
    Y        doy click en el boton continuar
    Y        ingreso los datos solicitados para la validacion del cliente
      | nombreMadre   | nombrePadre   | distritoNac   |
    #  | DEYSI | JOSE | SULLANA |
      | MARIBEL | RUBEN | SAN JUAN DE MIRAFLORES |
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    #Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento |documento|nro|tipoDocRepLegal|numDocRepLegal|cliente   | departamento | provincia | distrito | direccion                   | referencia | tipoPlan | nombrePlan  |tipoValidacion|plan|
      #| usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ | Bienvenid@ | RUC            | 20513763663     |1| DNI | 75448228|ANALY FLORES LOPEZ| 15           | 1501      | 150116   | Jiron Julio Cesar Tello 460 | A | Trío     | TRÍO MOV. VOZ INTERNET ESTANDAR HD RA D22 150 MBPS|discapacitado|RA D22 50 MBPS|
      | usuario externo | evillanuevag | #o2Wy23oA1458 | Bienvenid@ | Bienvenid@ | RUC            | 20547284501     |1| DNI | 75447652|ANALY FLORES LOPEZ| 15           | 1501      | 150116   | Jiron Julio Cesar Tello 460 | A | Trío     | TRÍO MOV. VOZ INTERNET ESTANDAR HD RA D22 150 MBPS|discapacitado|TRÍO MOV. VOZ INTERNET ESTANDAR HD RA D22 150 MBPS|

