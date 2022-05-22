package edu.school21.cinema.models;

import edu.school21.cinema.annotations.Column;
import edu.school21.cinema.annotations.Id;
import edu.school21.cinema.annotations.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Table(name = "images")
public class Image extends Entity {
    @Id
    @Column(name = "image_id")
    Long id;
    @Column(name = "user_id")
    Long userId;
    Long size;
    @Column(name = "file_name")
    String filename;
    String mime;
    Date date;
}

