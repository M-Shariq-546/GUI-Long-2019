import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main class
class Long19 {

    // Main driver method
    public static void main(String[] args) {
        JFrame frame = new JFrame(); // creating instance of JFrame
        JLabel sname = new JLabel("Student Name :");
        sname.setBounds(100, 50, 220, 50);
        JTextField snamef = new JTextField();
        snamef.setBounds(100, 100, 220, 50);

        JLabel cgpa = new JLabel("CGPA :");
        cgpa.setBounds(100, 150, 220, 50);
        JTextField cgpaf = new JTextField();
        cgpaf.setBounds(100, 200, 220, 50);

        JLabel semester = new JLabel("Semester :");
        semester.setBounds(100, 250, 220, 50);
        JTextField semesterN = new JTextField();
        semesterN.setBounds(100, 300, 220, 50);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(100, 350, 220, 50);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(330, 350, 100, 50);

        frame.add(submitButton);
        frame.add(cancelButton);
        frame.add(sname);
        frame.add(snamef);
        frame.add(cgpa);
        frame.add(cgpaf);
        frame.add(semester);
        frame.add(semesterN);
        frame.setSize(500, 600);
        frame.setLayout(null);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the entered data
                String studentName = snamef.getText();
                String cgpaValue = cgpaf.getText();
                String semesterValue = semesterN.getText();

                // Save the data to a text file
                try (FileWriter fw = new FileWriter("studentData.txt", true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {

                    out.println("Student Name: " + studentName + ", CGPA: " + cgpaValue + ", Semester: " + semesterValue);
                    JOptionPane.showMessageDialog(frame, "Data saved successfully!");

                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error saving data!");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the program
                System.exit(0);
            }
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
