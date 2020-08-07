
package acme.features.entrepreneur.investmentRound;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurInvestmentRoundRepository extends AbstractRepository {

	@Query("select wp.investmentRound from WorkProgramme wp where wp.investmentRound.entrepreneur.id =?1")
	Collection<InvestmentRound> findActivesInvestmentRounds(int entrepeneurId);

	@Query("select ir from InvestmentRound ir where ir.id =?1")
	InvestmentRound findOneInvestmentRoundById(int id);
}
