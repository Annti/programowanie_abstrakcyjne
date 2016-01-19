
public abstract class Exporter {

    protected Data exportedData;

    public abstract Data exportData();

    public Exporter(Data data_to_export) {

        this.exportedData = data_to_export;
    }


}
