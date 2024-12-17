public class NodeRiwayat {
    NodeMenu item;
    NodeRiwayat next;

    NodeRiwayat(NodeMenu item) {
        this.item = item;
        this.next = null;
    }

    class RiwayatPesanan {
        NodeRiwayat head;

        void tambahPesanan(NodeMenu item) {
            NodeRiwayat nodeBaru = new NodeRiwayat(item);
            nodeBaru.next = head;
            head = nodeBaru;
        }

        void tampilkanRiwayat() {
            if (head == null) {
                System.out.println("Riwayat kosong.");
                return;
            }
            NodeRiwayat temp = head;
            System.out.println("Riwayat Pesanan:");
            while (temp != null) {
                System.out.println(temp.item.nama + " - Rp" + temp.item.harga);
                temp = temp.next;
            }
        }
    }
}
