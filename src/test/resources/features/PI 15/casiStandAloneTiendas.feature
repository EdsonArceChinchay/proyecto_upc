#language:es
##CREADOR: Moises Llamoca
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:AT-DT112
##GDAP:
##SPRINT CREADO: SP4
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:Reusable
##ENCARGADO:Brandon
##FECMOD: 30/05/2023

@BERSERKERS @DoneDevOps @casiStandAloneTiendas

Característica: AT-DT112_CASI Stand Alone por Tiendas
  Quiero realizar un CASI a un cliente con parque movil a un usuario con CE

  Antecedentes:
    Dado     que abro la pagina de movistar

  @casiStandAloneTiendas
  Esquema del escenario: Cambio de Simcard a un cliente con parque movil a un usuario con CE
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
    Y        cierro pop up de CU
    Cuando   doy click en ver detalle
    Y        selecciono el boton Cambiar Chip
    Y        cierro pop up de Cliente Exonerado
    Cuando   doy clic a iniciar registro
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName    | password       | msgHome    | tipoDocumento | documento  |  correo           |
      | usuario externo | evillanuevag | $Telefonica2020$ | Bienvenid@ | CE            | 1042464853 | prueba@prueba.com |
