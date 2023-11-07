# Sprint_4
UI автотесты для Сервиса [QA-scooter](https://qa-scooter.praktikum-services.ru/)
Использует в качестве основных зависимостей:
`JUnit 4`
`Selenium`
`Java 11`
`maven`

Опции при создании `WebDriver`:
```
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
```
требуются из-за проблем с подключением к Хрому в новых версиях selenium/chromedriver.
