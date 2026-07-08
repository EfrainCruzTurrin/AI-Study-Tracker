# AI Study Tracker - Contexto del proyecto

> Este archivo se actualiza al cerrar cada fase. Subir al Project para que Claude tenga contexto en cualquier chat nuevo.

## Stack
- Backend: Java 21 + Spring Boot 3 + Spring Security (JWT) + JPA/Hibernate + PostgreSQL
- Frontend: React 18 + Vite + Tailwind
- IA: Groq (LLaMA) vía WebClient
- Opcional: Wikipedia API
- DB local: Postgres en Docker

## Diferencial del proyecto
Algoritmo SM-2 (repetición espaciada tipo Anki) implementado a mano en un service Java propio, testeable y aislado de la IA. La IA solo genera contenido (resúmenes/preguntas), nunca decide lógica de repaso.

## Metodología (seguir en orden, no saltar fases)
1. ✅ Modelo de datos y diagrama de entidades — **CERRADA**
2. 🔵 Setup repo + Gitflow (main/develop/feature) — **EN CURSO**
3. Entidad → Repository → Service → Controller
4. Servicio SM-2 con tests, sin IA
5. Auth JWT
6. Integración Groq aislada en IAService
7. Frontend: CRUD + dashboard de repasos
8. Deploy en Railway + README con capturas

## Mi contexto personal
- Egresado de Tecnicatura en Programación (UTN FRVM), tesis pendiente
- Prefiero explicaciones paso a paso, código completo y no verboso
- Busco desarrollar independencia en debugging, no solo copiar código
- Proyectos previos con este stack: ecommerce, Prode Mundial, PuntoOficio

## Instrucciones para Claude
- Responder siempre en español rioplatense, directo y breve
- Antes de avanzar de fase, confirmar que la fase anterior está cerrada
- No adelantar código de fases futuras sin que se pida explícitamente
- Avisar si se detecta que me estoy salteando el orden metodológico

---

## Fase 1 — Modelo de datos (CERRADA)

**Entidades y relaciones:**
```
USUARIO (1) → (N) MATERIA → (N) TEMA → (N) SESION_ESTUDIO
                              TEMA → (N) CONTENIDO_GENERADO
```

**Decisiones clave:**
- Los campos de SM-2 (`easeFactor`, `intervalo`, `proximoRepaso`, `repeticiones`) viven en `TEMA`, no en una entidad aparte — son el estado actual de repaso de ese tema.
- `dificultad` en `TEMA`: la elige el usuario manualmente (enum: `FACIL`, `MEDIA`, `DIFICIL`), no se calcula.
- `CONTENIDO_GENERADO` es **historial con caché** (relación 1:N, no 1:1): cada generación de IA guarda un registro nuevo, con campo `tipo` (resumen/pregunta). Permite servir contenido cacheado sin repegarle a Groq, y da pie a versionado futuro si se quiere regenerar contenido.
- `SESION_ESTUDIO.calificacion`: nota 0-5 estilo Anki, es el input que alimenta el algoritmo SM-2 en Fase 4.

**Base de datos:** PostgreSQL (no MySQL). Motivos: mejor manejo de fechas para queries de `proximoRepaso`, soporte nativo `jsonb` por si se cachea respuesta cruda de Groq, integración directa con Railway, consistencia con stack previo.

**Entorno local:** Postgres corriendo en Docker.
```
docker run --name study-tracker-db -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=studytracker -p 5432:5432 -d postgres:16
```
Credenciales para usar después en `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/studytracker
spring.datasource.username=postgres
spring.datasource.password=postgres
```

**Diagrama ER:** exportado en PDF (`ai-study-tracker-erd.pdf`).

---

## Fase 2 — Setup repo + Gitflow (EN CURSO)

_(completar al cerrar la fase)_
