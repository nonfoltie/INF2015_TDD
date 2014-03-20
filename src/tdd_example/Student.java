/*
 * Copyright 2013 Alexandre Terrasa <alexandre@moz-code.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tdd_example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Student {

    protected Map<String, Double> scores;
    protected String permaCode;
    protected Integer age;

    public Student(String lastname, String firstname, Date birthDate) {
        this.scores = new HashMap<>();
        this.permaCode = computePermaCode(lastname, firstname, birthDate);
        this.age = computeAge(birthDate);
    }

    private String computePermaCode(String lastname, String firstname, Date birthDate) {
        SimpleDateFormat formater = new SimpleDateFormat("yyMMdd");
        return lastname.substring(0, 3).toUpperCase() + firstname.substring(0, 1).toUpperCase() + formater.format(birthDate);
    }

    //FIXME : très mauvaise implémentation qui ne prend pas en compte le jour dans l'année
    public Integer computeAge(Date birthDate) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy");
        int todayYear = Integer.parseInt(formater.format(new Date()));
        int birthYear = Integer.parseInt(formater.format(birthDate));
        return todayYear - birthYear;
    }

    public String getPermaCode() {
        return permaCode;
    }

    public Integer getAge() {
        return age;
    }

    public void setScore(String course, Double score) {
        this.scores.put(course, score);
    }

    public Double getScore(String course) {
        return this.scores.get(course);
    }

    public Double getAverageScore() {
        Double sum = 0.0;
        for (Double score : scores.values()) {
            sum += score;
        }
        return sum / scores.size();
    }
}
