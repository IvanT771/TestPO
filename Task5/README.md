## Исходная программа

```java
1: package Task5.src;
2: 
3: import javax.swing.*;
4: import java.awt.event.*;
5: import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
6: 
7: class MyFrame extends JFrame implements ItemListener{
8: 
9:     private JComboBox CB;
10:     private JButton B;
11:     private JLabel L;
12:     private String[] animals = new String[]{"Принтер", "Сканер", "Телефон", "Планшет"};
13:     private String[] files = new String[]{"printer.jpg", "scaner.jpg", "телефон.jpg", "планшет.jpg"};
14:     private String path = "c:\\Users\\Dudrrillo\\Documents\\РиСИСиИТ\\books\\pictures";
15:     private ImageIcon[] imgs;
16: 
17:     MyFrame() {
18:         super("Раскрывающийся список");
19:         setBounds(250, 250, 400, 300);
20:         setDefaultCloseOperation(EXIT_ON_CLOSE);
21:         setResizable(false);
22:         setLayout(null);;
23:         imgs = new ImageIcon[files.length];
24:         for(int k = 1; k < imgs.length; k++) {
25:             imgs[k] = new ImageIcon(path + "\\" + files[k]);
26:         }
27:         L = new JLabel(imgs[0]);
28:         L.setBounds(1, 20, 250, 20);
29:         add(L);
30:         JLabel lbl = new JLabel("Сделайте выбор");
31:         lbl.setBounds(260, 10, 120, 120);
32:         add(lbl);
33:         CB = new JComboBox(animals);
34:         CB.setBounds(260, 40, 120, 30);
35:         CB.setSelectedIndex(0);
36:         CB.addItemListener(this);
37:         add(CB);
38:         B = new JButton("OK");
39:         B.setBounds(260, 80, 120, 30);
40:         B.addActionListener(e->System.exit(0));
41:         add(B);
42:         setVisible(true);
43:     }
44: 
45:     public void itemStateChanged(ItemEvent e) {
46:         if (e.getStateChange() == ItemEvent.SELECTED) {
47:             int selectedIndex = CB.getSelectedIndex();
48:             if (selectedIndex > 0 && selectedIndex < files.length) {
49:                 L.setIcon(new ImageIcon(path + "\\" + files[selectedIndex]));
50:             }
51:         }
52:     }
53: 
54:     public static void main(String[] args) {
55:         SwingUtilities.invokeLater(() -> new MyFrame());
56:     }
57: }
```

### Найденные ошибки в программе 

| Строка | Описание ошибки                                  | Тип ошибки                                                        |
| ------ | ------------------------------------------------ | ----------------------------------------------------------------- |
| **13** | Возможные неверные имена файлов.                 | Логическая / ошибка данных                                        |
| **22** | Лишняя точка с запятой `;`.                      | Синтаксическая                                                    |
| **24** | Цикл начинается с `1` вместо `0`.                | Логическая                                                        |
| **27** | Используется `imgs[0]`, который не был загружен. | Логическая / использование неинициализированного элемента массива |
| **28** | Неправильная высота области изображения.         | Логическая / ошибка интерфейса                                    |
| **48** | Условие должно допускать индекс `0`.             | Логическая                                                        |

### Исправленые ошибки

```java
1: package Task5.src;
2: 
3: import javax.swing.*;
4: import java.awt.event.*;
5: import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
6: 
7: class MyFrame extends JFrame implements ItemListener {
8: 
9:     private JComboBox CB;
10:     private JButton B;
11:     private JLabel L;
12:     private String[] animals = new String[]{"Принтер", "Сканер", "Телефон", "Планшет"};
13:     private String[] files = new String[]{"printer.jpg", "scaner.jpg", "телефон.jpg", "планшет.jpg"};
14:     private String path = System.getProperty("user.dir") + "\\" + "pictures";
15:     private ImageIcon[] imgs;
16: 
17:     MyFrame() {
18:         super("Раскрывающийся список");
19:         setBounds(250, 250, 400, 300);
20:         setDefaultCloseOperation(EXIT_ON_CLOSE);
21:         setResizable(false);
22:         setLayout(null);
23:         imgs = new ImageIcon[files.length];
24:         for(int k = 0; k < imgs.length; k++) {
25:             imgs[k] = new ImageIcon(path + "\\" + files[k]);
26:         }
27:         L = new JLabel(imgs[0]);
28:         L.setBounds(1, 20, 250, 200);
29:         add(L);
30:         JLabel lbl = new JLabel("Сделайте выбор");
31:         lbl.setBounds(260, 10, 120, 120);
32:         add(lbl);
33:         CB = new JComboBox(animals);
34:         CB.setBounds(260, 40, 120, 30);
35:         CB.setSelectedIndex(0);
36:         CB.addItemListener(this);
37:         add(CB);
38:         B = new JButton("OK");
39:         B.setBounds(260, 80, 120, 30);
40:         B.addActionListener(e->System.exit(0));
41:         add(B);
42:         setVisible(true);
43:     }
44: 
45:     public void itemStateChanged(ItemEvent e) {
46:         if (e.getStateChange() == ItemEvent.SELECTED) {
47:             int selectedIndex = CB.getSelectedIndex();
48:             if (selectedIndex >= 0 && selectedIndex < files.length) {
49:                 L.setIcon(new ImageIcon(path + "\\" + files[selectedIndex]));
50:             }
51:         }
52:     }
53: 
54:     public static void main(String[] args) {
55:         SwingUtilities.invokeLater(() -> new MyFrame());
56:     }
57: }
```

## Метрика Джилба 
### Подсчет операторов в программе

| Параметр | Значение | Описание |
|---|---|---|
| L | 31 | Общее количество операторов программы |
| Lif | 2 | Количество условных операторов (`if`) |
| Lwl | 1 | Количество итерационных операторов (`for`) |

### Абсолютная сложность программы

| Параметр | Формула | Значение |
|---|---|---|
| CL | Lif + Lwl | 2 + 1 = **3** |

### Относительная сложность программы

| Параметр | Формула | Значение |
|---|---|---|
| cl | CL / L | 3 / 31 | **0.09677** |

## Метрика Чепина 

### Классификация переменных программы

| Тип | Переменные | Количество | Описание |
|---|---|---|---|
| P | e, args | 2 | Вводимые переменные (параметры методов) |
| M | CB, B, L, animals, files, path, imgs | 7 | Модифицируемые или создаваемые в программе |
| C | k, selectedIndex | 2 | Переменные, управляющие выполнением программы |
| T | lbl | 1 | Временные переменные |

### Подсчет параметров

| Параметр | Значение |
| -------- | -------- |
| P        | 2        |
| M        | 7        |
| C        | 2        |
| T        | 1        |

### Формула метрики Чепина

Q = P + 2 × M + 3 × C + 0.5 × T
### Расчет

Q = 2 + 2 × 7 + 3 × 2 + 0.5 × 1

Q = 2 + 14 + 6 + 0.5

Q = **22.5**
### Результат

| Метрика | Значение |
| ------- | -------- |
| Q       | **22.5** |
## Метрики Холстеда 

### Операторы

| j | Оператор | f₁j |
|---|---|---:|
| 1 | `=` | 11 |
| 2 | `[]` | 11 |
| 3 | `()` | 37 |
| 4 | `>=` | 1 |
| 5 | `<` | 2 |
| 6 | `==` | 1 |
| 7 | `;` | 35 |
| 8 | `++` | 1 |
| 9 | `{}` | 9 |
| 10 | `.` | 17 |
| 11 | `new` | 10 |
| 12 | `for` | 1 |
| 13 | `if` | 2 |
| 14 | `&&` | 1 |
| 15 | `->` | 2 |
| 16 | `+` | 6 |

**Итого**

| Параметр | Значение |
|---|---:|
| n₁ | 16 |
| N₁ | 147 |
### Операнды

| i | Операнд | f₂j |
|---|---|---:|
| 1 | `CB` | 7 |
| 2 | `B` | 5 |
| 3 | `L` | 5 |
| 4 | `animals` | 2 |
| 5 | `files` | 5 |
| 6 | `path` | 3 |
| 7 | `imgs` | 5 |
| 8 | `k` | 5 |
| 9 | `lbl` | 3 |
| 10 | `selectedIndex` | 4 |
| 11 | `e` | 3 |
| 12 | `args` | 1 |
| 13 | `EXIT_ON_CLOSE` | 1 |
| 14 | `null` | 1 |
| 15 | `false` | 1 |
| 16 | `true` | 1 |
| 17 | `ItemEvent.SELECTED` | 1 |
| 18 | `SwingUtilities` | 1 |
| 19 | `MyFrame` | 2 |
| 20 | `0` | 5 |
| 21 | `1` | 1 |
| 22 | `10` | 1 |
| 23 | `20` | 1 |
| 24 | `30` | 2 |
| 25 | `40` | 1 |
| 26 | `80` | 1 |
| 27 | `120` | 4 |
| 28 | `200` | 1 |
| 29 | `250` | 3 |
| 30 | `260` | 3 |
| 31 | `300` | 1 |
| 32 | `400` | 1 |
| 33 | `"Раскрывающийся список"` | 1 |
| 34 | `"Принтер"` | 1 |
| 35 | `"Сканер"` | 1 |
| 36 | `"Телефон"` | 1 |
| 37 | `"Планшет"` | 1 |
| 38 | `"printer.jpg"` | 1 |
| 39 | `"scaner.jpg"` | 1 |
| 40 | `"телефон.jpg"` | 1 |
| 41 | `"планшет.jpg"` | 1 |
| 42 | `"user.dir"` | 1 |
| 43 | `"\\"` | 3 |
| 44 | `"pictures"` | 1 |
| 45 | `"Сделайте выбор"` | 1 |
| 46 | `"OK"` | 1 |

**Итого**

| Параметр | Значение |
| -------- | -------: |
| n₂       |       46 |
| N₂       |       97 |
### Основные метрики Холстеда

| Метрика | Формула | Значение |
|---|---|---:|
| Словарь программы | `n = n₁ + n₂` | 62 |
| Длина программы | `N = N₁ + N₂` | 244 |
| Объём программы | `V = N · log₂(n)` | 1452.82 |
| Сложность программы | `D = (n₁ / 2) · (N₂ / n₂)` | 16.87 |
| Трудоёмкость | `E = D · V` | 24508.51 |
### Сводка метрик по Холстеду

| Метрика                     | Формула                              | Значение                                   |
| --------------------------- | ------------------------------------ | ------------------------------------------ |
| Оценка длины программы      | `N^ = n₁ × log₂(n₁) + n₂ × log₂(n₂)` | 16 × log₂(16) + 46 × log₂(46) ≈ **318.08** |
| Объём программы             | `V = N × log₂(n)`                    | 244 × log₂(62) ≈ **1452.82**               |
| Уровень реализации          | `L = (2 × n₂) / (n₁ × N₂)`           | (2 × 46) / (16 × 97) ≈ **0.0593**          |
| Трудоёмкость реализации     | `E = D × V`                          | 16.87 × 1452.82 ≈ **24508.51**             |
| Интеллектуальное содержание | `I = L × V`                          | 0.0593 × 1452.82 ≈ **86.12**               |
