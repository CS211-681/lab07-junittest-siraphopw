package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวณเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }


    @Test
    @DisplayName("ทดสอบการได้คะแนนรวมเกรด C")
    void testGradeC() {
        Student s = new Student("6xxxxxxxx", "StudentTest", 60);
        assertEquals("C", s.grade());
    }


    @Test
    @DisplayName("ทดสอบการได้คะแนนรวมเกรด D")
    void testGradeD() {
        Student s = new Student("6xxxxxxxx", "StudentTest", 50);
        assertEquals("D", s.grade());
    }


    @Test
    @DisplayName("ทดสอบการได้คะแนนรวมเกรด F")
    void testGradeF() {
        Student s = new Student("6xxxxxxxx", "StudentTest", 40);
        assertEquals("F", s.grade());
    }


    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อให้เป็น 'New Name'")
    void testChangeName() {
        Student s = new Student("6xxxxxxxx", "Old Name");
        s.changeName("New Name");
        assertEquals("New Name", s.getName());
    }


    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนนเป็นค่าลบ (ไม่ควรเพิ่มคะแนน)")
    void testAddNegativeScore(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(-10);
        assertEquals(0, s.getScore());
    }

}
