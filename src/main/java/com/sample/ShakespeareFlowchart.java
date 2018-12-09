package com.sample;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;



/**
 * This is a sample class to launch a rule.
 */
public class ShakespeareFlowchart {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
        	/*
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            kSession.insert(message);
            kSession.fireAllRules();*/
        	
        	new ShakespeareFlowchart().init(kContainer);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    public ShakespeareFlowchart() {
    	
    }
    
    public void init(KieContainer kc) {
    	
    	ShakespeareUI ui = new ShakespeareUI(kc);
    	ui.createAndShowGUI(true);
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }

    public class ShakespeareUI extends JPanel {

		/** 
		 * This class implements a GUI for our application
		 *
		 */
		private static final long serialVersionUID = 1L;
    	
		private JTextArea output;
		
		private JButton buttonYes;
		private JButton buttonNo;
		
		
		public ShakespeareUI(KieContainer kc) {
			super(new BorderLayout());
			output = new JTextArea();
			
			JSplitPane splitPane = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
            add( splitPane,
                 BorderLayout.CENTER );
            JPanel topHalf = new JPanel();
            topHalf.setLayout( new BoxLayout( topHalf,
                                              BoxLayout.X_AXIS ) );
            topHalf.setBorder( BorderFactory.createEmptyBorder( 5,
                                                                5,
                                                                0,
                                                                5 ) );
            topHalf.setMinimumSize( new Dimension( 400,
                                                   50 ) );
            topHalf.setPreferredSize( new Dimension( 450,
                                                     250 ) );
            splitPane.add( topHalf );
            
            JPanel bottomHalf = new JPanel( new BorderLayout() );
            bottomHalf.setMinimumSize( new Dimension( 400,
                                                      50 ) );
            bottomHalf.setPreferredSize( new Dimension( 450,
                                                        300 ) );
            splitPane.add( bottomHalf );

            output.setMinimumSize(new Dimension(200, 100));
            output.setEditable(false);
            output.setText("Watch the sky!");
            topHalf.add( output );
            
            JPanel checkoutPane = new JPanel();
            buttonYes= new JButton( "Yes" );
            buttonYes.setVerticalTextPosition( AbstractButton.CENTER );
            buttonYes.setHorizontalTextPosition( AbstractButton.LEADING );
            //attach handler to assert items into working memory
           // button.addMouseListener( new CheckoutButtonHandler() );
            buttonYes.setActionCommand( "checkout" );
            checkoutPane.add( buttonYes );
            bottomHalf.add( checkoutPane,
                            BorderLayout.NORTH );

            buttonNo = new JButton( "No" );
            buttonNo.setVerticalTextPosition( AbstractButton.CENTER );
            buttonNo.setHorizontalTextPosition( AbstractButton.TRAILING );
            //attach handler to assert items into working memory
         //   button.addMouseListener( new ResetButtonHandler() );
            buttonNo.setActionCommand( "reset" );
            checkoutPane.add( buttonNo );
            bottomHalf.add( checkoutPane,
                            BorderLayout.NORTH );

			
		}
		
        public void createAndShowGUI(boolean exitOnClose) {
            //Create and set up the window.
            JFrame frame = new JFrame( "Which Shakespeare's Play Should You See First?" );
            frame.setDefaultCloseOperation(exitOnClose ? JFrame.EXIT_ON_CLOSE : JFrame.DISPOSE_ON_CLOSE);

            setOpaque( true );
            frame.setContentPane( this );

            //Display the window.
            frame.pack();
            frame.setLocationRelativeTo(null); // Center in screen
            frame.setVisible( true );
        }
    	
    }
    
}
