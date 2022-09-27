public class Harcos {
    private String nev;
    private Integer szint;
    private Integer tapasztalat;
    private Integer eletero;
    private Integer alapEletero;
    private Integer alapSebzes;

    public Harcos(String nev, Integer statuszSablon) {
        this.nev = nev;
        this.szint = 1;
        this.tapasztalat = 0;
        if (statuszSablon == 1){
            this.alapEletero = 15;
            this.alapSebzes = 3;
        } else if (statuszSablon == 2) {
            this.alapEletero = 12;
            this.alapSebzes =4;
        } else if (statuszSablon==3) {
            this.alapEletero = 8;
            this.alapSebzes = 5;
        }else{
            System.out.println("Hibás Státusz Sablon értéket adott meg!");
        }
        this.eletero=alapEletero;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Integer getSzint() {
        return szint;
    }

    public void setSzint(Integer szint) {
        this.szint = szint;
    }

    public Integer getTapasztalat() {
        return tapasztalat;
    }

    public void setTapasztalat(Integer tapasztalat) {
        this.tapasztalat = tapasztalat;
    }

    public Integer getAlapEletero() {
        return alapEletero;
    }

    public Integer getAlapSebzes() {
        return alapSebzes;
    }

    public Integer getEletero() {
        return eletero;
    }

    public void setEletero(Integer eletero) {
        this.eletero = eletero;
    }

    public Integer getSebzes() {
        return this.alapSebzes + this.szint;
    }

    public Integer getSzintLepeshez() {
        return 10 + (this.szint * 5);
    }

    public Integer getMaxEletero() {
        return this.alapEletero + (this.szint * 3);
    }

    public void megkuzd(Harcos masikharcos){
        if (true){
            System.out.println("A harcos nem küzdhet meg saját magával.");
        }else if(true){

        }
    }

    @Override
    public String toString() {
        return  nev + " - " + " LVL:" + szint +" EXP:" + tapasztalat +"/"+ getSzintLepeshez() +
                " - HP:" + getEletero() + "/ maxéleterő - DMG:" + getSebzes();
    }
}
