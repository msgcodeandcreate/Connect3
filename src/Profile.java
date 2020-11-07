public class Profile {

    private String username;
    private String password;
    private String[][] accounts = {{"SimonM", "a2vd"},{"SimonG", "aqef"},{"Alice", "jdnd"},
            {"Jannis", "qevu"},{"Katharina", "12de"},{"Oliver", "cacr"}};

    public Profile(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public boolean checkPassword()
    {
        for (int i = 1; i <= 6; i++){
            if((username.equals(accounts[i][0])) && (password.equals(accounts[i][1])))
                return true;
        }

        return false;
    }

}
