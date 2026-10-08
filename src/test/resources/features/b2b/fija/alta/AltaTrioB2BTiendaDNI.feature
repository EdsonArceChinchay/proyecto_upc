#language:es
##CREADOR: Edson Arce
##APP: DITO
##MODULO: FIJA
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT019
##GDAP: GDAP-965
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: Edson Arce
##FECMOD: 13/02/2024

@BERSERKERS @DoneDevOps @AltaFija @AltaTrioUpfront
Característica: AT-DT019_Alta Trío familiar 100 Mbps tecnología FTTH + SVA con ruc por canal Tienda, financiado 100 % con flujo biométrico

  @AltaTrioRuCTienda @MVP10 @Global
  Esquema del escenario: Alta Trío familiar 100 Mbps tecnología FTTH + SVA con ruc por canal Tienda, financiado 100 % con flujo biométrico
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        selecciono el ID de Cliente nro "<nro>"
    Y        selecciono el tipo de documento "<tipoDocRepLegal>" del Representante Legal
    E        ingreso el numero de documento "<numDocRepLegal>" del Representante Legal
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

    Ejemplos:
      | userType | userName   | userPassword   | msgHome     | channelType  | documentType | documentNumber | nro | tipoDocRepLegal | numDocRepLegal | departamento | provincia | distrito | direccion                   | referencia |
      | userType | userNameST | userPasswordST | Bienvenid@   | Tienda        | RUC          | 20534983612    | 1   | DNI             | 75448387       | LIMA         | LIMA      | LINCE    | Jiron Julio Cesar Tello 469 | A          |
