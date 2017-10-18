package project;
import java.io.File;
import javax.swing.JFileChooser;
public  class choosefile extends JFileChooser{
	public static String fileChooser() {

		JFileChooser jfc = new JFileChooser(); 
    
        jfc.setAcceptAllFileFilterUsed(false);//设置文件过滤条件，在文件选择中没有“所有文件”的选项
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);//设置文件选择类型，在这里只是选择具体文件
       
		        jfc.showOpenDialog(null);
		        File xls = jfc.getSelectedFile();
		        
		        if(xls == null){
		            return "";
		        }
		        String resultOpen = jfc.getSelectedFile().getPath();//获取文件路径
		        return resultOpen;
		    }

	    }
	



