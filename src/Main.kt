import java.awt.Color
import java.awt.Dimension
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*
import kotlin.system.exitProcess


class MyFrame(title: String) : JFrame() {
    init {
        this.contentPane.background = Color.DARK_GRAY
        setTitle(title)
        var card1 = JPanel()
        card1.background = Color.DARK_GRAY

        val closeBtn = JButton("Close")
        closeBtn.addActionListener { exitProcess(0) }
        card1.add(closeBtn)

        val messageBtn = JButton("Message")
        messageBtn.addActionListener {
            run {
                JOptionPane.showMessageDialog(null, "Message!", "FYI", JOptionPane.INFORMATION_MESSAGE)
            }
        }

        val confirmBtn = JButton("Confirm")
        confirmBtn.addActionListener {
            run {
                val response = JOptionPane.showConfirmDialog(null, "Please confirm", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)
                JOptionPane.showMessageDialog(null, "You responded: " + response, "Response", JOptionPane.INFORMATION_MESSAGE)

                if (response == JOptionPane.YES_OPTION) {
                    JOptionPane.showInputDialog(JButton("Input"))
                } else if (response == JOptionPane.NO_OPTION) {
                    JOptionPane.showOptionDialog(null, "Please select option", "Option", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null)
                }
            }
        }

        val inputBtn = JButton("Input")
        inputBtn.addActionListener {
            run {
                val response = JOptionPane.showInputDialog(null, "Please input something", "Input", JOptionPane.QUESTION_MESSAGE)
                JOptionPane.showMessageDialog(null, "You responded: " + response, "Response", JOptionPane.INFORMATION_MESSAGE)
            }
        }

        val optionBtn = JButton("Option")
        optionBtn.addActionListener {
            run {
                val response = JOptionPane.showOptionDialog(null, "Please select option", "Options", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null)
                JOptionPane.showMessageDialog(null, "You responded: " + response, "Response", JOptionPane.INFORMATION_MESSAGE)

                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0)
                } else if (response == JOptionPane.NO_OPTION) {
                    JOptionPane.showInputDialog(JButton("Option"))
                }
            }
        }

        // New Button
        val roterKnopf = JButton("Klick mich!")
        roterKnopf.background = Color.RED
        roterKnopf.minimumSize = Dimension(100, 100)
        roterKnopf.addActionListener {
            JOptionPane.showMessageDialog(null, "Hurra", "Popup", JOptionPane.INFORMATION_MESSAGE)
        }

        card1.add(messageBtn)
        card1.add(confirmBtn)
        card1.add(inputBtn)
        card1.add(optionBtn)
        card1.add(roterKnopf)

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl
        gl.autoCreateContainerGaps = true

        gl.setHorizontalGroup(
            gl.createSequentialGroup()
                .addComponent(card1)
        )

        gl.setVerticalGroup(
            gl.createSequentialGroup()
                .addComponent(card1)
        )
        
        pack()
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(800, 600)  // Set the initial size
        minimumSize = Dimension(500, 500)  // Set the minimum size
        setLocationRelativeTo(null)
    }
}

fun main() {
    val frame = MyFrame("Cooles GUI")
    frame.isVisible = true
}
