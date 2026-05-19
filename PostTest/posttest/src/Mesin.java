class Mesin {
    private String nomorSeri;
    private int kapasitasCC;

    public Mesin(String nomorSeri, int kapasitasCC) {
        this.nomorSeri = nomorSeri;
        this.kapasitasCC = kapasitasCC;
    }

    public String getNomorSeri() {
        return this.nomorSeri;
    }

    public int getKapasitasCC() {
        return this.kapasitasCC;
    }
}