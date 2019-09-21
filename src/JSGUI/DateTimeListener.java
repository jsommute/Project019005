/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


public class DateTimeListener extends JFrame implements ActionListener {
	private JLabel timeLabel;
	
	private Calendar calendar = Calendar.getInstance(); //Get calendar using this machine's current local
	private int hour, minute, second;

	public static void main( String[] args ) {
		new DateTimeListener();
	}
	
	public DateTimeListener() {
		updateTime();
		timeLabel = new JLabel(hour + ":" + minute + ":" + second);
		
		add(timeLabel, BorderLayout.CENTER);
		
		setVisible( true );
		pack();
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		new Timer(1000, this).start(); //Update every 1s, let this class listen
	}
	
	private void updateTime() {
		calendar.setTimeInMillis( System.currentTimeMillis() ); //Update the calendar's time
		hour = calendar.get( 11 ); //Calendar field 11 is hours
		minute = calendar.get( 12 ); //Field 12
		second = calendar.get( 13 ); //Field 13
	}

	@Override
	public void actionPerformed( ActionEvent e ) { //A tick happened
		updateTime(); //Update time
		timeLabel.setText( hour + ":" + minute + ":" + second ); //Update label text
		repaint(); //Update gui
	}
}

