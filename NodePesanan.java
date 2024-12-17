public class NodePesanan {
    NodeMenu item;
    NodePesanan next;

    NodePesanan(NodeMenu item) {
        this.item = item;
        this.next = null;
    }

    class AntrianPesanan {
        NodePesanan head, tail;

        void tambahPesanan(NodeMenu item) {
            NodePesanan nodeBaru = new NodePesanan(item);
            if (head == null) {
                head = tail = nodeBaru;
            } else {
                tail.next = nodeBaru;
                tail = nodeBaru;
            }
        }

        void tampilkanAntrian() {
            if (head == null) {
                System.out.println("Antrian kosong.");
                return;
            }
            NodePesanan temp = head;
            System.out.println("Antrian Pesanan:");
            while (temp != null) {
                System.out.println(temp.item.nama + " - Rp" + temp.item.harga);
                temp = temp.next;
            }
        }
    }
}
