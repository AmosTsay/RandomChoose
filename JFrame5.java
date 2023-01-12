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
        this.setTitle("���������");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setLayout(new BorderLayout());
    }
    //��������˵����֣�ÿ������һ����ť�������˷���Ҫ���롰throws Exception����䣬��Ȼ������InputSteamReader�ᱨ���޷�����
    private void initCenter() throws Exception{
        center = new JPanel();
        center.setLayout(new FlowLayout(FlowLayout.LEADING));

        for (int i = 1; i <=5; i++) {
            JButton jb = new JButton("��seven"+i);
            jb.setBackground(new Color(0x3765EE));
            center.add(jb);
            System.out.println("��������");
        }

        /**
         *  �������ڲ�ѭ����ӿ��Խ�����淽�����ⲿ�������Ԫ��
         * ���Գɹ�����Ч������?ǿ?��
         */


        InputStreamReader reader = new InputStreamReader(JFrame5.class.getClassLoader().getResourceAsStream("HelloSoccer.txt"),"UTF-8");
        BufferedReader br = new BufferedReader(reader);
        String name;
        //�Ȱ�readLine������ȡ�����ݸ�ֵ��name��Ȼ�����ж��Ƿ�Ϊ��
        //whileѭ���ڳ��������жϵ�����¿��Գ��������´�ѭ���壬Ҫ����forѭ�����޴β���������˵��ͬ��
        while((name = br.readLine())!=null){
            JButton jb = new JButton(name);
            //���ó�ʼ���
            jb.setBackground(Color.CYAN);
            center.add(jb);
        }
        //�ر���Stream����,û�йر��ƺ�Ҳ������������
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


    //�齱��ť�����ܵ�ʵ��
    private void initSouth(){
        JPanel st = new JPanel();
        JButton jb = new JButton("�齱��");
        Random r = new Random(1);
        jb.addActionListener(
                //����������ÿ�ε���ֻʵ��һ��
                new ActionListener() {
            //ע��˽�л� �������Component
            private  Component comp = null;
            @Override
            public void actionPerformed(ActionEvent e) {
                //���ȣ��Ѹղų鵽���Ǹ���ť����ɫ��ԭ��ȥ�� ��ȡ�ղų鵽�İ�ť
                if(comp != null) {
                    comp.setForeground(Color.BLACK);
                    comp.setBackground(Color.cyan);
                }
                    //��ȡcenter�������е�������Ϣ
                    Component[] names = center.getComponents();
                    //�����ȡ����
                    int index = r.nextInt(names.length);
                    comp = names[index];
                    //��ȡ�鵽�İ�ť
                    comp.setForeground(Color.RED);
                    comp.setBackground(Color.BLACK);
                    comp.setFont(new Font("����",Font.ITALIC,15));

            }
        });
        st.add(jb);
        //ĩβ����ӵ�λ�ò�����Ҫ���
        this.add(st,BorderLayout.SOUTH);

        this.setVisible(true);
    }
    //�������������ӡ�throws Exception�� ʵ��������ʱ�ᱨ��!
    public static void main (String[] args) throws Exception{
        //��Ҫ���ǣ�ʵ��������
        JFrame5 jf5 = new JFrame5 ();
/*�����������ļ��������ݣ���������ֻ��Ҫʵ��������Ϳ���ʵ��
        ArrayList<String> al = new ArrayList<>();
        for (int i = 1; i <=20; i++) {
            al.add("��"+i);
        }
            Random r = new Random();
            //int anInt = r.nextInt(100);
            int index = r.nextInt(20);
            System.out.println(al.get(index));

 */
    }
}
