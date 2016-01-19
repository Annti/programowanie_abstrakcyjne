
import org.junit.*;


public class Tests {

    @Test
    public void TestExporter() {
        //co bedzie eksportowane
        String textToBeExported = "Ala ma kota";
        //tworzy nowy eksporter z tym co bedzie eksportowane
        Exporter exporter = new TextExporter(textToBeExported);

        Data exportedData = exporter.exportData();

        String exportedText = ((TextData) exportedData).getData();
        assert (textToBeExported.equals(exportedText));
        exporter = new TextExporter("");
        exportedData = exporter.exportData();
        exportedText = ((TextData) exportedData).getData();
        textToBeExported = "";
        assert (textToBeExported.equals(exportedText));
    }

    @Test
    public void TestImporter() {
        String textToBeImported = "Ala zgubila dolara";
        Data dataToSendToImporter = new TextData(textToBeImported);
        Importer importer = new TextImporter();
        importer.importData(dataToSendToImporter);
        String dataSavedInImporter = ((TextImporter) importer).getImportedText();
        assert (textToBeImported.equals(dataSavedInImporter));
    }

    @Test
    public void TestFactory() {
        String textToForFactory = "Ali kot zjadl dolara";
        DistributedModuleFactory factory = new DistributedModuleTextFactory(textToForFactory);
        Data dataFromFactory = factory.createData();
        String textFromModule = ((TextData) dataFromFactory).getData();
        assert (textToForFactory.equals(textFromModule));
        Exporter exporter = factory.createExporter();
        textFromModule = ((TextData) ((TextExporter) exporter).exportData()).getData();
        assert (textToForFactory.equals(textFromModule));
        Importer importer = factory.createImporter();
        assert (importer instanceof TextImporter);
    }


}