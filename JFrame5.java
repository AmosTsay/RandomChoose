import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class JFrame5 extends JFrame {
    private JPanel center;
    public JFrame5() throws Exception{
        init();
        initCenter();
        initSouth();
        this.setVisible(true);
    }

    private void init(){
        this.setSize(600,400);
        //jf.setLocation(450,200);
        this.setLocationRelativeTo(null);
        this.setTitle("随机点名器");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setLayout(new BorderLayout());
    }
    //添加所有人的名字，每个都是一个按钮，，，此方法要加入“throws Exception”语句，不然方法体InputSteamReader会报错，无法运行
    private void initCenter() throws Exception{
        center = new JPanel();
        center.setLayout(new FlowLayout(FlowLayout.LEADING));

        for (int i = 1; i <=5; i++) {
            JButton jb = new JButton("蔡seven"+i);
            jb.setBackground(new Color(0x3765EE));
            center.add(jb);
            System.out.println("隔断了吗");
        }

        /**
         *  上面再内部循环添加可以结合下面方法的外部引用添加元素
         * 可以成功呈现效果！（?强?）
         */


        InputStreamReader reader = new InputStreamReader(JFrame5.class.getClassLoader().getResourceAsStream("HelloSoccer.txt"),"UTF-8");
        BufferedReader br = new BufferedReader(reader);
        String name;
        //先把readLine方法获取的数据赋值给name，然后再判断是否为空
        //while循环在充足条件判断的情况下可以持续开启下次循环体，要好于for循环的限次操作（或者说不同）
        while((name = br.readLine())!=null){
            JButton jb = new JButton(name);
            //设置初始外观
            jb.setBackground(Color.CYAN);
            center.add(jb);
        }
        //关闭流Stream操作,没有关闭似乎也可以正常运行
        //br.close();
        this.add(center,BorderLayout.CENTER);
        System.out.println();
        System.out.println();
        for (int i = 1; i <=3; i++) {
            JButton jb = new JButton(i+"Football"+i);
            jb.setBackground(new Color(0xCE21B8));
            center.add(jb);
        }
    }


    //抽奖按钮及功能的实现
    private void initSouth(){
        JPanel st = new JPanel();
        JButton jb = new JButton("抽奖啦");
        Random r = new Random(1);
        jb.addActionListener(
                //监听器对象每次调用只实现一次
                new ActionListener() {
            //注意私有化 组件对象Component
            private  Component comp = null;
            @Override
            public void actionPerformed(ActionEvent e) {
                //首先，把刚才抽到的那个按钮的颜色还原回去， 获取刚才抽到的按钮
                if(comp != null) {
                    comp.setForeground(Color.BLACK);
                    comp.setBackground(Color.cyan);
                }
                    //获取center里面所有的数据信息
                    Component[] names = center.getComponents();
                    //随机抽取数据
                    int index = r.nextInt(names.length);
                    comp = names[index];
                    //获取抽到的按钮
                    comp.setForeground(Color.RED);
                    comp.setBackground(Color.BLACK);
                    comp.setFont(new Font("楷体",Font.ITALIC,15));

            }
        });
        st.add(jb);
        //末尾处添加的位置参数不要搞错
        this.add(st,BorderLayout.SOUTH);

        this.setVisible(true);
    }
    //主方法后若不加”throws Exception“ 实例化对象时会报错!
    public static void main (String[] args) throws Exception{
        //不要忘记，实例化对象啊
        JFrame5 jf5 = new JFrame5 ();
/*若不从其他文件引入数据，那主方法只需要实例化对象就可以实现
        ArrayList<String> al = new ArrayList<>();
        for (int i = 1; i <=20; i++) {
            al.add("蔡"+i);
        }
            Random r = new Random();
            //int anInt = r.nextInt(100);
            int index = r.nextInt(20);
            System.out.println(al.get(index));

 */
    }
}
