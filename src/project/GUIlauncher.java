package project;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;

import java.util.*;
import java.util.Timer;
import java.util.List;

import project.project1;
import project.choosefile;

public class GUIlauncher extends JFrame
{
	private JComboBox jcb;
	private JLabel lb;
	private JButton b1 = new JButton("showDirectedGraph!");
	private JButton b2 = new JButton("save into graph");
	private JButton b3 = new JButton(" search Bridge words of two:");
	private JButton b4 = new JButton("new text is :");
	private JButton b5 = new JButton("calcShortestPath of two");
	private JButton b6 = new JButton("the table of the shortest way of the word:");
	private JButton b7 = new JButton("random work");
	private ACTION action = new ACTION();
	private ACTION2 action2 = new ACTION2();
	private ACTION3 action3 = new ACTION3();
	private ACTION4 action4 = new ACTION4();
	private ACTION5 action5 = new ACTION5();
	private ACTION6 action6 = new ACTION6();
	private ACTION7 action7 = new ACTION7();

	private String Str, randomworkStr;
	private String filename;
	private String new_filename;
	private String Strgraph = "";
	private String new_filename2;
	List<project1.edge> edges = new ArrayList();
	List<project1.edge> edges1 = new ArrayList();
	String[] reswords = new String[100];
	int temp1;
	private JPanel p, p1, p2, p3, p4, p5, p6, p7, p_login, contentPanel;
	private JButton bLogin, bok, bExit, Success, bcontinue, bstop, bsave;
	private JLabel In1, In2, OUT, new_text, OUT_RESULT;
	private JTextField INPUT1, INPUT2, OUTPUT, INPUT_text, OUT_new_text;
	private JTextArea Shortestway, TXT, OUTPUT_RESULT;
	private JScrollPane scroll;
	private JMenuBar jb;
	private JTextArea ja;

	public GUIlauncher()
	{
		GridLayout flow = new GridLayout(2, 3, 8, 6);
		Container con = getContentPane();
		con.setLayout(flow);
		b1.addActionListener(action);
		b2.addActionListener(action);
		b3.addActionListener(action);
		b4.addActionListener(action);
		b5.addActionListener(action);
		b6.addActionListener(action);
		b7.addActionListener(action);
		con.add(b1);
		con.add(b2);
		con.add(b3);
		con.add(b4);
		con.add(b5);
		con.add(b6);
		con.add(b7);
		setTitle("project-lab1");
		setLocation(200, 200);
		setSize(1200, 900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		filename = choosefile.fileChooser();
		File filename1 = new File(filename);
		filename = filename.replaceAll("\\\\ ", "\\\\\\\\ ");
		Str = project1.txtOpen(filename1);
		WindowText win2 = new WindowText("result");
	}

	class WindowText extends JFrame
	{
		WindowText(String s)
		{
			super(s);
			setLayout(new GridLayout());
			Success = new JButton("Success");
			Success.addActionListener(action4);
			this.add(Success);
			setBounds(500, 500, 200, 150);
			this.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					setVisible(false);
				}
			});
			setVisible(true);
			validate();

		}
	}

	class WindowText2 extends JFrame
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 6570853030881924336L;
		JTextField text1;

		WindowText2(String s)
		{
			this.setLayout(new GridLayout());
			p = new JPanel();
			p_login = new JPanel();
			p1 = new JPanel();
			p2 = new JPanel();
			p3 = new JPanel();
			p4 = new JPanel();
			p5 = new JPanel();
			p6 = new JPanel();
			p7 = new JPanel();
			p_login.setLayout(new GridLayout(4, 2));
			bLogin = new JButton("ok");
			bLogin.addActionListener(action2);
			In1 = new JLabel("in1");
			In2 = new JLabel("in2");
			OUT = new JLabel("OUT");
			INPUT1 = new JTextField(30);
			INPUT2 = new JTextField(30);
			OUTPUT = new JTextField(30);
			p1.add(In1);
			p2.add(INPUT1);
			p3.add(In2);
			p4.add(INPUT2);

			p6.add(OUT);
			p7.add(OUTPUT);
			p5.add(bLogin);
			p_login.add(p1);
			p_login.add(p2);
			p_login.add(p3);
			p_login.add(p4);
			p_login.add(p6);
			p_login.add(p7);
			p_login.add(p5);
			p.add(p_login);
			this.add(p, "Center");
			this.setBounds(400, 400, 1200, 500);
			this.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					setVisible(false);
				}
			});
			this.setVisible(true);
			validate();
		}

	}

	class WindowText5 extends JFrame
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -5665759228089695218L;
		JTextField text1;

		WindowText5(String s)
		{
			this.setLayout(new GridLayout());
			p = new JPanel();
			p_login = new JPanel();
			p1 = new JPanel();
			p2 = new JPanel();
			p3 = new JPanel();
			p4 = new JPanel();
			p5 = new JPanel();
			p6 = new JPanel();
			p7 = new JPanel();
			p_login.setLayout(new GridLayout(4, 2));
			bLogin = new JButton("ok");
			bLogin.addActionListener(action5);
			In1 = new JLabel("in1");
			In2 = new JLabel("in2");
			OUT = new JLabel("OUT");
			INPUT1 = new JTextField(30);
			INPUT2 = new JTextField(30);
			Shortestway = new JTextArea(10, 30);
			p1.add(In1);
			p2.add(INPUT1);
			p3.add(In2);
			p4.add(INPUT2);
			p5.add(bLogin);
			p6.add(OUT);
			p7.add(Shortestway);

			p_login.add(p1);
			p_login.add(p2);
			p_login.add(p3);
			p_login.add(p4);

			p_login.add(p6);
			p_login.add(p7);
			p_login.add(p5);
			p.add(p_login);
			this.add(p, "Center");
			this.setBounds(400, 400, 1600, 800);
			this.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					setVisible(false);
				}
			});
			this.setVisible(true);
			validate();
		}

	}

	class WindowText6 extends JFrame
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -2260658775020941245L;

		WindowText6(String s)
		{
			this.setLayout(new GridLayout());
			p = new JPanel();
			scroll = new JScrollPane();
			p_login = new JPanel();
			p1 = new JPanel();
			p2 = new JPanel();
			p5 = new JPanel();
			p6 = new JPanel();
			p7 = new JPanel();
			p_login.setLayout(new GridLayout(4, 2));
			bLogin = new JButton("ok");
			bLogin.addActionListener(action6);
			In1 = new JLabel("in1");
			OUT = new JLabel("OUT");
			INPUT1 = new JTextField(30);
			Shortestway = new JTextArea(10, 30);
			jb = new JMenuBar();
			this.setJMenuBar(jb);
			scroll = new JScrollPane(Shortestway);
			p1.add(In1);
			p2.add(INPUT1);
			p5.add(bLogin);
			p_login.add(p1);
			p_login.add(p2);
			p_login.add(p5);
			p.add(scroll);
			p.add(p_login);
			this.add(p, "Center");
			this.setBounds(400, 400, 1200, 600);
			this.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					setVisible(false);
				}
			});
			this.setVisible(true);
			validate();
		}

	}

	class WindowText7 extends JFrame
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -7241081016319681396L;

		WindowText7(String s)
		{
			this.setLayout(new GridLayout());
			p = new JPanel();
			p_login = new JPanel();
			p1 = new JPanel();
			p2 = new JPanel();
			p3 = new JPanel();
			p4 = new JPanel();
			p5 = new JPanel();
			p_login.setLayout(new GridLayout(3, 2));
			bcontinue = new JButton("continue");
			bcontinue.addActionListener(action7);
			bstop = new JButton("stop");
			bstop.addActionListener(action7);
			bsave = new JButton("save");
			bsave.addActionListener(action7);
			OUT_RESULT = new JLabel("OUT_RESULT");
			OUTPUT_RESULT = new JTextArea(10, 30);
			p1.add(bcontinue);
			p2.add(bstop);
			p3.add(OUT_RESULT);
			p4.add(OUTPUT_RESULT);
			p5.add(bsave);
			p_login.add(p1);
			p_login.add(p2);
			p_login.add(p3);
			p_login.add(p4);
			p_login.add(p5);
			p.add(p_login);
			this.add(p, "Center");
			this.setBounds(400, 400, 1200, 500);
			this.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					setVisible(false);
				}
			});
			this.setVisible(true);
			validate();
		}

	}

	class WindowText0 extends JFrame
	{
		WindowText0(String s)
		{
			this.setLayout(new GridLayout());
			p = new JPanel();
			p_login = new JPanel();
			p7 = new JPanel();
			p_login.setLayout(new GridLayout(4, 2));
			TXT = new JTextArea(10, 30);
			jb = new JMenuBar();
			this.setJMenuBar(jb);
			scroll = new JScrollPane(TXT);
			p_login.add(p7);
			p.add(p_login);
			p.add(scroll);
			this.add(p, "Center");

			this.setBounds(400, 400, 1200, 600);
			for (int i = 0; i < edges.size(); i++)
			{
				TXT.append("From:" + edges.get(i).start_node + "  To:" + edges.get(i).end_node + "  Weight:"
						+ edges.get(i).weight + "\n");

			}
			this.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					setVisible(false);

				}
			});
			this.setVisible(true);

			validate();
		}

	}

	class ACTION2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton btn = (JButton) e.getSource();

			if (btn == bLogin)
			{
				String word1 = INPUT1.getText();
				String word2 = INPUT2.getText();

				String result = project1.queryBridgeWords(edges, word1, word2);
				OUTPUT.setText(result);
			}

		}
	}

	class ACTION4 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton btn = (JButton) e.getSource();
			if (btn == Success)
			{

			}

		}
	}

	class WindowText4 extends JFrame
	{
		WindowText4(String s)
		{
			this.setLayout(new GridLayout());
			p = new JPanel();
			p_login = new JPanel();
			p1 = new JPanel();
			p2 = new JPanel();
			p3 = new JPanel();
			p5 = new JPanel();
			p6 = new JPanel();
			p7 = new JPanel();
			p_login.setLayout(new GridLayout(2, 4));
			bok = new JButton("ok");
			bok.addActionListener(action3);
			bExit = new JButton("Exit");
			new_text = new JLabel("newtext");
			OUT = new JLabel("OUT");
			INPUT_text = new JTextField(30);
			OUT_new_text = new JTextField(30);
			p1.add(new_text);
			p2.add(INPUT_text);
			p6.add(OUT);
			p7.add(OUT_new_text);
			p5.add(bok);
			p3.add(bExit);
			p_login.add(p1);
			p_login.add(p2);
			p_login.add(p5);
			p_login.add(p6);
			p_login.add(p7);
			p_login.add(p3);
			p.add(p_login);
			this.add(p);
			// setBounds(500, 500, 200, 150);
			this.setBounds(400, 400, 1300, 500);
			this.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					setVisible(false);
				}
			});
			this.setVisible(true);
			validate();
		}

	}

	class ACTION3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton btn = (JButton) e.getSource();
			if (btn.equals(bExit))
			{
				setVisible(false);
			}
			if (btn.equals(bok))
			{
				String newtext = INPUT_text.getText();

				String result = project1.generateNewText(edges, newtext);
				OUT_new_text.setText(result);
			}

		}
	}

	class ACTION5 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton btn = (JButton) e.getSource();

			if (btn == bLogin)
			{
				String word1 = INPUT1.getText();
				String word2 = INPUT2.getText();

				List<String> a = project1.calcShortestPath(edges, word1, word2);
				for (int i = 0; i < a.size(); i++)
				{

					Shortestway.append(a.get(i) + "\n");
				}
				if (a.size() == 0)
				{
					Shortestway.setText("no such way\n");
				}

			}

		}
	}

	class ACTION6 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton btn = (JButton) e.getSource();

			if (btn == bLogin)
			{
				String word1 = INPUT1.getText();

				List<String> check = new ArrayList();

				for (int temp = 0; temp < edges.size(); temp++)
				{

					if (check.contains(edges.get(temp).start_node))
						continue;
					check.add(edges.get(temp).start_node);
					Shortestway.append(
							"The shortest way(s) from " + word1 + " to " + edges.get(temp).start_node + " is(are):");
					List<String> b = project1.calcShortestPath(edges, word1, edges.get(temp).start_node);
					Shortestway.setLineWrap(true);
					Shortestway.setWrapStyleWord(true);
					for (int j = 0; j < b.size(); j++)
					{

						Shortestway.append(b.get(j) + "\n");
					}
					if (b.size() == 0)
					{
						Shortestway.append("no such way\n");
					}
				}
			}

		}
	}

	class ACTION7 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			JButton btn = (JButton) e.getSource();
			String a = project1.randomWalk(edges);
			int count = 0;
			reswords = a.split(" ");
			if (btn == bcontinue)
			{

				temp1 = 0;

			}
			if (btn == bstop || btn == bsave)
			{
				temp1 = 1;

			}

			Timer timer = new Timer();
			TimerTask task = new TimerTask()
			{
				private int count = 0;

				@Override
				public void run()
				{
					if (temp1 == 1)
					{
						timer.cancel();
					}
					OUTPUT_RESULT.append(reswords[count] + " ");
					Strgraph += reswords[count] + " ";
					this.count++;

					OUTPUT_RESULT.setLineWrap(true);
					OUTPUT_RESULT.setWrapStyleWord(true);

				}
			};
			timer.schedule(task, 0, 500);
		}
	}

	class ACTION implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			Object source = e.getSource();

			if (source == b1)
			{
				edges = project1.createDirectedGraph(project1.domain(Str));

				WindowText0 win0 = new WindowText0("showDirectedGraph");

			} else if (source == b2)
			{

				GraphViz gv = new GraphViz();
				gv.addln(gv.start_graph());
				for (int i = 0; i < edges.size(); i++)
				{
					gv.addln(edges.get(i).start_node + " -> " + edges.get(i).end_node + "[label = \""
							+ edges.get(i).weight + "\"];");
					System.out.println(edges.get(i).start_node + " -> " + edges.get(i).end_node + "[label = \""
							+ edges.get(i).weight + "\"];");
				}
				gv.addln(gv.end_graph());
				String type = "jpg";
				new_filename = choosefile.fileChooser();
				File new_filename1 = new File(new_filename);
				new_filename = new_filename.replaceAll("\\\\ ", "\\\\\\\\ ");
				File out = new File(new_filename1 + type);
				gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type), out);
				WindowText win1 = new WindowText("result");
			}

			else if (source == b3)
			{
				new WindowText2("bridge words");
			} else if (source == b4)
			{
				WindowText4 win4 = new WindowText4("new text is:");
			}

			else if (source == b5)
			{
				WindowText5 win5 = new WindowText5("calcShortestPath");
			} else if (source == b6)
			{
				String search3;
				String search4;
				WindowText6 win6 = new WindowText6("the table of the shortest way of the word:");
			} else
			{
				WindowText7 win7 = new WindowText7("randomwalk");
			}

		}
	}
}