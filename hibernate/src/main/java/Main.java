
/*
* 1. Создать базу данных Student с полями id, name, mark.
2. Создать сущность Student и добавить в нее аннотации. Поле id должно заполняться автоматически.
3. Создать конфигурационный файл hibernate.cfg.xml, в котором указать свойства для подключения к БД
* и список классов с аннотациями Entity.
4. Создать класс со статическим методом, который возвращает объект SessionFactory.
5. Создать DAO-слой с операциями добавления, удаления, изменения сущности, выборки записи по ID и всех записей.
6. Добавить 1000 записей в таблицу Student.
7. Проверить работоспособность приложения, выполнить методы по удалению, изменению, добавлению записей,
* а также выборки одной и всех записей.

* */

import dao.StudentDao;
import db.InitDB;

public class Main {
    public static void main(String[] args) {
        //InitDB initDB = new InitDB();
        FactorySession factorySession = new FactorySession();
        factorySession.init();
        StudentDao studentDao = new StudentDao(factorySession.getFactory());
        System.out.println(studentDao.findById((long) 1).get());


    }
}
