#language:es
##CREADOR:  CARLOS RUIZ
##APP: DITO
##MODULO:
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT
##GDAP: GDAP-
##SPRINT CREADO: PI18_SP3
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: CARLOS RUIZ
##FECMOD: 12/02/2024

@BERSERKERS @DoneDevOps @PI18_SP3 @TEST1
Característica: AT-DT0_ Alta Trío B2B Upfront con SVA con representa legal CEX en canal Tienda

  @AltaTrioSVARucCETienda
  Esquema del escenario: Alta Trío B2B Upfront con SVAs con representa legal CEX en canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        selecciono el ID de Cliente nro "<nro>"
    Y        selecciono el tipo de documento "<tipoDocRepLegal>" del Representante Legal
    E        ingreso el numero del documento "<numDocRepLegal>" del Representante Legal
    Y        doy click en Validar Representa Legal
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton consultar cobertura
#   Y        valido si el usuario aplica para upfront
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        selecciono la oferta "<plan>"
    Y        selecciono en linea Nueva
    Y        doy click en añadir SVA
    Y        doy click en agregar Bloque "HBO"
    Y        doy click en Guardar cambios
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento para RUC
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en el boton continuar
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    #Y        doy clic para descargar el contrato
    Y        doy clic en Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido del "Servicio Hogar"

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento   | nro | tipoDocRepLegal | numDocRepLegal | cliente            | departamento | provincia | distrito | direccion                   | referencia | tipoPlan | nombrePlan                                         | tipoValidacion | plan                                           |
      | usuario externo | userNameST | passST   | Bienvenid@ | RUC           | 20450685446 | 2   | CE              | 6172834231     | ANALY FLORES LOPEZ | 15           | 1501      | 150116   | Jiron Julio Cesar Tello 469 | A          | Trío     | TRÍO MOV. VOZ INTERNET ESTANDAR HD RA D22 150 MBPS | discapacitado  | Trio Mov. Voz Int. Estandar HD RA O23 100 Mbps |
