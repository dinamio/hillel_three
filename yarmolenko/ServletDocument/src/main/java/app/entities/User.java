package app.entities;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor


public class User {

    private int id;
    private String login;
    private String password;


}
