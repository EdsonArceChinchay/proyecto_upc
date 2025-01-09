#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT038
##GDAP: GDAP-1765
##SPRINT CREADO:
##FRECUENCIA:
##TAG: BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 06/01/2025

@validar-mt

Característica: Visualizacion de Ofertas MT - CE por Call Center

  @robotQAN @QAN
  Esquema del escenario: Visualizacion de Ofertas MT - CE por Call Center
    Dado     que abro la pagina de movistar
    Y        ingreso los datos para la bitacora
      | Analista QA   | HU          | Test        | Transaccion                 | Tipo Venta |
      | Lucero Obispo | TIQLT-23032 | TIQLT-20771 | Visualizacion de Ofertas MT | CONTADO    |
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    #Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres      | apellidos          | genero   |
      | QATIPROD QAN | DCC SETENTAICUATRO | femenino |
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
#   Y        ingreso la informacion del lugar de instalacion
#      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
#      | A  | casa     | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton consultar cobertura
    #        Entonces me muestra la pantalla de ofertas sugeridos
    Y        selecciono tipo de oferta
#    Y        selecciono un plan Movistar Total "<nombrePlan>"
    Y        selecciono un plan "<nombrePlan>" de Movistar Total
    Y        visualizo los detalles del plan seleccionado
    Y        selecciono ir a Movistar Total

    Ejemplos:
      | userType | userName     | password         | msgHome    | documentType | documentNumber | departamento | provincia | distrito | direccion                   | referencia | nombrePlan |
      | userType | userNameQAN5 | userPasswordQAN5 | Bienvenid@ | CE           | 1100000761     | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 | Inkafarma  | MBPS       |
