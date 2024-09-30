package net.javaguides.assertions;

import net.javaguides.Student;
import net.javaguides.StudentNotFoundException;
import net.javaguides.StudentService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    public void getStudentsTest() {
        StudentService studentService = new StudentService();

        Student student = new Student(1, "Erick");

        List<Student> listOfStudents = studentService.getStudents();
//        listOfStudents.add(student);

        boolean actualResult = listOfStudents.isEmpty();

//        assertTrue(actualResult);
//        assertTrue(()->actualResult);
//        assertTrue(actualResult, "List of Student is Empty!");
//        assertTrue(()->actualResult, "List of Student is Empty!");
//        assertTrue(actualResult, () -> "List of Student is Empty!");
        assertTrue(() -> actualResult, () -> "List of Student is Empty!");
    }

    @Test
    public void getStudentsTestUsingAssertFalse(){
        StudentService studentService = new StudentService();

        Student student = new Student(1, "Erick");
        List<Student> studentList = studentService.getStudents();
        //studentService.addStudent(student);

        boolean actualResult = studentList.isEmpty();

        assertFalse(actualResult, ()->"Student list should not be empty!!");
    }

    @Test
    public void getStudentByIdTestUsingAssertNull() {
        StudentService studentService = new StudentService();

        Student student = new Student(1, "Ramesh");
        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(1);

//        assertNull(actualObject);
//        assertNull(actualObject, () -> "Student object is not null");
        assertNull(actualObject, "Student object is not null");
    }

    @Test
    public void getStudentByIdTestUsingAssertNotNull() {
        StudentService studentService = new StudentService();

        Student student = new Student(1, "Ramesh");
        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(1);

//        assertNotNull(actualObject);
//        assertNotNull(actualObject, "Student is null");
        assertNotNull(actualObject, ()-> "student is Null");

    }

    @Test
    public void getStudentByIdTestUsingAssertEquals() {
        StudentService studentService = new StudentService();

        Student student = new Student(1, "Erick");
        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(1);

//        assertEquals(1, actualObject.getId());
//        assertEquals("Erick", actualObject.getName());
//        assertEquals(student, actualObject);
        assertEquals("Erickeee", actualObject.getName(), "Names are not equals");

    }

    @Test
    public void getStudentByIdTestUsingAssertNotEquals(){
        StudentService studentService = new StudentService();

        Student student = new Student(1, "Erick");
        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(1);

        assertNotEquals("Erickeee", actualObject.getName(), "Names are equals");
    }

    @Test
    public void getStudentNamesByDepartmentTestUsingAssertArrayEquals() {

        StudentService studentService = new StudentService();

        Student student = new Student(1, "Erick", "Science");
        Student student1 = new Student(2, "Marcos", "Science");
        Student student2 = new Student(3, "Oriana", "Arts");

        studentService.addStudent(student);
        studentService.addStudent(student1);
        studentService.addStudent(student2);

        String[] actualArray = studentService.getStudentNamesByDepartment("Science");
        String[] expectedArray = {"Erick", "Marcos", "Another"};

//        assertArrayEquals(expectedArray, actualArray);
//        assertArrayEquals(expectedArray, actualArray, "Student names are not equal");

        Integer[] actualStudentIds = studentService.getStudentIdsByDepartment("Arts");
        Integer[] expectedStudentIds = {3};

//        assertArrayEquals(expectedStudentIds, actualStudentIds);
//        assertArrayEquals(expectedStudentIds, actualStudentIds, "Student Ids are not equal");
        assertArrayEquals(expectedStudentIds, actualStudentIds, () -> "Student Ids are not equal");

    }


    @Test
    public void getStudentNameListByDepartmentTestUsingAssertIterableEquals() {
        StudentService studentService = new StudentService();

        Student student = new Student(1, "Erick", "Science");
        Student student1 = new Student(2, "Marcos", "Science");
        Student student2 = new Student(3, "Oriana", "Arts");

        studentService.addStudent(student);
        studentService.addStudent(student1);
        studentService.addStudent(student2);

        List<String> actualStudentNameList = studentService.getStudentNamesListByDepartment("Science");
        List<String> expectedStudentNameList = Arrays.asList("Erick", "Marcos");

        assertIterableEquals(expectedStudentNameList, actualStudentNameList);

    }

    @Test
    public void getStudentByNameTestUsingAssertThrows(){

        StudentService studentService = new StudentService();

        Student student = new Student(1, "Erick", "science");
        studentService.addStudent(student);

//        assertThrows(NullPointerException.class, () -> {
//            studentService.getStudentByName("Marcos");
//        });

//        assertThrows(StudentNotFoundException.class, () -> {
//            studentService.getStudentByName("Marcos");
//        });

//        assertThrows(StudentNotFoundException.class, () -> {
//            studentService.getStudentByName("Erick");
//        }, "StudentNotFoundException should be thrown, But it wasn't");

        assertThrows(StudentNotFoundException.class, () -> {
            studentService.getStudentByName("MArcos");
        }, () -> "StudentNotFoundException should be thrown, But it wasn't");

    }

    @Test
    public void getStudentByNameTestUsingAssertThrowsExactly(){

        StudentService studentService = new StudentService();

        Student student = new Student(1, "Erick", "science");
        studentService.addStudent(student);

//        assertThrowsExactly(StudentNotFoundException.class, () -> {
//            studentService.getStudentByName("Erick111");
//        });

        assertThrowsExactly(StudentNotFoundException.class, () -> {
            studentService.getStudentByName("Erick111");
        }, "StudentNotFoundException should be thrown, But it wasn't");
    }

}