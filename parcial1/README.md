# Primer Parcial - ICC-443 - Aseguramiento Calidad Software

## _Pruebas Unitarias con JUnit_

### Descripción

Este proyecto tiene como objetivo evaluar los conocimientos sobre pruebas unitarias utilizando JUnit. Se te proporcionan
las clases `EmployeeManager`, `Employee`, y `Position`, así como una clase de pruebas `EmployeeManagerTest` con métodos
vacíos y comentarios que indican qué se debe probar en cada caso.

### Clases Proporcionadas

#### `Position`

Representa una posición dentro de la empresa.

```java
public class Position implements Serializable {
    private String id;
    private String name;
    private double minSalary;
    private double maxSalary;
}
```

#### `Employee`

Representa un empleado de la empresa.

```java
public class Employee implements Serializable {
    private String id;
    private String name;
    private Position position;
    private double salary;
}
```

#### `EmployeeManager`

Gestiona las operaciones relacionadas con los empleados.

```java
public class EmployeeManager {
    public void addEmployee(Employee employee) { /* Implementación */ }

    public void removeEmployee(Employee employee) { /* Implementación */ }

    public double calculateTotalSalary() { /* Implementación */ }

    public void updateEmployeeSalary(Employee employee, double newSalary) { /* Implementación */ }

    public void updateEmployeePosition(Employee employee, Position newPosition) { /* Implementación */ }

    public boolean isSalaryValidForPosition(Position position, double salary) { /* Implementación */ }

    public List<Employee> getEmployees() { /* Implementación */ }
}
```

### Excepciones Personalizadas

Se han proporcionado las siguientes excepciones personalizadas:

* `DuplicateEmployeeException`
* `EmployeeNotFoundException`
* `InvalidSalaryException`

### Tarea

Debes completar los métodos de prueba en `EmployeeManagerTest` de acuerdo con los comentarios proporcionados.

Cada método de prueba incluye comentarios que describen lo que se debe probar. Los métodos estan disponible en la
clase `EmployeeManagerTest`

### Requisitos de Cobertura de Pruebas

Para obtener el 100% de la evaluación, la cobertura de pruebas debe estar al 100% en la clase `EmployeeManager` en las
siguientes áreas:

Clase (Class)
Método (Method)
Línea (Line)
Rama (Branch)

Tal como se muestra en la imagen a continuación

<img width="968" alt="image" src="https://github.com/fredpena/employee-management/assets/5680906/5449dc06-0ef7-4a1f-836a-9b0b0fb3f4ed">


Asegúrate de que todas las rutas del código sean cubiertas por tus pruebas unitarias.

### Instrucciones

1. Clona este repositorio en tu máquina local.
2. Importa el proyecto en tu IDE favorito.
3. Navega a la clase `EmployeeManagerTest`.
4. Completa los métodos de prueba según los comentarios proporcionados.
5. Ejecuta las pruebas para asegurarte de que todo funciona correctamente.
6. Utiliza una herramienta de cobertura de código para verificar que has alcanzado el 100% de cobertura en
   `EmployeeManager`.

### ¡Buena suerte y feliz codificación!

Este archivo README proporciona toda la información necesaria para que los estudiantes comprendan el objetivo del
parcial, las clases involucradas, las tareas a realizar, y los requisitos de cobertura de pruebas para alcanzar el 100%
de la evaluación.
