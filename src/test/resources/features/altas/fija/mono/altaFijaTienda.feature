#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT009
##GDAP: GDAP-577
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: VICTOR CARPIO
##FECMOD: 10/01/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Sanity @Sanity28 @SanityF @DROP-G08 @Revision
Característica: AT-DT009_Alta Fija por tienda

  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaFijaTienda
  Esquema del escenario: Alta fija por tienda con CE
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos | genero   |
      | Felipa  | Mendoza   | femenino |
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
#      | mz | lote | vivienda | nombreVivienda  | piso | int | conjunto             | conjHabit   |
#      | A  | 1    | EDIFICIO | Familia Barreto | 1    | 1   | URBANIZACION POPULAR | RISSO |
    Y        presiono el boton consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 10/11/1996 | Casado      | Albania      |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces me muestra la pantalla registrar venta
    Y        doy clic para descargar el contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
#    Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName  | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | departamento | provincia | distrito | direccion                         | referencia | tipoPlan | nombrePlan               | tipoValidacion | nombreMadre | nombrePadre | distritoNac |
      #| usuario externo | nishuizas | $t3l3f0n1c4$ | Bienvenid@ | CAJAMARCA    | CE            | 1423432127 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | INKAFARMA  | Mono     | INTERNET MOVISTAR RA D22 | discapacitado  | PATRICIA    | GERBER      | MARIANO     |
      | usuario interno |  |  | Bienvenid@ | CAJAMARCA    | CE            | 1100000747 | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 UR RISSO | INKAFARMA  | Trio     | INTERNET MOVISTAR RA D22 | discapacitado  | PATRICIA    | GERBER      | MARIANO     |


