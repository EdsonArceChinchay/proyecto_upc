#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT023
##GDAP: GDAP-584
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Sanity28 @DROPG7

Característica: AT-DT023_Alta Movil Control con un financiamiento por tienda

  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaMovilFinaciamientoTienda_CE
  Esquema del escenario: Realizar una alta movil Control con un financiamiento, metodo de entrega por tienda
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
      | nombres | apellidos | genero    |
      | Jbac    | Lozano    | masculino |
    Y        selecciono el boton Linea Nueva Movil
    Y cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
 #   Y        selecciono tipo de oferta
 #   Y        selecciono el tipo de plan movil "Control"
   #  Y        selecciono un plan movil "Plan Mi Movistar Total 72 Gb"
#    Y        selecciono la oferta de plan movil "Control"
#    Y        selecciono un plan movil "Plan Ilimitado Mi Movistar S/55.9 "
#    Y        selecciono el boton de iniciar registro
#    Y        selecciono tipo de oferta alta movil
#      | Ofertas_Sugeridas |
#      | PLAN MOVIL        |
#    Y        selecciono la campania
#      | Tipo_Ofertas |
#      | Control      |
#    Y        selecciono el boton de Seleccionar Oferta
#    Y        selecciono el boton Linea Nueva Movil
#    Y        selecciono en agregar equipo y valido la pantalla de seleccionar equipo:"Seleccione un equipo"
#    Y        selecciono un equipo movil
    Y        selecciono en linea Nueva
    Y        selecciono el boton de iniciar registro
    Y        ingreso un correo electronico "tester@tester.com"
    Y        ingreso nuevamente el correo electronico "tester@tester.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion                   |
      | 12/12/1980 | soltero     | Angola      | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Ejemplos:

      | tipoUsuario     | userName     | password         | msgHome    | tipoDocumento | documento  | planMovil |
      | usuario externo | nishuizas | $T3l3f0n1c4$ | Bienvenid@ | CE            | 1024268407 | Postpago  |


