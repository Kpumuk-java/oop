import db.InitDB;
import service.CinemaService;

import java.sql.SQLException;

public class DBCinema {
    public static void main(String[] args) throws SQLException {
        InitDB initDB = new InitDB();
        CinemaService cinemaService = new CinemaService(initDB.getConnection());
        cinemaService.found();
    }
}
