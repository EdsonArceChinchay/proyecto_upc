#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT038
##GDAP: GDAP-589
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023
#probarenmadrugada
@BERSERKERS @QAN @DoneDevOps @DoneDevOpsPI11 @Sanity28 @AT-DT038 @DROP-G01

Característica: AT-DT038_Alta Fija Pura MT por Call Center

  @AltaPuraMTcallCenterCE
  Esquema del escenario: Alta pura MT por call center con nuevo cliente con documento CE
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
      | nombres | apellidos   | genero   |
      | Lucia   | Perez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
#    Y        ingreso la informacion del lugar de instalacion
#      | mz | vivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
#      | A  | casa     | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton consultar cobertura
    #        Entonces me muestra la pantalla de ofertas sugeridos
    Y        selecciono tipo de oferta
    Y        selecciono un plan Movistar Total "<nombrePlan>"
    Y        valido el detalle de la seleccion
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        presiono Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | vivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A  | CASA     | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        Consulto ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono horario "3pm-7pm"
    E        ingreso telefono del titular "984592938"
    E        ingreso instrucciones de delivery "cerca al parque"
    Y        doy clic en confirmar delivery
    #Y        valido que este en la seccion completa los datos solicitados
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    #Y        completo id call "2BE1772E-ADDB-51B6-865A-7E356D944955"
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
    Y        doy clic para descargar el contrato
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
      | tipoUsuario     | userName | password | msgHome    | tipoDocumento | documento  | departamento | provincia | distrito | direccion                         | referencia | nombrePlan |
      | usuario interno |          |          | Bienvenid@ | CE            | 1100000786 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma  | MBPS       |

