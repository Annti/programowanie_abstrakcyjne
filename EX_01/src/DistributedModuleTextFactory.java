
public class DistributedModuleTextFactory extends DistributedModuleFactory {
    private final String text;

    public DistributedModuleTextFactory(String text) {

        this.text = text;
    }

    @Override
    public Data createData() {

        return new TextData(text);
    }

    @Override
    public Exporter createExporter() {

        return new TextExporter(text);
    }

    @Override
    public Importer createImporter() {
        return new TextImporter() {
            {
                importData(new TextData(text));
            }
        };
    }
}
