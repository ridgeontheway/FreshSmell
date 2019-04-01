import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wasps.data.repository.concretes.ParsedRepository;
import org.wasps.model.ParsedClass;
import org.wasps.service.concretes.ParsingService;

import java.util.ArrayList;
import java.util.List;


public class ParsingServiceTests {
    ParsedRepository repo;
    List<ParsedClass> files;
    @Before
    public void setup() {
        repo = new ParsedRepository();
        files = new ArrayList<>();
    }


    @Test
    public void ParsedServiceClassGetTest(){
        ParsingService tempService = new ParsingService();

        try {
            files = tempService.parse("src/tests/test_data");
            repo.insert(files);
        } catch (Exception e) {
            Assert.fail(e.toString());
        }

        Assert.assertEquals(repo.get("RandomClass")
                .get(0)
                .getParsedJavaClass()
                .getName(), "RandomClass");
    }

    @Test
    public void ParsedServiceSingleUseCheck(){
        ParsingService tempService = new ParsingService();
        Boolean singleUseCheckTriggered = false;

        try{
            files = tempService.parse("src/tests/test_data");
            tempService.parse("src/tests/test_data");
        }
        catch (Exception e){
            singleUseCheckTriggered = true;
        }
        Assert.assertEquals(singleUseCheckTriggered, true);
    }

    @Test
    public void ParsedServiceMethodLineCheck(){
        ParsingService tempParsingService = new ParsingService();
        int methodLineLength = 0;

        try{
            files = tempParsingService.parse("src/tests/test_data");
            repo.insert(files);
        }
        catch (Exception e){
            Assert.fail(e.getMessage());
        }
        methodLineLength = repo.get("RandomClass").get(0)
                .getMethods().get(0).getLineLength();
        Assert.assertEquals(methodLineLength, 3);
    }

    @Test
    public void ParsedServiceMethodSubDirLookUp(){
        ParsingService tempParsingService = new ParsingService();
        try{
            files = tempParsingService.parse("src/tests/test_data_sub");
            repo.insert(files);
        }
        catch (Exception e){
            Assert.fail(e.getMessage());
        }

        List<ParsedClass> returnList = repo.get("hello");
        Assert.assertEquals(returnList.size(), 2);
    }


}
