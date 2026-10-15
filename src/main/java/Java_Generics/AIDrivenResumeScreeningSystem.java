package Java_Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Generics assignment 5: type-safe role processing, with a simple demo skill check.
// No AI model or scoring rules are supplied by the question.
public class AIDrivenResumeScreeningSystem {

    abstract static class JobRole {
        abstract String name();
        abstract List<String> requiredSkills();
    }

    static class SoftwareEngineer extends JobRole {
        String name() { return "Software Engineer"; }
        List<String> requiredSkills() { return Arrays.asList("Java", "SQL"); }
    }

    static class DataScientist extends JobRole {
        String name() { return "Data Scientist"; }
        List<String> requiredSkills() { return Arrays.asList("Python", "Statistics"); }
    }

    static class ProductManager extends JobRole {
        String name() { return "Product Manager"; }
        List<String> requiredSkills() { return Arrays.asList("Planning", "Communication"); }
    }

    static class Resume<T extends JobRole> {
        final String candidate;
        final T role;
        final List<String> skills;

        Resume(String candidate, T role, List<String> skills) {
            this.candidate = candidate;
            this.role = role;
            this.skills = new ArrayList<>(skills);
        }
    }

    static <T extends JobRole> boolean process(Resume<T> resume) {
        boolean matches = resume.skills.containsAll(resume.role.requiredSkills());
        System.out.println(resume.candidate + " | " + resume.role.name()
                + " | Matches demo skills: " + matches);
        return matches;
    }

    static void displayRoles(List<? extends JobRole> roles) {
        for (JobRole role : roles) System.out.println(role.name());
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> engineer = new Resume<>("Mihir",
                new SoftwareEngineer(), Arrays.asList("Java", "SQL", "Git"));
        Resume<DataScientist> scientist = new Resume<>("Asha",
                new DataScientist(), Arrays.asList("Python", "Statistics"));
        Resume<ProductManager> manager = new Resume<>("Shrey",
                new ProductManager(), Arrays.asList("Planning"));
        process(engineer);
        process(scientist);
        process(manager);
        List<JobRole> roles = Arrays.asList(engineer.role, scientist.role, manager.role);
        displayRoles(roles);
    }
}
