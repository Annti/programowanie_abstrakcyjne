
public class TextExporter extends Exporter {

    public TextExporter(String tx) {

        super(new TextData(tx));

    }

    @Override
    public Data exportData() {

        return exportedData;

    }

}
