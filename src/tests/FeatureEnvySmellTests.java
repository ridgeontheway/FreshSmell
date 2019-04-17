import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wasps.configuration.MappingProfile;
import org.wasps.data.repository.concretes.ParsedRepository;
import org.wasps.model.ParsedClass;
import org.wasps.model.SmellReportModel;
import org.wasps.service.concretes.ParsingService;
import org.wasps.service.smells.concretes.FeatureEnvySmell;

import java.util.ArrayList;
import java.util.List;

public class FeatureEnvySmellTests {
    ParsedRepository repo;
    List<ParsedClass> files;
    SmellReportModel tempModel;

    @Before
    public void setup() {
        repo = new ParsedRepository();
        files = new ArrayList<>();
    }

    @Test
    public void FeatureEnvyTrue(){
        FeatureEnvySmell tempSmell = new FeatureEnvySmell(1);
        ParsingService tempService = new ParsingService();
        MappingProfile tempMappingProfile = new MappingProfile();

        try{
            files = tempService.parse("src/tests/test_data");
            repo.insert(files);
        }
        catch (Exception e){
            Assert.fail(e.toString());
        }

        tempModel = tempSmell.smell(tempMappingProfile.map(repo.get("RandomClass")).get(0));
        Assert.assertEquals(100, (int) tempModel.getScore());
    }

    @Test
    public void FeatureEnvyFalse(){
        FeatureEnvySmell tempSmell = new FeatureEnvySmell(1);
        ParsingService tempService = new ParsingService();
        MappingProfile tempMappingProfile = new MappingProfile();

        try{
            files = tempService.parse("src/tests/test_data");
            repo.insert(files);
        }
        catch (Exception e){
            Assert.fail(e.toString());
        }

        tempModel = tempSmell.smell(tempMappingProfile.map(repo.get("RandomClass1")).get(0));
        Assert.assertEquals(0, (int) tempModel.getScore());
    }

    @Test
    public void FeatureEnvyStaticTrue(){
        FeatureEnvySmell tempSmell = new FeatureEnvySmell(1);
        ParsingService tempService = new ParsingService();
        MappingProfile tempMappingProfile = new MappingProfile();

        try{
            files = tempService.parse("src/tests/test_data");
            repo.insert(files);
        }
        catch (Exception e){
            Assert.fail(e.toString());
        }

        tempModel = tempSmell.smell(tempMappingProfile.map(repo.get("RandomClass2")).get(0));
        Assert.assertEquals(0, (int) tempModel.getScore());
    }
}
