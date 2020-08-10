
package acme.features.bookkeeper.investment;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface BookkeeperInvestmentRepository extends AbstractRepository {

	@Query("select i from InvestmentRound i where i.id = ?1")
	InvestmentRound findOneById(int id);

	@Query("select i from InvestmentRound i")
	Collection<InvestmentRound> findManyAll();

	@Query("select a.investmentRound from AccountingRecord a where a.bookkeeper.id = ?1")
	Collection<InvestmentRound> findManyByBookkeeperId(int bookkeeperId);

	@Query("select i from InvestmentRound i where i.id not in (select a.investmentRound.id from AccountingRecord a where a.bookkeeper.id = ?1)")
	Collection<InvestmentRound> findOthersByBookkeeperId(int bookkeeperId);

}
