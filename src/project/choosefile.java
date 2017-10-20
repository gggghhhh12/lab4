package project;

import java.io.File;
import javax.swing.JFileChooser;

public class choosefile extends JFileChooser
{
	public static String fileChooser()
	{
		JFileChooser jfc = new JFileChooser();
		jfc.setAcceptAllFileFilterUsed(false);
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.showOpenDialog(null);
		File xls = jfc.getSelectedFile();
		if (xls == null)
		{
			return "";
		}
		String resultOpen = jfc.getSelectedFile().getPath();
		return resultOpen;
	}
}
