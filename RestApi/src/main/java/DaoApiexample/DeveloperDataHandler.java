package DaoApiexample;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeveloperDataHandler {

    developerDao developerDao = new developerDaoImpl();

    @RequestMapping("/dao")
    public List<Developer> getall()
    {
        return developerDao.getAllDevelopers();
    }

    @RequestMapping("/dao/{id}")
    public Developer getDeveloper(@PathVariable String id)
    {
        return developerDao.getDeveloper(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/dao")
    public void addDeveloper(@RequestBody Developer developer)
    {
        developerDao.addDeveloper(developer);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/dao")
    public void updateDeveloper(@RequestBody Developer developer)
    {
        developerDao.updateDeveloper(developer);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/dao/{id}")
    public void deleteDeveloper(@PathVariable String id)
    {
        developerDao.deleteDeveloper(id);
    }

}
