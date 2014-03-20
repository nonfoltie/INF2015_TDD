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
import org.junit.Test;

public class GroupTest {

    protected SimpleDateFormat formater;
    protected Group testee;

    @Before
    public void setUp() {
        formater = new SimpleDateFormat("dd/MM/yyyy");
        testee = new Group();
    }

    @Test
    public void testAddStudent_3args() {
        System.out.println("addStudent");

        String lastname = "Doe";
        String firstname = "John";
        Date birthDate = new Date();

        testee.addStudent(lastname, firstname, birthDate);
        assertEquals(testee.getStudents().size(), 1);
    }

    @Test
    public void testAddStudent_Student() throws ParseException {
        System.out.println("addStudent");

        Student student = new Student("Doe", "John", new Date());

        testee.addStudent(student);
        assertEquals(testee.getStudents().size(), 1);
    }

    @Test
    public void testGetStudentByPermaCode() throws ParseException {
        System.out.println("getStudentByPermaCode");

        Student student = new Student("Doe", "John", formater.parse("12/10/1987"));
        String permaCode = student.getPermaCode();

        testee.addStudent(student);

        Student result = testee.getStudentByPermaCode(permaCode);
        assertEquals(student, result);

        result = testee.getStudentByPermaCode("FOOZ909090");
        assertNull(result);
    }

    @Test
    public void testGetGroupAverage() {
        System.out.println("getGroupAverage");

        Student student1 = new Student("Doe", "John", new Date());
        student1.setScore("INF2005", 100.0);
        student1.setScore("INF2015", 50.0);
        testee.addStudent(student1);

        Student student2 = new Student("Plof", "Bertrand", new Date());
        student2.setScore("INF2005", 50.0);
        student2.setScore("INF2015", 100.0);
        testee.addStudent(student2);

        Student student3 = new Student("Lavoie", "Sandrine", new Date());
        student3.setScore("INF2005", 80.0);
        student3.setScore("INF2015", 70.0);
        testee.addStudent(student3);

        Double sum = student1.getAverageScore() + student2.getAverageScore() + student3.getAverageScore();
        Double expResult = sum / 3;
        Double result = testee.getGroupAverage();
        assertEquals(expResult, result);
    }
}