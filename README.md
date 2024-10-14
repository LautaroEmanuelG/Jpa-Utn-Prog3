# 🎉 Proyecto de Gestión de Promociones y Artículos

## 📜 Descripción del Proyecto

Este proyecto es una aplicación de gestión de promociones y artículos, desarrollada en Java utilizando JPA (Java Persistence API) para la persistencia de datos. La aplicación permite gestionar unidades de medida, imágenes, artículos y promociones, y proporciona funcionalidades para mostrar información detallada sobre estos elementos.

## 📊 Base de Datos UML

![Diagrama de la Base de Datos](/data/JpaPromociones.png)

## ⚙️ Funcionalidades

- **Gestión de Unidades de Medida**: Crear y persistir diferentes unidades de medida.
- **Gestión de Imágenes**: Crear y persistir imágenes asociadas a artículos y promociones.
- **Gestión de Artículos**: Crear y persistir artículos con sus respectivas unidades de medida e imágenes.
- **Gestión de Promociones**: Crear y persistir promociones que incluyen artículos e imágenes promocionales.
- **Visualización de Datos**: Mostrar información detallada sobre promociones, artículos y sus relaciones.

## 🛠️ Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **JPA (Java Persistence API)**: Para la persistencia de datos.
- **Hibernate**: Implementación de JPA.
- **H2 Database**: Base de datos en memoria para desarrollo y pruebas.
- **Lombok**: Para reducir el código boilerplate.

## 📁 Estructura del Proyecto

- **Entidades**: Clases que representan las tablas de la base de datos (`Promocion`, `Articulo`, `Imagen`, `UnidadMedida`).
- **Relaciones**:
    - `Promocion` tiene una relación de muchos a muchos con `Articulo`.
    - `Promocion` tiene una relación de uno a muchos con `Imagen`.
    - `Articulo` tiene una relación de muchos a uno con `UnidadMedida`.
    - `Articulo` tiene una relación de uno a uno con `Imagen`.

## 🚀 Instalación

Sigue estos pasos para instalar y ejecutar el proyecto desde GitHub:

1. **Clonar el repositorio**:

    ```bash
    git clone https://github.com/LautaroEmanuelG/Jpa-Utn-Prog3.git
    cd Jpa-Utn-Prog
    ```

2. **Configurar la base de datos**:

    - El proyecto está configurado para usar una base de datos H2 en memoria.
    - Debes revisar el archivo `persistence.xml` y colocar donde deseas persistir la base de datos
    - `jdbc:h2:C:\Users\Lautaro\OneDrive\Documentos\WorkSpace\Estudio\JpaH2\JpaModelo2`

3. **Construir el proyecto**:
    - Utiliza Gradle para construir el proyecto:

    ```bash
    ./gradlew build
    ```

4. **Ejecutar la aplicación**:
    - Ejecuta la clase `Main` desde tu IDE o usando Gradle:

    ```bash
    ./gradlew run
    ```

    - O las automatizaciones proporcionadas por IDE

## 👁️ Uso

Una vez ejecutada la aplicación, se mostrarán en la consola los detalles de las promociones y artículos persistidos en la base de datos.

## 🔗 Relación Muchos a Muchos con JPA

En este proyecto, la relación muchos a muchos entre `Promocion` y `Articulo` se implementa utilizando la anotación `@ManyToMany` junto con `@JoinTable`. Este enfoque permite que JPA cree automáticamente una tabla intermedia para gestionar la relación, sin necesidad de definir una clase explícita para dicha tabla.

```java
@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
@JoinTable(
    name = "promocion_articulo",
    joinColumns = @JoinColumn(name = "promocion_id"),
    inverseJoinColumns = @JoinColumn(name = "articulo_id")
)
private Set<Articulo> articulos = new HashSet<>();
```

### ✅ Ventajas:

Simplicidad: Implementación rápida y directa.
Menor cantidad de código: No se necesita una entidad para la tabla intermedia.
Eficiencia en casos simples: Ideal si la tabla intermedia solo contiene claves foráneas.

### ❌ Desventajas:

Limitada personalización: No se pueden agregar atributos adicionales a la tabla intermedia.
Escalabilidad limitada: Difícil de extender con información adicional.
Dificultad para acceder a la tabla intermedia: No existe una clase explícita para la tabla intermedia.