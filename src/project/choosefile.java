package project;
import java.io.File;
import javax.swing.JFileChooser;
public  class choosefile extends JFileChooser{
	public static String fileChooser() {

		JFileChooser jfc = new JFileChooser(); 
    
        jfc.setAcceptAllFileFilterUsed(false);//�����ļ��������������ļ�ѡ����û�С������ļ�����ѡ��
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);//�����ļ�ѡ�����ͣ�������ֻ��ѡ������ļ�
       
		        jfc.showOpenDialog(null);
		        File xls = jfc.getSelectedFile();
		        
		        if(xls == null){
		            return "";
		        }
		        String resultOpen = jfc.getSelectedFile().getPath();//��ȡ�ļ�·��
		        return resultOpen;
		    }

	    }
	



