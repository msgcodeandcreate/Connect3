public class Profile {
  
  private String username;
  private String password;
  private String[][] accounts;
  
  public Profile(String username, String password) 
  {
	  this.username = username;
	  this.password = password;

	  updateAccounts(this, accounts);

  }

  public boolean checkPassword()
  {
	  for (int i = 1; i <= 6; i++){
		  if((username.equals(accounts[i][0])) && (password.equals(accounts[i][1])))
	    	  return true;
	  }
	    	
	    	return false;
		}


  public String[][] updateAccounts(Profile newProfile, String[][] accounts){

	String[][] new_accounts = new String[accounts.length+1][2];
	for(int i=0; i<accounts.length; i++){
		new_accounts[i][0] = accounts[i][0];
		new_accounts[i][1] = accounts[i][1];			
	}
	new_accounts[accounts.length][0] = newProfile.username;
	new_accounts[accounts.length][1] = newProfile.password;

	return new_accounts;
	}

}
