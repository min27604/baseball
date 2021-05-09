package com.codesquad.baseball.controller;

import com.codesquad.baseball.DTO.GameListDTO;
import com.codesquad.baseball.DTO.TeamRecordDTO;
import com.codesquad.baseball.domain.Game;
import com.codesquad.baseball.domain.Team;
import com.codesquad.baseball.service.GameService;
import com.codesquad.baseball.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baseball")
public class GameController {

    private final GameService gameService;
    private final TeamService teamService;

    public GameController(GameService gameService, TeamService teamService) {
        this.gameService = gameService;
        this.teamService = teamService;
    }

    @GetMapping("/games")
    public List<GameListDTO> browseGames() {
        return gameService.browseAllGames();
    }

    @GetMapping("/play/{gameId}/players")
    public TeamRecordDTO browseTeamPlayers(@PathVariable Long gameId) {
        Game game = gameService.findGameById(gameId);
        Team homeTeam = teamService.browseTeamById(game.getHomeTeamId());
        Team awayTeam = teamService.browseTeamById(game.getAwayTeamId());
        return new TeamRecordDTO(homeTeam, awayTeam);
    }
}
