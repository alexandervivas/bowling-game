package com.avivas.game;

import com.avivas.game.enums.GameEnum;
import com.avivas.game.factory.GameFactory;
import com.avivas.game.model.Game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // map to store player's name and the player's game
        Map<String, Game> players = new HashMap<String, Game>();

        try (Stream<String> stream = Files.lines(Paths.get(args[0]))) {

            stream.forEach(l -> {
                String[] line = l.split("\t");

                if(!players.containsKey(line[0])) {
                    players.put(line[0], GameFactory.getInstance().createGameForPlayer(GameEnum.BOWLING, line[0]));
                }

                int score = 0;

                // if it's a foul then it means 0 points
                if(!line[1].equals("F")) {
                    score = Integer.valueOf(line[1]);
                }

                players.get(line[0]).addScore(score);
            } );

            printResults(players);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints every player's score
     * @param players
     */
    private static void printResults(Map<String, Game> players) {

        System.out.print("Frame");
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.print("\t\t" + i));
        System.out.print("\n");
        players.entrySet().stream().forEach(entry -> System.out.println(entry.getValue().getPrintableScore()));

    }
}
