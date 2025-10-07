public class voter {
    public static void main(String[] arg){
class InvalidVoterAgeException extends Exception {
    public InvalidVoterAgeException(String message) {
        super(message);
    }
}
{
class Voter {
    int voterId;
    String name;
    int age;

    public Voter(int voterId, String name, int age) throws InvalidVoterAgeException {
        if (age < 18) {
            throw new InvalidVoterAgeException("Invalid age for voter");
        }
        this.voterId = voterId;
        this.name = name;
        this.age = age;
                }
            } 
        } 
    }     
}
