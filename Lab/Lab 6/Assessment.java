public class Assessment implements Keyable<String> {
    private final String assessment;
    private final String grade;

    public Assessment(String assessment, String grade) {
        this.assessment = assessment;
        this.grade = grade;
    }

    public String getGrade() {
        return this.grade;
    }

    @Override
    public String getKey() {
        return this.assessment;
    }

    @Override
    public String toString() {
        return "{" + this.assessment + ": " + this.grade + "}";
    }
}
