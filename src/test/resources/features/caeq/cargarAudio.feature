#language:es

##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: REFACTORIZADO 24/08/2023 OK
##CODIGO: AT-DT101
##GDAP: GDAP-00
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 24/10/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11SP5
  Característica: Subir un audio por CPL

    @AdjuntarAudioBackOffice
    Escenario: Subir un audio luego de finalizar registro de CAPL
      Dado que abro la pagina de movistar
      Dado     que abro la pagina de movistar
      Cuando   presiono el boton Iniciar Sesion
      Y        selecciono el tipo de usuario "usuario externo"
      Y        ingreso el usuario "jpachaot"
      Y        ingreso el password "$t3l3f0n1c4$"
      E        ingreso el captcha
      Y        presiono el boton Continuar hacia el home
      Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
      Y        me dirijo a la bandeja de Back Office
      Y        busco por el documento "1075255161"
      Y        selecciono la solicitud "FE1000142653"
      Y        cargo el audio en la web
      Y        apruebo la solicitud




