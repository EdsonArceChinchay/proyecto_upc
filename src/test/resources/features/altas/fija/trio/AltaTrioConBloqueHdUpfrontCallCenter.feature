#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT018
##GDAP: GDAP-591
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROP35_Upfront @Sanity28 @DROP

Característica: AT-DT018_Alta Trio con bloque HD Upfront por Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaTrioConBloqueHdUpfrontCallCenter
  Esquema del escenario: Alta Trio con bloque HD Upfront por Call Center con CE sin productos asociados sin biometria
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    #Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos    | genero    |
      | Juan    | Lopez Garcia | masculino |
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
    Y        selecciono el plan "<nombrePlan>"
    Y        doy click en Agregar Sva
    Y         seleccionamos agregar Bloque HBO
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    #Y        ingreso el call id "2BE1772E-ADDB-51B6-865A-7E356D944955"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/12/1980 | Casado      | Albania      |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName  | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento  | departamento | provincia | distrito | direccion                   | referencia | tipoPlan | nombrePlan                                         | tipoValidacion | nombreMadre | nombrePadre | distritoNac |
#      | usuario externo | lterrazosce | Telefonica2021 | Bienvenid@ |  SAN MIGUEL    | DNI           | 75504508  | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | casa verde    | Internet RA 40 Mbps | discapacitado  | ELIZABETH   | JORGE       | LIMA        |
      | usuario externo | jpachaot  | $t3l3f0n1c4$ | Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 10003901233 | 15           | 1501      | 150116   | Jiron Julio Cesar Tello 460 | casa crema | Trío     | TRÍO MOV. VOZ INTERNET ESTANDAR HD RA D22 100 MBPS| discapacitado  | ODELIA      | CIPRIANO    | EL AGUSTINO |


