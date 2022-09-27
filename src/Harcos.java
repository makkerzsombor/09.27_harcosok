public class Harcos {
    private String nev;
    private Integer szint;
    private Integer tapasztalat;
    private Integer eletero;
    private Integer alapEletero;
    private Integer alapSebzes;

    public Harcos(String nev, Integer statuszSablon) {
        this.nev = nev;
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
}
