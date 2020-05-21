# factoriesProject
Для работы этого чуда в папке src/main/resources/  создать файл application.properties со следующим содержимым:

spring.main.banner-mode=off
logging.level.org.springframework=ERROR

spring.jpa.hibernate.ddl-auto=update

spring.datasource.initialization-mode=always
spring.datasource.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/ИМЯ_БД
spring.datasource.username=ИМЯ_ЮЗЕРА_БД
spring.datasource.password=ПАРОЛЬ
server.port=8081

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
