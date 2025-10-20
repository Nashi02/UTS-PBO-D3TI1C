package uts_pbo_ivan;

public class Pejabat {
    private String nama;
    private String nip;
    private String jabatan;
    private double gajiPokok;

    public Pejabat(String nama, String nip, String jabatan, double gajiPokok) {
        this.nama = nama;
        this.nip = nip;
        this.jabatan = jabatan;
        this.gajiPokok = gajiPokok;
    }

    public String getNama() {
        return nama;
    }

    public String getNip() {
        return nip;
    }

    public String getJabatan() {
        return jabatan;
    }

    public double getGajiPokok() {
        return gajiPokok;
    }

    // Hitung tunjangan berdasarkan jabatan
    public double getTunjangan() {
        switch (jabatan.toLowerCase()) {
            case "kepala dinas":
                return gajiPokok * 0.30; // 30% dari gaji pokok
            case "sekretaris":
                return gajiPokok * 0.25;
            case "kabid":
            case "kepala bidang":
                return gajiPokok * 0.20;
            case "staff":
                return gajiPokok * 0.10;
            default:
                return gajiPokok * 0.05; // default tunjangan
        }
    }

    public double getTotalGaji() {
        return gajiPokok + getTunjangan();
    }

    @Override
    public String toString() {
        return "NIP       : " + nip +
               "\nNama      : " + nama +
               "\nJabatan   : " + jabatan +
               "\nGaji Pokok: Rp " + gajiPokok;
    }
}
