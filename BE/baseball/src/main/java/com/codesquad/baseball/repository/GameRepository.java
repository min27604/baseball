package com.codesquad.baseball.repository;

import com.codesquad.baseball.DTO.GameListDTO;
import com.codesquad.baseball.domain.Game;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {

    @Query("select game.id as gameId,\n" +
            "(Select team.name from game left join team on game.home_team_id = team.id where game.id = gameId) as homeTeamName,\n" +
            "(Select team.id from game left join team on game.home_team_id = team.id where game.id = gameId) as homeTeamId,\n" +
            "(Select team.name from game left join team on game.away_team_id = team.id where game.id = gameId) as awayTeamName,\n" +
            "(Select team.id from game left join team on game.away_team_id = team.id where game.id = gameId) as awayTeamId\n" +
            "From game;")
    List<GameListDTO> browseAllGames();

}