# Hackathon todos
Aplicación para el Hackathon "Todos incluidos", organizado por Telefónica los días 2-4 de octubre
de 2015.

Utilizando la tecnología "Thinking Things" de Telefónica, tratamos de monitorizar la temperatura, humedad y luminosidad de una habitación

![](img_readme.jpg)

Para hacer consultas a la API que se nos ha facilitado, es necesario ejecutar el siguiente comando (no funcionará por que este servidor habrá sido desactivado cuando trates de hacerlo funcionar)

``` bash
curl http://hackathon.ttcloud.net:10026/v1/contextEntities/[ID de tu dispositivo] -s -S --header 'Accept: application/json' --header 'fiware-service: todosincluidos' --header 'x-auth-token: ' --header "fiware-servicepath: /iot"
```

Y obtendrás una respuesta en JSON tal que
```JSON
{
  "contextElement" : {
    "type" : "thinkingthing",
    "isPattern" : "false",
    "id" : "[ID]",
    "attributes" : [
      {
        "name" : "cellid",
        "type" : "string",
        "value" : "1f3c"
      },
      {
        "name" : "charger",
        "type" : "integer",
        "value" : "0"
      },
      {
        "name" : "charging",
        "type" : "integer",
        "value" : "1"
      },
      {
        "name" : "color",
        "type" : "string",
        "value" : " "
      },
      {
        "name" : "dbm",
        "type" : "integer",
        "value" : "-69"
      },
      {
        "name" : "desconnection",
        "type" : "integer",
        "value" : "0"
      },
      {
        "name" : "humidity",
        "type" : "float",
        "value" : "1043108.50"
      },
      {
        "name" : "lac",
        "type" : "integer",
        "value" : "70c"
      },
      {
        "name" : "luminance",
        "type" : "float",
        "value" : "38.90"
      },
      {
        "name" : "mcc",
        "type" : "integer",
        "value" : "214"
      },
      {
        "name" : "melody",
        "type" : "string",
        "value" : " "
      },
      {
        "name" : "mnc",
        "type" : "integer",
        "value" : "07"
      },
      {
        "name" : "mode",
        "type" : "integer",
        "value" : "1"
      },
      {
        "name" : "sleepcondition",
        "type" : "string",
        "value" : "Wake"
      },
      {
        "name" : "sleeptime",
        "type" : "string",
        "value" : "3"
      },
      {
        "name" : "state",
        "type" : "integer",
        "value" : "1"
      },
      {
        "name" : "temperature",
        "type" : "float",
        "value" : "28.73"
      },
      {
        "name" : "voltage",
        "type" : "float",
        "value" : "6.52"
      }
    ]
  },
  "statusCode" : {
    "code" : "200",
    "reasonPhrase" : "OK"
  }
}
```

Donde puedes obtener algunos datos del dispositivo (carga, temperatura, estado...)

[Puedes obtener más información sobre la API aquí](https://github.com/telefonicaid/fiware-orion)
