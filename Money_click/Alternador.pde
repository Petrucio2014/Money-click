class Alternador {

    private final Robot robot;
    private final int abas;
    
    public Alternador(int abas) throws AWTException {
        
        this.abas = abas;
        robot = new Robot();
    }
    
    public void alternador() {
        
        altTab();
        robot.delay(2000);
        
    }


    private void altTab(){
        
        robot.keyPress(KeyEvent.VK_ALT);

        for (int y = 0; y < abas-1; y++) {

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.delay(100);
        }
        
        robot.keyRelease(KeyEvent.VK_ALT);
    }
}
