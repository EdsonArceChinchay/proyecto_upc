#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT006
##GDAP: GDAP-571
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI12 @AltaDuo_Upfront_CE @DROP-G01
Característica: AT-DT006_Alta Duo por tienda

  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaDuo_Upfront
  Esquema del escenario: Alta Duo por tienda con Nuevo Cliente Extranjero
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    #Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos   | genero   |
      | Fernada     | Lopez Lance | femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
#    Y        ingreso la informacion del lugar de instalacion
#      | mz  | vivienda      | nombreVivienda | piso | int | conjunto             | conjHabit |
#      | A  | 1    | alex mancilla | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | -parque   |
    Y        presiono el boton consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<plan_hogar>"
    Y        selecciono el plan "<nombrePlan>"
    E        inicio su registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        completo los datos solicitados
      | fechaNac   | nacionalidad | estado_civil |
      | 01/12/1990 | Angola   | Casado    |
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    #Y        presiono el boton descargar contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Ejemplos:
<<<<<<< HEAD
      | tipoUsuario     | userName    | password       | msgHome    | tipoDocumento | documento | departamento | provincia | distrito | direccion                                | referencia | plan_hogar | nombrePlan                                |
      | usuario externo | nishuizas | $t3l3f0n1c4$ | Bienvenid@ | CE            | 0029877545 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 | INKAFARMA  | Duo        | DUO INTERNET ESTANDAR HD RA S23 200 MBPS |
=======
      | tipoUsuario     | userName  | password     | msgHome    | tipoDocumento | documento  | departamento | provincia | distrito | direccion                         | referencia | plan_hogar | nombrePlan                   |
      | usuario externo | nishuizas | $T3l3f0n1c4$ | Bienvenid@ | CE            | 1002464816 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | INKAFARMA  | Duo        | DÚO MOVISTAR VOZ INTERNET RA |
>>>>>>> d161020ae9448874e09a6a0111575b8a4c6f9303
