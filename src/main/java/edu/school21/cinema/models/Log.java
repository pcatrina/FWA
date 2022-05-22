package edu.school21.cinema.models;

import edu.school21.cinema.annotations.Column;
import edu.school21.cinema.annotations.Id;
import edu.school21.cinema.annotations.Table;
import lombok.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Table(name = "connection_logs")
@Builder
@AllArgsConstructor
public class Log extends Entity{

    private static DateFormat datePattern = new  SimpleDateFormat("MMM, dd, yyyy");
    private static DateFormat timePattern = new  SimpleDateFormat("hh:mm") ;

    @Id
    @Column(name = "object_id")
    Long objectId;
    @Column(name = "user_id")
    Long userId;
    Date date;
    String ip;

    public String getDateFormat(){
        return datePattern.format(date);
    }

    public String getTimeFormat(){
        return timePattern.format(date);
    }
}
