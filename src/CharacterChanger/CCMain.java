package CharacterChanger;

public class CCMain 
{
	public static void main(String[] args) 
	{
		CCView view = new CCView();
		CCModel model = new CCModel();
		CCController contoller = new CCController(view, model);
		
		view.setVisible(true);
	}
}
