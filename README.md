# Проект автотестов

## Описание проекта
Проект автотестов разработан для тестирования функционала веб-приложения на стенде http://172.24.120.5:8081/. В проекте реализованы автотесты для следующих функций:
- Регистрация
- Авторизация
- Работа с заметками
  ![Скриншот 1](screenshots/structure.png)
В проекте предусмотрены как UI-тесты, так и API-тесты для проверки функционала. Также реализована возможность работы с базой данных.
  ![Скриншот 2](screenshots/tests.png)
## Паттерн проектирования
В проекте используется паттерн Page Object для организации структуры тестовых классов и разделения логики тестов от логики взаимодействия с элементами интерфейса. Это позволяет упростить поддержку и расширение автотестов.

## Параллельный запуск
Проект поддерживает параллельный запуск тестов, что позволяет ускорить процесс выполнения тестов и сократить время прогона.

## Allure-отчет
Проект имеет интеграцию с Allure Framework для формирования наглядных и информативных отчетов о выполнении тестов. Allure-отчет позволяет легко просматривать результаты тестирования, а также анализировать их.
![Скриншот 3](screenshots/allure.png)
## Репозиторий GitHub
Проект был добавлен в репозиторий GitHub для удобного хранения и управления версиями кода. В репозитории можно найти все исходные файлы проекта, а также историю изменений.

## Инструкции по запуску
1. Склонируйте репозиторий проекта с помощью команды `git clone <URL репозитория>`.
2. Установите необходимые зависимости, указанные в файле `pom.xml`.
3. Запустите автотесты с помощью команды `mvn clean test`.
4. Для формирования Allure-отчета выполните команду `mvn allure:serve`.

## Заключение
Проект автотестов предоставляет набор тестов для проверки функционала веб-приложения на стенде http://172.24.120.5:8081/. Он реализован с использованием паттерна Page Object, поддерживает параллельный запуск и формирование Allure-отчета. Проект хранится в репозитории GitHub для удобного управления версиями и совместной работы.