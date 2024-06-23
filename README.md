# Diplom_3

# Built With

| [Java 11](https://www.java.com/ru/)                      |
|----------------------------------------------------------|
| [JUnit 4](https://junit.org/junit4/)                     |
| [REST Assured](https://rest-assured.io/)                 |
| [Allure Framework](https://github.com/allure-framework/) |
| [Selenium](https://www.selenium.dev/)                                                      |


# Запуск с Chrome

```bash
mvn test
```

# Запуск с Firefox

```bash
mvn -Dbrowser=firefox test
```

если mvn test падает с ошибкой 500, и не находит бинарник, то запускаем с параметром
```bash
mvn -Dbrowser=firefox -Dwebdriver.firefox.bin=/usr/bin/firefox test
```


# Запуск с Yandex

```bash
mvn -Dbrowser=yandex -Ddriver.version=122.0.6261.94 -Dwebdriver.yandex.bin=/usr/bin/yandex-browser test
```


# Отчет Allure

```bash
mvn allure:serve
```