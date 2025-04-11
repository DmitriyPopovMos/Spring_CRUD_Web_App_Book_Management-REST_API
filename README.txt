

Тестовое задание
Разработать небольшой веб-сервис с авторизацией и возможностью управления списком книг.

1. Авторизация по логину и паролю (можно in-memory, без регистрации)
2. Добавлять, редактировать, удалять книги
3. Хранить поля: id, vendorCode, title, year, brand, stock, price. Все данные сохраняются в базу данных.
4. Выводить список книг в виде таблицы (Bootstrap+Thymeleaf)
5. Поддерживать пагинацию и фильтрацию по title, brand, year
6. REST API: GET /api/books, POST /api/books, PUT /api/books/{id}, DELETE /api/books/{id}


---------------------------------------------

♠ Результат: (Дополнительно) Смотри файл README2


Spring_CRUD_Web_App_Book_Management+REST_API
Приложение по управлению списком книг.


♣ Функционал


1. Авторизация по логину и паролю (можно in-memory, без регистрации)
    При запуске приложения spring security запросит Логин и Пароль на вход.
    По умолчанию используется in-memory-аутентификация,
    логин — user, пароль — случайный, выводится в консоли при запуске приложения.


---------------------------------------------

2. Добавлять, редактировать, удалять книги

• Получение общего количества книг в БД (CRUD)
GET /showBooks
Параметры: id, vendorCode, title, year, brand, stock, price.
Выводит список всех книг в БД.


• Добавление книг (CRUD):
GET /addBookPage
Параметры: id, vendorCode, title, year, brand, stock, price.
Увеличивает количество Книг в БД.


• Редактирование книг (CRUD):
GET /book-update/{id}
Параметры: id, vendorCode, title, year, brand, stock, price.
Вносит изменения в существующие данные в БД


• Удаление книг (CRUD):
GET /book-delete/{id}
Параметры: id, vendorCode, title, year, brand, stock, price.
Удаляет книги из БД


---------------------------------------------

3. Хранить поля: id, vendorCode, title, year, brand, stock, price. Все данные сохраняются в базу данных.
    В проекте используется БД PostgreSQL (установлена сортировка в порядке возрастания по полю "id").


---------------------------------------------

4. Выводить список книг в виде таблицы (Bootstrap+Thymeleaf)
    В проекте подключены Bootstrap+Thymeleaf+CSS

---------------------------------------------

5. Поддерживать пагинацию и фильтрацию по title, brand, year
    В проекте настроены фильтры для CRUD (WEB)
    (LIKE - Фильтры НЕ чувствительны к регистру)


    REST API (Postman):
    (moreThan, lessThan, equal, like, in, between)

    В проекте настроена пагинация для REST API (Postman) (Возврат постраничных данных, Сортировка, Обработка ошибок)

---------------------------------------------
        *POSTMAN*
6. REST API: GET /api/books, POST /api/books, PUT /api/books/{id}, DELETE /api/books/{id}

    (Для корректной работы можно отключить spring security)


• Получение общего количества книг в БД (REST API)
GET /api/books
Параметры: id, vendorCode, title, year, brand, stock, price.
Выводит список всех книг в БД.


• Добавление книг (REST API):
POST /api/books
Параметры: id, vendorCode, title, year, brand, stock, price.
Увеличивает количество Книг в БД.


• Редактирование книг (REST API):
PUT /api/books/{id}
Параметры: id, vendorCode, title, year, brand, stock, price.
Вносит изменения в существующие данные в БД


• Удаление книг (CRUD):
DELETE /api/books/{id}
Параметры: id, vendorCode, title, year, brand, stock, price.
Удаляет книги из БД


---------------------------------------------

Требования
Язык реализации: Java 22
Фреймворк: Spring Boot 3.4.4
База данных:  PostgreSQL
версия JDK : 22
Система сборки: Maven

---------------------------------------------
