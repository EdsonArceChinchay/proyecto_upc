#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: REFACTORIZADO 24/08/2023 OK
##CODIGO: AT-DT101
##GDAP: GDAP-1369
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 11/06/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11SP5
Característica: Subir audio en canal Call Center

  @AdjuntarAudioBackOffice
  Escenario: Subir un audio despues de generar orden en canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "userType"
    Y        ingreso el usuario "userNameCC"
    Y        ingreso el password "userPasswordCC"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por el documento "121219511"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud




