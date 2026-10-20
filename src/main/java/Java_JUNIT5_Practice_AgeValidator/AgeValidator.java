package Java_JUNIT5_Practice_AgeValidator;


class AgeValidator {

    boolean isAdult(int age){

        validateAge(age);

        return (age >= 18);
    }

    int yearsUntilAdult(int age){

        if (isAdult(age)){
            return 0;

        }
        return (18 - age);
    }

    void validateAge(int age){
        if (age < 0 || age > 120){
            throw new IllegalArgumentException("Age is Invalid");
        }
    }

}