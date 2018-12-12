package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by eugen on 11/14/18.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    Integer id;

    String name;

    Integer age;
}
