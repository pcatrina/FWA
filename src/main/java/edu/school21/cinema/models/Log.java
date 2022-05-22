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

    private static String datePattern = "MM/dd/yyyy";
    private static String timePattern = "\"h:mm a\"";

    @Id
    @Column(name = "object_id")
    Long objectId;
    @Column(name = "user_id")
    Long userId;
    Date date;
    String ip;

    String getDataFormat(){
        DateFormat df = new SimpleDateFormat(datePattern);
        return df.format(date);
    }

    String getTimeFormat(){
        DateFormat df = new SimpleDateFormat(timePattern);
        return df.format(date);
    }
}
