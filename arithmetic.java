import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class arithmetic implements ActionListener {
	JFrame f;
	JLabel title, title1;
	JTextField jfirst1, jfirst2, jfirst3, jfirst4, jfirst5, jfirst6, jfirst7,
			jfirst8, jfirst9, jfirst10;// 10道题的分别的第一个数据
	JLabel jsymbol1, jsymbol2, jsymbol3, jsymbol4, jsymbol5, jsymbol6,
			jsymbol7, jsymbol8, jsymbol9, jsymbol10;// 10道题的分别的符号
	JTextField jsecond1, jsecond2, jsecond3, jsecond4, jsecond5, jsecond6,
			jsecond7, jsecond8, jsecond9, jsecond10;// 10道题的分别的第二个数据
	JTextField janswer1, janswer2, janswer3, janswer4, janswer5, janswer6,
			janswer7, janswer8, janswer9, janswer10;// 10道题分别的结果
	JLabel jjudge1, jjudge2, jjudge3, jjudge4, jjudge5, jjudge6, jjudge7,
			jjudge8, jjudge9, jjudge10;// 判断10道题输入答案的对错
	JTextField jjresult1, jjresult2, jjresult3, jjresult4, jjresult5,
			jjresult6, jjresult7, jjresult8, jjresult9, jjresult10;// 10道题分别的
	// 正确答案
	JButton SubmitBtn;// 提交答案按钮
	JButton AddBtn, SubBtn, MulBtn, DivBtn, ExitBtn;// 加法测试，减法测试，乘法测试，除法测试，退出系统
	JLabel jtotle, jright, jjright;// 总共题数，提示：“正确题数：”，正确的题数

	float first1, first2, first3, first4, first5, first6, first7, first8,
			first9, first10;
	float second1, second2, second3, second4, second5, second6, second7,
			second8, second9, second10;
	int flag;

	public arithmetic() {
		f = new JFrame(" 小学四则运算系统");
		f.setBounds(100, 100, 1150, 520);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = f.getContentPane();

		// 添加提示：“请选择”，添加加法测试按钮、减法测试按钮、乘法测试按钮、除法测试按钮、退出测试按钮
		JLabel Choose = new JLabel("请选择:");
		Choose.setFont(new Font("黑体", Font.BOLD, 18));
		AddBtn = new JButton("加法运算");
		AddBtn.setFont(new Font("黑体", Font.BOLD, 18));
		AddBtn.addActionListener(this);
		SubBtn = new JButton("减法运算");
		SubBtn.setFont(new Font("黑体", Font.BOLD, 18));
		SubBtn.addActionListener(this);
		MulBtn = new JButton("乘法运算");
		MulBtn.setFont(new Font("黑体", Font.BOLD, 18));
		MulBtn.addActionListener(this);
		DivBtn = new JButton("除法运算");
		DivBtn.setFont(new Font("黑体", Font.BOLD, 18));
		DivBtn.addActionListener(this);
		ExitBtn = new JButton("退出系统");
		ExitBtn.setFont(new Font("黑体", Font.BOLD, 18));
		ExitBtn.addActionListener(this);
		Box box11 = Box.createVerticalBox();
		box11.add(Box.createHorizontalStrut(73));
		box11.add(Choose);
		box11.add(Box.createVerticalStrut(44));
		box11.add(AddBtn);
		box11.add(Box.createVerticalStrut(44));
		box11.add(SubBtn);
		box11.add(Box.createVerticalStrut(44));
		box11.add(MulBtn);
		box11.add(Box.createVerticalStrut(44));
		box11.add(DivBtn);
		box11.add(Box.createVerticalStrut(44));
		box11.add(ExitBtn);
		box11.add(Box.createVerticalStrut(35));

		// 添加标签：“您已进入加法测试，现在开始答题："”
		title = new JLabel("您好，欢迎进入小学四则运算系统！");
		title.setFont(new Font("黑体", Font.BOLD, 18));
		Box box = Box.createHorizontalBox();
		box.add(Box.createHorizontalGlue());
		box.add(title);
		box.add(Box.createHorizontalGlue());

		// 添加提示标签
		title1 = new JLabel("注：请在左边栏内选择运算后开始答题，除法运算结果保留两位小数，其余运算保留一位小数。");
		title1.setFont(new Font("黑体", Font.BOLD, 14));
		Box box12 = Box.createHorizontalBox();
		box12.add(Box.createHorizontalGlue());
		box12.add(title1);
		box12.add(Box.createHorizontalGlue());

		// 添加每道题的符号标签
		jsymbol1 = new JLabel("?");
		jsymbol2 = new JLabel("?");
		jsymbol3 = new JLabel("?");
		jsymbol4 = new JLabel("?");
		jsymbol5 = new JLabel("?");
		jsymbol6 = new JLabel("?");
		jsymbol7 = new JLabel("?");
		jsymbol8 = new JLabel("?");
		jsymbol9 = new JLabel("?");
		jsymbol10 = new JLabel("?");

		// 设置答案对错的标签
		jjudge1 = new JLabel("?");
		jjudge2 = new JLabel("?");
		jjudge3 = new JLabel("?");
		jjudge4 = new JLabel("?");
		jjudge5 = new JLabel("?");
		jjudge6 = new JLabel("?");
		jjudge7 = new JLabel("?");
		jjudge8 = new JLabel("?");
		jjudge9 = new JLabel("?");
		jjudge10 = new JLabel("?");

		// 为每道题的结果设置为不可更改
		jjresult1 = new JTextField(8);
		jjresult1.setEditable(false);
		jjresult2 = new JTextField(8);
		jjresult2.setEditable(false);
		jjresult3 = new JTextField(8);
		jjresult3.setEditable(false);
		jjresult4 = new JTextField(8);
		jjresult4.setEditable(false);
		jjresult5 = new JTextField(8);
		jjresult5.setEditable(false);
		jjresult6 = new JTextField(8);
		jjresult6.setEditable(false);
		jjresult7 = new JTextField(8);
		jjresult7.setEditable(false);
		jjresult8 = new JTextField(8);
		jjresult8.setEditable(false);
		jjresult9 = new JTextField(8);
		jjresult9.setEditable(false);
		jjresult10 = new JTextField(8);
		jjresult10.setEditable(false);

		// 设置第一个数据和第二个数据为不可见
		jfirst1 = new JTextField(6);
		jfirst1.setEditable(false);
		jfirst2 = new JTextField(6);
		jfirst2.setEditable(false);
		jsecond1 = new JTextField(6);
		jsecond1.setEditable(false);
		jsecond2 = new JTextField(6);
		jsecond2.setEditable(false);
		janswer1 = new JTextField(6);
		janswer2 = new JTextField(6);
		// 把标签加入盒子box1中
		Box box1 = Box.createHorizontalBox();
		box1.add(Box.createHorizontalStrut(50));
		box1.add(jfirst1);
		box1.add(Box.createHorizontalStrut(3));
		box1.add(jsymbol1);
		box1.add(Box.createHorizontalStrut(3));
		box1.add(jsecond1);
		box1.add(Box.createHorizontalStrut(5));
		box1.add(new JLabel("="));
		box1.add(Box.createHorizontalStrut(5));
		box1.add(janswer1);
		box1.add(Box.createHorizontalStrut(5));
		box1.add(new JLabel("对/错："));
		box1.add(jjudge1);
		box1.add(Box.createHorizontalStrut(20));
		box1.add(new JLabel("正确答案："));
		box1.add(jjresult1);
		box1.add(Box.createHorizontalStrut(73));
		box1.add(jfirst2);
		box1.add(Box.createHorizontalStrut(3));
		box1.add(jsymbol2);
		box1.add(Box.createHorizontalStrut(3));
		box1.add(jsecond2);
		box1.add(Box.createHorizontalStrut(5));
		box1.add(new JLabel("="));
		box1.add(Box.createHorizontalStrut(5));
		box1.add(janswer2);
		box1.add(Box.createHorizontalStrut(5));
		box1.add(new JLabel("对/错："));
		box1.add(jjudge2);
		box1.add(Box.createHorizontalStrut(20));
		box1.add(new JLabel("正确答案："));
		box1.add(jjresult2);
		box1.add(Box.createHorizontalStrut(50));

		jfirst3 = new JTextField(6);
		jfirst3.setEditable(false);
		jfirst4 = new JTextField(6);
		jfirst4.setEditable(false);
		jsecond3 = new JTextField(6);
		jsecond3.setEditable(false);
		jsecond4 = new JTextField(6);
		jsecond4.setEditable(false);
		janswer3 = new JTextField(6);
		janswer4 = new JTextField(6);
		Box box2 = Box.createHorizontalBox();
		box2.add(Box.createHorizontalStrut(50));
		box2.add(jfirst3);
		box2.add(Box.createHorizontalStrut(3));
		box2.add(jsymbol3);
		box2.add(Box.createHorizontalStrut(3));
		box2.add(jsecond3);
		box2.add(Box.createHorizontalStrut(5));
		box2.add(new JLabel("="));
		box2.add(Box.createHorizontalStrut(5));
		box2.add(janswer3);
		box2.add(Box.createHorizontalStrut(5));
		box2.add(new JLabel("对/错："));
		box2.add(jjudge3);
		box2.add(Box.createHorizontalStrut(20));
		box2.add(new JLabel("正确答案："));
		box2.add(jjresult3);
		box2.add(Box.createHorizontalStrut(73));
		box2.add(jfirst4);
		box2.add(Box.createHorizontalStrut(3));
		box2.add(jsymbol4);
		box2.add(Box.createHorizontalStrut(3));
		box2.add(jsecond4);
		box2.add(Box.createHorizontalStrut(5));
		box2.add(new JLabel("="));
		box2.add(Box.createHorizontalStrut(5));
		box2.add(janswer4);
		box2.add(Box.createHorizontalStrut(5));
		box2.add(new JLabel("对/错："));
		box2.add(jjudge4);
		box2.add(Box.createHorizontalStrut(20));
		box2.add(new JLabel("正确答案："));
		box2.add(jjresult4);
		box2.add(Box.createHorizontalStrut(50));

		jfirst5 = new JTextField(6);
		jfirst5.setEditable(false);
		jfirst6 = new JTextField(6);
		jfirst6.setEditable(false);
		jsecond5 = new JTextField(6);
		jsecond5.setEditable(false);
		jsecond6 = new JTextField(6);
		jsecond6.setEditable(false);
		janswer5 = new JTextField(6);
		janswer6 = new JTextField(6);
		Box box3 = Box.createHorizontalBox();
		box3.add(Box.createHorizontalStrut(50));
		box3.add(jfirst5);
		box3.add(Box.createHorizontalStrut(3));
		box3.add(jsymbol5);
		box3.add(Box.createHorizontalStrut(3));
		box3.add(jsecond5);
		box3.add(Box.createHorizontalStrut(5));
		box3.add(new JLabel("="));
		box3.add(Box.createHorizontalStrut(5));
		box3.add(janswer5);
		box3.add(Box.createHorizontalStrut(5));
		box3.add(new JLabel("对/错："));
		box3.add(jjudge5);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(new JLabel("正确答案："));
		box3.add(jjresult5);
		box3.add(Box.createHorizontalStrut(73));
		box3.add(jfirst6);
		box3.add(Box.createHorizontalStrut(3));
		box3.add(jsymbol6);
		box3.add(Box.createHorizontalStrut(3));
		box3.add(jsecond6);
		box3.add(Box.createHorizontalStrut(5));
		box3.add(new JLabel("="));
		box3.add(Box.createHorizontalStrut(5));
		box3.add(janswer6);
		box3.add(Box.createHorizontalStrut(5));
		box3.add(new JLabel("对/错："));
		box3.add(jjudge6);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(new JLabel("正确答案："));
		box3.add(jjresult6);
		box3.add(Box.createHorizontalStrut(50));

		jfirst7 = new JTextField(6);
		jfirst7.setEditable(false);
		jfirst8 = new JTextField(6);
		jfirst8.setEditable(false);
		jsecond7 = new JTextField(6);
		jsecond7.setEditable(false);
		jsecond8 = new JTextField(6);
		jsecond8.setEditable(false);
		janswer7 = new JTextField(6);
		janswer8 = new JTextField(6);
		Box box4 = Box.createHorizontalBox();
		box4.add(Box.createHorizontalStrut(50));
		box4.add(jfirst7);
		box4.add(Box.createHorizontalStrut(3));
		box4.add(jsymbol7);
		box4.add(Box.createHorizontalStrut(3));
		box4.add(jsecond7);
		box4.add(Box.createHorizontalStrut(5));
		box4.add(new JLabel("="));
		box4.add(Box.createHorizontalStrut(5));
		box4.add(janswer7);
		box4.add(Box.createHorizontalStrut(5));
		box4.add(new JLabel("对/错："));
		box4.add(jjudge7);
		box4.add(Box.createHorizontalStrut(20));
		box4.add(new JLabel("正确答案："));
		box4.add(jjresult7);
		box4.add(Box.createHorizontalStrut(73));
		box4.add(jfirst8);
		box4.add(Box.createHorizontalStrut(3));
		box4.add(jsymbol8);
		box4.add(Box.createHorizontalStrut(3));
		box4.add(jsecond8);
		box4.add(Box.createHorizontalStrut(5));
		box4.add(new JLabel("="));
		box4.add(Box.createHorizontalStrut(5));
		box4.add(janswer8);
		box4.add(Box.createHorizontalStrut(5));
		box4.add(new JLabel("对/错："));
		box4.add(jjudge8);
		box4.add(Box.createHorizontalStrut(20));
		box4.add(new JLabel("正确答案："));
		box4.add(jjresult8);
		box4.add(Box.createHorizontalStrut(50));

		jfirst9 = new JTextField(6);
		jfirst9.setEditable(false);
		jfirst10 = new JTextField(6);
		jfirst10.setEditable(false);
		jsecond9 = new JTextField(6);
		jsecond9.setEditable(false);
		jsecond10 = new JTextField(6);
		jsecond10.setEditable(false);
		janswer9 = new JTextField(6);
		janswer10 = new JTextField(6);
		Box box5 = Box.createHorizontalBox();
		box5.add(Box.createHorizontalStrut(50));
		box5.add(jfirst9);
		box5.add(Box.createHorizontalStrut(3));
		box5.add(jsymbol9);
		box5.add(Box.createHorizontalStrut(3));
		box5.add(jsecond9);
		box5.add(Box.createHorizontalStrut(5));
		box5.add(new JLabel("="));
		box5.add(Box.createHorizontalStrut(5));
		box5.add(janswer9);
		box5.add(Box.createHorizontalStrut(5));
		box5.add(new JLabel("对/错："));
		box5.add(jjudge9);
		box5.add(Box.createHorizontalStrut(20));
		box5.add(new JLabel("正确答案："));
		box5.add(jjresult9);
		box5.add(Box.createHorizontalStrut(73));
		box5.add(jfirst10);
		box5.add(Box.createHorizontalStrut(3));
		box5.add(jsymbol10);
		box5.add(Box.createHorizontalStrut(3));
		box5.add(jsecond10);
		box5.add(Box.createHorizontalStrut(5));
		box5.add(new JLabel("="));
		box5.add(Box.createHorizontalStrut(5));
		box5.add(janswer10);
		box5.add(Box.createHorizontalStrut(5));
		box5.add(new JLabel("对/错："));
		box5.add(jjudge10);
		box5.add(Box.createHorizontalStrut(20));
		box5.add(new JLabel("正确答案："));
		box5.add(jjresult10);
		box5.add(Box.createHorizontalStrut(50));

		// 设置提交答案按钮
		SubmitBtn = new JButton("提交答案");
		SubmitBtn.setFont(new Font("黑体", Font.BOLD, 18));
		SubmitBtn.addActionListener(this);
		// 添加总题数标签
		jtotle = new JLabel("总题数：10 题");
		jtotle.setFont(new Font("黑体", Font.BOLD, 18));
		// 添加答对题数标签
		jright = new JLabel("答对题数：");
		jright.setFont(new Font("黑体", Font.BOLD, 18));
		jjright = new JLabel("0");
		jjright.setFont(new Font("黑体", Font.BOLD, 18));
		Box box6 = Box.createHorizontalBox();
		box6.add(Box.createHorizontalStrut(50));
		box6.add(SubmitBtn);
		box6.add(Box.createHorizontalStrut(50));
		box6.add(jtotle);
		box6.add(Box.createHorizontalStrut(50));
		box6.add(jright);
		box6.add(Box.createHorizontalStrut(20));
		box6.add(jjright);
		box6.add(Box.createHorizontalStrut(50));

		// 创建一个容器
		Box box7 = Box.createVerticalBox();
		box7.add(Box.createVerticalStrut(30));
		box7.add(box);
		box7.add(Box.createVerticalStrut(30));
		box7.add(box12);
		box7.add(Box.createVerticalStrut(30));
		box7.add(box1);
		box7.add(Box.createVerticalStrut(30));
		box7.add(box2);
		box7.add(Box.createVerticalStrut(30));
		box7.add(box3);
		box7.add(Box.createVerticalStrut(30));
		box7.add(box4);
		box7.add(Box.createVerticalStrut(30));
		box7.add(box5);
		box7.add(Box.createVerticalStrut(30));
		box7.add(box6);
		box7.add(Box.createVerticalStrut(30));

		// 创建一个容器
		Box box8 = Box.createHorizontalBox();
		box8.add(box11);
		box8.add(Box.createHorizontalStrut(40));
		box8.add(new JSeparator(JSeparator.VERTICAL));
		box8.add(box7);

		c.add(box8);
		f.setVisible(true);
	}

	public static void main(String args[]) {
		new arithmetic();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/* 加法计算 */
		if (e.getSource() == AddBtn) {
			flag = 1;
			jsymbol1.setText("+");
			jsymbol2.setText("+");
			jsymbol3.setText("+");
			jsymbol4.setText("+");
			jsymbol5.setText("+");
			jsymbol6.setText("+");
			jsymbol7.setText("+");
			jsymbol8.setText("+");
			jsymbol9.setText("+");
			jsymbol10.setText("+");
			fun();
			random();
		}
		// 提交答案并判断
		if (e.getSource() == SubmitBtn && flag == 1) {
			double a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
			int true1 = 0;
			// 计算第一道题
			String answer1 = null;
			a1 = first1 + second1;
			answer1 = Double.toString(a1);
			String result1 = janswer1.getText();
			if (result1.equals(answer1)) {
				jjudge1.setText("对");
				true1 = true1 + 1;
				jjright.setText(Integer.toString(true1));// 显示答对题数
			} else {
				jjudge1.setText("错");
				jjresult1.setText(answer1);// 显示正确结果
			}
			// 计算第二道题
			String answer2 = null;
			a2 = first2 + second2;
			answer2 = Double.toString(a2);
			String result2 = janswer2.getText();
			if (result2.equals(answer2)) {
				jjudge2.setText("对");
				true1 = true1 + 1;
				jjright.setText(Integer.toString(true1));
			} else {
				jjudge2.setText("错");
				jjresult2.setText(answer2);
			}
			// 计算第三道题
			String answer3 = null;
			a3 = first3 + second3;
			answer3 = Double.toString(a3);
			String result3 = janswer3.getText();
			if (result3.equals(answer3)) {
				jjudge3.setText("对");
				true1 = true1 + 1;
				jjright.setText(Integer.toString(true1));
			} else {
				jjudge3.setText("错");
				jjresult3.setText(answer3);
			}
			// 计算第四道题
			String answer4 = null;
			a4 = first4 + second4;
			answer4 = Double.toString(a4);
			String result4 = janswer4.getText();
			if (result4.equals(answer4)) {
				jjudge4.setText("对");
				true1 = true1 + 1;
				jjright.setText(Integer.toString(true1));
			} else {
				jjudge4.setText("错");
				jjresult4.setText(answer4);
			}
			// 计算第五道题
			String answer5 = null;
			a5 = first5 + second5;
			answer5 = Double.toString(a5);
			String result5 = janswer5.getText();
			if (result5.equals(answer5)) {
				jjudge5.setText("对");
				true1 = true1 + 1;
				jjright.setText(Integer.toString(true1));
			} else {
				jjudge5.setText("错");
				jjresult5.setText(answer5);
			}
			// 计算第六道题
			String answer6 = null;
			a6 = first6 + second6;
			answer6 = Double.toString(a6);
			String result6 = janswer6.getText();
			if (result6.equals(answer6)) {
				jjudge6.setText("对");
				true1 = true1 + 1;
				jjright.setText(Integer.toString(true1));
			} else {
				jjudge6.setText("错");
				jjresult6.setText(answer6);
			}
			// 计算第七道题
			String answer7 = null;
			a7 = first7 + second7;
			answer7 = Double.toString(a7);
			String result7 = janswer7.getText();
			if (result7.equals(answer7)) {
				jjudge7.setText("对");
				true1 = true1 + 1;
				jjright.setText(Integer.toString(true1));
			} else {
				jjudge7.setText("错");
				jjresult7.setText(answer7);
			}
			// 计算第八道题
			String answer8 = null;
			a8 = first8 + second8;
			answer8 = Double.toString(a8);
			String result8 = janswer8.getText();
			if (result8.equals(answer8)) {
				jjudge8.setText("对");
				true1 = true1 + 1;
				jjright.setText(Integer.toString(true1));
			} else {
				jjudge8.setText("错");
				jjresult8.setText(answer8);
			}
			// 计算第九道题
			String answer9 = null;
			a9 = first9 + second9;
			answer9 = Double.toString(a9);
			String result9 = janswer9.getText();
			if (result9.equals(answer9)) {
				jjudge9.setText("对");
				true1 = true1 + 1;
				jjright.setText(Integer.toString(true1));
			} else {
				jjudge9.setText("错");
				jjresult9.setText(answer9);
			}
			// 计算第十道题
			String answer10 = null;
			a10 = first10 + second10;
			answer10 = Double.toString(a10);
			String result10 = janswer10.getText();
			if (result10.equals(answer10)) {
				jjudge10.setText("对");
				true1 = true1 + 1;
				jjright.setText(Integer.toString(true1));
			} else {
				jjudge10.setText("错");
				jjresult10.setText(answer10);
			}
		}

		/* 减法计算 */
		else if (e.getSource() == SubBtn) {
			flag = 2;
			jsymbol1.setText("-");
			jsymbol2.setText("-");
			jsymbol3.setText("-");
			jsymbol4.setText("-");
			jsymbol5.setText("-");
			jsymbol6.setText("-");
			jsymbol7.setText("-");
			jsymbol8.setText("-");
			jsymbol9.setText("-");
			jsymbol10.setText("-");
			fun();
			random();
		}
		if (e.getSource() == SubmitBtn && flag == 2) {
			double a1_1, a2_1, a3_1, a4_1, a5_1, a6_1, a7_1, a8_1, a9_1, a10_1;
			int true2 = 0;
			// 计算第一道题
			String answer1_1 = null;
			a1_1 = first1 - second1;
			answer1_1 = Double.toString(a1_1);
			String result1_1 = janswer1.getText();
			if (result1_1.equals(answer1_1)) {
				jjudge1.setText("对");
				true2 = true2 + 1;
				jjright.setText(Integer.toString(true2));
			} else {
				jjudge1.setText("错");
				jjresult1.setText(answer1_1);
			}
			// 计算第二道题
			String answer2_1 = null;
			a2_1 = first2 - second2;
			answer2_1 = Double.toString(a2_1);
			String result2_1 = janswer2.getText();
			if (result2_1.equals(answer2_1)) {
				jjudge2.setText("对");
				true2 = true2 + 1;
				jjright.setText(Integer.toString(true2));
			} else {
				jjudge2.setText("错");
				jjresult2.setText(answer2_1);
			}
			// 计算第三道题
			String answer3_1 = null;
			a3_1 = first3 - second3;
			answer3_1 = Double.toString(a3_1);
			String result3_1 = janswer3.getText();
			if (result3_1.equals(answer3_1)) {
				jjudge3.setText("对");
				true2 = true2 + 1;
				jjright.setText(Integer.toString(true2));
			} else {
				jjudge3.setText("错");
				jjresult3.setText(answer3_1);
			}
			// 计算第四道题
			String answer4_1 = null;
			a4_1 = first4 - second4;
			answer4_1 = Double.toString(a4_1);
			String result4_1 = janswer4.getText();
			if (result4_1.equals(answer4_1)) {
				jjudge4.setText("对");
				true2 = true2 + 1;
				jjright.setText(Integer.toString(true2));
			} else {
				jjudge4.setText("错");
				jjresult4.setText(answer4_1);
			}
			// 计算第五道题
			String answer5_1 = null;
			a5_1 = first5 - second5;
			answer5_1 = Double.toString(a5_1);
			String result5_1 = janswer5.getText();
			if (result5_1.equals(answer5_1)) {
				jjudge5.setText("对");
				true2 = true2 + 1;
				jjright.setText(Integer.toString(true2));
			} else {
				jjudge5.setText("错");
				jjresult5.setText(answer5_1);
			}
			// 计算第六道题
			String answer6_1 = null;
			a6_1 = first6 - second6;
			answer6_1 = Double.toString(a6_1);
			String result6_1 = janswer6.getText();
			if (result6_1.equals(answer6_1)) {
				jjudge6.setText("对");
				true2 = true2 + 1;
				jjright.setText(Integer.toString(true2));
			} else {
				jjudge6.setText("错");
				jjresult6.setText(answer6_1);
			}
			// 计算第七道题
			String answer7_1 = null;
			a7_1 = first7 - second7;
			answer7_1 = Double.toString(a7_1);
			String result7_1 = janswer7.getText();
			if (result7_1.equals(answer7_1)) {
				jjudge7.setText("对");
				true2 = true2 + 1;
				jjright.setText(Integer.toString(true2));
			} else {
				jjudge7.setText("错");
				jjresult7.setText(answer7_1);
			}
			// 计算第八道题
			String answer8_1 = null;
			a8_1 = first8 - second8;
			answer8_1 = Double.toString(a8_1);
			String result8_1 = janswer8.getText();
			if (result8_1.equals(answer8_1)) {
				jjudge8.setText("对");
				true2 = true2 + 1;
				jjright.setText(Integer.toString(true2));
			} else {
				jjudge8.setText("错");
				jjresult8.setText(answer8_1);
			}
			// 计算第九道题
			String answer9_1 = null;
			a9_1 = first9 - second9;
			answer9_1 = Double.toString(a9_1);
			String result9_1 = janswer9.getText();
			if (result9_1.equals(answer9_1)) {
				jjudge9.setText("对");
				true2 = true2 + 1;
				jjright.setText(Integer.toString(true2));
			} else {
				jjudge9.setText("错");
				jjresult9.setText(answer9_1);
			}
			// 计算第十道题
			String answer10_1 = null;
			a10_1 = first10 - second10;
			answer10_1 = Double.toString(a10_1);
			String result10_1 = janswer10.getText();
			if (result10_1.equals(answer10_1)) {
				jjudge10.setText("对");
				true2 = true2 + 1;
				jjright.setText(Integer.toString(true2));
			} else {
				jjudge10.setText("错");
				jjresult10.setText(answer10_1);
			}
		}

		/* 乘法计算 */
		else if (e.getSource() == MulBtn) {
			flag = 3;
			jsymbol1.setText("*");
			jsymbol2.setText("*");
			jsymbol3.setText("*");
			jsymbol4.setText("*");
			jsymbol5.setText("*");
			jsymbol6.setText("*");
			jsymbol7.setText("*");
			jsymbol8.setText("*");
			jsymbol9.setText("*");
			jsymbol10.setText("*");
			fun();
			random();
		}
		if (e.getSource() == SubmitBtn && flag == 3) {
			double a1_2, a2_2, a3_2, a4_2, a5_2, a6_2, a7_2, a8_2, a9_2, a10_2;
			int true3 = 0;
			// 计算第一道题
			String answer1_2 = null;
			a1_2 = first1 * second1;
			answer1_2 = Double.toString(a1_2);
			String result1_2 = janswer1.getText();
			if (result1_2.equals(answer1_2)) {
				jjudge1.setText("对");
				true3 = true3 + 1;
				jjright.setText(Integer.toString(true3));
			} else {
				jjudge1.setText("错");
				jjresult1.setText(answer1_2);
			}
			// 计算第二道题
			String answer2_2 = null;
			a2_2 = first2 * second2;
			answer2_2 = Double.toString(a2_2);
			String result2_2 = janswer2.getText();
			if (result2_2.equals(answer2_2)) {
				jjudge2.setText("对");
				true3 = true3 + 1;
				jjright.setText(Integer.toString(true3));
			} else {
				jjudge2.setText("错");
				jjresult2.setText(answer2_2);
			}
			// 计算第三道题
			String answer3_2 = null;
			a3_2 = first3 * second3;
			answer3_2 = Double.toString(a3_2);
			String result3_2 = janswer3.getText();
			if (result3_2.equals(answer3_2)) {
				jjudge3.setText("对");
				true3 = true3 + 1;
				jjright.setText(Integer.toString(true3));
			} else {
				jjudge3.setText("错");
				jjresult3.setText(answer3_2);
			}
			// 计算第四道题
			String answer4_2 = null;
			a4_2 = first4 * second4;
			answer4_2 = Double.toString(a4_2);
			String result4_2 = janswer4.getText();
			if (result4_2.equals(answer4_2)) {
				jjudge4.setText("对");
				true3 = true3 + 1;
				jjright.setText(Integer.toString(true3));
			} else {
				jjudge4.setText("错");
				jjresult4.setText(answer4_2);
			}
			// 计算第五道题
			String answer5_2 = null;
			a5_2 = first5 * second5;
			answer5_2 = Double.toString(a5_2);
			String result5_2 = janswer5.getText();
			if (result5_2.equals(answer5_2)) {
				jjudge5.setText("对");
				true3 = true3 + 1;
				jjright.setText(Integer.toString(true3));
			} else {
				jjudge5.setText("错");
				jjresult5.setText(answer5_2);
			}
			// 计算第六道题
			String answer6_2 = null;
			a6_2 = first6 * second6;
			answer6_2 = Double.toString(a6_2);
			String result6_2 = janswer6.getText();
			if (result6_2.equals(answer6_2)) {
				jjudge6.setText("对");
				true3 = true3 + 1;
				jjright.setText(Integer.toString(true3));
			} else {
				jjudge6.setText("错");
				jjresult6.setText(answer6_2);
			}
			// 计算第七道题
			String answer7_2 = null;
			a7_2 = first7 * second7;
			answer7_2 = Double.toString(a7_2);
			String result7_2 = janswer7.getText();
			if (result7_2.equals(answer7_2)) {
				jjudge7.setText("对");
				true3 = true3 + 1;
				jjright.setText(Integer.toString(true3));
			} else {
				jjudge7.setText("错");
				jjresult7.setText(answer7_2);
			}
			// 计算第八道题
			String answer8_2 = null;
			a8_2 = first8 * second8;
			answer8_2 = Double.toString(a8_2);
			String result8_2 = janswer8.getText();
			if (result8_2.equals(answer8_2)) {
				jjudge8.setText("对");
				true3 = true3 + 1;
				jjright.setText(Integer.toString(true3));
			} else {
				jjudge8.setText("错");
				jjresult8.setText(answer8_2);
			}
			// 计算第九道题
			String answer9_2 = null;
			a9_2 = first9 * second9;
			answer9_2 = Double.toString(a9_2);
			String result9_2 = janswer9.getText();
			if (result9_2.equals(answer9_2)) {
				jjudge9.setText("对");
				true3 = true3 + 1;
				jjright.setText(Integer.toString(true3));
			} else {
				jjudge9.setText("错");
				jjresult9.setText(answer9_2);
			}
			// 计算第十道题
			String answer10_2 = null;
			a10_2 = first10 * second10;
			answer10_2 = Double.toString(a10_2);
			String result10_2 = janswer10.getText();
			if (result10_2.equals(answer10_2)) {
				jjudge10.setText("对");
				true3 = true3 + 1;
				jjright.setText(Integer.toString(true3));
			} else {
				jjudge10.setText("错");
				jjresult10.setText(answer10_2);
			}
		}

		/* 除法计算 */
		else if (e.getSource() == DivBtn) {
			flag = 4;
			jsymbol1.setText("/");
			jsymbol2.setText("/");
			jsymbol3.setText("/");
			jsymbol4.setText("/");
			jsymbol5.setText("/");
			jsymbol6.setText("/");
			jsymbol7.setText("/");
			jsymbol8.setText("/");
			jsymbol9.setText("/");
			jsymbol10.setText("/");
			fun();
			random();
		}
		if (e.getSource() == SubmitBtn && flag == 4) {
			double a1_3, a2_3, a3_3, a4_3, a5_3, a6_3, a7_3, a8_3, a9_3, a10_3;
			int true4 = 0;
			// 计算第一道题
			String answer1_3 = null;
			if (second1 == 0) {
				do {
					random();
				} while (second1 != 0);
			}// 除数为0时的操作
			a1_3 = first1 / second1;
			answer1_3 = String.format("%.2f", a1_3);// 除法结果保留小数点后两位
			String result1_3 = janswer1.getText();
			if (result1_3.equals(answer1_3)) {// 判断输入结果与正确结果是否相等
				jjudge1.setText("对");
				true4 = true4 + 1;
				jjright.setText(Integer.toString(true4));
			} else {
				jjudge1.setText("错");
				jjresult1.setText(answer1_3);
			}
			// 计算第二道题
			String answer2_3 = null;
			if (second1 == 0) {
				do {
					random();
				} while (second1 != 0);
			}
			a2_3 = first2 / second2;
			answer2_3 = String.format("%.2f", a2_3);
			String result2_3 = janswer2.getText();
			if (result2_3.equals(answer2_3)) {
				jjudge2.setText("对");
				true4 = true4 + 1;
				jjright.setText(Integer.toString(true4));
			} else {
				jjudge2.setText("错");
				jjresult2.setText(answer2_3);
			}
			// 计算第三道题
			String answer3_3 = null;
			if (second1 == 0) {
				do {
					random();
				} while (second1 != 0);
			}
			a3_3 = first3 / second3;
			answer3_3 = String.format("%.2f", a3_3);
			String result3_3 = janswer3.getText();
			if (result3_3.equals(answer3_3)) {
				jjudge3.setText("对");
				true4 = true4 + 1;
				jjright.setText(Integer.toString(true4));
			} else {
				jjudge3.setText("错");
				jjresult3.setText(answer3_3);
			}
			// 计算第四道题
			String answer4_3 = null;
			if (second1 == 0) {
				do {
					random();
				} while (second1 != 0);
			}
			a4_3 = first4 / second4;
			answer4_3 = String.format("%.2f", a4_3);
			String result4_3 = janswer4.getText();
			if (result4_3.equals(answer4_3)) {
				jjudge4.setText("对");
				true4 = true4 + 1;
				jjright.setText(Integer.toString(true4));
			} else {
				jjudge4.setText("错");
				jjresult4.setText(answer4_3);
			}
			// 计算第五道题
			String answer5_3 = null;
			if (second1 == 0) {
				do {
					random();
				} while (second1 != 0);
			}
			a5_3 = first5 / second5;
			answer5_3 = String.format("%.2f", a5_3);
			String result5_3 = janswer5.getText();
			if (result5_3.equals(answer5_3)) {
				jjudge5.setText("对");
				true4 = true4 + 1;
				jjright.setText(Integer.toString(true4));
			} else {
				jjudge5.setText("错");
				jjresult5.setText(answer5_3);
			}
			// 计算第六道题
			String answer6_3 = null;
			if (second1 == 0) {
				do {
					random();
				} while (second1 != 0);
			}
			a6_3 = first6 / second6;
			answer6_3 = String.format("%.2f", a6_3);
			String result6_3 = janswer6.getText();
			if (result6_3.equals(answer6_3)) {
				jjudge6.setText("对");
				true4 = true4 + 1;
				jjright.setText(Integer.toString(true4));
			} else {
				jjudge6.setText("错");
				jjresult6.setText(answer6_3);
			}
			// 计算第七道题
			String answer7_3 = null;
			if (second1 == 0) {
				do {
					random();
				} while (second1 != 0);
			}
			a7_3 = first7 / second7;
			answer7_3 = String.format("%.2f", a7_3);
			String result7_3 = janswer7.getText();
			if (result7_3.equals(answer7_3)) {
				jjudge7.setText("对");
				true4 = true4 + 1;
				jjright.setText(Integer.toString(true4));
			} else {
				jjudge7.setText("错");
				jjresult7.setText(answer7_3);
			}
			// 计算第八道题
			String answer8_3 = null;
			if (second1 == 0) {
				do {
					random();
				} while (second1 != 0);
			}
			a8_3 = first8 / second8;
			answer8_3 = String.format("%.2f", a8_3);
			String result8_3 = janswer8.getText();
			if (result8_3.equals(answer8_3)) {
				jjudge8.setText("对");
				true4 = true4 + 1;
				jjright.setText(Integer.toString(true4));
			} else {
				jjudge8.setText("错");
				jjresult8.setText(answer8_3);
			}
			// 计算第九道题
			String answer9_3 = null;
			if (second1 == 0) {
				do {
					random();
				} while (second1 != 0);
			}
			a9_3 = first9 / second9;
			answer9_3 = String.format("%.2f", a9_3);
			String result9_3 = janswer9.getText();
			if (result9_3.equals(answer9_3)) {
				jjudge9.setText("对");
				true4 = true4 + 1;
				jjright.setText(Integer.toString(true4));
			} else {
				jjudge9.setText("错");
				jjresult9.setText(answer9_3);
			}
			// 计算第十道题
			String answer10_3 = null;
			if (second1 == 0) {
				do {
					random();
				} while (second1 != 0);
			}
			a10_3 = first10 / second10;
			answer10_3 = String.format("%.2f", a10_3);
			String result10_3 = janswer10.getText();
			if (result10_3.equals(answer10_3)) {
				jjudge10.setText("对");
				true4 = true4 + 1;
				jjright.setText(Integer.toString(true4));
			} else {
				jjudge10.setText("错");
				jjresult10.setText(answer10_3);
			}
		} else if (e.getSource() == ExitBtn) {
			System.exit(0);
		}
	}

	public void judge1(String result, String answer, int true1) {
		if (result.equals(answer)) {
			jjudge1.setText("对");
			true1 = true1 + 1;
		} else {
			jjudge1.setText("错");
			jjresult1.setText(answer);// 显示正确结果
		}
	}

	/* 将十个题分别的第一个数和第二个数置为空，将答对题数置为“？” */
	public void fun() {
		janswer1.setText("");
		janswer2.setText("");
		janswer3.setText("");
		janswer4.setText("");
		janswer5.setText("");
		janswer6.setText("");
		janswer7.setText("");
		janswer8.setText("");
		janswer9.setText("");
		janswer10.setText("");
		jjresult1.setText("");
		jjresult2.setText("");
		jjresult3.setText("");
		jjresult4.setText("");
		jjresult5.setText("");
		jjresult6.setText("");
		jjresult7.setText("");
		jjresult8.setText("");
		jjresult9.setText("");
		jjresult10.setText("");
		jjright.setText("0");
	}

	/* 产生十道题分别第一个数和第二个数的随机数 */
	public void random() {
		Random rand = new Random();

		first1 = rand.nextInt(200);
		first1 = first1 - 100;
		second1 = rand.nextInt(200);
		second1 = second1 - 100;
		if (first1 < 0) {
			String f1 = Float.toString(first1);
			jfirst1.setText("(" + f1 + ")");
		} else {
			String f1 = Float.toString(first1);
			jfirst1.setText(f1);
		}
		if (second1 < 0) {
			String s1 = Float.toString(second1);
			jsecond1.setText("(" + s1 + ")");
		} else {
			String s1 = Float.toString(second1);
			jsecond1.setText(s1);
		}

		first2 = rand.nextInt(200);
		first2 = first2 - 100;
		second2 = rand.nextInt(200);
		second2 = second2 - 100;
		if (first2 < 0) {
			String f2 = Float.toString(first2);
			jfirst2.setText("(" + f2 + ")");
		} else {
			String f2 = Float.toString(first2);
			jfirst2.setText(f2);
		}
		if (second2 < 0) {
			String s2 = Float.toString(second2);
			jsecond2.setText("(" + s2 + ")");
		} else {
			String s2 = Float.toString(second2);
			jsecond2.setText(s2);
		}

		first3 = rand.nextInt(200);
		first3 = first3 - 100;
		second3 = rand.nextInt(200);
		second3 = second3 - 100;
		if (first3 < 0) {
			String f3 = Float.toString(first3);
			jfirst3.setText("(" + f3 + ")");
		} else {
			String f3 = Float.toString(first3);
			jfirst3.setText(f3);
		}
		if (second3 < 0) {
			String s3 = Float.toString(second3);
			jsecond3.setText("(" + s3 + ")");
		} else {
			String s3 = Float.toString(second3);
			jsecond3.setText(s3);
		}

		first4 = rand.nextInt(200);
		first4 = first4 - 100;
		second4 = rand.nextInt(200);
		second4 = second4 - 100;
		if (first4 < 0) {
			String f4 = Float.toString(first4);
			jfirst4.setText("(" + f4 + ")");
		} else {
			String f4 = Float.toString(first4);
			jfirst4.setText(f4);
		}
		if (second4 < 0) {
			String s4 = Float.toString(second4);
			jsecond4.setText("(" + s4 + ")");
		} else {
			String s4 = Float.toString(second4);
			jsecond4.setText(s4);
		}

		first5 = rand.nextInt(200);
		first5 = first5 - 100;
		second5 = rand.nextInt(200);
		second5 = second5 - 100;
		if (first5 < 0) {
			String f5 = Float.toString(first5);
			jfirst5.setText("(" + f5 + ")");
		} else {
			String f5 = Float.toString(first5);
			jfirst5.setText(f5);
		}
		if (second5 < 0) {
			String s5 = Float.toString(second5);
			jsecond5.setText("(" + s5 + ")");
		} else {
			String s5 = Float.toString(second5);
			jsecond5.setText(s5);
		}

		first6 = rand.nextInt(200);
		first6 = first6 - 100;
		second6 = rand.nextInt(200);
		second6 = second6 - 100;
		if (first6 < 0) {
			String f6 = Float.toString(first6);
			jfirst6.setText("(" + f6 + ")");
		} else {
			String f6 = Float.toString(first6);
			jfirst6.setText(f6);
		}
		if (second6 < 0) {
			String s6 = Float.toString(second6);
			jsecond6.setText("(" + s6 + ")");
		} else {
			String s6 = Float.toString(second6);
			jsecond6.setText(s6);
		}

		first7 = rand.nextInt(200);
		first7 = first7 - 100;
		second7 = rand.nextInt(200);
		second7 = second7 - 100;
		if (first7 < 0) {
			String f7 = Float.toString(first7);
			jfirst7.setText("(" + f7 + ")");
		} else {
			String f7 = Float.toString(first7);
			jfirst7.setText(f7);
		}
		if (second7 < 0) {
			String s7 = Float.toString(second7);
			jsecond7.setText("(" + s7 + ")");
		} else {
			String s7 = Float.toString(second7);
			jsecond7.setText(s7);
		}

		first8 = rand.nextInt(200);
		first8 = first8 - 100;
		second8 = rand.nextInt(200);
		second8 = second8 - 100;
		if (first8 < 0) {
			String f8 = Float.toString(first8);
			jfirst8.setText("(" + f8 + ")");
		} else {
			String f8 = Float.toString(first8);
			jfirst8.setText(f8);
		}
		if (second8 < 0) {
			String s8 = Float.toString(second8);
			jsecond8.setText("(" + s8 + ")");
		} else {
			String s8 = Float.toString(second8);
			jsecond8.setText(s8);
		}

		first9 = rand.nextInt(200);
		first9 = first9 - 100;
		second9 = rand.nextInt(200);
		second9 = second9 - 100;
		if (first9 < 0) {
			String f9 = Float.toString(first9);
			jfirst9.setText("(" + f9 + ")");
		} else {
			String f9 = Float.toString(first9);
			jfirst9.setText(f9);
		}
		if (second9 < 0) {
			String s9 = Float.toString(second9);
			jsecond9.setText("(" + s9 + ")");
		} else {
			String s9 = Float.toString(second9);
			jsecond9.setText(s9);
		}

		first10 = rand.nextInt(200);
		first10 = first10 - 100;
		second10 = rand.nextInt(200);
		second10 = second10 - 100;
		if (first10 < 0) {
			String f10 = Float.toString(first10);
			jfirst10.setText("(" + f10 + ")");
		} else {
			String f10 = Float.toString(first10);
			jfirst10.setText(f10);
		}
		if (second10 < 0) {
			String s10 = Float.toString(second10);
			jsecond10.setText("(" + s10 + ")");
		} else {
			String s10 = Float.toString(second10);
			jsecond10.setText(s10);
		}
	}
}
