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

        Assert.assertEquals("RandomClass", repo.get("RandomClass")
                .get(0)
                .getParsedJavaClass()
                .getName());
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
        Assert.assertEquals(3, methodLineLength);
    }

    @Test
    public void ParsedServiceMethodSubDirLookUp(){
        ParsingService tempParsingService = new ParsingService();
        ParsedRepository local_repo = new ParsedRepository();
        List<ParsedClass> local_files;

        try{
            local_files = tempParsingService.parse("src/tests/test_data_sub");
            local_repo.insert(local_files);
        }
        catch (Exception e){
            Assert.fail(e.getMessage());
        }

        List<ParsedClass> returnList = local_repo.get("hello");
        Assert.assertEquals(2, returnList.size());
    }


}
