# Ejemplos de Cliente API de Onurix en Java

[![Java](https://img.shields.io/badge/Java-11+-orange?style=flat&logo=openjdk&logoColor=white)](https://openjdk.java.net/)

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg?style=flat)](https://opensource.org/licenses/MIT)

![Onurix Logo](https://cdn.onurix.com/web/assets/img/logo50.png)

Este repositorio contiene ejemplos de código en Java para interactuar con la **API de Onurix**. Está diseñado para ayudarte a integrar fácilmente los servicios de Onurix (SMS, Llamadas, WhatsApp, etc.) en tus aplicaciones Java.

## 📋 Tabla de Contenido

- [Ejemplos de Cliente API de Onurix en Java](#ejemplos-de-cliente-api-de-onurix-en-java)
  - [📋 Tabla de Contenido](#-tabla-de-contenido)
  - [⚙️ Prerrequisitos](#️-prerrequisitos)
  - [📂 Estructura del Repositorio](#-estructura-del-repositorio)
    - [Calls](#calls)
    - [General](#general)
    - [Groups and Contacts](#groups-and-contacts)
    - [SMS](#sms)
    - [URL](#url)
    - [WhatsApp](#whatsapp)
  - [📖 Uso](#-uso)
  - [⚙️ Configuración de Parámetros](#️-configuración-de-parámetros)
    - [Credenciales de Autenticación (Obligatorias) `POST o GET`](#credenciales-de-autenticación-obligatorias-post-o-get)
    - [Parámetros Comunes](#parámetros-comunes)
    - [Parámetros Específicos](#parámetros-específicos)
    - [Ejemplo de parámetros para `SMS/SendSMS.java`](#ejemplo-de-parámetros-para-smssendsmsjava)
  - [📚 Documentación Completa de la API](#-documentación-completa-de-la-api)
  - [📄 Licencia](#-licencia)
  - [📞 Soporte](#-soporte)

## ⚙️ Prerrequisitos

Antes de empezar, asegúrate de tener instalado lo siguiente:
- **Java Development Kit (JDK) 11 o superior**
- **Maven** o **Gradle** (para gestionar las dependencias y construir el proyecto)

## 📂 Estructura del Repositorio

Los ejemplos de código están organizados en carpetas que corresponden a las diferentes categorías de la API de Onurix. Las peticiones a la API se realizan comúnmente mediante `HTTP POST` o `GET`. Para los envíos de WhatsApp, es necesario enviar los datos en formato `JSON`.

A continuación, se detalla cada endpoint de ejemplo y el método HTTP que utiliza:

### Calls
| Archivo            | Método | Descripción                                                             |
| :----------------- | :----- | :---------------------------------------------------------------------- |
| `SendCall.java`    | `POST` | Genera una llamada con un mensaje de voz.                               |
| `SendCALL2FA.java` | `POST` | Genera y entrega un código de verificación 2FA a través de una llamada. |

### General
| Archivo                    | Método | Descripción                                                   |
| :------------------------- | :----- | :------------------------------------------------------------ |
| `Balance.java`             | `GET`  | Consulta el saldo de créditos de la cuenta.                   |
| `Security.java`            | `POST` | Bloquea un número de teléfono para no recibir comunicaciones. |
| `VerificationCode2FA.java` | `POST` | Realiza la verificación de un código 2FA.                     |
| `VerificationMessage.java` | `GET`  | Verifica el estado de un envío de SMS o llamada.              |

### Groups and Contacts
| Archivo                           | Método | Descripción                              |
| :-------------------------------- | :----- | :--------------------------------------- |
| `AssociateContactToGroup.java`    | `POST` | Asocia un contacto a un grupo.           |
| `ContactCreate.java`              | `POST` | Crea un nuevo contacto.                  |
| `ContactDelete.java`              | `POST` | Elimina un contacto.                     |
| `ContactGroupList.java`           | `GET`  | Lista los contactos de un grupo.         |
| `ContactUpdate.java`              | `POST` | Actualiza la información de un contacto. |
| `DissasociateContactToGroup.java` | `POST` | Desasocia un contacto de un grupo.       |
| `GroupCreate.java`                | `POST` | Crea un nuevo grupo de contactos.        |
| `GroupDelete.java`                | `POST` | Elimina un grupo de contactos.           |
| `GroupList.java`                  | `GET`  | Lista todos los grupos de la cuenta.     |
| `GroupUpdate.java`                | `POST` | Actualiza el nombre de un grupo.         |

### SMS
| Archivo           | Método | Descripción                                                        |
| :---------------- | :----- | :----------------------------------------------------------------- |
| `SendSMS.java`    | `POST` | Envía un mensaje de texto (SMS).                                   |
| `SendSMS2FA.java` | `POST` | Envía un mensaje de texto (SMS) con un código de verificación 2FA. |

### URL
| Archivo             | Método | Descripción                                |
| :------------------ | :----- | :----------------------------------------- |
| `Statistics.java`   | `GET`  | Obtiene las estadísticas de una URL corta. |
| `URLShortener.java` | `POST` | Crea una URL corta.                        |

### WhatsApp
| Archivo                    | Método        | Descripción                                                     |
| :------------------------- | :------------ | :-------------------------------------------------------------- |
| `SendWhatsApp2FA.java`     | `POST (JSON)` | Envía un mensaje de WhatsApp con un código de verificación 2FA. | :-------------------------------------------------------------- |
| `WhatsAppGeneralSend.java` | `POST (JSON)` | Envía un mensaje de WhatsApp usando una plantilla.                          |
| `SendWhatsAppWithoutTemplate.java` | `POST (JSON)` | Envía un mensaje de WhatsApp sin usar una plantilla.                        |

## 📖 Uso

1.  **Clona el repositorio y configura las dependencias (Maven/Gradle):**
    Este proyecto puede usar cualquier cliente HTTP en Java (ej. OkHttp, Apache HttpClient).
    ```bash
    git clone https://github.com/onurixlatam/onurix-java.git
    cd onurix-java
    # Si usas Maven:
    # mvn clean install
    # Si usas Gradle:
    # gradle build
    ```

2.  **Navega al archivo** del endpoint que deseas utilizar (ej. `SMS/SendSMS.java`).

3.  **Edita el archivo** y reemplaza los valores de los placeholders con tus datos reales.

4.  **Compila y ejecuta el script** desde tu IDE o terminal (ej. con Maven):
    ```bash
    # Para compilar
    mvn compile
    # Para ejecutar (ejemplo, ajusta según tu estructura de proyecto y clase principal)
    mvn exec:java -Dexec.mainClass="SMS.SendSMS"
    ```

5.  **Verifica la respuesta** que se imprimirá en la consola.

## ⚙️ Configuración de Parámetros

Para usar los ejemplos, necesitas reemplazar los valores de los placeholders (`AQUI_...`) con tus datos reales. A continuación, se detallan los parámetros que encontrarás en los scripts:

### Credenciales de Autenticación (Obligatorias) `POST o GET`

| Parámetro | Descripción                                                               |
| :-------- | :------------------------------------------------------------------------ |
| `client`  | Tu ID de Cliente. Lo encuentras en tu panel de Onurix en `Seguridad API`. |
| `key`     | Tu Llave de API. La encuentras en tu panel de Onurix en `Seguridad API`.  |

### Parámetros Comunes

| Parámetro  | Descripción                                                                 | Ejemplo                                      |
| :--------- | :-------------------------------------------------------------------------- | :------------------------------------------- |
| `phone`    | Número de teléfono de destino. Para múltiples números, sepáralos por comas. | `573001234567` o `573001234567,573001234568` |
| `name`     | Nombre para un contacto o grupo.                                            | `Mi Grupo`                                   |
| `lastname` | Apellido para un contacto.                                                  | `Pérez`                                      |
| `email`    | Correo electrónico de un contacto.                                          | `ejemplo@email.com`                          |
| `id`       | ID de un recurso (mensaje, contacto, grupo).                                | `12345`                                      |
| `group-id` | ID de un grupo.                                                             | `6789`                                       |
| `groups`   | IDs de grupos separados por comas.                                          | `1,2,3`                                      |
| `app-name` | Nombre de la aplicación 2FA creada en Onurix.                               | `MiApp`                                      |

### Parámetros Específicos

| Servicio     | Parámetro    | Descripción                                                                 |
| :----------- | :----------- | :-------------------------------------------------------------------------- |
| **SMS**      | `sms`        | Contenido del mensaje de texto a enviar.                                    |
| **SMS**      | `is-transactional` | (Opcional) `1` (por defecto): mensaje transaccional. `0`: mensaje comercial; los números inscritos en el Registro de Números Excluidos (RNE) que no aceptan SMS se rechazan con el error `1010`. |
| **Llamadas** | `message`    | Mensaje que se reproducirá en la llamada.                                   |
| **Llamadas** | `voice`      | Voz a usar en la llamada (ej. `Mariana`, `Penelope`).                       |
| **Llamadas** | `audio-code` | ID de un audio previamente cargado en la plataforma.                        |
| **URL**      | `url-long`   | La URL original que deseas acortar.                                         |
| **URL**      | `alias`      | (Opcional) Alias personalizado para la URL corta.                           |
| **WhatsApp** | `templateId` | ID de la plantilla de WhatsApp aprobada por Meta.                           |
| **WhatsApp** | `data`       | Un array de PHP que se convertirá a JSON con los valores para la plantilla. |
| **WhatsApp** | `from_phone_meta_id` | ID del número de teléfono de origen en la plataforma de Meta.       |
| **WhatsApp** | `message`            | Objeto JSON que contiene el tipo y el valor del mensaje a enviar.   |

### Ejemplo de parámetros para `SMS/SendSMS.java`

```java
// Define el cuerpo de la solicitud.
String client = "12345";
String key = "*********************";
String phone = "573001234567";
String sms = "Este es un mensaje de prueba enviado desde Onurix.com";
String groups = "1,2,3";
String isTransactional = "1"; // se envía como "is-transactional"; 0 si el mensaje es comercial
```

**Ejemplo de `data` para WhatsApp (JSON):**

```json
{
    "phones": "573001234567",
    "body": {
        "1": {"type": "text", "value": "John Doe"},
        "2": {"type": "text", "value": "ORD-12345"}
    }
}
```

## 📚 Documentación Completa de la API

Para obtener una descripción detallada de todos los endpoints, parámetros y respuestas de la API, por favor consulta nuestra documentación oficial en [https://docs.onurix.com/](https://docs.onurix.com/).

## 📄 Licencia

Este proyecto está bajo la Licencia MIT.

## 📞 Soporte

Para soporte y preguntas, no dudes en contactarnos:
- **Email**: soporte@onurix.com
- **Website**: [https://onurix.com](https://onurix.com)
