import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//render the gui Components(frontend)
// this class will inherit from th Jframe Class
public class PasswordGeneratorGUI extends JFrame {
    private PasswordGenerator passwordGenerator;

    public PasswordGeneratorGUI() {
        //render frame and add a title
        super("Password Generator");

        //set the size oh the GUi
        setSize(540,570);

        //prevent GUI from being able to resized
        setResizable(false);

        // we will set the layout to be null to have control over the position and sizez or ouf components in our app
        setLayout(null);

        // terminate the program when the GUi is closed (end the process)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // center the GUI to the screen
        setLocationRelativeTo(null);

        //init password generator
        passwordGenerator = new PasswordGenerator();

        // render GUI components
        addGuiComponent();
    }

    private void addGuiComponent() {
        // creat title tex t
        JLabel titleLabel = new JLabel("Password Generator");

        //increase the font size and make it bold
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));

        //center the text to the screen
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // set x,y coordinates and widh/height values
        titleLabel.setBounds(0,10,540,39);

        // add the GUI
        add(titleLabel);

        // create result text area
        JTextArea passwordOutput = new JTextArea();

        // prevent aditing the text area
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog",Font.BOLD,32));

        // add scrolllability in case output becomes too big
        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25,97,478,70);

        // create a black border around the text area
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);

        // creat password  lenght label
        JLabel passwordLengthLabel = new JLabel("Password Length");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25,215,272,39);
        add(passwordLengthLabel);

        //creat password length input
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog",Font.PLAIN,32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(310,215,192,39);
        add(passwordLengthInputArea);

        //creae toggle buttons
        //uperCase letter toggle
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        uppercaseToggle.setBounds(25,302,225,56);
        add(uppercaseToggle);

        //lower case letter toggle
        JToggleButton lowercaseToggle = new JToggleButton("lowercase");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        lowercaseToggle.setBounds(282,302,225,56);
        add(lowercaseToggle);

        // numbers toggle
        JToggleButton numbersToggle = new JToggleButton("numbers");
        numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        numbersToggle.setBounds(25,373,225,56);
        add(numbersToggle);

        // symbols togle
        JToggleButton symbolsToggle = new JToggleButton("symbols");
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        symbolsToggle.setBounds(282,373,225,56);
        add(symbolsToggle);

        // create generate button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155,477,222,41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //validation: generate a password only when length > 0 and one of the toggled buttons is pressed
                if (passwordLengthInputArea.getText().length() <= 0) return;
                boolean anyToggleSelected = uppercaseToggle.isSelected() ||
                        lowercaseToggle.isSelected() ||
                        numbersToggle.isSelected() ||
                        symbolsToggle.isSelected();

                //generate password
                // converts the text to an integer value
                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
                if(anyToggleSelected){
                    String generatedPassword = passwordGenerator.generatePassword(passwordLength,
                            uppercaseToggle.isSelected(),
                            lowercaseToggle.isSelected(),
                            numbersToggle.isSelected(),
                            symbolsToggle.isSelected());

                    // dislpay password back to the user
                    passwordOutput.setText(generatedPassword);
                }

            }
        });
        add(generateButton);
    }
}
