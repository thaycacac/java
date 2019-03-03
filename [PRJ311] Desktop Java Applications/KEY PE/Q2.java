//turn off default event key
    txtArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_MASK), "none");

//edit system
    System.exit(0);

//format date
	String timeStamp = new SimpleDateFormat("ss/mm/HH").format(Calendar.getInstance().getTime());
	//specially
	Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY:DD:MM:hh:mm:ss");
    String time = sdf.format(cal.getTime());// year:day:month:hour:minute:second