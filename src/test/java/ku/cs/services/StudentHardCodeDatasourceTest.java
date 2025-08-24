package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    private StudentHardCodeDatasource datasource;

    @BeforeEach
    void setUp() {
        datasource = new StudentHardCodeDatasource();
    }

    @Test
    @DisplayName("ทดสอบการอ่านข้อมูลจาก datasource ที่มีข้อมูล hardcode 4 นักเรียน")
    void testReadData() {
        StudentList list = datasource.readData();
        assertEquals(4, list.getStudents().size(), "จำนวนของนักเรียนที่ดึงออกมาจาก datasource ควรจะเป็น 4 คน");
        // ตรวจสอบข้อมูลของนักเรียนตัวแรก
        Student firstStudent = list.getStudents().get(0);
        assertEquals("6710400001", firstStudent.getId(), "ID ของนักเรียนคนแรกต้องเป็น 6710400001");
        assertEquals("First", firstStudent.getName(), "ชื่อของนักเรียนคนแรกต้องเป็น First");

        // ตรวจสอบข้อมูลของนักเรียนตัวสุดท้าย
        Student lastStudent = list.getStudents().get(3);
        assertEquals("6710400004", lastStudent.getId(), "ID ของนักเรียนคนสุดท้ายต้องเป็น 6710400004");
        assertEquals("Fourth", lastStudent.getName(), "ชื่อของนักเรียนคนสุดท้ายต้องเป็น Fourth");
    }

}
