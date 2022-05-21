package edu.school21.cinema.models;

import edu.school21.cinema.annotations.Column;
import edu.school21.cinema.annotations.Id;
import edu.school21.cinema.annotations.Table;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Table(name = "users")
public class User extends Entity{
    @Id
    @Column(name = "user_id")
    Long id;
    @Column(name = "image_id")
    Long imageId;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    String phone;
    String password;
}
