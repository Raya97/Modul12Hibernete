# Hibernate CRUD Project

## Опис проекту
Цей проект є прикладом базового Java додатку, який демонструє використання Hibernate для роботи з базою даних. Проект реалізує CRUD операції для сутностей `Client`, `Planet`, та `Ticket`, що дозволяє створювати, читати, оновлювати та видаляти дані в H2 базі даних.

### Сутності проекту

1. **Client (Клієнт)**:
   - `id` - Ідентифікатор клієнта, первинний сурогатний ключ.
   - `name` - Ім'я клієнта, рядок від 3 до 200 символів.

2. **Planet (Планета)**:
   - `id` - Ідентифікатор планети, рядок з латинських букв у верхньому регістрі та цифр.
   - `name` - Назва планети, рядок від 1 до 500 символів.

3. **Ticket (Квиток)**:
   - `id` - Ідентифікатор квитка, первинний сурогатний ключ.
   - `created_at` - Дата та час створення квитка.
   - `client_id` - Ідентифікатор клієнта, зв'язаний з квитком.
   - `from_planet_id` - Ідентифікатор планети відправлення.
   - `to_planet_id` - Ідентифікатор планети призначення.

### Використані технології

- **Java** - основна мова програмування.
- **Hibernate ORM** - для роботи з базою даних через об'єктно-реляційне відображення.
- **H2 Database** - вбудована реляційна база даних для тестування та розробки.
- **Flyway** - для управління версіями схеми бази даних.
