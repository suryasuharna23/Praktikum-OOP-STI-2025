public class Ngabuburit {
    public static int maxSameActivity = 3;

    public ICommand command;
    public int jenuhCounter;

    /**
     * Constructor untuk melakukan Ngabuburit
     * 
     * @param command     Aktivitas yang ingin dilakukan
     */
    public Ngabuburit(ICommand command) {
        this.command = command;
        this.jenuhCounter = 0;
    }

    /**
     * Setter untuk mengubah aktivitas yang dilakukan
     * Counter jenuh akan kembali ke 0
     * 
     * @param command     Aktivitas yang ingin dilakukan
     */
    public void changeCommand(ICommand command) {
        this.command = command;
        this.jenuhCounter = 0;
    }

    /**
     * Setter untuk mengubah aktivitas yang dilakukan dengan argumen string. 
     * Counter jenuh akan kembali ke 0
     * Pilihan command adalah "laptop", "pintu", atau "rumah"
     * 
     * @param command     Aktivitas yang ingin dilakukan dalam string
     */
    public void changeCommandStr(String commandStr) {
        if (commandStr.equals("laptop")) {
            this.command = new LaptopCommand(new Laptop());
        } else if (commandStr.equals("pintu")) {
            this.command = new PintuCommand(new Pintu());
        } else if (commandStr.equals("rumah")) {
            this.command = new RumahCommand(new Rumah());
        }

        this.jenuhCounter = 0;
    }

    /**
     * Method untuk melakukan aktivitas pada command. Jika command sudah dijalankan
     * lebih dari maxSameActivity, maka akan mencetak "Sudah jenuh! Lakukan aktivitas lain"
     * ke layar.
     */
    public void doStuff() {
        if (jenuhCounter >= maxSameActivity){
            System.out.println("Sudah jenuh! Lakukan aktivitas lain");
        } else {
            if (command != null){
                command.execute();
                jenuhCounter++;
            }
        }
    }
}
