public class Student extends KeyableMap<String, String, Module> {

    public Student(String studentName) {
        super(studentName);
    }

    @Override
    public Student put(Module module) {
        super.put(module);
        return this;
    }
}
