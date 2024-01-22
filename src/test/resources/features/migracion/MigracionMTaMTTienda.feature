#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP:GDAP-1421
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 31/11/2023

@BERSERKERS

Característica: Migracion de MT a MT en Tienda

  Antecedentes:
    Dado     que abro la pagina de movistar

  @MigracionMTaMT
  Esquema del escenario: Migracion de MT a MT  en el canal Tienda
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
	#Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
#    Y        selecciono la cartilla del plan activo
    Y        selecciona el boton del numero del plan MT existente "<numeroMt>"
#    Y        Selecciono la cartilla del plan Motvistar Total
    Y        selecciono el boton Mostrar ofertas
    #Y        verifico la direccion "JULIO CESAR TELLO,469,LINCE,LIMA" actual del servicio
    Y        doy click en el boton "Confirmar direccion"
#    Y        selecciono tipo de oferta
    Y        selecciono el primer tipo de oferta
    Y        selecciono un plan Movistar Total "<nombrePlan>"
    #Y        luego doy click en la cartilla ir a Movistar Total
    Cuando   doy clic a iniciar registro
    ######
    Y        verifico si me encuentro en la pantalla de agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    ######
    Y        valido que este en la seccion completa los datos solicitados
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces me muestra la pantalla registrar venta
    Y        doy clic para descargar el contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName      | password      | msgHome    | tipoDocumento | documento  | correo           | nombrePlan                                     | numeroMt   |
      | usuario interno | shuancac | Tele#9m&9&a28 | Bienvenid@ | CE            | 1100000311 | correo@gmail.com | Dúo BA TV HD 200 Mbps RV + Ilimitado 135 Gb RV | 5010192666 |
#      | usuario interno | csalvatierrac | Tele#Jo4s&a55 | Bienvenid@ | CE            | 1100000217 | correo@gmail.com | Dúo BA TV HD 200 Mbps RV + Ilimitado 135 Gb RV ||
#      | usuario interno | csalvatierrac | Tele#Jo4s&a55 | Bienvenid@ | CE            | 1100000756 | correo@gmail.com | Dúo BA TV HD 200 Mbps RV + Ilimitado 135 Gb RV ||
#      | usuario interno | csalvatierrac | Tele#Jo4s&a55 | Bienvenid@ | CE            | 222103292  | correo@gmail.com | Dúo BA TV HD 200 Mbps RV + Ilimitado 135 Gb RV ||
#      | usuario interno | csalvatierrac | Tele#Jo4s&a55 | Bienvenid@ | CE            | 1100000217 | correo@gmail.com | Dúo BA TV HD 200 Mbps RV + Ilimitado 135 Gb RV ||
#      | usuario interno | csalvatierrac | Tele#Jo4s&a55 | Bienvenid@ | CE            | 1100000202 | correo@gmail.com | Dúo BA TV HD 200 Mbps RV + Ilimitado 135 Gb RV ||

