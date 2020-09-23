# Warehouse
CRUD MVC JDBC Spring

Вэб-приложение "Warehouse".
Выполнено в качестве тестового задания при трудоустройстве.

Состоит из 2 JSP страниц, Tomcat 9, Java; 
В качестве базы данных используется MySQL. Реализовать приложение на HSQL не вышло - был занят процесс (видимо, так как данная БД использовалась мной ранее для работы над другими проетами).

На странице index.jsp пользователь имеет возможность ознакомиться со списком товаров, которые добавлены в базу - данные прерсистенты. 
Так же пользователь может удалить/отредактировать данные.

На странице article_form.jsp пользователь имеет возможность добавить новый товар, либо отредактировать уже имеющийся в БД.
На данной странице так же реализован datepicker для вбора даты в нужном формате.

Основные методы работы с БД были протестированы в соответствующем классе ArticleDaoTest.

Взаимодействие пользователя с БД осуществляется через класс прослойку ArticleServiceImpl.

Отображение кириллицы на jsp странице было реализовано за счет изменения настроек Tomcat 9, описанных здесь:
https://stackoverflow.com/questions/138948/how-to-get-utf-8-working-in-java-webapps/138950#138950%5C
а так же за счет добавления фильтра в Java классе "EncodingFilter" и добавления заголовков в JSP, которые описанны по ссылке выше.

Это первое мое web приложение.
Я очень рад, что у меня получилось его сделать.
