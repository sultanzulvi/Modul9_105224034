public class KomputerServer {
    protected HardDisk HD;
    protected Monitor monitor;

    public KomputerServer(Monitor monitor){
        this.HD = new HardDisk();
        this.monitor = monitor;
    }
    
}
