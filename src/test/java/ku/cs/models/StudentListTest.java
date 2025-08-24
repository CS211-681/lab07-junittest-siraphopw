package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    private StudentList studentList;

    @BeforeEach
    void setUp() {
        studentList = new StudentList();
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนใหม่โดยไม่มีคะแนน")
    void testAddNewStudentWithoutScore() {
        studentList.addNewStudent("123", "Alice");
        ArrayList<Student> students = studentList.getStudents();
        assertEquals(1, students.size());
        assertEquals("Alice", students.get(0).getName());
        assertEquals(0.0, students.get(0).getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนใหม่พร้อมคะแนน")
    void testAddNewStudentWithScore() {
        studentList.addNewStudent("123", "Bob", 85.5);
        ArrayList<Student> students = studentList.getStudents();
        assertEquals(1, students.size());
        assertEquals("Bob", students.get(0).getName());
        assertEquals(85.5, students.get(0).getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนซ้ำ (ID เดียวกัน) ไม่ควรถูกเพิ่ม")
    void testAddDuplicateStudent() {
        studentList.addNewStudent("123", "Charlie", 70);
        studentList.addNewStudent("123", "Charlie Again", 80);
        assertEquals(1, studentList.getStudents().size());
        assertEquals("Charlie", studentList.getStudents().get(0).getName()); // ชื่อต้น
    }

    @Test
    @DisplayName("ทดสอบการค้นหานักเรียนด้วย ID ที่มีอยู่")
    void testFindStudentByIdExists() {
        studentList.addNewStudent("001", "David");
        Student found = studentList.findStudentById("001");
        assertNotNull(found);
        assertEquals("David", found.getName());
    }

    @Test
    @DisplayName("ทดสอบการค้นหานักเรียนด้วย ID ที่ไม่มีอยู่")
    void testFindStudentByIdNotExists() {
        Student found = studentList.findStudentById("999");
        assertNull(found);
    }


    @Test
    @DisplayName("ทดสอบการให้คะแนนแก่นักเรียนที่มีอยู่")
    void testGiveScoreToExistingStudent() {
        studentList.addNewStudent("001", "Ella");
        studentList.giveScoreToId("001", 40);
        Student student = studentList.findStudentById("001");
        assertEquals(40, student.getScore());
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนแก่นักเรียนที่ไม่มีอยู่ (ควรไม่เกิด Exception)")
    void testGiveScoreToNonExistingStudent() {
        assertDoesNotThrow(() -> studentList.giveScoreToId("999", 50));
        assertEquals(0, studentList.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดของนักเรียนที่มีอยู่")
    void testViewGradeOfExistingStudent() {
        studentList.addNewStudent("001", "Grace", 77);
        String grade = studentList.viewGradeOfId("001");
        assertEquals("B", grade);
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดของนักเรียนที่ไม่มีอยู่ (ควรคืนค่า null)")
    void testViewGradeOfNonExistingStudent() {
        assertNull(studentList.viewGradeOfId("123"));
    }

    @Test
    @DisplayName("ทดสอบการไม่เพิ่มนักเรียนเมื่อชื่อหรือ ID เป็นค่าว่าง")
    void testAddStudentWithEmptyValues() {
        studentList.addNewStudent("", "Name");
        studentList.addNewStudent("ID", "");
        studentList.addNewStudent("   ", "   ");
        assertEquals(0, studentList.getStudents().size());
    }
}
