package org.govhack.helpinghand.persistance.respositories;

import org.govhack.helpinghand.persistance.entities.SuburbEntity;
import org.govhack.helpinghand.persistance.entities.SuburbUsageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

/**
 * Created by James on 31-Jul-16.
 */
@Transactional
@Component(value="suburbDAO")
public class SuburbDAO {
    @Autowired
    private HibernateTemplate  hibernateTemplate;

    public void saveSuburb() { }

    public SuburbEntity getSuburb(int id) {
        return hibernateTemplate.get(SuburbEntity.class, id);
    }

    public List<SuburbUsageEntity> getAllSuburbUsage() {
        return hibernateTemplate.loadAll(SuburbUsageEntity.class);
    }
}
