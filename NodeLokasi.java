public class NodeLokasi {
    String nama;
    int jarak;
    NodeLokasi next;

    NodeLokasi(String nama, int jarak) {
        this.nama = nama;
        this.jarak = jarak;
        this.next = null;
    }

    class PencariRute {
        NodeLokasi head;

        void tambahLokasi(String nama) {
            NodeLokasi lokasiBaru = new Lokasi(nama);
            if (head == null) {
                head = lokasiBaru;
            } else {
                NodeLokasi temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = lokasiBaru;
            }
        }

        void tambahRute(String dari, String ke, int jarak) {
            NodeLokasi lokasiDari = cariLokasi(dari);
            NodeLokasi lokasiKe = cariLokasi(ke);

            if (lokasiDari != null && lokasiKe != null) {
                NodeLokasi jalurBaru = new NodeLokasi(ke, jarak);
                jalurBaru.next = lokasiDari.jalur;
                lokasiDari.jalur = jalurBaru;

                jalurBaru = new NodeLokasi(dari, jarak);
                jalurBaru.next = lokasiKe.jalur;
                lokasiKe.jalur = jalurBaru;
            }
        }

        Lokasi cariLokasi(String nama) {
            Lokasi temp = head;
            while (temp != null) {
                if (temp.nama.equalsIgnoreCase(nama)) {
                    return temp;
                }
                temp = temp.next;
            }
            return null;
        }

        void temukanRuteTerpendek(String dari, String ke) {
            Lokasi lokasiDari = cariLokasi(dari);
            Lokasi lokasiKe = cariLokasi(ke);

            if (lokasiDari == null || lokasiKe == null) {
                System.out.println("Lokasi tidak ditemukan.");
                return;
            }

            // Algoritma sederhana untuk mencari rute terpendek (hanya menampilkan nama dan
            // jarak)
            NodeLokasi temp = lokasiDari.jalur;
            while (temp != null) {
                if (temp.nama.equalsIgnoreCase(ke)) {
                    System.out.println("Rute terpendek: " + dari + " -> " + ke + " dengan jarak " + temp.jarak);
                    return;
                }
                temp = temp.next;
            }

            System.out.println("Tidak ada rute langsung dari " + dari + " ke " + ke);
        }
    }
}
