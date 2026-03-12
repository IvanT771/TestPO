package Task5.src;

import javax.swing.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class MyFrame2 extends JFrame implements ItemListener{

    private JComboBox CB;
    private JButton B;
    private JLabel L;
    private String[] animals = new String[]{"Принтер", "Сканер", "Телефон", "Планшет"};
    private String[] files = new String[]{"printer.jpg", "scaner.jpg", "телефон.jpg", "планшет.jpg"}; // Ошибка: вероятно неверные имена файлов по сравнению с правильным листингом ("telephone.jpg", "planshet.jpg"). Тип ошибки: логическая / ошибка данных.
    private String path = "c:\\Users\\Dudrrillo\\Documents\\РиСИСиИТ\\books\\pictures";
    private ImageIcon[] imgs;

    MyFrame2() {
        super("Раскрывающийся список");
        setBounds(250, 250, 400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);; // Ошибка: лишняя точка с запятой. Тип ошибки: синтаксическая (избыточный символ, хотя компиляции обычно не мешает).
        imgs = new ImageIcon[files.length];
        for(int k = 1; k < imgs.length; k++) { // Ошибка: цикл начинается с 1, поэтому imgs[0] не инициализируется. Тип ошибки: логическая.
            imgs[k] = new ImageIcon(path + "\\" + files[k]);
        }
        L = new JLabel(imgs[0]); // Ошибка: imgs[0] не был загружен из-за ошибки в строке 24. Тип ошибки: логическая / использование неинициализированного элемента массива.
        L.setBounds(1, 20, 250, 20); // Ошибка: слишком маленькая высота области для изображения, на правильном листинге 200. Тип ошибки: логическая / ошибка интерфейса.
        add(L);
        JLabel lbl = new JLabel("Сделайте выбор");
        lbl.setBounds(260, 10, 120, 120);
        add(lbl);
        CB = new JComboBox(animals);
        CB.setBounds(260, 40, 120, 30);
        CB.setSelectedIndex(0);
        CB.addItemListener(this);
        add(CB);
        B = new JButton("OK");
        B.setBounds(260, 80, 120, 30);
        B.addActionListener(e->System.exit(0));
        add(B);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            int selectedIndex = CB.getSelectedIndex();
            if (selectedIndex > 0 && selectedIndex < files.length) { // Ошибка: индекс 0 исключён, первый элемент списка никогда не обработается. Тип ошибки: логическая.
                L.setIcon(new ImageIcon(path + "\\" + files[selectedIndex]));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyFrame2());
    }
}