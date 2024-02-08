package fr.epita.assistants.practicelombok;

import lombok.*;

@ToString (exclude = {"nickname"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"name", "nickname"})
public class Horse {
    private String name;
    private String nickname;
    @Setter(AccessLevel.NONE)
    private int speed;
}
