import java.util.Scanner;

public class ManajemenNilai08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Inisialisasi variabel
        double totalNilai = 0;
        int jumlahSiswa = 0;
        String lanjut;
        int diAtasRataRata = 0;
        double nilaiSementara = 0;
        
        System.out.println("PROGRAM ANALISIS NILAI KELAS");
        System.out.println("============================");
        
        do {
            // Input data siswa
            jumlahSiswa++;
            System.out.print("\nMasukkan nilai siswa ke-" + jumlahSiswa + ": ");
            nilaiSementara = input.nextDouble();
            totalNilai += nilaiSementara;
            
            // Tanya apakah ingin melanjutkan
            System.out.print("Ada siswa lagi? (y/t): ");
            input.nextLine(); // membersihkan buffer
            lanjut = input.nextLine();
            
        } while (lanjut.equalsIgnoreCase("y"));
        
        // Hitung rata-rata
        double rataRata = totalNilai / jumlahSiswa;
        
        // Input ulang untuk menghitung siswa di atas rata-rata
        System.out.println("\nRata-rata kelas: " + String.format("%.2f", rataRata));
        System.out.println("\nMasukkan kembali nilai siswa untuk analisis:");
        
        for (int i = 1; i <= jumlahSiswa; i++) {
            System.out.print("Nilai siswa ke-" + i + ": ");
            nilaiSementara = input.nextDouble();
            
            if (nilaiSementara > rataRata) {
                diAtasRataRata++;
            }
        }
        
        // Hitung siswa di bawah rata-rata
        int diBawahRataRata = jumlahSiswa - diAtasRataRata;
        
        // Cek mayoritas
        boolean mayoritasDiatas = (diAtasRataRata > jumlahSiswa / 2);
        
        // Tampilkan hasil
        System.out.println("\nHASIL ANALISIS NILAI KELAS");
        System.out.println("==========================");
        System.out.println("1. Rata-rata nilai kelas: " + String.format("%.2f", rataRata));
        System.out.println("2. Jumlah siswa: " + jumlahSiswa);
        System.out.println("3. Siswa di atas rata-rata: " + diAtasRataRata + " siswa");
        System.out.println("4. Siswa di bawah rata-rata: " + diBawahRataRata + " siswa");
        System.out.println("5. Status mayoritas: " + 
            (mayoritasDiatas ? "Mayoritas siswa di ATAS rata-rata" : 
                             "Mayoritas siswa di BAWAH rata-rata"));
                             
        input.close();
    }
}