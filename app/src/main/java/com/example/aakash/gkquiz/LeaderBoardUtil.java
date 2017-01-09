package com.example.aakash.gkquiz;

import android.content.SharedPreferences;
import android.support.v4.util.ArraySet;

import java.util.Collections;
import java.util.Set;

/**
 * Created by Aakash on 08/01/2017.
 */

public class LeaderBoardUtil {
    public static void saveNewHighScores(HighScore[] highScores, SharedPreferences sp) {
        Set<String> results = new ArraySet<>();
        for (int i=0; i<highScores.length; i++){
            HighScore score = highScores[i];
            if (score != null) {
                //e.g. store result as "1 Aakash 9" or "2 Tom 8"
                results.add(i + Constants.DELIMETER + score.getName() + Constants.DELIMETER + score.getScore());
            }
        }
        SharedPreferences.Editor edit = sp.edit();
        edit.putStringSet(Constants.HIGH_SCORE, results);
        edit.commit();
    }

    public static HighScore[] getHighScores(SharedPreferences sp) {
        Set<String> results = sp.getStringSet(Constants.HIGH_SCORE, Collections.EMPTY_SET);
        HighScore[] highScores = new HighScore[5];
        for (String result : results){
            if (!result.isEmpty()){
                String[] tokens = result.split(Constants.DELIMETER);
                int index = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                int scoreNumber = Integer.parseInt(tokens[2]);
                HighScore score = new HighScore(name, scoreNumber);
                highScores[index] = score;
            }
        }
        return highScores;
    }

    public static void clearHighScores(SharedPreferences sp){
        Set<String> results = new ArraySet<>();
        SharedPreferences.Editor edit = sp.edit();
        edit.putStringSet(Constants.HIGH_SCORE, results);
        edit.commit();
    }


}
