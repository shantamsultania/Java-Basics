package DaoApiexample;

import java.util.List;

public interface developerDao {

    public List<Developer> getAllDevelopers();
    public Developer getDeveloper(String id);
    public void addDeveloper(Developer dev);
    public void updateDeveloper(Developer developer);
    public void deleteDeveloper(String id);
}
