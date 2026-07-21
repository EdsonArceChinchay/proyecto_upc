#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVIL
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT025
##GDAP: GDAP-1007 v1
##GDAP: GDAP-1948 v2
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: Hiro Macuri
##FECMOD: 26/05/2026

@BERSERKERS @DoneDevOps @DoneDevOpsPI14 @AltaMovil
Característica: AT-DT025_Alta Movil Postpago a cliente con CE por canal Tienda

  @AltaMovilPostpagoCanalTienda
  Esquema del escenario: Alta Movil Postpago a cliente con CE por canal Tienda
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
    Y        cierro popup de error
    ##Y        ingreso los datos del nuevo cliente
    ##  | nombres        | apellidos      | genero   |
    ##  | Estela Rosario | Lopez Manrique | femenino |
    ## Y        valido que muestre el nombre completo del cliente "Estela Rosario Lopez Manrique"
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        cierro el popup de cliente con exoneracion
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan movil "<tipoPlanMovil>"
    Y        selecciono la opcion "<tipoPlanes>"
    Y        doy click en el boton seleccionar oferta
    Y        doy click en el boton Linea Nueva
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        valido que este en la seccion completa los datos solicitados
    Y        ingreso correo electronico "estelalopez@mail.com"
    Y        ingreso nuevamente el correo electronico "estelalopez@mail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito   | direccion            |
      | 26/07/1995 | soltero     | Alemania     | LIMA         | LIMA      | SAN MIGUEL | CALLE SAN MARTIN 399 |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        doy clic para descargar el contrato
     Entonces valido el contrato descargado
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
   ## Y        doy click en ver detalle del pedido
   ## Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
   ## Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | tipoPlanMovil | tipoPlanes                 |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | CE           | 444455687   | Postpago | Plan Ilimitado Mi Movistar S/69.9 VII |

  ## Data Sanity v1 : 1042464796
  ## Data Sanity v2 : 444455687
  ## userNameST | userPasswordST
  # #userNameDLC | userPasswordDLC
  ##Descomentar lineas con son clientes nuevos : 7077003355
  ## tipoPlanes :Plan Movistar Maximo S/79.9 u Plan Ilimitado Mi Movistar S/69.9 VII