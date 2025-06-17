@RestController
@RequestMapping("/students")
public class StudentController {

    private Map<Integer, Student> students = new HashMap<>();

    public StudentController() {
        students.put(1010, new Student(1010, "Dilan", "Informatik"));
        students.put(1000, new Student(1000, "Sonya", "Bauingenieurwesen"));
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Student>> getAllStudents() {
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {
        Student student = students.get(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student nicht gefunden");
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        if (students.containsKey(student.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Student schon vorhanden");
        }
        students.put(student.getId(), student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        students.put(student.getId(), student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        if (!students.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student nicht gefunden");
        }
        students.remove(id);
        return ResponseEntity.ok("Student gelöscht");
    }
}
