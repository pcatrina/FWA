package edu.school21.cinema.models;

import edu.school21.cinema.annotations.Column;
import edu.school21.cinema.annotations.Id;
import edu.school21.cinema.annotations.Table;
import lombok.*;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Table(name = "connection_logs")
@Builder
@AllArgsConstructor
public class Log extends Entity{
    @Id
    @Column(name = "object_id")
    Long objectId;
    @Column(name = "user_id")
    Long userId;
    Date date;
    String ip;
}
