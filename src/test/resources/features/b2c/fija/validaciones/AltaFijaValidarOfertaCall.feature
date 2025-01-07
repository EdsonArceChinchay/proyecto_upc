#language:es
##CREADOR: Angel Medina
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT005
##GDAP: GDAP-1763
##SPRINT CREADO: PI12
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 06/01/2025

@validar-fija
Característica:Visualizacion de Ofertas Fija - CE en canal Call Center

  @robotQAN
  Esquema del escenario: Visualizacion de Ofertas Fija - CE por Call Center
    Dado     que abro la pagina de movistar
    Y        ingreso los datos para la bitacora
      | Analista QA   | HU          | Test        | Transaccion                   | Tipo Venta |
      | Lucero Obispo | TIQLT-23032 | TIQLT-20769 | Visualizacion de Ofertas Fija | CONTADO    |
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
      | nombres   | apellidos   | genero   |
      | <nombres> | <apellidos> | femenino |
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
      | mz | tipoVivienda | nombreVivienda | bloque | piso | int | conjunto             | conjHabit |
      |    |              |                | 1      | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"


    Ejemplos:
      | tipoUsuario     | userName     | password         | msgHome    | tipoDocumento | documento  | nombres      | apellidos            | departamento | provincia | distrito | direccion                                                                 | referencia             | tipoPlan | nombrePlan |
      | usuario externo | userNameQAN5 | userPasswordQAN5 | Bienvenid@ | CE            | 1100002107 | QATIPROD QAN | QAN TRESCIENTOS ONCE | 15           | 1501      | 150104   | AVENIDA ALMIRANTE MIGUEL GRAU 93 Bloque 1 Piso 1 interior 1 Urb Sauzalito | AL FRENTE DE LA BOTICA | Duo      | DUO TV     |
    #  | usuario interno | userNameQAN6 | passQAN6 | Bienvenid@ | CE            | 221011311 | QATIPROD QAN | QAN TRESCIENTOS ONCE | 15           | 1501      | 150104   | AVENIDA ALMIRANTE MIGUEL GRAU 93 Bloque 1 Piso 1 interior 1 Urb Sauzalito | AL FRENTE DE LA BOTICA | Duo      | DUO TV     |
    #      | usuario interno | userNameCC | passCC   | Bienvenid@ | CE            | 1100000312 | QATIPROD QAN | Prueba QAN TRECIENTOS DOCE | 15           | 1501      | 150104   | AVENIDA ALMIRANTE MIGUEL GRAU 93 Bloque 1 Piso 1 interior 1 Urb Sauzalito | AL FRENTE DE LA BOTICA | Duo      | DUO INTERNET |
    #  | usuario interno | userNameCC | passCC   | Bienvenid@ | CE            | 1100000522 | QATIPROD QAN | Prueba QAN D VEINTIDOS   | 15           | 1501      | 150104   | AVENIDA ALMIRANTE MIGUEL GRAU 93 Bloque 1 Piso 2 interior 1 Urb Sauzalito | AL FRENTE DE LA BOTICA | Duo      | DUO INTERNET |
    #  | usuario interno | userNameCC | passCC   | Bienvenid@ | CE            | 1100000523 | QATIPROD QAN | Prueba QAN D VEINTITRES  | 15           | 1501      | 150104   | AVENIDA ALMIRANTE MIGUEL GRAU 93 Bloque 1 Piso 2 interior 1 Urb Sauzalito | AL FRENTE DE LA BOTICA | Duo      | DUO TV       |
    #  | usuario interno | userNameCC | passCC   | Bienvenid@ | CE            | 1100000525 | QATIPROD QAN | Prueba QAN D VEINTICINCO | 15           | 1501      | 150104   | AVENIDA ALMIRANTE MIGUEL GRAU 93 Bloque 1 Piso 3 interior 1 Urb Sauzalito | AL FRENTE DE LA BOTICA | Duo      | DUO INTERNET |












