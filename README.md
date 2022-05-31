## Introducción

La idea es implementar un servicio REST para obtener el precio actual de BTC

## Problema principal

Implementar una API con las siguientes características

GET:
- `/` - recuperar todos los pares btc fiat registrados ordenados por fecha en la base de datos
- `/pair/:fiatType` - recuperar el valor actual del par BTC-fiatType

POST:
- `/` - ejecutar una tarea para obtener el precio btc(https://api.coindesk.com/v1/bpi/currentprice.json) y persistir en la base de datos

## Requisitos

El código debe ser escrito en inglés, con buena lógica y buena claridad y debe solucionar el problema.

## Evaluación

Serás evaluado en base los siguientes puntos:

- La calidad del código
- La estructura de tu aplicación
- Las pruebas unitarias (como adicional)
- La robustez de tu aplicación
- Buenas prácticas de proyecto
- La documentación del código
