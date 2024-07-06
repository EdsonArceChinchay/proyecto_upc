#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT107
##GDAP: GDAP-1067
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2024

@BERSERKERS @DoneDevOps @svaBloqueHboDuoPorCallCenter @AltaSVA
Característica: AT-DT107_Sva bloque HBO a duo por Call Center
  Quiero agregar un bloque hbo a un cliente con parque duo a un usuario con CE

  @svaBloqueHboDuoPorCallCenter
  Esquema del escenario: Alta de un bloque hbo a un cliente con parque duo a un usuario con CE
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Cuando   doy click en el boton Ver detalle del servicio "9234740961"
    Y        doy click en el boton Agregar SVA
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA bloque "HBO"
    Y        doy click en el boton Guardar cambios
    Cuando   doy clic a iniciar registro
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor              | tipoDocumento | documento | departamento | provincia | distrito | direccion                   | referencia | tipoOferta     | nombrePlan                                        | sva | correo            |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 142536409 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | PISO 1     | MOVISTAR TOTAL | TRÍO MOV. VOZ INTERNET ESTANDAR HD RA D22 50 MBPS | HBO | prueba@prueba.com |
