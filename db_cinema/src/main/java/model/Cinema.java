package model;

import java.time.LocalDateTime;
import java.util.*;

public class Cinema {
    private int id;
    private Film film;
    private LocalDateTime started;
    private List<Tickets> tickets;
}
