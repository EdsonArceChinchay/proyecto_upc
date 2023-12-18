#language:es
##CREADOR: MOISES LLAMOCA
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT116
##GDAP:GDAP-1412
##SPRINT CREADO:PI16 SP4
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 29/08/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Sanity28 @DROP-G04 @RegresionDitoC

Característica: AT-DT116_Alta MT MAS SVA POR CANAL TIENDAS

  @AltaMt_SvaTiendas
  Esquema del escenario: Alta MT mas SVA en Canal Tiendas
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    #Y     valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos | genero    |
      | Moises  | Llanos    | masculino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        cierro pop up de Cliente Exonerado
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    #Y        ingreso la informacion del lugar de instalacion
     # | mz | vivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
      #| A  | EDIFICIO | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | parque   |
    Y        presiono el boton consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono un plan Movistar Total "<nombrePlan>"
    Y        valido el detalle de la seleccion
    Y        valido que este en la seccion de registro
    Y        doy click en agregar "PACK ANTIVIRUS MCAFEE"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "tester@tester.com"
    Y        ingreso nuevamente el correo electronico "tester@tester.com"
    Y        doy click en datos del cliente
    Y        completo los datos solicitados
      | fechaNac   | nacionalidad | estado_civil |
      | 24/01/1996 | Aruba        | Casado       |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
#    Y        presiono el boton descargar contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName  | password     | msgHome    | tipoDocumento | documento  | departamento | provincia | distrito | direccion                | referencia | tipoPlan | nombrePlan                                |
      | usuario externo | nishuizas | $t3l3f0n1c4$ | Bienvenid@ | CE            | 1042464677 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 | INKAFARMA  | Trío     | Trío HD 600 Mbps RA + Ilimitado 135 Gb RA |

