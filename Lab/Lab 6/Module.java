public class Module extends KeyableMap<String, String, Assessment> {

    public Module(String moduleName) {
        super(moduleName);
    }

    @Override
    public Module put(Assessment assessment) {
        super.put(assessment);
        return this;
    }

}

