# ✅ Test Summary – Employee Management App (Backend)

Este documento describe las pruebas unitarias incluidas en el proyecto para validar la lógica de negocio implementada en los servicios y controladores del backend.

---

## 🧪 1. EmployeeServiceTest.java

**Archivo:** `src/test/java/com/hiberus/employees/service/EmployeeServiceTest.java`

| Método de prueba | Propósito |
|------------------|-----------|
| `testCreateEmployee()` | Verifica que un empleado se cree correctamente y se asocie con un departamento. |
| `testDeleteEmployee()` | Verifica que la eliminación lógica (activo=false) de un empleado funciona correctamente. |

---

## 🧪 2. DepartmentServiceTest.java

**Archivo:** `src/test/java/com/hiberus/employees/service/DepartmentServiceTest.java`

| Método de prueba | Propósito |
|------------------|-----------|
| `testCreateDepartment()` | Verifica la creación de un nuevo departamento. |
| `testDeleteDepartment()` | Verifica que un departamento puede ser desactivado lógicamente. |

---

## 🧪 3. EmployeeControllerTest.java

**Archivo:** `src/test/java/com/hiberus/employees/controller/EmployeeControllerTest.java`

| Método de prueba | Propósito |
|------------------|-----------|
| `testCreateEmployee()` | Simula una petición POST a `/employee/create/{id}` y valida que el backend responde correctamente con los datos del nuevo empleado. |

> ✅ Usa `MockMvc` para simular peticiones HTTP sin levantar el servidor completo.

---

## 🧪 4. DepartmentControllerTest.java

**Archivo:** `src/test/java/com/hiberus/employees/controller/DepartmentControllerTest.java`

| Método de prueba | Propósito |
|------------------|-----------|
| `testCreateDepartment()` | Simula una petición POST a `/department/create` y verifica que se retorna correctamente el objeto creado. |

---

## 🛠 Tecnologías usadas

- **JUnit 5** – Motor de pruebas unitarias
- **Mockito** – Mock de dependencias
- **Spring Boot Test** – Pruebas de integración de controladores con `@WebMvcTest`
- **MockMvc** – Simula solicitudes HTTP

---

## 📌 Notas adicionales

- Las pruebas están aisladas, rápidas y no dependen de la base de datos.
- El enfoque de pruebas unitarias facilita la refactorización sin comprometer la lógica del sistema.

---

## 🚀 Cómo ejecutar las pruebas

```bash
mvn test