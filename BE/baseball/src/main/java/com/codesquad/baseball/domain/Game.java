package com.codesquad.baseball.domain;

import org.springframework.data.annotation.Id;

public class Game {

    @Id
    private Long id;

    private Long homeTeamId;

    private Long awayTeamId;

    public Game(Long homeTeamId, Long awayTeamId) {
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
    }

    public Long getId() {
        return id;
    }

    public Long getHomeTeamId() {
        return homeTeamId;
    }

    public Long getAwayTeamId() {
        return awayTeamId;
    }

    public void setHomeTeamId(Long homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public void setAwayTeamId(Long awayTeamId) {
        this.awayTeamId = awayTeamId;
    }
}