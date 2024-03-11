#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT0
##GDAP: GDAP-#QAN1
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: VICTOR CARPIO
##FECMOD: 25/12/2023

@BERSERKERS @QAN @DoneDevOps @DoneDevOpsPI11 @Sanity28  @DROP-G01

Característica: AT-DT0_Completa Planta Fija Alta Movil con documento CE en Call Center

  @CompletaPlantaFijaAltaMovil
  Esquema del escenario: Completa Planta Fija Alta Movil con documento CE
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    #Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    #Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos     | genero    |
      | QAN     | MCCCDIECISEIS | masculino |
    #Y        valido que muestre el nombre completo del cliente "<nombreCliente>"
    Y        selecciono el boton de la Linea Hogar Existente "<numeroExistente>"
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para verificar la direccion
    Y        presiono el boton Confirmar direccion
    Y        selecciono tipo de oferta
    Y        selecciono un plan Movistar Total "<nombrePlan>"
    Y        valido el detalle de la seleccion
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        presiono Consultar ubicacion
    Entonces me muestra la pantalla para ingresar la direccion de entrega
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A  | CASA         | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        Consulto ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono horario "3pm-7pm"
    E        ingreso telefono del titular "998877665"
    E        ingreso instrucciones de delivery "cerca al parque"
    Y        doy clic en confirmar delivery
    #Y        valido que este en la seccion completa los datos solicitados
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        ingreso el callId "910690021"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 10/12/1990 | Divorciado  | Alemania     |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Y        guardo el numero de solicitud
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces me muestra la pantalla registrar venta
    Y        doy clic para descargar el contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "solicitud"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
    Ejemplos:
      | tipoUsuario     | userName    | password | msgHome    | tipoDocumento | documento  | departamento | provincia | distrito | direccion                         | referencia | nombrePlan                                | numeroExistente |
      | usuario interno | userNameQAN | passQAN  | Bienvenid@ | CE            | 1100000232 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma  | Trío HD 100 Mbps RA + Ilimitado 135 Gb RA | 5010197873      |
#      | usuario interno |          |          | Bienvenid@ | CE            | 221011210  | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma  | Trío HD 100 Mbps RA + Ilimitado 135 Gb RA | 984685176       |
#      | usuario interno |          |         | Bienvenid@ | CE            | 221011210  | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma  | Trío HD 100 Mbps RA + Ilimitado 135 Gb RA | 984685176       |
#      | usuario interno |          |          | Bienvenid@ | CE            | 1100000312 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma  | Trío HD 100 Mbps RA + Ilimitado 135 Gb RA |                 |
#      | usuario interno |          |          | Bienvenid@ | CE            | 1100000200 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma  | Trío HD 100 Mbps RA + Ilimitado 135 Gb RA |                 |
#      | usuario interno |          |          | Bienvenid@ | CE            | 221011316  | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma  | Trío HD 100 Mbps RA + Ilimitado 135 Gb RA | 14013112        |
#      | usuario interno |          |          | Bienvenid@ | CE            | 1100000265 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma  | Trío HD 100 Mbps RA + Ilimitado 135 Gb RA | 13095674        |
#      | usuario interno |          |          | Bienvenid@ | CE            | 1100000328 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma  | Trío HD 100 Mbps RA + Ilimitado 135 Gb RA | 13979978        |
#      | usuario interno |          |          | Bienvenid@ | CE            | 1100000312 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma  | Trío HD 100 Mbps RA + Ilimitado 135 Gb RA | 12776246        |
#      | usuario interno |          |          | Bienvenid@ | CE            | 1100000307 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma  | Trío HD 100 Mbps RA + Ilimitado 135 Gb RA | 13998362        |
