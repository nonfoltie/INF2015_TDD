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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class StudentTest {

    protected SimpleDateFormat formater;

    @Before
    public void setUp() throws ParseException {
        formater = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Test
    public void testGetPermaCode() throws ParseException {
        System.out.println("getPermaCode");

        Student instance = new Student("Beaudry", "Mathieu", formater.parse("23/11/1983"));
        String expResult = "BEAM831123";
        String result = instance.getPermaCode();
        assertEquals(expResult, result);

        instance = new Student("Doe", "John", formater.parse("02/03/1986"));
        expResult = "DOEJ860302";
        result = instance.getPermaCode();
        assertEquals(expResult, result);

        instance = new Student("Seguin", "Julie", formater.parse("11/08/1989"));
        expResult = "SEGJ890811";
        result = instance.getPermaCode();
        assertEquals(expResult, result);
    }

    @Ignore
    public void testGetAge() throws ParseException {
        System.out.println("getAge");

        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        Integer thisYear = Integer.parseInt(yearFormat.format(new Date()));

        Integer age = 21;

        Date birthDate = formater.parse("02/03/" + (thisYear - age));
        Student instance = new Student("Doe", "John", birthDate);

        Integer expResult = age;
        Integer result = instance.getAge();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetScore() throws ParseException {
        System.out.println("getScore");

        Student testee = new Student("Doe", "John", formater.parse("23/11/1983"));

        testee.setScore("INF2015", 85.0);
        testee.setScore("INF2005", 80.0);

        Double result = testee.getScore("INF2015");
        assertEquals(result, (Double) 85.0);

        result = testee.getScore("INF2005");
        assertEquals(result, (Double) 80.0);

        result = testee.getScore("INF5000");
        assertNull(result);
    }

    @Test
    public void testSetScore() throws ParseException {
        System.out.println("setScore");

        Student testee = new Student("Doe", "John", formater.parse("23/11/1983"));

        testee.setScore("INF2015", 85.0);
        assertFalse(testee.scores.isEmpty());
    }

    @Test
    public void testGetAverageScore() throws ParseException {
        System.out.println("getAverageScore");

        Student testee = new Student("Doe", "John", formater.parse("23/11/1983"));

        testee.setScore("INF2015", 85.0);
        testee.setScore("INF2005", 80.0);

        Double expResult = (Double) 82.5;
        Double result = testee.getAverageScore();
        assertEquals(expResult, result);
    }
}