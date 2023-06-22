package LOGIN;

import javax.swing.*;

public class LOADING extends JFrame{
    private JProgressBar progressBar1;
    private JPanel PanelLoading;
    private JLabel loadnya;

    public LOADING()
    {
        add(PanelLoading);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        progressBar1();
    }
    public void  progressBar1()
    {
        int i = 0;
        while (i<= 100)
        {
            try
            {
                Thread.sleep(60);
                progressBar1.setValue(i);
                loadnya.setText("LOADING.....(" + (i) + "%)");
                i++;
            }catch (Exception E)
            {
                E.printStackTrace();
            }
        }
        dispose();
    }

    public static void main(String[] args) {
        new LOADING();
    }
}
