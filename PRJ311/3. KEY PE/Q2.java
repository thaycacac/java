//turn off default event key
    txtArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_MASK), "none");

//edit system
    System.exit(0);

//format date
	String timeStamp = new SimpleDateFormat("ss/mm/HH").format(Calendar.getInstance().getTime());