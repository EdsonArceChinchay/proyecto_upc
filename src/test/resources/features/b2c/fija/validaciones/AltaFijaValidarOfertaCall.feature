#language:es
##CREADOR: Angel Medina
##APP: DITO
##MODULO: FIJA
##FUNCIONALIDAD: ALTA DUO
##ESTADO: ACTIVO
##CODIGO: AT-DT005
##GDAP: GDAP-572
##SPRINT CREADO: PI12
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: Angel Medina
##FECMOD: 08/04/2024

@validar-fija
Característica: Visualizacion de Ofertas Fija - CE en canal Call Center

  @robotQAN @QAN
  Esquema del escenario: Visualizacion de Ofertas Fija - CE en canal Call Center
    Dado     que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA   | HU           | Test        | Transaccion   | Tipo Venta |
      | Lucero Obispo | TIQLT-JR1220 | TIQLT-20528 | ALTA FIJA DUO | Contado    |
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos | genero   |
      | Pruebas | Qan       | femenino |
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
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto                 | conjHabit |
      |    |              |                | 1    | 4   | URBANIZACION RESIDENCIAL | RISSO     |
    Y        presiono el boton Consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "<plan_hogar>"
    Y        selecciono el plan "<nombrePlan>"


    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | channelType | documentType | documentNumber | departamento | provincia | distrito | direccion                   | referencia | plan_hogar | nombrePlan                |
      | userType | userNameQAN5 | userPasswordQAN5 | Bienvenid@ | Call Center | CE           | 1100002107     | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | DUO MOVISTAR VOZ INTERNET |