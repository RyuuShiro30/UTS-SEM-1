import java.util.Scanner;

public class StokBarang08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String pilihan;
        
        System.out.println("PROGRAM MANAJEMEN STOK BARANG");
        System.out.println("=============================");
        
        do {
            System.out.print("\nMasukkan nama barang: ");
            String nama = input.nextLine();
            
            System.out.print("Masukkan jumlah stok awal: ");
            int stok = input.nextInt();
            
            System.out.print("Masukkan harga per unit: Rp ");
            double harga = input.nextDouble();
            
            String lanjutPermintaan;
            do {
                System.out.println("\nStatus " + nama + ":");
                System.out.println("Stok saat ini: " + stok);
                System.out.printf("Nilai stok: Rp %,.0f\n", (stok * harga));
                
                System.out.print("\nJumlah yang diminta: ");
                int permintaan = input.nextInt();
                
                int stokTersedia = stok;
                int i = 0;
                while (i < permintaan && stokTersedia > 0) {
                    stokTersedia--;
                    i++;
                }
                
                if (i == permintaan) {
                    System.out.println("Permintaan dapat dipenuhi");
                    stok = stokTersedia;
                } else {
                    System.out.println("Stok tidak mencukupi!");
                }
                
                System.out.print("\nPerlu penyesuaian stok? (y/t): ");
                input.nextLine(); 
                String sesuaikan = input.nextLine();
                
                if (sesuaikan.equalsIgnoreCase("y")) {
                    System.out.print("Masukkan jumlah penambahan/pengurangan stok: ");
                    int pengaturan = input.nextInt();
                    stok += pengaturan;
                    System.out.println("Stok setelah penyesuaian: " + stok);
                }
                
                System.out.print("\nAda permintaan lagi untuk " + nama + "? (y/t): ");
                input.nextLine(); 
                lanjutPermintaan = input.nextLine();
                
            } while (lanjutPermintaan.equalsIgnoreCase("y"));
            
            System.out.println("\nHASIL AKHIR " + nama.toUpperCase());
            System.out.println("--------------------");
            System.out.println("Sisa stok: " + stok);
            System.out.printf("Nilai sisa stok: Rp %,.0f\n", (stok * harga));
            
            System.out.print("\nInput barang baru? (y/t): ");
            pilihan = input.nextLine();
            
        } while (pilihan.equalsIgnoreCase("y"));
        
        System.out.println("\nProgram selesai!");
        input.close();
    }
}