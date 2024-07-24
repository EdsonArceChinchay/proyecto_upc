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
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        selecciono la linea con numero "9234740961"
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "ACTUALIZAR DIRECCION"
    Y        ingreso la referencia de la direccion "."
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        doy click en el boton "ENTENDIDO"
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono boton mantener plan
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Agregar SVA
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA bloque "HBO"
    Y        doy click en el boton Guardar cambios
    Cuando   doy click en el boton Iniciar registro
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento | correo            |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | CE            | 142536409 | prueba@prueba.com |
