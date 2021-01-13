package DaoApiexample;

import java.util.ArrayList;
import java.util.List;

public class developerDaoImpl implements developerDao{

    List<Developer> developerList;

    developerDaoImpl()
    {
        developerList = new ArrayList<Developer>();
        developerList.add(new Developer("100","dev0"));
        developerList.add(new Developer("101","dev1"));
        developerList.add(new Developer("102","dev2"));
        developerList.add(new Developer("103","dev3"));

    }

    @Override
    public List<Developer> getAllDevelopers() {
        return developerList;
    }

    @Override
    public Developer getDeveloper(String id) {
        for (Developer developer : developerList)
        {
            if (developer.getId().equals(id))
            {
                return developer;
            }
        }
        return new Developer("404","not found");
    }

    @Override
    public void addDeveloper(Developer developer) {
        developerList.add(developer);
    }

    @Override
    public void updateDeveloper(Developer developer) {
        int i=0;
        for (Developer dev : developerList)
        {
            if (dev.getId().equals(developer.getId()))
            {
                developerList.set(i,developer);
            }
            else
            {
                i++;
            }
        }
    }

    @Override
    public void deleteDeveloper(String id) {
        int i=0;
        for (Developer dev : developerList)
        {
            if (dev.getId().equals(id))
            {
                developerList.remove(i);
            }
            else
            {
                i++;
            }
        }
    }
}
