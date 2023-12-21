#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT037
##GDAP: GDAP-1006
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 08/11/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @AT-DT037

Característica: AT-DT037_Alta Fija  MT SVA por Call Center

  @AltaMTSVAcallCenterCE
  Esquema del escenario: Alta  MT SVA por call center con nuevo cliente con documento CE
    Dado     que abro la pagina de movistar
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
    Y        cierro popup de error
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
	#Y        valido el detalle de la seleccion
    Y        doy click en agregar "<sva>"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        presiono Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | vivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A  | casa     | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        Consulto ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono horario "3pm-7pm"
    E        ingreso telefono del titular "998877665"
    E        ingreso instrucciones de delivery "cerca al parque"
    Y        doy clic en confirmar delivery
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
#    Y        completo id call "2BE1772E-ADDB-51B6-865A-7E356D944955"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 10/12/1990 | Divorciado  | Alemania     |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono en el boton de Registrar Venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor              | sva                   | tipoDocumento | documento | departamento | provincia | distrito | direccion                | referencia | tipoOferta     | nombrePlan                 | correo           |
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | PACK ANTIVIRUS MCAFEE | CE            | 123408407 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 | Inkafarma  | MOVISTAR TOTAL | HD 100 Mbps RA + 100 Gb RA | correo@gmail.com |

