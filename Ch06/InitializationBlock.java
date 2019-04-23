class InitializationBlock {
    static int count;
    int serialNo;
    String color;
    String gearType;
    {
        count++;
        serialNo = count;
    }
    
    InitializationBlock() {
        color="white";
        gearType="auto";
    }
    InitializationBlock(String color, String gearType) {
        this.color = color;
        this.gearType = gearType;
    }
	public static void main(String[] args) {
        InitializationBlock ib = new InitializationBlock();
        InitializationBlock ib2 = new InitializationBlock("pink", "manual");
        
        System.out.println("serialNo : " + ib.serialNo + " ib.color : " + ib.color + " ib.gearType : " + ib.gearType);
        System.out.println("serialNo : " + ib2.serialNo + " ib2.color : " + ib2.color + " ib2.gearType : " + ib2.gearType);
	}
}
