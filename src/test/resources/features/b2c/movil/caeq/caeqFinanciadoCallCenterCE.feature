#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVÍL
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO:
##GDAP: GDAP-1420 v1
##GDAP: GDAP-1946 v2
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDENES EN VUELO)
##ENCARGADO: HIRO MACURI
##FECMOD: 29/05/2026

@BERSERKERS @DoneDevOps @DoneDevOpsPI12
Característica: Cambio de Equipo (CAEQ) a cliente extranjero (CE) por Call Center

  @CaeqFinanciadoCallCenter_CE
  Esquema del escenario: Cambio de Equipo (CAEQ) a cliente extranjero (CE) por Call Center
    Dado     que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA   | HU         | Test      | Transaccion | Tipo Venta | Tags                         |
      | Jorge Cancino | TIQLT-xxxx | TIQLT-xxx | CAEQ        | Financiado | @CaeqFinanciadoCallCenter_CE |
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar

    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | insertarDireccion | channelType | documentType | documentNumber | EncontrarCelular | equipoName                  | nombreMadre | nombrePadre | distritoNac |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | SI                | Call Center | CE          | 1042464939       | 920955026        | HONOR X8A VERDE CRT-LX3 C/PACK | SILVIA      | FRANCISCO   | COMAS       |


  ## CE A PROBAR : 1042464939
  ## N° CELULAR A PROBAR  : 920955026
  ##NOMBRE DEL EQUIPO : HONOR X8A VERDE CRT-LX3 C/PACK
  ## NOMBRE DEL Esquema del escenario: : Cambio de Equipo (CAEQ) financiado a cliente extranjero (CE) por Call Center