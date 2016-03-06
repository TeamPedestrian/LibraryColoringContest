package view;

import java.awt.EventQueue;

/**
 * @author Antonio V. Alvillar
 */
public final class Main {
        
    /**
     * Private constructor to prevent instantiation of this class.
     */
    private Main() {
        throw new IllegalStateException();
    }

    /**
     * @param theArgs : The command line arguments.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomePage();
            }
        });

    }
}