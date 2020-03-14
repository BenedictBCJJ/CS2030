public class Roster extends KeyableMap<String, String, Student> {

    Roster(String year) {
        super(year);
    }

    public 
        String getGrade(String student, String module, String test) throws NoSuchRecordException {
        try {
            return this.get(student).get(module).get(test).getGrade();
        } catch (NullPointerException ex) {
            throw 
                new NoSuchRecordException("No such record: " + student + " " + module + " " + test);
        }
    }

    @Override
    public Roster put(Student student) {
        super.put(student);
        return this;
    }
}
