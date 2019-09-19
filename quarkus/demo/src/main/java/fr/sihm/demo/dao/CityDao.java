package fr.sihm.demo.dao;

import fr.sihm.demo.domain.City;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
public class CityDao {

  @Inject
  EntityManager entityManager;

  @Transactional(SUPPORTS)
  public List<City> getAll() {
    return entityManager.createQuery("select c from City c", City.class).getResultList();
  }

  @Transactional(SUPPORTS)
  public City getByInsee(String inseeId) throws Throwable {
    return entityManager.createQuery("select c from City c where c.inseeId = :insee", City.class).setParameter("insee", inseeId).getResultList().stream().findFirst().orElseThrow(() -> new Exception("pas trouvé"));
  }

}
