class Ruangan {
    private String nomorRegistrasi;
    private int kapasitasMaksimal;

    public Ruangan(String nomorRegistrasi, int kapasitasMaksimal) {
        this.nomorRegistrasi = nomorRegistrasi;
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public String getNomorRegistrasi() {
        return this.nomorRegistrasi;
    }

    public int getKapasitasMaksimal() {
        return this.kapasitasMaksimal;
    }
}