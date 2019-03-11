class Propaganda {
    
    private final Color cor;
    private final Color idk;
    private final Color cinza;
    private final Color branco;
    private final Color fechar;
    private final Color fecharA;
    private final Color amarelo;
    private final Color able;
    private final Color cinzinha;
    private final Robot robot ;
    private final Alternador alt;
    private final int margem;
    
    public Propaganda() throws AWTException{
        
        margem = 2;
        idk = new Color(241, 82, 73);
        cinza = new Color(44, 44, 44);
        cinzinha = new Color(61,61,61);
        able = new Color(243, 240, 204);
        cor = new Color(171, 163, 95);
        branco = new Color(255, 255, 255);
        fechar = new Color(124, 124, 124);
        fecharA = new Color(245, 245, 245);
        amarelo = new Color(244, 184, 68);
        robot = new Robot();
        alt = new Alternador(2); // Quantidade de processos ativos
    }
    
    public void checar() throws AWTException{
        
        gelo();
        
    }
    
    private boolean compararCor(int x, int y, Color cor){
        boolean found = false;
        for(int i=-margem;i<=margem;i++){
            
            for(int j=-margem;j<=margem &&x+i >=0 && x+i < 1600;j++){
            
                if(y+j>=0 && y+j<900 && robot.getPixelColor(x+i, y+j).equals(cor)){
                   found=true;
                   break;
                }
            }
            if(found)
                break;
        }
        return found;
    }
    
    private void clicar(int x, int y){
        
        robot.mouseMove(x, y);
        clicar();
        
    }
    private void clicar(){
        
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(20);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        
    }
    private void clicar(int x, int y,int t){
        
        robot.mouseMove(x, y);        
        for(int i = 0; i<t ; i++)
            clicar();
        
    }
    
    private void gelo(){
        
        if (compararCor(809, 464,able)){
            
           clicar(809, 464, 51);
           
           if(compararCor(911, 470,cinzinha))
              clicar(911, 470);
           
        } else if(compararCor(789, 453,cinza)){
            clicar(789,453);
            robot.delay(500);
            
            if(compararCor(641,679,idk)){
                clicar(641,679);
            } else
                robot.delay(500);
        }else{
            fechar();
        }
        
        
    }
    
    private void fechar(){
        
        if(compararCor(822, 460, branco))
            clicar(910, 487);
        
        if(compararCor(1362, 137, branco))
            clicar(1362, 137);
        else if(compararCor(1351, 150, branco))
            clicar(1351, 150);
        else if(compararCor(1363, 138,fechar))
            clicar(1363, 138);
        else 
            alt.alternador();
        

        
        
    }
    
        
}
    
    
