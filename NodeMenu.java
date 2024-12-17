public class NodeMenu {
    String nama;
    int harga;
    NodeMenu next;

    NodeMenu(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
        this.next = null;
    }

    class Menu {
        NodeMenu head;

        void tambahMenu(String nama, int harga) {
            NodeMenu nodeBaru = new NodeMenu(nama, harga);
            if (head == null) {
                head = nodeBaru;
            } else {
                NodeMenu temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = nodeBaru;
            }
        }

        void tampilkanMenu() {
            if (head == null) {
                System.out.println("Menu kosong.");
                return;
            }
            NodeMenu temp = head;
            System.out.println("Menu:");
            while (temp != null) {
                System.out.println(temp.nama + " - Rp" + temp.harga);
                temp = temp.next;
            }
        }

        NodeMenu cariMenu(String nama) {
            NodeMenu temp = head;
            while (temp != null) {
                if (temp.nama.equalsIgnoreCase(nama)) {
                    return temp;
                }
                temp = temp.next;
            }
            return null;
        }
    }
}
