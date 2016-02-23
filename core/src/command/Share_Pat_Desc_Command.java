package command;

import beansAfrica.PatDesc;

public class Share_Pat_Desc_Command extends Command{
	private PatDesc pat ; 
	

	public Share_Pat_Desc_Command(int numCommand,PatDesc pat) {
		super(numCommand);
		this.pat=pat;
	}


	public PatDesc getPat() {
		return pat;
	}


	public void setPat(PatDesc pat) {
		this.pat = pat;
	}
	

}
