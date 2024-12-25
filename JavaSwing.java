import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;

public class JavaSwing {
    public static void main(String[] args) {

        //Bagian Label ini buat cout
        JLabel label = new JLabel();
        label.setText("ADMINISTRASI  MAHASISWA");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(19, 16, 16));
        label.setFont(new Font("Courier New",Font.PLAIN,20));


        // Bagian Kerangka Frame
        JFrame frame = new JFrame();
        frame.setTitle("Project Kelompok ?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(750,500);
        frame.setVisible(true);
        frame.getContentPane().add(label);
        frame.getContentPane().setLayout(new BorderLayout()); // ini yang buat text di tengah atas
        frame.getContentPane().add(label, BorderLayout.NORTH); // ini juga sama

        
        //Custom WARNA Framenya...
        frame.getContentPane().setBackground(new Color(255, 240, 220));

        //Besok ku lanjutin lagi... ini JButton nya belum masih kerangka awal, kalau warna kurang suka kasih tau yoo biar tak ganti warnanya....
    }
}
