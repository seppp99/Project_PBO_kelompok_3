import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaSwing {
    public static void main(String[] args) {

        //Bagian Label ini buat cout
        JLabel label = new JLabel("ADMINISTRASI  MAHASISWA");
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
        frame.setSize(350,150);

        frame.getContentPane().add(label);
        frame.getContentPane().setLayout(new BorderLayout()); // ini yang buat text di tengah atas
        frame.getContentPane().add(label, BorderLayout.NORTH); // ini juga sama


        //Custom WARNA Framenya...
        frame.getContentPane().setBackground(new Color(255, 240, 220));

        //Membuat bagian JPanel nih bang yang ini
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255,240,220));
        panel.add(label);
        frame.add(panel, BorderLayout.NORTH);

        //yang ini bagian JButton bang buat event listener (kayak klik gitu lah)
        JButton tombol = new JButton("CLICK ME!!");
        tombol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tampilkanMenu(); // biar nyambung sama yang switch case dibawah
            }
        });

        JPanel panelTombol = new JPanel();
        frame.add(panelTombol, BorderLayout.CENTER);
        panel.setBackground(new Color(255,240,220));
        panelTombol.add(tombol);
        frame.setVisible(true);

        }

    public static void tampilkanMenu(){
        String[] pilihan = {"1. Lihat Daftar program Studi", "2. Lihat daftar Mahasiswa", "3. Lihat daftar Mata Kuliah", "4. Tambah mahasiswa ke mata kuliah", "5. Batal Mahasiswa dari Mata Kuliah", "6. Exit"};
        int pilih = JOptionPane.showOptionDialog(
                null,
                "Pilih Menu : ",
                "Menu utama",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                pilihan,
                pilihan[0]
        );

        switch(pilih){
            case 0:
            JOptionPane.showMessageDialog(null, "Anda memilih opsi 1");
            //override class mu disini kawan
            break;
            case 1:
                JOptionPane.showMessageDialog(null, "Anda memilih opsi 2");
                //override class mu disini kawan
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Anda memilih opsi 3");
                //override class mu disini kawan
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Anda memilih opsi 4");
                //override class mu disini kawan
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Anda memilih opsi 5");
                //override class mu disini kawan
                break;
            case 5:
            JOptionPane.showMessageDialog(null, "EXIT.....");
                break;
            default:
                System.out.println("Input not valid");

        }
    }
}
