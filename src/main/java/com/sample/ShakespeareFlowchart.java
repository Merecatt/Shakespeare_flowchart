package com.sample;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class ShakespeareFlowchart {
	
	public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
	public static class Answer{
		
		public String myAnswer;
		public int ans;
		
		public Answer (String mO)
		{
			this.myAnswer = mO;
		}
		
		public String getOdpowiedz(){
			return this.myAnswer;
		}
	}
	
	public static class Question{
		
		public String qstext;
		public String anstext;
		
		public Question(String p, Object n)
		{
			this.qstext = p;
			this.anstext = (String)n;
		}
		
		public String getPytanie(){
			return this.qstext;
		}
	}

    
}
