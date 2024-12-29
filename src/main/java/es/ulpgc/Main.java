package es.ulpgc;

public class Main {
    public static void main(String[] args) {
        LoadRandomUserCommand command = new LoadRandomUserCommand(10);
        command.execute();
        for(User user : command.getUsers()){
            System.out.println(user.getName());
        }
    }
}
