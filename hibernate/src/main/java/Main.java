
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
import entity.Student;

public class Main {
    public static void main(String[] args) {
        FactorySession factorySession = new FactorySession();
        factorySession.init();
        StudentDao studentDao = new StudentDao(factorySession.getFactory());
        System.out.println(studentDao.findById(1L).get());
        System.out.println(studentDao.findAll().toString());
        studentDao.deleteById(1L);
        System.out.println(studentDao.findAll().toString());
        studentDao.saveOrUpdate(new Student().setName("Solt").setMark(4));
        System.out.println(studentDao.findAll().toString());
        Student s1  = studentDao.findById(3L).get().setName("John1");
        studentDao.saveOrUpdate(s1);
        System.out.println(studentDao.findAll().toString());

        for (int i = 0; i <= 1000; i++) {
            studentDao.saveOrUpdate(new Student().setName("Example" + i).setMark(1 + (int) (Math.random() * 5)));
        }
        System.out.println(studentDao.findAll().toString());

        factorySession.shutDown();


    }
}
