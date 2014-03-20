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

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Group {

    protected Map<String, Student> students;

    public Group() {
        this.students = new HashMap<>();
    }

    public Collection<Student> getStudents() {
        return students.values();
    }

    public void addStudent(String lastname, String firstname, Date birthDate) {
        addStudent(new Student(lastname, firstname, birthDate));
    }

    public void addStudent(Student student) {
        students.put(student.permaCode, student);
    }

    public Student getStudentByPermaCode(String permaCode) {
        return students.get(permaCode);
    }

    public Double getGroupAverage() {
        Double sum = 0.0;
        for (Student student : students.values()) {
            sum += student.getAverageScore();
        }
        return sum / students.size();
    }
}
