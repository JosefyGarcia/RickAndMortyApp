**Rick and Morty App**

Aplicación desarrollada en Android utilizando GraphQL, Jetpack Compose y MVVM para mostrar personajes de la serie Rick and Morty.

Tecnologías Utilizadas
- **Kotlin** - Lenguaje principal.
- **Jetpack Compose** - UI declarativa moderna.
- **GraphQL (Apollo Client)** - Para obtener datos de la API.
- **Hilt (Dagger Hilt)** - Inyección de dependencias.
- **GitFlow** - Para la gestión de ramas y versionado.
- **Lottie** - Animaciones en la pantalla de carga.

Estructura del Proyecto
El proyecto sigue el patrón **MVVM + Repository Pattern**, con una arquitectura escalable:

 `data/` → Maneja la obtención de datos (GraphQL).  
 `ui/` → Contiene las pantallas y componentes de la UI.  
 `viewmodel/` → Gestiona la lógica de negocio y el estado de la UI.  
 `di/` → Configuración de Hilt para inyección de dependencias.  
 `navigation/` → Manejo de navegación con Jetpack Compose.  
 `graphql/` → Contiene las consultas GraphQL.  

Instalación y Configuración
1. Clona el repositorio:
  git clone https://github.com/JosefyGarcia/RickAndMortyApp.git
2. Abre el proyecto en Android Studio.
Asegúrate de tener un emulador o dispositivo real para probar.
3. Ejecuta la aplicación con Run > Run 'app'.

Capturas de Pantalla

<img src="https://github.com/user-attachments/assets/5381b560-fe6f-4708-b9a9-cca09d0f5c10" width="200"/>
<img src="https://github.com/user-attachments/assets/1fc6c37f-c81d-4f94-8455-ce4c2b231864" width="200"/>
<img src="https://github.com/user-attachments/assets/2f2c3f9e-f71c-45d2-a947-7bbd441ff3ec" width="200"/>

API Utilizada
Se utilizó la API pública de Rick and Morty:
[Rick and Morty API GraphQL](https://rickandmortyapi.com/graphql)
