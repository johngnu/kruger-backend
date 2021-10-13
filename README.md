# kruger-backend
[ ![Author](https://img.shields.io/badge/Author-Johngnu-red.svg?style=flat-square) ](https://www.jianshu.com/u/1d0c0bc634db)

Inventario de vacunación de empleados (SpringBoot Demo)
## Rol administrador
### Listar empleados
``` html
GET: http://localhost:8090/api/v1/administrator/employees
```
#### Listar empleados FILTERS
``` html
Listar por ID vacuna
GET: http://localhost:8090/api/v1/administrator/employees?vaccine=[1....n]

Listar [vacunados = true, no vacunados = false]
GET: http://localhost:8090/api/v1/administrator/employees?vaccinated=[true/false]

Listar por fecha de vacunación [dateFrom and dateTo]
http://localhost:8090/api/v1/administrator/employees?dateFrom=01/09/2021&dateTo=12/10/2021
```
### Registrar empleado
``` html
POST: http://localhost:8090/api/v1/administrator/employees
```
Body
``` json
{
  "nombres": "John",
  "apellidos": "Castillo",
  "cedula": "77723873",
  "email": "john.gnu@gmail.com"  
}
```
### Eliminar empleado
``` html
DELETE: http://localhost:8090/api/v1/administrator/employees/{id}
```
## Rol empleado
### Actualizar sus datos
``` html
GET: http://localhost:8090/api/v1/employees/{id}
```
Body
``` json
{
  "address": "La Paz Bolivia",
  "birthday": "18/11/1980",
  "movil": 70685903,  
  "vaccineId": 1,
  "nroDosis": 1,
  "vaccineDate": "10/09/2021",
  "vacunado": true
}
```
