package com.retro.game.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "games")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int releaseDate;

    private String genre;

    private String developer;

}
