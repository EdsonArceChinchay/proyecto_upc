#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT038
##GDAP: GDAP-#QAN2
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: VICTOR CARPIO
##FECMOD: 25/12/2023

@BERSERKERS @QAN @DoneDevOps @DoneDevOpsPI11 @Sanity28 @AT-DT038 @DROP-G01

Característica: AT-DT038_Completa Planta Movil Alta Fija con documento CE en Canal Call Center

  @CompletaPlantaMovilAltaFija
  Esquema del escenario: Completa Planta Movil Alta Fija con documento CE
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
    #Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos   | genero    |
      | QAN     | SESENTAYDOS | masculino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciona el boton del numero de celular existente "<celularExistente>"
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
   # Y        ingreso la informacion del lugar de instalacion
   #   | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
   #   | A  | casa     | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton consultar cobertura
    #        Entonces me muestra la pantalla de ofertas sugeridos
    Y        selecciono tipo de oferta
    Y        selecciono un plan Movistar Total "<nombrePlan>"
    Y        valido el detalle de la seleccion
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso el callId "910690021"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
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
    Y        valido que se muestre el detalle del pedido del "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido del "Servicio Móvil"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "solicitud"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
    Ejemplos:
  | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor              | nombreCliente   | tipoDocumento | documento  | departamento | provincia | distrito | direccion                         | referencia | tipoOferta     | nombrePlan                                | correo           | celularExistente |
  | usuario externo | userNameCC | passCC   | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | QAN SESENTAYDOS | CE            | 1075255002 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma  | MOVISTAR TOTAL | Trío HD 100 Mbps RA + Ilimitado 135 Gb RA | correo@gmail.com |                  |
#      | usuario interno |          |              | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | QAN SESENTAYDOS | CE         | 1100000218   | 15        | 1501     | 150116                            | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma      | MOVISTAR TOTAL                            | Trío HD 100 Mbps RV + Ilimitado 95 Gb RV | correo@gmail.com |           |
#      | usuario interno |          |              | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | QAN SESENTAYDOS | CE         | 1100000310   | 15        | 1501     | 150116                            | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma      | MOVISTAR TOTAL                            | Trío HD 100 Mbps RV + Ilimitado 95 Gb RV | correo@gmail.com |           |
#      | usuario interno |          |              | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | QAN SESENTAYDOS | CE         | 221011298    | 15        | 1501     | 150116                            | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma      | MOVISTAR TOTAL                            | Trío HD 100 Mbps RV + Ilimitado 95 Gb RV | correo@gmail.com | 995130241 |
#  | usuario interno |          |          | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | QAN SESENTAYDOS | CE            | 1100000815 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma  | MOVISTAR TOTAL | Trío HD 100 Mbps RV + Ilimitado 95 Gb RV | correo@gmail.com | 984589250        |
#  | usuario interno |          |          | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | QAN SESENTAYDOS | CE            | 1100000218 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma  | MOVISTAR TOTAL | Trío HD 100 Mbps RV + Ilimitado 95 Gb RV | correo@gmail.com |                  |

