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
        if (statuszSablon == 1) {
            this.alapEletero = 15;
            this.alapSebzes = 3;
        } else if (statuszSablon == 2) {
            this.alapEletero = 12;
            this.alapSebzes = 4;
        } else if (statuszSablon == 3) {
            this.alapEletero = 8;
            this.alapSebzes = 5;
        } else {
            System.out.println("Hibás Státusz Sablon értéket adott meg!");
        }
        this.eletero = getMaxEletero();
    }

    //Név

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    //szint

    public Integer getSzint() {
        return szint;
    }

    public void setSzint(Integer szint) {
        this.szint = szint + 1;
    }

    //tapasztalat

    public Integer getTapasztalat() {
        return tapasztalat;
    }

    public void setTapasztalat(Integer tapasztalat) {
        this.tapasztalat = tapasztalat;
        if (this.getSzintLepeshez() <= tapasztalat){
            this.setTapasztalat(this.getTapasztalat()-getSzintLepeshez());
            this.setSzint(this.getSzint());
        }
    }

    public Integer getAlapEletero() {
        return alapEletero;
    }

    public Integer getAlapSebzes() {
        return alapSebzes;
    }

    //életerő
    public Integer getEletero() {
        return eletero;
    }

    public void setEletero(Integer eletero) {
        if (eletero == 0){
            this.setTapasztalat(0);
        }else if (this.eletero>this.getMaxEletero()){
            this.eletero = this.getMaxEletero();
        }
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

    //metodusok

    public void megkuzd(Harcos masikharcos) {
        if (this.nev.equals(masikharcos.nev)) {
            System.out.println("A harcos nem küzdhet meg saját magával.");
        }else if (this.eletero <= 0 || masikharcos.eletero <= 0) {
            if (this.eletero<=0){
                this.setEletero(getAlapEletero());
                this.setTapasztalat(0);
                this.setSzint(0);
            }else{
                masikharcos.setEletero(getAlapEletero());
                masikharcos.setTapasztalat(0);
                masikharcos.setSzint(0);
            }
        } else {
            masikharcos.setEletero(masikharcos.getEletero() - this.getSebzes());
            if (masikharcos.eletero > 0) {
                this.setEletero(getEletero() - masikharcos.getSebzes());
                //xp
                if (this.getEletero() > 0 && masikharcos.getEletero() > 0) {
                    this.setTapasztalat(this.getTapasztalat() + 5);
                    masikharcos.setTapasztalat(masikharcos.getTapasztalat() + 5);
                }else if (this.getEletero() <= 0 && masikharcos.getEletero() > 0) {
                    masikharcos.setTapasztalat(masikharcos.getTapasztalat() + 10);
                } else if (this.getEletero() > 0 && masikharcos.getEletero() <= 0) {
                    this.setTapasztalat(getTapasztalat() + 10);
                }
            }
        }
    }

    public void gyogyul() {
        if (this.eletero == 0) {
            setEletero(getMaxEletero());
        } else {
            this.setEletero(3 + this.getSzint());
        }
    }

    @Override
    public String toString() {
        return nev + " - " + " LVL:" + getSzint() + " EXP:" + getTapasztalat() + "/" + getSzintLepeshez() +
                " - HP:" + getEletero() + "/" + getMaxEletero() +" - DMG:" + getSebzes();
    }
}
