package com.ichuk.coffee.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2017/12/14.
 *
 */

public class ScoreBean {
    private int id;
    private String score;
    private List<ScoreData> scoreDataList = new ArrayList<>();

    public static class ScoreData {
        private int id;
        private String content;
        private String time;
        private String number;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public List<ScoreData> getScoreDataList() {
        return scoreDataList;
    }

    public void setScoreDataList(List<ScoreData> scoreDataList) {
        this.scoreDataList = scoreDataList;
    }
}
